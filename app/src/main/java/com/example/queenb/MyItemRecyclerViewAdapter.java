package com.example.queenb;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.queenb.dummy.DummyContent.DummyItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder> {

    private final List<DummyItem> mValues;
    private final FragmentActivity mActivity;
    public MyItemRecyclerViewAdapter(FragmentActivity activity, List<DummyItem> items) {
        mActivity = activity;
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mBtn.setText(mValues.get(position).text);
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
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final Button mBtn;
        public DummyItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mBtn = (Button) view.findViewById(R.id.item_btn_name);
        }
    }
}