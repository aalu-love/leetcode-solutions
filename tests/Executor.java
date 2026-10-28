import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

// Shared runner for every problem. Usage: java Executor <CasesClass> <methodName>
// Calls Solution.<methodName> with each case's args and compares the result.
// For void methods (in-place problems) the mutated first argument is compared instead.
public class Executor {

    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.out.println("usage: Executor <CasesClass> <methodName>");
            System.exit(2);
        }
        List<TestCase> cases = loadCases(args[0]);
        int failed = runAll(cases, args[1]);
        System.exit(failed == 0 ? 0 : 1);
    }

    @SuppressWarnings("unchecked")
    static List<TestCase> loadCases(String className) throws Exception {
        return (List<TestCase>) Class.forName(className).getMethod("all").invoke(null);
    }

    static int runAll(List<TestCase> cases, String methodName) throws Exception {
        Constructor<?> constructor = Class.forName("Solution").getDeclaredConstructor();
        constructor.setAccessible(true);
        Object solution = constructor.newInstance();
        Method method = findMethod(solution, methodName);

        int passed = 0;
        int failed = 0;
        for (TestCase tc : cases) {
            if (run(solution, method, tc)) {
                passed++;
            } else {
                failed++;
            }
        }
        System.out.println();
        System.out.printf("%d passed, %d failed, %d total%n", passed, failed, cases.size());
        return failed;
    }

    static Method findMethod(Object solution, String name) {
        for (Method m : solution.getClass().getMethods()) {
            if (m.getName().equals(name)) {
                m.setAccessible(true);
                return m;
            }
        }
        throw new IllegalArgumentException("Solution has no public method " + name);
    }

    static boolean run(Object solution, Method method, TestCase tc) {
        Object[] args = copyArgs(tc.args);
        Object actual;
        try {
            Object result = method.invoke(solution, args);
            actual = method.getReturnType() == void.class ? args[0] : result;
        } catch (Exception e) {
            Throwable cause = e.getCause() != null ? e.getCause() : e;
            System.out.println("FAIL  " + tc.name + "  (threw " + cause + ")");
            return false;
        }

        if (Objects.deepEquals(actual, tc.expected)) {
            System.out.println("PASS  " + tc.name);
            return true;
        }
        System.out.println("FAIL  " + tc.name);
        for (Object arg : tc.args) {
            System.out.println("      input:    " + show(arg));
        }
        System.out.println("      expected: " + show(tc.expected));
        System.out.println("      actual:   " + show(actual));
        return false;
    }

    // Copies arrays and lists so in-place solutions never change the stored test case.
    static Object[] copyArgs(Object[] args) {
        Object[] copy = new Object[args.length];
        for (int i = 0; i < args.length; i++) {
            copy[i] = copyValue(args[i]);
        }
        return copy;
    }

    static Object copyValue(Object value) {
        if (value instanceof List<?> list) {
            List<Object> copy = new ArrayList<>();
            for (Object item : list) {
                copy.add(copyValue(item));
            }
            return copy;
        }
        if (value != null && value.getClass().isArray()) {
            int length = Array.getLength(value);
            Object copy = Array.newInstance(value.getClass().getComponentType(), length);
            for (int i = 0; i < length; i++) {
                Array.set(copy, i, copyValue(Array.get(value, i)));
            }
            return copy;
        }
        return value;
    }

    static String show(Object value) {
        if (value == null || !value.getClass().isArray()) {
            return String.valueOf(value);
        }
        String wrapped = Arrays.deepToString(new Object[] {value});
        return wrapped.substring(1, wrapped.length() - 1);
    }
}
