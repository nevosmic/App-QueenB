package com.example.queenb;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class ProjectsF extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_projects, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.project1).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openProject1();
            }
        });

        view.findViewById(R.id.project2).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openProject2();
            }
        });

        view.findViewById(R.id.project3).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openProject3();
            }
        });

        view.findViewById(R.id.project4).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openProject4();
            }
        });

        view.findViewById(R.id.project5).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openProject5();
            }
        });

        view.findViewById(R.id.project6).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openProject6();
            }
        });

        view.findViewById(R.id.project7).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openProject7();
            }
        });

        view.findViewById(R.id.project8).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openProject8();
            }
        });

        view.findViewById(R.id.project9).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openProject9();
            }
        });

        view.findViewById(R.id.project10).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openProject10();
            }
        });

        view.findViewById(R.id.register).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                register();
            }
        });
    }


    public void openProject1() {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://hqtvn--shirayeori.repl.co"));
        startActivity(intent);
    }

    public void openProject2() {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://hacaton2020--lyvrmvzs.repl.co"));
        startActivity(intent);
    }

    public void openProject3() {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://queenb-thing.danda123.repl.co"));
        startActivity(intent);
    }

    public void openProject4() {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://orangereddisguisedadaware.shaharl6000.repl.co/"));
        startActivity(intent);
    }


    public void openProject5() {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://hackathon-7--amitr72.repl.co"));
        startActivity(intent);
    }


    public void openProject6() {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://hqtvn--mayats1.repl.co"));
        startActivity(intent);
    }

    public void openProject7() {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://qvrnqtyby-nysyvn.liori.repl.co/"));
        startActivity(intent);
    }

    public void openProject8() {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://mypet--maram95.repl.co/"));
        startActivity(intent);
    }

    public void openProject9() {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://books--leahshl.repl.co/"));
        startActivity(intent);
    }

    public void openProject10() {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://apptemplate--naamaronen.repl.co/"));
        startActivity(intent);
    }

    public void register() {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.queenb.org.il/signup"));
        startActivity(intent);
    }


}