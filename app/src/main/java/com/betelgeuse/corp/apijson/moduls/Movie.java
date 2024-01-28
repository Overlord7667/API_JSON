package com.betelgeuse.corp.apijson.moduls;

//public class SearchObject {
//    String Title;
//    String Year;
//    String Type;
//    String Poster;
//
//    public SearchObject(String title, String year, String type, String poster) {
//        Title = title;
//        Year = year;
//        Type = type;
//        Poster = poster;
//    }
//
//    public String getTitle() {
//        return Title;
//    }
//
//    public void setTitle(String title) {
//        Title = title;
//    }
//
//    public String getYear() {
//        return Year;
//    }
//
//    public void setYear(String year) {
//        Year = year;
//    }
//
//    public String getType() {
//        return Type;
//    }
//
//    public void setType(String type) {
//        Type = type;
//    }
//
//    public String getPoster() {
//        return Poster;
//    }
//
//    public void setPoster(String poster) {
//        Poster = poster;
//    }
//}

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

//@lombok.NoArgsConstructor
//@lombok.Data
public class Movie implements Serializable {
//    @JsonProperty("Search")
//    private List<SearchDTO> search;
//    @JsonProperty("totalResults")
//    private String totalResults;
//    @JsonProperty("Response")
//    private String response;
//
////    @lombok.NoArgsConstructor
////    @lombok.Data
//    public static class SearchDTO {
//        @JsonProperty("Title")
//        private String title;
//        @JsonProperty("Year")
//        private String year;
//        @JsonProperty("imdbID")
//        private String imdbID;
//        @JsonProperty("Type")
//        private String type;
//        @JsonProperty("Poster")
//        private String poster;
//    }
    @SerializedName("Title")
    public String title;
    @SerializedName("Year")
    public String year;
    public String imdbID;
    @SerializedName("Type")
    public String type;
    @SerializedName("Poster")
    public String poster;
}
