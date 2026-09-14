import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> t = new ArrayList<List<Integer>>();
        List<Integer> row1 = new ArrayList<Integer>();

        row1.add(1);
        t.add(row1);

        for (int i = 2; i <= numRows; i++) {
            List<Integer> row2 = new ArrayList<Integer>();

            // t is my last added row
            int lastRowIndex = t.size() - 1;
            int lastRowSize = t.get(lastRowIndex).size();

            row2.add(1);
            for (int j = 0; j < lastRowSize - 1; j++) {
                row2.add(t.get(lastRowIndex).get(j) + t.get(lastRowIndex).get(j + 1));
            }
            row2.add(1);
            t.add(row2);
        }

        return t;
    }
}