package com.example.queenb.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.queenb.MainActivity;
import com.example.queenb.R;
import com.example.queenb.menu.MenuContent.MenuButtonItem;

import java.util.List;

public class MenuRecyclerViewAdapter extends RecyclerView.Adapter<MenuRecyclerViewAdapter.ViewHolder>
{

    private final List<MenuButtonItem> mItems;
    private final MainActivity mActivity;
    public MenuRecyclerViewAdapter(FragmentActivity activity, List<MenuButtonItem> items) {
        mActivity = (MainActivity) activity;
        mItems = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.menu_item, parent, false);
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
                    mActivity.mClickListener.emulateClick();
                    mActivity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            holder.mItem.destination).addToBackStack(null).commit();
            }
        });

    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        public final View mView;
        public final Button mBtn;
        public MenuButtonItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mBtn = (Button) view.findViewById(R.id.item_btn_id);
        }
    }


}