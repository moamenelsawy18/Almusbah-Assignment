package com.assignment.almusbah.main;

import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.assignment.almusbah.BR;
import com.assignment.almusbah.R;
import com.assignment.almusbah.base.BaseRecyclerViewAdapter;
import com.assignment.almusbah.data.User;

import java.security.acl.Group;
import java.util.ArrayList;
import java.util.List;

public class UsersViewAdapter extends BaseRecyclerViewAdapter<User, UsersViewModel, UsersViewAdapter.UserViewHolder> {

    public UsersViewAdapter(List<User> dataSet, UsersViewModel viewModel) {
        super(dataSet, viewModel);
    }

    @Override
    protected UserViewHolder onCreateViewHolder(ViewDataBinding binding) {
        return new UserViewHolder(binding);
    }

    @Override
    protected int getLayoutIdForPosition(int position) {
        return R.layout.item_user;
    }

    @Override
    protected int getLayoutIdForLoading(int position) {
        return R.layout.item_shimmer_user;
    }

    protected class UserViewHolder extends BaseRecyclerViewAdapter.BaseViewHolder {
        ImagesViewAdapter mAdapter;

        UserViewHolder(ViewDataBinding binding) {
            super(binding);

            RecyclerView recyclerView = binding.getRoot().findViewById(R.id.recyclerView);

            GridLayoutManager layoutManager = new GridLayoutManager(binding.getRoot().getContext(), 2);
            layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    if (mAdapter != null) {
                        if (mAdapter.getItemViewType(position) == R.layout.item_image_odd)
                            return 2;
                        else
                            return 1;
                    } else {
                        return -1;
                    }
                }
            });
            recyclerView.setLayoutManager(layoutManager);
            mAdapter = new ImagesViewAdapter(
                    new ArrayList<>(0),
                    mViewModel
            );

            recyclerView.setAdapter(mAdapter);
        }

        @Override
        public void bind(Object item) {
            binding.setVariable(BR.viewModel, mViewModel);
            super.bind(item);
        }
    }


}