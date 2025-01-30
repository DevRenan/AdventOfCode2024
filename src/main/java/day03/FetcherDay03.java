package day03;

import io.github.cdimascio.dotenv.Dotenv;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class FetcherDay03 {
    public static String extractAndTransform() {
        String url = "https://adventofcode.com/2024/day/3/input";
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

                return response.body();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
