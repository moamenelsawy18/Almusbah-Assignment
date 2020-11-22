package com.assignment.almusbah.main;

import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;

import com.assignment.almusbah.BR;
import com.assignment.almusbah.R;
import com.assignment.almusbah.base.BaseRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class ImagesViewAdapter extends BaseRecyclerViewAdapter<String, UsersViewModel, BaseRecyclerViewAdapter.BaseViewHolder> {

    public ImagesViewAdapter(List<String> dataSet, UsersViewModel viewModel) {
        super(dataSet, viewModel);
    }

    @Override
    protected BaseRecyclerViewAdapter.BaseViewHolder onCreateViewHolder(ViewDataBinding binding) {
        return new ImageViewHolder(binding);
    }

    @Override
    protected int getLayoutIdForPosition(int position) {
        return R.layout.item_image_even;
    }

    @Override
    protected int getLayoutIdForLoading(int position) {
        return 0;
    }

    private int getOddLayoutIdForPosition(int position) {
        return R.layout.item_image_odd;
    }

    @Override
    public void onBindViewHolder(@NonNull BaseRecyclerViewAdapter.BaseViewHolder holder, int position) {
        holder.bind(mDataSet.get(position));
    }

    @Override
    public int getItemViewType(int position) {
        if ((mDataSet.size() % 2) != 0 && position == 0)
            return getOddLayoutIdForPosition(position);
        else
            return getLayoutIdForPosition(position);
    }

    protected class ImageViewHolder extends BaseViewHolder {

        ImageViewHolder(ViewDataBinding binding) {
            super(binding);
        }

        @Override
        public void bind(Object item) {
            binding.setVariable(BR.viewModel, mViewModel);
            super.bind(item);
        }
    }

}