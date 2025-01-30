package day02;

import io.github.cdimascio.dotenv.Dotenv;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FetcherDay02 {
    public static List<List<Integer>> extractAndTransform() {
        String url = "https://adventofcode.com/2024/day/2/input";
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
               return splitLines(responseBody);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static List<List<Integer>> splitLines(String responseBody) {
        var linesStream = Arrays.stream(responseBody.split("\n"));
        return linesStream.map(line ->
                        Arrays.stream(line.split(" "))
                                .map(Integer::parseInt).collect(Collectors.toList())
                        ).collect(Collectors.toList());
    }
}
