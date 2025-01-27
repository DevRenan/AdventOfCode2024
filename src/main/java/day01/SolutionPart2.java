package day01;

import java.util.List;
import java.util.Optional;

public class SolutionPart2 {
    public static void main(String[] args) {


        List<List<Integer>> lists = FetcherDay01.extractAndTransform();
//        List<List<Integer>> lists = List.of(List.of(1,2,3,4,5,6), List.of(1,2,3,4,5,5,5));


        assert lists != null;
        List<Integer> leftList = lists.getFirst();
        List<Integer> rightList = lists.getLast();
        System.out.println(calculateSimilarity(leftList, rightList).get());

    }

    private static Optional<Long> calculateSimilarity(List<Integer> leftList, List<Integer> rightList) {
//        var similarity = 0;
//        for (int i = 0; i < leftList.size(); i++) {
//            Integer n1 = leftList.get(i);
//            similarity+= rightList.stream().filter(n1::equals).count() * n1;
//        }

        var similarity = leftList.stream().map(l1 -> l1*rightList.stream().filter(l1::equals).count()).reduce(Long::sum);
        return similarity;
    }
}
