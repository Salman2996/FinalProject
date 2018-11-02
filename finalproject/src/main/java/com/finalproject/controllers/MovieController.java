package com.finalproject.controllers;

import java.util.Arrays;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MovieController {

	@Autowired
	RestTemplate restTemplate;

	@RequestMapping("movie/{movie}")
	public String getMovie(@PathVariable String movie) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		
		ResponseEntity<String> response = restTemplate.exchange("http://www.omdbapi.com/?apikey=cac2b61e&s=" + movie, HttpMethod.GET, entity, String.class);
		JSONObject jsonObject;
		try {
			jsonObject = new JSONObject(response.getBody());
			JSONArray jsonArray = jsonObject.getJSONArray("Search");
			
			for(int count = 0; count < jsonArray.length(); count++){
				System.out.println(jsonArray.getJSONObject(count).get("Title").toString());
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return restTemplate.exchange("http://www.omdbapi.com/?apikey=cac2b61e&s=" + movie, HttpMethod.GET, entity, String.class).getBody();
	}
}
