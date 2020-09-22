package com.example.queenb.main_fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.queenb.R;

/**
 * A fragment representing a list of Items.
 */
public class MainFragment extends Fragment
{

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public MainFragment()
    {
    }
    public static MainFragment newInstance()
    {
        MainFragment fragment = new MainFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        // Set the adapter
        if (view instanceof RecyclerView)
        {
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setAdapter(new MainFragmentRecyclerViewAdapter(getActivity(), MainFragmentContent.ITEMS));
        }
        return view;
    }
}