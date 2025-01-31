package day04;

import java.util.ArrayList;
import java.util.List;


public class SolutionPart2 {

    private static List<List<String>> matrix;

    public static void main(String[] args) {

        matrix = FetcherDay04.extractAndTransform();
        assert matrix != null;

        int count = countXMASinMatrix();
        System.out.println(count);

    }

    private static int countXMASinMatrix() {
        int count = 0;

        for (int line = 0; line < matrix.size(); line++) {
            for (int column = 0; column < matrix.get(line).size(); column++) {
                if (matrix.get(line).get(column).equals("A")){
                    count += countMASinXDirections(line, column);
                }

            }
        }
        return count;
    }

    private static int countMASinXDirections(int line, int column) {
        try{
            boolean isXmas = verifyFirstXLeg(line, column) && verifySecondXLeg(line, column);
            if(isXmas)
                return 1;
        }catch (Exception e) {
            return 0;
        }
        return 0;
    }

    private static boolean verifyFirstXLeg(int line, int column) {
        if(matrix.get(line +1).get(column +1).matches("[MS]")){
            if(matrix.get(line -1).get(column -1).matches("[MS]")){
                if(!matrix.get(line -1).get(column -1).equals(matrix.get(line +1).get(column +1))){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean verifySecondXLeg(int line, int column) {
        if(matrix.get(line +1).get(column -1).matches("[MS]")){
            if(matrix.get(line -1).get(column +1).matches("[MS]")){
                if(!matrix.get(line +1).get(column -1).equals(matrix.get(line -1).get(column +1))){
                    return true;
                }
            }
        }
        return false;
    }


}


