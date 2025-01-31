package day03;

import day02.FetcherDay02;

import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class SolutionPart1 {
    public static void main(String[] args) {

        String text = FetcherDay03.extractAndTransform();
        assert text != null;

        Pattern patternCalculation = Pattern.compile("mul\\(\\d{1,3},\\d{1,3}\\)");
        List<String> mulInstructions = patternCalculation.matcher(text).results().map(MatchResult::group).toList();
        System.out.println(mulInstructions);

        Pattern patternParamsCalculation = Pattern.compile("mul\\((\\d+),(\\d+)\\)");
        var sum = mulInstructions.stream().map(instruction -> {
            Matcher matcher = patternParamsCalculation.matcher(instruction);
            matcher.find();
            int num1 = Integer.parseInt(matcher.group(1));
            int num2 = Integer.parseInt(matcher.group(2));
            return num2 * num1;

        }).reduce(0, Integer::sum);
        System.out.println(sum);
    }


}


