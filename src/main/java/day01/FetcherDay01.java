package day01;

import io.github.cdimascio.dotenv.Dotenv;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FetcherDay01 {
    public static List<List<Integer>> extractAndTransform() {
        String url = "https://adventofcode.com/2024/day/1/input";
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
               return splitColumnsToLists(responseBody);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static List<List<Integer>> splitColumnsToLists(String responseBody) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        Arrays.stream(responseBody.split("\n")).forEach(line -> {
            String[] parts = line.replaceAll("[^0-9]+", " ").trim().split(" ");
            list1.add(Integer.parseInt(parts[0]));
            list2.add(Integer.parseInt(parts[1]));
        });
        return Arrays.asList(list1, list2);
    }
}
