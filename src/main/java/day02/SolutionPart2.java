package day02;

import java.util.ArrayList;
import java.util.List;

public class SolutionPart2 {
    public static void main(String[] args) {
        List<List<Integer>> lines = FetcherDay02.extractAndTransform();

        assert lines != null;
        long countSafes = lines.stream().map(ArrayList::new).filter(numbers -> SolutionPart2.isSafe(numbers, true)).count();

        System.out.println(lines.size());
        System.out.println(countSafes);

    }

    public static boolean isSafe(List<Integer> numbers,boolean problemDampener ) {
        if (numbers.getLast() > numbers.getFirst()) {
            return isSafeIncreasing(numbers,problemDampener);
        } else if (numbers.getLast() < numbers.getFirst()) {
            return isSafeDecreasing(numbers,problemDampener);
        }
        return false;
    }

    private static boolean isSafeIncreasing(List<Integer> numbers, boolean problemDampener) {

        for (int i = 0; i < numbers.size()-1; i++) {
            if (numbers.get(i) >= numbers.get(i + 1) || Math.abs(numbers.get(i) - numbers.get(i + 1)) > 3)
                if (problemDampener){
                    for (int j = 0; j < numbers.size(); j++) {
                        var numbersDampener = new ArrayList<>(numbers);
                        numbersDampener.remove(j);
                        var isSafe = isSafe(numbersDampener,false);
                        if (isSafe)
                            return true;
                    }
                    return false;
                } else
                    return false;
        }
        return true;
    }

    private static boolean isSafeDecreasing(List<Integer> numbers, boolean problemDampener) {
        var numbersOriginal = new ArrayList<>(numbers);
        for (int i = 0; i < numbers.size()-1; i++) {
            if (numbers.get(i) <= numbers.get(i + 1) || Math.abs(numbers.get(i) - numbers.get(i + 1)) > 3)
                if (problemDampener){
                    for (int j = 0; j < numbers.size(); j++) {
                        var numbersDampener = new ArrayList<>(numbers);
                        numbersDampener.remove(j);
                        var isSafe = isSafe(numbersDampener,false);
                        if (isSafe)
                            return true;
                    }
                    return false;
                } else
                    return false;
        }
        return true;
    }


}


