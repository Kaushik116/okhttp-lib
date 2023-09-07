package com.example.okhttp_demo_lib;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class NetworkManager {

    private static NetworkManager instance;
    private OkHttpClient client;

    public NetworkManager() {

        client = new OkHttpClient();
    }
    public static NetworkManager getInstance(){
        if(instance == null){
            synchronized (NetworkManager.class){
                if(instance == null){
                    instance = new NetworkManager();
                }
            }
        }
        return instance;
    }

    public void get(String url, Callback callback) {
        Request request = new Request.Builder().url(url).build();
        client.newCall(request).enqueue(callback);
    }

    public void post(String url, RequestBody requestBody, Callback callback) {
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        client.newCall(request).enqueue(callback);
    }
}
