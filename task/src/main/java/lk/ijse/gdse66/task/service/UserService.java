package lk.ijse.gdse66.task.service;

import okhttp3.*;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class UserService {

    private static final String API_URL = "https://dc791b3b9e9a467ba02c0b7647e2bb10.weavy.io/api/users";
    private static final String API_KEY = "wys_m4Np6pVD3ipECRh44v6nMTpFYWXt6w0JP3UN";

    private final OkHttpClient client = new OkHttpClient();

    // Create User

    String userJson="{\n" +
            "    \"uid\": \"user1234\",\n" +
            "    \"email\": \"user@example.com\",\n" +
            "    \"given_name\": \"John\",\n" +
            "    \"middle_name\": \"Michael\",\n" +
            "    \"name\": \"John Michael Doe\",\n" +
            "    \"family_name\": \"Doe\",\n" +
            "    \"nickname\": \"Johnny\",\n" +
            "    \"phone_number\": \"+1234567890\",\n" +
            "    \"comment\": \"New user account created for testing.\",\n" +
            "    \"picture\": \"https://example.com/profile-picture.jpg\",\n" +
            "    \"directory\": \"default\",\n" +
            "    \"metadata\": {\n" +
            "        \"color\": \"blue\",\n" +
            "        \"size\": \"XL\"\n" +
            "    },\n" +
            "    \"tags\": [\"admin\", \"beta-tester\"],\n" +
            "    \"is_suspended\": false,\n" +
            "    \"is_bot\": false\n" +
            "}\n";
    public String createUser() throws IOException {
        RequestBody body = RequestBody.create(userJson, MediaType.parse("application/json; charset=utf-8"));
        Request request = new Request.Builder()
                .url(API_URL)
                .addHeader("Authorization", "Bearer " + API_KEY)
                .post(body)
                .build();

        try (Response response = client.newCall(request).execute()) {

            return response.body().string();
        }
    }

    // List Users
    public String listUsers() throws IOException {
        Request request = new Request.Builder()
                .url(API_URL)
                .addHeader("Authorization", "Bearer " + API_KEY)
                .get()
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
            return response.body().string();
        }
    }

    // Get User Details
    public String getUserDetails(String uid) throws IOException {
        Request request = new Request.Builder()
                .url(API_URL + "/" + uid)
                .addHeader("Authorization", "Bearer " + API_KEY)
                .get()
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
            return response.body().string();
        }
    }

    // Update User
    public String updateUser(String uid, String json) throws IOException {
        RequestBody body = RequestBody.create(json, MediaType.parse("application/json; charset=utf-8"));
        Request request = new Request.Builder()
                .url(API_URL + "/" + uid)
                .addHeader("Authorization", "Bearer " + API_KEY)
                .put(body)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
            return response.body().string();
        }
    }

    // Delete User
    public String deleteUser(String uid) throws IOException {
        Request request = new Request.Builder()
                .url(API_URL + "/" + uid)
                .addHeader("Authorization", "Bearer " + API_KEY)
                .delete()
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
            return response.body().string();
        }
    }
}
