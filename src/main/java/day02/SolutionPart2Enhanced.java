package day02;

import java.util.ArrayList;
import java.util.List;

public class SolutionPart2Enhanced {
    public static void main(String[] args) {
        List<List<Integer>> lines = FetcherDay02.extractAndTransform();

        assert lines != null;
        long countSafes = lines.stream().map(ArrayList::new).filter(SolutionPart2Enhanced::isSafe).count();

        System.out.println(lines.size());
        System.out.println(countSafes);

    }

    public static boolean isSafe(List<Integer> numbers ) {
        if(SolutionPart1Enhanced.isSafe(numbers))
            return true;
        else{
            for (int j = 0; j < numbers.size(); j++) {
                var numbersDampener = new ArrayList<>(numbers);
                numbersDampener.remove(j);
                if (SolutionPart1Enhanced.isSafe(numbersDampener))
                    return true;
            }
        }
        return false;
    }
}


