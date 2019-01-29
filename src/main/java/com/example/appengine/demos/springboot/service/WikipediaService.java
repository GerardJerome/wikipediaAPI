package com.example.appengine.demos.springboot.service;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

import com.google.api.client.json.Json;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

public class WikipediaService {

	
	private final String searchUrl = "https://fr.wikipedia.org/w/api.php?action=opensearch&format=json&search=";
	private final String contentUrl = "https://fr.wikipedia.org/w/api.php?action=query&prop=revisions&rvprop=content&format=json&titles=";
	
	/**
	 * 
	 * @param name
	 * @return
	 * @throws IOException
	 */
	public String getTitle(String name) throws IOException {
		URL url = new URL(searchUrl+name);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		InputStreamReader test = new InputStreamReader(con.getInputStream(),"UTF-8");
		JsonElement json = new JsonParser().parse(new JsonReader(test));
		System.out.println("TITLE :  "+json.getAsJsonArray().get(1).getAsJsonArray().get(0).toString());
		return json.getAsJsonArray().get(1).getAsJsonArray().get(0).toString().replace("\"", "");
	}

	public String getContent(String titre) throws IOException {
		String title = getTitle(titre);
		URL url = new URL(contentUrl+title);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		InputStreamReader test = new InputStreamReader(con.getInputStream(),"UTF-8");
		JsonObject json =(JsonObject) new JsonParser().parse(new JsonReader(test));
		return json.getAsJsonObject("query").getAsJsonObject("pages").getAsJsonObject().get(json.getAsJsonObject("query").getAsJsonObject("pages").entrySet().iterator().next().getKey()).getAsJsonObject().get("revisions").getAsJsonArray().get(0).getAsJsonObject().get("*").toString().replace("\"", "");
	}
	
	public String getInfoBox(String title) throws IOException {
		String content = getContent(title);
		String pattern = "Note = ";
		String oui = Arrays.asList(content.split("Infobox")).stream().reduce((first, second) -> second).get();
		String infobox = "";
		//Arrays.asList(oui.split(pattern)).get(0);
		return Arrays.asList(oui.split(pattern)).get(0);
		
	}
}
