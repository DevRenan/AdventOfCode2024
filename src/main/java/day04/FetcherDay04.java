package day04;

import io.github.cdimascio.dotenv.Dotenv;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FetcherDay04 {
    public static List<List<String>> extractAndTransform() {
        String url = "https://adventofcode.com/2024/day/4/input";
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
               return getMatrix(responseBody);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static List<List<String>> getMatrix(String responseBody) {
        var linesStream = Arrays.stream(responseBody.split("\n"));
        return linesStream.map(line ->
                        Arrays.stream(line.split(""))
                                .collect(Collectors.toList())
                        ).collect(Collectors.toList());
    }
}
