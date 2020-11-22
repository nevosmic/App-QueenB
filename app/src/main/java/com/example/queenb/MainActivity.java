package com.example.queenb;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.queenb.menu.MenuContent;
import com.example.queenb.menu.MenuRecyclerViewAdapter;

public class MainActivity extends AppCompatActivity {
    public NavigationIconClickListener mClickListener;
    @Override
    public void onWindowFocusChanged(boolean hasFocus){

        // set toolbar logo to center programmatically
        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        ImageView logo = (ImageView) findViewById(R.id.logo);
        int offset = (toolbar.getWidth() / 2) - (logo.getWidth() / 2);
        // set
        logo.setX(offset);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
        View view = inflater.inflate(R.layout.activity_main, null);
        setContentView(view);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MenuRecyclerViewAdapter(this, MenuContent.ITEMS));
        // Set up the tool bar
        setUpToolbar(view);

        // Check that the activity is using the layout version with
        // the fragment_container FrameLayout
        if (findViewById(R.id.fragment_container) != null)
        {

            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (savedInstanceState != null)
            {
                return;
            }

            // Create a new Fragment to be placed in the activity layout
            WhoAreWeF firstFragment = new WhoAreWeF();

            // In case this activity was started with special instructions from an
            // Intent, pass the Intent's extras to the fragment as arguments
            firstFragment.setArguments(getIntent().getExtras());

            // Add the fragment to the 'fragment_container' FrameLayout
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, firstFragment).commit();
        }
    }

    private void setUpToolbar(View view) {
        Toolbar toolbar = view.findViewById(R.id.app_bar);
        AppCompatActivity activity = this;
        if (activity != null) {
            activity.setSupportActionBar(toolbar);
        }
        mClickListener = new NavigationIconClickListener(
                MainActivity.this,
                view.findViewById(R.id.fragment_container),
                new AccelerateDecelerateInterpolator());
        toolbar.setNavigationOnClickListener(mClickListener);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        //toolbar.setLogo(R.drawable.app_logo);

    }


}