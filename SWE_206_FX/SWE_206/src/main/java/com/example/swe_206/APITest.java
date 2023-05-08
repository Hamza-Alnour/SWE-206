package com.example.swe_206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class APITest {
    private static final String API_ENDPOINT = "https://us-central1-swe206-221.cloudfunctions.net/app";
    public static String checkCredentials(String username, String password) throws IOException {
        String userType = "";
        String urlString = "https://us-central1-swe206-221.cloudfunctions.net/app/UserSignIn" +
                "?username=" + username + "&password=" + password;
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String response = in.readLine();
            in.close();
            if (response.contains("student")) {
                userType = "Student";
            } else if (response.contains("admin")) {
                userType = "Admin";
            } else {
                userType = "unknown";
            }
        }
        return userType;
    }

}

