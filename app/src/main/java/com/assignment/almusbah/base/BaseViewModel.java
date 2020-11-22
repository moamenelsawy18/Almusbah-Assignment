package com.assignment.almusbah.base;

import android.app.Application;
import android.database.Observable;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;
import androidx.lifecycle.AndroidViewModel;

import com.assignment.almusbah.data.ApiResponse;
import com.assignment.almusbah.data.User;

import io.reactivex.disposables.CompositeDisposable;


public abstract class BaseViewModel extends AndroidViewModel {

    public CompositeDisposable mCompositeDisposable = new CompositeDisposable();
    public final ObservableList<User> users = new ObservableArrayList<>();
    public final ObservableField<ApiResponse> apiResponse = new ObservableField<>();

    public BaseViewModel(@NonNull Application application) {
        super(application);
    }


    public abstract void onLoadMore();
}
