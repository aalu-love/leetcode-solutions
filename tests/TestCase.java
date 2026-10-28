public class TestCase {
    final String name;
    final Object[] args;
    final Object expected;

    public TestCase(String name, Object[] args, Object expected) {
        this.name = name;
        this.args = args;
        this.expected = expected;
    }
}
