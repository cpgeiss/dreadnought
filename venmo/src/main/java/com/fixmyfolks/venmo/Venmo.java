package com.fixmyfolks.venmo;

import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Query;

import com.fixmyfolks.venmo.model.RecentPaymentData;
import com.fixmyfolks.venmo.model.PaymentData;

public interface Venmo {
    @POST("/payments")
    PaymentData makePayment(@Query("access_token") String accessToken);

    @GET("/payments/{paymentId}")
    PaymentData getPayment(@Query("access_token") String accessToken, @Query("paymentId") String paymentId);

    @GET("/payments")
    RecentPaymentData recentPayments(@Query("accessToken") String accessToken);
}
