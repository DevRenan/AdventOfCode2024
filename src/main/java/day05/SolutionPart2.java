package day05;

import java.util.Collections;
import java.util.List;

public class SolutionPart2 {
    public static void main(String[] args) {

        List<List<List<Integer>>> lists = FetcherDay05.extractAndTransform();
        assert lists != null;
        var listRules = lists.getFirst();
        var listUpdates = lists.getLast();
        System.out.println(listUpdates.size());


        fixAndCountIncorrectUpdates(listUpdates, listRules);

    }

    private static void fixAndCountIncorrectUpdates(List<List<Integer>> listUpdates, List<List<Integer>> rules) {
        var middleUpdatesCorrect = 0;
        for (List<Integer> updates : listUpdates) {
            if (!isUpdateCorrect(rules, updates)) {
                List<Integer> fixedUpdates = fixUpdateOrder(rules, updates);
                middleUpdatesCorrect+= fixedUpdates.get(fixedUpdates.size()/2);
            }
        }
        System.out.println(middleUpdatesCorrect);
    }

    private static List<Integer> fixUpdateOrder(List<List<Integer>> rules, List<Integer> updates) {
        for (int i = 0; i < updates.size() - 1; i++) {
            int finalI = i;
            List<Integer> numberSecondRules = rules.stream().filter(rule -> rule.getFirst().equals(updates.get(finalI))).map(List::getLast).toList();
            if (!numberSecondRules.contains(updates.get(finalI + 1))){
                Collections.swap(updates, finalI, finalI + 1);
                fixUpdateOrder(rules, updates);
            }
        }
        return updates;
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


