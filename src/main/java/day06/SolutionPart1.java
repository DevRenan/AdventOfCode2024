package day06;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SolutionPart1 {

    public static void main(String[] args) {

        List<List<String>> lines = FetcherDay06.extractAndTransform();
        assert lines != null;
        System.out.println(countSteps(lines));
    }

    public static int countSteps(List<List<String>> lines) {
        int[] guardPosition = findGuardPosition(lines);
        assert guardPosition != null;
        System.out.println(guardPosition[0] + " " + guardPosition[1]);

        int direction = 0;
        lines.get(guardPosition[0]).set(guardPosition[1], "X");
        int[] nextPosition = giveNextStep(guardPosition, direction);

        while (nextPosition[0] < lines.size() && nextPosition[1] < lines.getFirst().size()) {
            if (lines.get(nextPosition[0]).get(nextPosition[1]).equals("#")){
                direction++;
                nextPosition = giveNextStep(guardPosition, direction);
            }else{
                lines.get(nextPosition[0]).set(nextPosition[1], "X");
                guardPosition = nextPosition;
                nextPosition = giveNextStep(guardPosition, direction);
            }
        }
        return countX(lines);
    }

    private static int countX(List<List<String>> lines) {
        return Math.toIntExact(lines.stream().flatMap(List::stream).filter("X"::equals).count());
    }

    private static int[] giveNextStep(int[] guardPosition, int changeDirection) {
        int[] nextPosition = new int[guardPosition.length];

        for (int i = 0; i < guardPosition.length; i++) {
            nextPosition[i] = guardPosition[i] + defineDirections().get(changeDirection % 4).get(i);
        }
        return nextPosition;
    }

    private static int[] findGuardPosition(List<List<String>> lines) {
        for (int line = 0; line < lines.size(); line++) {
            for (int step = 0; step < lines.get(line).size(); step++) {
                if (lines.get(line).get(step).equals("^"))
                    return new int[]{line, step};
            }

        }
        return null;
    }

    private static ArrayList<List<Integer>> defineDirections() {
        ArrayList<List<Integer>> directions = new ArrayList<>();
        directions.add(List.of(-1, 0));
        directions.add(List.of(0, 1));
        directions.add(List.of(1, 0));
        directions.add(List.of(0, -1));
        return directions;
    }


    public static boolean countSteps(List<List<String>> lines, int stepsLimit) {
        int[] guardPosition = findGuardPosition(lines);
        assert guardPosition != null;
        System.out.println(guardPosition[0] + " " + guardPosition[1]);

        int direction = 0;
        lines.get(guardPosition[0]).set(guardPosition[1], "X");
        int[] nextPosition = giveNextStep(guardPosition, direction);

        while (nextPosition[0] < lines.size() && nextPosition[1] < lines.getFirst().size() && nextPosition[0]>=0 && nextPosition[1]>=0) {
            if (lines.get(nextPosition[0]).get(nextPosition[1]).equals("#")){
                direction++;
                nextPosition = giveNextStep(guardPosition, direction);
            }else{
                lines.get(nextPosition[0]).set(nextPosition[1], "X");
                guardPosition = nextPosition;
                nextPosition = giveNextStep(guardPosition, direction);
            }
            if (direction > stepsLimit/2)
               return true;
        }
        return false;
    }
}


