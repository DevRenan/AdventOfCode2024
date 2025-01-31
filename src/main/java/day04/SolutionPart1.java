package day04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SolutionPart1 {

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
                if (matrix.get(line).get(column).equals("X")){
                    ArrayList<List<Integer>> directions = defineDirections();
                    count += countXMASinAllDirections(line, column, directions,0);
                }

            }
        }
        return count;
    }

    private static ArrayList<List<Integer>> defineDirections() {
        ArrayList<List<Integer>> directions = new ArrayList<>();
        directions.add(List.of(0, 1));
        directions.add(List.of(0, -1));
        directions.add(List.of(1, 0));
        directions.add(List.of(1, 1));
        directions.add(List.of(1, -1));
        directions.add(List.of(-1, -1));
        directions.add(List.of(-1, 0));
        directions.add(List.of(-1, 1));
        return directions;
    }

    private static int countXMASinAllDirections(int line, int column, ArrayList<List<Integer>> directions, int count) {
        ArrayList<String> xmasSplitted = new ArrayList<String>(List.of("M","A","S"));
        if(!directions.isEmpty()){
            List<Integer> direction = directions.getFirst();
            int finded = findXMASinOneDirection(line, column, direction, xmasSplitted);
            directions.removeFirst();
            return countXMASinAllDirections(line, column, directions, count+finded);
        }
        return count;
    }

    private static int findXMASinOneDirection(int line, int column, List<Integer> direction, ArrayList<String> xmasSplitted) {
        try{
            if(xmasSplitted.isEmpty())
                return 1;
            if (matrix.get(line + direction.getFirst()).get(column + direction.getLast()).equals(xmasSplitted.getFirst())) {
                xmasSplitted.remove(xmasSplitted.getFirst());
                return findXMASinOneDirection(line + direction.getFirst(), column + direction.getLast(), direction, xmasSplitted);
            }
            return 0;
        }catch (Exception e) {
            return 0;
        }

    }


}


