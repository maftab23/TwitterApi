package com.test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GetUserInfo {

    private static String BEARER_TOKEN = "AAAAAAAAAAAAAAAAAAAAAKmZlAEAAAAAngcj2ASKc%2BEvjGub5N7hWvmmw8s%3DNsz9NnJzbAyzg4SGGzHBbaqJ1P4tZ0kUPe25479YomRmMA095c";

    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {

        HttpRequest request = HttpRequest

                .newBuilder()
                .header("Authorization", "Bearer "+BEARER_TOKEN)
                .uri(new URI("https://api.twitter.com/2/users/767764039019528192?user.fields=created_at,entities,public_metrics"))
                .GET()
                .build();

        HttpClient httpClient = HttpClient.newBuilder().build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readValue(response.body(), JsonNode.class);

        System.out.println(response.statusCode());
        System.out.println(jsonNode.toString());

        String followersCount = jsonNode
                .get("data")
                .get("public_metrics")
                .get("followers_count")
                .asText();

        System.out.println("Followers Count : "+ followersCount);

    }

}