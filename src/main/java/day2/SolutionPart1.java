package day2;

import java.util.List;

public class SolutionPart1 {
    public static void main(String[] args) {

        List<List<Integer>> lines = FetcherDay02.extractAndTransform();


        assert lines != null;
        long countSafes = lines.stream().filter(SolutionPart1::isSafe).count();

        System.out.println(lines.size());
        System.out.println(countSafes);

    }

    private static boolean isSafe(List<Integer> numbers) {
        if (numbers.getLast() > numbers.getFirst()) {
            return isSafeIncreasing(numbers);
        } else if (numbers.getLast() < numbers.getFirst()) {
            return isSafeDecreasing(numbers);
        }
        return false;
    }

    private static boolean isSafeIncreasing(List<Integer> numbers) {
        for (int i = 0; i < numbers.size()-1; i++) {
            if (numbers.get(i) >= numbers.get(i + 1) || Math.abs(numbers.get(i) - numbers.get(i + 1)) > 3)
                return false;
        }
        return true;
    }

    private static boolean isSafeDecreasing(List<Integer> numbers) {
        for (int i = 0; i < numbers.size()-1; i++) {
            if (numbers.get(i) <= numbers.get(i + 1) || Math.abs(numbers.get(i) - numbers.get(i + 1)) > 3)
                return false;
        }
        return true;
    }


}


