package day2;

import java.util.ArrayList;
import java.util.List;

public class SolutionPart2Failed {
    public static void main(String[] args) {
        List<List<Integer>> lines = FetcherDay02.extractAndTransform();

        assert lines != null;
        long countSafes = lines.stream().map(ArrayList::new).filter(SolutionPart2Failed::isSafe).count();

        System.out.println(lines.size());
        System.out.println(countSafes);

    }

    public static boolean isSafe(ArrayList<Integer> numbers) {
        if (numbers.getLast() > numbers.getFirst()) {
            return isSafeIncreasing(numbers);
        } else if (numbers.getLast() < numbers.getFirst()) {
            return isSafeDecreasing(numbers);
        } else{
            if (numbers.getLast() > numbers.get(1))
                return isSafeIncreasing(numbers);
            else
                return isSafeDecreasing(numbers);
        }
    }

    private static boolean isSafeIncreasing(ArrayList<Integer> numbers) {
        for (int i = 0; i < numbers.size()-1; i++) {
            if (numbers.get(i) >= numbers.get(i + 1)) {
                numbers.remove(numbers.get(i));
                return isSafeIncreasingTolerate(numbers);
            }
            if (Math.abs(numbers.get(i) - numbers.get(i + 1)) > 3){
                if(i==0)
                    if (Math.abs(numbers.get(i) - numbers.get(i + 2)) > 3)
                        numbers.remove(numbers.get(i));
                    else
                        numbers.remove(numbers.get(i+1));
                else
                    numbers.remove(numbers.get(i+1));
                return isSafeIncreasingTolerate(numbers) || isSafeDecreasingTolerate(numbers);
            }
        }
        return true;
    }

    private static boolean isSafeDecreasing(List<Integer> numbers) {
        for (int i = 0; i < numbers.size()-1; i++) {
            if (numbers.get(i) <= numbers.get(i + 1)) {
                numbers.remove(numbers.get(i));
                return isSafeDecreasingTolerate(numbers);
            }
            if (Math.abs(numbers.get(i) - numbers.get(i + 1)) > 3){
                if(i==0)
                    numbers.remove(numbers.get(i));
                else
                    numbers.remove(numbers.get(i+1));
                return isSafeDecreasingTolerate(numbers) || isSafeIncreasingTolerate(numbers) ;
            }
        }
        return true;
    }

    private static boolean isSafeIncreasingTolerate(List<Integer> numbers) {
        for (int i = 0; i < numbers.size()-1; i++) {
            if (numbers.get(i) >= numbers.get(i + 1) || Math.abs(numbers.get(i) - numbers.get(i + 1)) > 3) {
                return false;
            }
        }
        return true;
    }

    private static boolean isSafeDecreasingTolerate(List<Integer> numbers) {
        for (int i = 0; i < numbers.size()-1; i++) {
            if (numbers.get(i) <= numbers.get(i + 1) || Math.abs(numbers.get(i) - numbers.get(i + 1)) > 3)
                return false;
        }
        return true;
    }
}


