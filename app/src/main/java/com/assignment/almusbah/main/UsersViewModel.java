package com.assignment.almusbah.main;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;


import com.assignment.almusbah.base.BaseViewModel;
import com.assignment.almusbah.data.ApiResponse;
import com.assignment.almusbah.data.UsersRepository;
import com.assignment.almusbah.network.NetworkState;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class UsersViewModel extends BaseViewModel {

    private UsersRepository usersRepository;
    public NetworkState networkState;
    public ObservableField<Boolean> isPaging = new ObservableField<>(false);
    private int offset = 0;

    public UsersViewModel(@NonNull Application application) {
        super(application);

        usersRepository = new UsersRepository(application);
    }

    public void start(){
        getUsers();
    }

    private void getUsers() {
        networkState = NetworkState.RUNNING;

        mCompositeDisposable.add(usersRepository.getUsersList(offset,10)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        this::onGetUsersLoaded,
                        this::onGetUsersFail
                ));
    }

    private void onGetUsersLoaded(ApiResponse response){
        networkState = NetworkState.SUCCESS;
        users.addAll(response.getData().getUsers());
        apiResponse.set(response);
        offset = users.size();
    }

    private void onGetUsersFail(Throwable throwable) {
        networkState = NetworkState.FAILED;
    }

    @Override
    public void onLoadMore() {
        if (apiResponse.get().getData().isHasMore())
            getUsers();
    }
}
