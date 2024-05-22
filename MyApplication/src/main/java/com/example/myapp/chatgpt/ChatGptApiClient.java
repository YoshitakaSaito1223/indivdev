package com.example.myapp.chatgpt;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatGptApiClient {

   @Autowired
   ChatGPT chatgpt;
    
    public String callChatGptApi(String role,String prompt) throws Exception {
        HttpClient client = HttpClient.newHttpClient();

        
        JSONArray messages = new JSONArray();
        messages.put(new JSONObject().put("role", role).put("content", prompt));

        JSONObject requestBody = new JSONObject();
        requestBody.put("model", "gpt-3.5-turbo");
        requestBody.put("messages", messages);
        requestBody.put("temperature", 0.5);
        requestBody.put("max_tokens", 256);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(chatgpt.getApiurl()))
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + chatgpt.getApikey())
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
    
}
