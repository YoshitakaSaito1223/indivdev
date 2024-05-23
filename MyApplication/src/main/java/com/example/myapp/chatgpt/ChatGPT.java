package com.example.myapp.chatgpt;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
@ConfigurationProperties("chatgpt")
public class ChatGPT {

	private String apikey;
	private String apiurl;

	
}
s