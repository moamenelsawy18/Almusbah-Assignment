package com.assignment.almusbah.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.assignment.almusbah.R;
import com.assignment.almusbah.databinding.UsersFragmentBinding;

import java.util.ArrayList;

public class UsersFragment extends Fragment {

    private UsersViewModel mViewModel;
    private UsersFragmentBinding mViewDataBinding;
    private UsersViewAdapter usersViewAdapter;

    @Override
    public void onStart() {
        super.onStart();
        mViewModel.start();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.users_fragment, container, false);
        if (mViewDataBinding == null) {
            mViewDataBinding = UsersFragmentBinding.bind(root);
        }
        mViewModel = ViewModelProviders.of(this).get(UsersViewModel.class);

        mViewDataBinding.setViewModel(mViewModel);

        setUpRecycler();
        return mViewDataBinding.getRoot();
    }

    private void setUpRecycler() {
        RecyclerView recyclerView = mViewDataBinding.usersListView.recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        usersViewAdapter = new UsersViewAdapter(
                new ArrayList<>(0),
                mViewModel
        );

        recyclerView.setAdapter(usersViewAdapter);
    }

}
