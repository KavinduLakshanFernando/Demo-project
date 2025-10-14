package org.example.demoproject.Service;

import okhttp3.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class UserService {

    private final OkHttpClient client = new OkHttpClient();


    private static final String WEAVY_URL = "https://887bdcf727aa49e58ff72b838c562000.weavy.io";
    private static final String API_KEY = "ys_qJT9S5JvveUcvBHUmOTHwojdPclmPH4KUwr5";

    //  Create User
    public ResponseEntity<String> createUser(String userJson) throws IOException {
        RequestBody body = RequestBody.create(userJson, MediaType.parse("application/json"));
        Request request = new Request.Builder()
                .url(WEAVY_URL + "/api/users")
                .post(body)
                .addHeader("Authorization", "Bearer " + API_KEY)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return ResponseEntity.status(response.code()).body(response.body().string());
        }
    }

    //  List Users
    public ResponseEntity<String> listUsers() throws IOException {
        Request request = new Request.Builder()
                .url(WEAVY_URL + "/api/users")
                .get()
                .addHeader("Authorization", "Bearer " + API_KEY)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return ResponseEntity.status(response.code()).body(response.body().string());
        }
    }

    //  Get User
    public ResponseEntity<String> getUser(String id) throws IOException {
        Request request = new Request.Builder()
                .url(WEAVY_URL + "/api/users/" + id)
                .get()
                .addHeader("Authorization", "Bearer " + API_KEY)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return ResponseEntity.status(response.code()).body(response.body().string());
        }
    }

    //Update User
    public ResponseEntity<String> updateUser(String id, String userJson) throws IOException {
        RequestBody body = RequestBody.create(userJson, MediaType.parse("application/json"));
        Request request = new Request.Builder()
                .url(WEAVY_URL + "/api/users/" + id)
                .put(body)
                .addHeader("Authorization", "Bearer " + API_KEY)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return ResponseEntity.status(response.code()).body(response.body().string());
        }
    }

    //Delete User
    public ResponseEntity<String> deleteUser(String id) throws IOException {
        Request request = new Request.Builder()
                .url(WEAVY_URL + "/api/users/" + id)
                .delete()
                .addHeader("Authorization", "Bearer " + API_KEY)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return ResponseEntity.status(response.code()).body(response.body().string());
        }
    }
}
