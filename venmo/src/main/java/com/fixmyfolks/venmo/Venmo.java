package com.fixmyfolks.venmo;

import retrofit.http.GET;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;
import retrofit.http.Query;

import com.fixmyfolks.venmo.model.OAuthToken;
import com.fixmyfolks.venmo.model.RecentPaymentData;
import com.fixmyfolks.venmo.model.PaymentData;

public interface Venmo {
    @FormUrlEncoded
    @POST("/v1/oauth/access_token")
    OAuthToken authenticate(@Field("client_id") String clientId, @Field("client_secret") String clientSecret, @Field("code") String authCode);

    @POST("/v1/payments")
    PaymentData makePayment(@Query("access_token") String accessToken);

    @GET("/v1/payments/{paymentId}")
    PaymentData getPayment(@Query("access_token") String accessToken, @Query("paymentId") String paymentId);

    @GET("/v1/payments")
    RecentPaymentData recentPayments(@Query("accessToken") String accessToken);
}
