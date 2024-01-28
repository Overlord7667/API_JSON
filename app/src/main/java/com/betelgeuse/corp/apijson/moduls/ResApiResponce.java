package com.betelgeuse.corp.apijson.moduls;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
//public class ResApiResponce {
//    ArrayList<SearchObject> Move;
//    String totalResult;
//    String Response;
//
//}
public class ResApiResponce implements Serializable {
    @SerializedName("Search")
    public ArrayList<Movie> search;
    public String totalResults;
    @SerializedName("Response")
    public String response;
}

