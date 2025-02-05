package day05;

import java.util.*;

public class SolutionPart1 {
    public static void main(String[] args) {

        List<List<List<Integer>>> lists = FetcherDay05.extractAndTransform();
        assert lists != null;
        var listRules = lists.getFirst();
        var listUpdates = lists.getLast();
        System.out.println(listUpdates.size());


        checkCorrectUpdates(listUpdates, listRules);

    }

    private static void checkCorrectUpdates(List<List<Integer>> listUpdates, List<List<Integer>> rules) {
        var middleUpdatesCorrect = 0;
        for (List<Integer> updates : listUpdates) {
            if (isUpdateCorrect(rules, updates)) {
                middleUpdatesCorrect+= updates.get(updates.size()/2);
            }
        }
        System.out.println(middleUpdatesCorrect);
    }

    private static boolean isUpdateCorrect(List<List<Integer>> rules, List<Integer> updates) {
        boolean correct = true;
        for (int i = 0; i < updates.size() - 1; i++) {
            int finalI = i;
            List<Integer> numberSecondRules = rules.stream().filter(rule -> rule.getFirst().equals(updates.get(finalI))).map(List::getLast).toList();
            if (!numberSecondRules.contains(updates.get(finalI + 1)))
                correct = false;
        }
        return correct;
    }
}


