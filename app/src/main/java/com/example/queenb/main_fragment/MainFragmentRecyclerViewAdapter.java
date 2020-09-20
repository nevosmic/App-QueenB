package com.example.queenb.main_fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.queenb.R;
import com.example.queenb.main_fragment.MainFragmentContent.MainFragmentButtonItem;

import java.util.List;

public class MainFragmentRecyclerViewAdapter extends RecyclerView.Adapter<MainFragmentRecyclerViewAdapter.ViewHolder> {

    private final List<MainFragmentButtonItem> mItems;
    private final FragmentActivity mActivity;
    public MainFragmentRecyclerViewAdapter(FragmentActivity activity, List<MainFragmentButtonItem> items) {
        mActivity = activity;
        mItems = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_main_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mItems.get(position);
        holder.mBtn.setText(mItems.get(position).text);
        holder.mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                mActivity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        holder.mItem.destination).addToBackStack(null).commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final Button mBtn;
        public MainFragmentButtonItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mBtn = (Button) view.findViewById(R.id.item_btn_id);
        }
    }
}