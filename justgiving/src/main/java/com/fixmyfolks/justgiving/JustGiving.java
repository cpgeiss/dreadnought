package com.fixmyfolks.justgiving;

import java.util.List;

import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.Query;
import retrofit.http.Path;

import com.fixmyfolks.justgiving.model.Category;
import com.fixmyfolks.justgiving.model.Charity;

public interface JustGiving {
    @GET("/{appId}/v1/charity/categories")
    @Headers({
      "Content-Type: application/json"
    })
    List<Category> categories(@Path("appId") String appId);

    @GET("/{appId}/v1/charity/search")
    @Headers({
      "Content-Type: application/json"
    })
    Charity charitySearch(@Path("appId") String appId, @Query("q") String search);
}
