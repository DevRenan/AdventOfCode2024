package day05;

import io.github.cdimascio.dotenv.Dotenv;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class FetcherDay05 {
    public static List<List<List<Integer>>> extractAndTransform() {
        String url = "https://adventofcode.com/2024/day/5/input";
        Dotenv dotenv = Dotenv.load();
        String sessionToken = dotenv.get("SESSION_TOKEN");


        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("Cookie", "session=" + sessionToken)
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            String responseBody = response.body();
            List<List<List<Integer>>> rulesAndUpdates = new ArrayList<>();
            rulesAndUpdates.add(splitLines(responseBody, "\\|"));
            rulesAndUpdates.add(splitLines(responseBody, ","));
            return rulesAndUpdates;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<List<Integer>> splitLines(String responseBody, String lineSeparator) {
        var linesStream = Arrays.stream(responseBody.split("\n"));
        return linesStream.map(line ->
                        Arrays.stream(line.split(lineSeparator))
                                .map(FetcherDay05::safeParseInt)
                                .filter(Objects::nonNull)
                                .collect(Collectors.toList())
                ).filter(item -> !((List<?>) item).isEmpty())
                .collect(Collectors.toList());
    }

    private static Integer safeParseInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException ex) {
            return null;
        }
    }
}
