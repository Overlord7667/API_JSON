package com.betelgeuse.corp.apijson.services;

import android.os.AsyncTask;

//import org.springframework.http.HttpMethod;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyServicesApi {
//    private final static String URL = "https://omdbapi.com/?s=Spiderman&apikey=5b9b7798";
//    private final static String BaseURL = "https://omdbapi.com/";
//    private final static String URL = "/";
//    private final static String URLParams = "?s=Spiderman&apikey=";
//    private final static String ApiKey = "5b9b7798";

//    public String FetchData(){
//
////        RestTemplate restTemplate = new RestTemplate();
////
////        ResponseEntity <String> responseEntity = restTemplate.exchange
////                ("https://omdbapi.com/?s=Spiderman&apikey=5b9b7798",
////                        HttpMethod.GET, null, String.class);
////        return responseEntity.getBody();
//
//        return null;
//
//
////            HttpURLConnection urlConnection = null;
////            BufferedReader reader = null;
////            String result = null;
////
////            try {
////                URL url = new URL("https://omdbapi.com/?s=Spiderman&apikey=5b9b7798");
////                urlConnection = (HttpURLConnection) url.openConnection();
////                InputStream inputStream = urlConnection.getInputStream();
////                reader = new BufferedReader(new InputStreamReader(inputStream));
////
////                StringBuilder builder = new StringBuilder();
////                String line;
////                while ((line = reader.readLine()) != null) {
////                    builder.append(line).append("\n");
////                }
////
////                result = builder.toString();
////            } catch (IOException e) {
////                e.printStackTrace();
////            } finally {
////                if (urlConnection != null) {
////                    urlConnection.disconnect();
////                }
////                if (reader != null) {
////                    try {
////                        reader.close();
////                    } catch (IOException e) {
////                        e.printStackTrace();
////                    }
////                }
////            }
////
////            return result;
////
////    }
//
//
////    @Override
////    protected String doInBackground(Void... voids) {
////        RestTemplate restTemplate = new RestTemplate();
////
////        ResponseEntity<String> responseEntity = restTemplate.exchange(
////                "https://omdbapi.com/?s=Spiderman&apikey=5b9b7798",
////                HttpMethod.GET, null, String.class);
////
////        return responseEntity.getBody();
////    }
////
////    @Override
////    protected void onPostExecute(String result) {
////        // Обработка результата, например, обновление UI
//    }
//    "https://omdbapi.com/?s=Spiderman&apikey=5b9b7798"
    public final static String BASE_URL = "https://omdbapi.com/";
    public final static String APIKEY = "5b9b7798";

    private static Retrofit retrofit = null;

    public static Retrofit getClient(){

        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
