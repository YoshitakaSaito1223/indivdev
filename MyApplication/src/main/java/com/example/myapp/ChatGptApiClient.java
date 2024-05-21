package com.example.myapp;

public class ChatGptApiClient {
/*
    private static final String API_URL = "https://api.openai.com/v1/chat/completions";
    private static final String API_KEY = "任意のAPI Key";

    public static void main(String[] args) {
        try {
            String responseMessage = callChatGptApi();
            System.out.println("Response from ChatGPT: " + responseMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String callChatGptApi() throws Exception {
        HttpClient client = HttpClient.newHttpClient();

        JSONArray messages = new JSONArray();
        messages.put(new JSONObject().put("role", "system").put("content", "You are a helpful assistant."));
        messages.put(new JSONObject().put("role", "user").put("content", "こんにちは"));

        JSONObject requestBody = new JSONObject();
        requestBody.put("model", "gpt-3.5-turbo");
        requestBody.put("messages", messages);
        requestBody.put("temperature", 0.5);
        requestBody.put("max_tokens", 256);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL))
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + API_KEY)
                .POST(BodyPublishers.ofString(requestBody.toString(), StandardCharsets.UTF_8))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            JSONObject jsonResponse = new JSONObject(response.body());
            return jsonResponse
                    .getJSONArray("choices")
                    .getJSONObject(0)
                    .getJSONObject("message")
                    .getString("content");
        } else {
            throw new RuntimeException("Failed to call ChatGPT API: " + response.body());
        }
    }
    */
}
