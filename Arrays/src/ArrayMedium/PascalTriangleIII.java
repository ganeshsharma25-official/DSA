package ArrayMedium;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangleIII {

    public static void main(String[] args) {
        System.out.println(pascalTriangleIII(4).toString());
    }

    public static List<List<Integer>> pascalTriangleIII(int n) {

        List<List<Integer>> resultList = new ArrayList<>();

        for (int i = 1; i <= n; i++) {

            List<Integer> rowResult = new ArrayList<>();

            int result = 1;
            rowResult.add(result);

            for (int j = 1; j < i; j++) {

                result = result * (i - j) / j;
                rowResult.add(result);

            }

            resultList.add(rowResult);

        }

        return resultList;

    }

}
