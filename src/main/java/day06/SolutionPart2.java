package day06;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class SolutionPart2 {
    public static void main(String[] args) {
        List<List<String>> lines = FetcherDay06.extractAndTransform();
        assert lines != null;
        int countStepsLimit = SolutionPart1.countSteps(deepCopy(Objects.requireNonNull(FetcherDay06.extractAndTransform())));
        int obstacles = 0;
        for (int i = 0; i < lines.size(); i++) {
            for (int j = 0; j < lines.get(i).size(); j++) {
                List<List<String>> linesOriginal = deepCopy(Objects.requireNonNull(FetcherDay06.extractAndTransform()));
                if (!Objects.equals(linesOriginal.get(i).get(j), "^"))
                    linesOriginal.get(i).set(j, "#");
                boolean isLooping = SolutionPart1.countSteps(linesOriginal, countStepsLimit);
                if (isLooping) {
                    obstacles++;
                    System.out.println(obstacles);
                    System.out.println(i+" - "+j);
                }
            }
        }
        System.out.println(obstacles);
    }

    private static List<List<String>> deepCopy(List<List<String>> original) {
        List<List<String>> copy = new ArrayList<>();
        for (List<String> row : original) {
            copy.add(new ArrayList<>(row));
        }
        return copy;
    }

}


