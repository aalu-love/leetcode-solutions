import java.util.ArrayList;
import java.util.List;

// Test cases for "48. Rotate Image". Run with: bash tests/run.sh "48. Rotate Image.java" RotateImageCases rotate
public class RotateImageCases {

    public static List<TestCase> all() {
        List<TestCase> cases = new ArrayList<>();

        cases.add(new TestCase("Example 1: 3x3",
                new Object[] {new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}},
                new int[][] {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}}));

        cases.add(new TestCase("Example 2: 4x4",
                new Object[] {new int[][] {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}}},
                new int[][] {{15, 13, 2, 5}, {14, 3, 4, 1}, {12, 6, 8, 9}, {16, 7, 10, 11}}));

        cases.add(new TestCase("1x1 single element",
                new Object[] {new int[][] {{42}}},
                new int[][] {{42}}));

        cases.add(new TestCase("2x2",
                new Object[] {new int[][] {{1, 2}, {3, 4}}},
                new int[][] {{3, 1}, {4, 2}}));

        cases.add(new TestCase("5x5 sequential",
                new Object[] {new int[][] {
                        {1, 2, 3, 4, 5},
                        {6, 7, 8, 9, 10},
                        {11, 12, 13, 14, 15},
                        {16, 17, 18, 19, 20},
                        {21, 22, 23, 24, 25}}},
                new int[][] {
                        {21, 16, 11, 6, 1},
                        {22, 17, 12, 7, 2},
                        {23, 18, 13, 8, 3},
                        {24, 19, 14, 9, 4},
                        {25, 20, 15, 10, 5}}));

        cases.add(new TestCase("2x2 with negatives and bounds",
                new Object[] {new int[][] {{-1000, 1000}, {0, -1}}},
                new int[][] {{0, -1000}, {-1, 1000}}));

        cases.add(new TestCase("3x3 all equal values",
                new Object[] {new int[][] {{7, 7, 7}, {7, 7, 7}, {7, 7, 7}}},
                new int[][] {{7, 7, 7}, {7, 7, 7}, {7, 7, 7}}));

        cases.add(new TestCase("20x20 generated (max size)",
                new Object[] {generate20()},
                expected20()));

        return cases;
    }

    // input[i][j] = i * 20 + j + 1
    private static int[][] generate20() {
        int n = 20;
        int[][] m = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                m[i][j] = i * n + j + 1;
            }
        }
        return m;
    }

    // Clockwise rotation: result[i][j] = input[n - 1 - j][i]
    private static int[][] expected20() {
        int n = 20;
        int[][] m = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                m[i][j] = (n - 1 - j) * n + i + 1;
            }
        }
        return m;
    }
}
