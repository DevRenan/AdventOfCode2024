package day03;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SolutionPart2 {
    public static void main(String[] args) {

        String text = FetcherDay03.extractAndTransform();
        assert text != null;

        Pattern patternDontCalculationText = Pattern.compile("don't\\(\\)(.*?)do\\(\\)");
        List<String> dontCalculationsText = patternDontCalculationText.matcher(text.replace("\n"," ")).results().map(MatchResult::group).toList();
        String allDontText = String.join("",dontCalculationsText);

        List<String> mulInstructions = new ArrayList<>(extractMulInstructions(text));
        List<String> dontMulInstructions = extractMulInstructions(allDontText);
        mulInstructions.removeAll(dontMulInstructions);

        var sum = getSum(mulInstructions);
        System.out.println(sum);
    }

    private static List<String> extractMulInstructions(String text) {
        Pattern patternCalculation = Pattern.compile("mul\\(\\d{1,3},\\d{1,3}\\)");
        return patternCalculation.matcher(text).results().map(MatchResult::group).toList();
    }

    private static Integer getSum(List<String> mulInstructions) {
        Pattern patternParamsCalculation = Pattern.compile("mul\\((\\d+),(\\d+)\\)");
        return mulInstructions.stream().map(instruction -> {
            Matcher matcher = patternParamsCalculation.matcher(instruction);
            matcher.find();
            int num1 = Integer.parseInt(matcher.group(1));
            int num2 = Integer.parseInt(matcher.group(2));
            return num2 * num1;

        }).reduce(0, Integer::sum);
    }


}


