package com.assignment.almusbah.data;

import android.content.Context;

import com.assignment.almusbah.network.ApiClient;
import com.assignment.almusbah.network.WebServices;

import io.reactivex.Observable;

public class UsersRepository {

    private WebServices apiService;

    public UsersRepository(Context context) {
        apiService = ApiClient.getClient(context)
                .create(WebServices.class);
    }

    public Observable<ApiResponse> getUsersList(int offset, int limit){
        return apiService.getUsersList(offset, limit);
    }

}
