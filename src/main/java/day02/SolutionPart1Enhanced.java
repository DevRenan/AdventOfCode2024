package day02;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SolutionPart1Enhanced {
    public static void main(String[] args) {
        List<List<Integer>> lines = FetcherDay02.extractAndTransform();

        assert lines != null;
        long countSafes = lines.stream().map(ArrayList::new).filter(SolutionPart1Enhanced::isSafe).count();

        System.out.println(lines.size());
        System.out.println(countSafes);

    }

    public static boolean isSafe(List<Integer> numbers ) {
        List<Integer> numbersSorted = new ArrayList<Integer>(numbers.stream().sorted().toList());
        List<Integer> numbersSortedReversed = new ArrayList<Integer>(numbers.stream().sorted(Comparator.reverseOrder()).toList());
        if (!numbers.equals(numbersSorted) && !numbers.equals(numbersSortedReversed))
            return false;
        for (int i = 0; i < numbers.size()-1; i++) {
            var diff = Math.abs(numbers.get(i) - numbers.get(i+1));
            if (diff < 1 || diff > 3)
                return false;
        }
        return true;
    }
}


