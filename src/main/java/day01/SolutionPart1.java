package day01;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SolutionPart1 {
    public static void main(String[] args) {

        List<List<Integer>> lists = FetcherDay01.extractAndTransform();


        assert lists != null;
        List<Integer> leftList = lists.getFirst().stream().sorted().collect(Collectors.toList());
        List<Integer> rightList = lists.getLast().stream().sorted().collect(Collectors.toList());
        System.out.println(calculateTotalDistance(leftList, rightList));

    }

    private static Integer calculateTotalDistance(List<Integer> leftList, List<Integer> rightList){
        List<Integer> sumList = new ArrayList<>();
        for (int i = 0; i < leftList.size(); i++) {
            sumList.add(Math.abs(leftList.get(i) - rightList.get(i)));
        }



        return sumList.stream().mapToInt(Integer::intValue).sum();
    }
}


