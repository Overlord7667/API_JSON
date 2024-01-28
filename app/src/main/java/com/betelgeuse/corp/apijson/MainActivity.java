package com.betelgeuse.corp.apijson;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.betelgeuse.corp.apijson.adapter.MovieAdapter;
import com.betelgeuse.corp.apijson.moduls.Movie;
import com.betelgeuse.corp.apijson.moduls.ResApiResponce;
import com.betelgeuse.corp.apijson.services.ApiInterface;
import com.betelgeuse.corp.apijson.services.MyServicesApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import androidx.appcompat.widget.SearchView;

public class MainActivity extends AppCompatActivity{

    Button buttonLeft;
    Button buttonRight;
    int pageNumber = 1;

    SearchView searchView;
    ApiInterface apiService;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerview);

        buttonLeft = findViewById(R.id.leftBtn);
        buttonRight = findViewById(R.id.rightBtn);
        searchView = findViewById(R.id.searchMovie);

        apiService = MyServicesApi.getClient().create(ApiInterface.class);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        if (MyServicesApi.APIKEY.isEmpty()) {
            Toast.makeText(this, "Please add apiKey!", Toast.LENGTH_SHORT).show();
            finish();
        }
//        Toast.makeText(this, "Is Ok", Toast.LENGTH_SHORT).show();
        apiService = MyServicesApi.getClient().create(ApiInterface.class);

        Call<ResApiResponce> call = apiService.getMoveByName("Iron-man", MyServicesApi.APIKEY, pageNumber);
        call.enqueue(new Callback<ResApiResponce>() {
            @Override
            public void onResponse(Call<ResApiResponce> call, Response<ResApiResponce> response) {
                if (response.isSuccessful() && response.body() != null && response.body().search != null) {
                    Log.i("Movie", "onResponse: " + response.body().totalResults);
                    Log.i("Movie", "onResponse: " + response.body().search.size());
                    StringBuilder stringBuilder = new StringBuilder();
                    for (Movie movie : response.body().search) {
                        stringBuilder.append(movie.title + " " + movie.type + " " + movie.year + " " + movie.poster + "\n");
                    }
                    Log.i("Movie", "onResponse: " + stringBuilder.toString());
                    recyclerView.setAdapter(new MovieAdapter(getApplicationContext(),
                            R.layout.movie_item,
                            response.body().search));
                } else {
                    Log.i("Movie", "Response is null or empty.");
                    // Ваш код обработки ошибки или пустого ответа
                }
            }

            @Override
            public void onFailure(Call<ResApiResponce> call, Throwable t) {
                Log.i("Movie", "OnError " + t.getMessage());
            }
        });

        buttonLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pageNumber >= 1) {
                    pageNumber--;
//
//                    apiService.getMoveByName("Hulk", MyServicesApi.APIKEY, pageNumber)
//                            .enqueue(new Callback<ResApiResponce>() {
//                                @Override
//                                public void onResponse(Call<ResApiResponce> call, Response<ResApiResponce> response) {
//                                    if (response.isSuccessful()) {
//                                        recyclerView.setAdapter(new MovieAdapter(getApplicationContext(),
//                                                R.layout.movie_item,
//                                                response.body().search));
//                                    } else {
//                                    }
//                                }
//                                @Override
//                                public void onFailure(Call<ResApiResponce> call, Throwable t) {
//                                }
//                            });
                    Call<ResApiResponce> call = apiService.getMoveByName("Iron-man", MyServicesApi.APIKEY, pageNumber);
                    call.enqueue(new Callback<ResApiResponce>() {
                        @Override
                        public void onResponse(Call<ResApiResponce> call, Response<ResApiResponce> response) {
                            if (response.isSuccessful() && response.body() != null && response.body().search != null) {
                                Log.i("Movie", "onResponse: " + response.body().totalResults);
                                Log.i("Movie", "onResponse: " + response.body().search.size());
                                StringBuilder stringBuilder = new StringBuilder();
                                for (Movie movie : response.body().search) {
                                    stringBuilder.append(movie.title + " " + movie.type + " " + movie.year + " " + movie.poster + "\n");
                                }
                                Log.i("Movie", "onResponse: " + stringBuilder.toString());
                                recyclerView.setAdapter(new MovieAdapter(getApplicationContext(),
                                        R.layout.movie_item,
                                        response.body().search));
                            } else {
                                Log.i("Movie", "Response is null or empty.");
                                // Ваш код обработки ошибки или пустого ответа
                            }
                        }

                        @Override
                        public void onFailure(Call<ResApiResponce> call, Throwable t) {
                            Log.i("Movie", "OnError " + t.getMessage());
                        }
                    });
                } else {
                    Toast.makeText(getApplicationContext(), "Невозможно загрузить страницу", Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pageNumber++;

                Call<ResApiResponce> call = apiService.getMoveByName("Iron-man", MyServicesApi.APIKEY, pageNumber);
                call.enqueue(new Callback<ResApiResponce>() {
                    @Override
                    public void onResponse(Call<ResApiResponce> call, Response<ResApiResponce> response) {
                        if (response.isSuccessful() && response.body() != null && response.body().search != null) {
                            Log.i("Movie", "onResponse: " + response.body().totalResults);
                            Log.i("Movie", "onResponse: " + response.body().search.size());
                            StringBuilder stringBuilder = new StringBuilder();
                            for (Movie movie : response.body().search) {
                                stringBuilder.append(movie.title + " " + movie.type + " " + movie.year + " " + movie.poster + "\n");
                            }
                            Log.i("Movie", "onResponse: " + stringBuilder.toString());
                            recyclerView.setAdapter(new MovieAdapter(getApplicationContext(),
                                    R.layout.movie_item,
                                    response.body().search));
                        } else {
                            Log.i("Movie", "Response is null or empty.");
                            // Ваш код обработки ошибки или пустого ответа
                        }
                    }

                    @Override
                    public void onFailure(Call<ResApiResponce> call, Throwable t) {
                        Log.i("Movie", "OnError " + t.getMessage());
                    }
                });
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchMovie(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // Вы можете реагировать на изменения текста в поисковой строке
                // Например, фильтровать результаты по мере ввода текста
                return false;
            }
        });

    }

    private void searchMovie(String title) {
        recyclerView = findViewById(R.id.recyclerview);
        apiService.getMoveByName(title, MyServicesApi.APIKEY, pageNumber)
                .enqueue(new Callback<ResApiResponce>() {
                    @Override
                    public void onResponse(Call<ResApiResponce> call, Response<ResApiResponce> response) {
                        // Обработка ответа
                        if (response.isSuccessful()) {
                            recyclerView.setAdapter(new MovieAdapter(getApplicationContext(),
                                    R.layout.movie_item,
                                    response.body().search));
                        } else {
                        }
                    }
                    @Override
                    public void onFailure(Call<ResApiResponce> call, Throwable t) {
                    }
                });
    }

//    public void CallData(View view) {
////        MyServicesApi myServicesApi = new MyServicesApi();
////        Toast.makeText(this, myServicesApi.FetchData() , Toast.LENGTH_SHORT).show();
//    }
}