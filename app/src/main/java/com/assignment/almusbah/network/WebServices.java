package com.assignment.almusbah.network;


import com.assignment.almusbah.data.ApiResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WebServices {

    @GET("users")
    Observable<ApiResponse> getUsersList(@Query("offset") int offset, @Query("limit") int limit);

}
