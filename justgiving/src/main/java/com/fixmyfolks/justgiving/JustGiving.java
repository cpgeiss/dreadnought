package com.fixmyfolks.justgiving;

import java.util.List;

import retrofit.http.GET;
import retrofit.http.Query;
import retrofit.http.Path;

import com.fixmyfolks.justgiving.model.Category;
import com.fixmyfolks.justgiving.model.Charity;
import com.fixmyfolks.justgiving.model.DonationStatus;

public interface JustGiving {
    @GET("/{appId}/v1/charity/categories")
    List<Category> categories(@Path("appId") String appId);

    @GET("/{appId}/v1/charity/search")
    List<Charity> charitySearch(@Path("appId") String appId, @Query("categoryId") String categoryId);

    @GET("/{appId}/v1/donation/{donationId}/status")
    DonationStatus donationStatus(@Path("appId") String appId, @Path("donationId") String donationId);
}
