package day06;

import io.github.cdimascio.dotenv.Dotenv;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FetcherDay06 {
    private static List<List<String>> cachedData = null;

    public static List<List<String>> extractAndTransform() {
        if (cachedData != null) {
            return cachedData;
        }
        String url = "https://adventofcode.com/2024/day/6/input";
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

            cachedData = splitLines(response.body());
            return cachedData;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<List<String>> splitLines(String responseBody) {
        var linesStream = Arrays.stream(responseBody.split("\n"));
        return linesStream.map(line ->
                Arrays.stream(line.split(""))
                        .collect(Collectors.toList())
        ).collect(Collectors.toList());
    }
}
