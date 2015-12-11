package com.example.user.myapplication.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.user.myapplication.MainActivity;
import com.example.user.myapplication.R;

/**
 * Created by user on 12/9/2015.
 */
public class SearchAngkotFragment extends Fragment {
    private int position;
    private MainActivity.PasAdapterPager adapter;
    Button searchAngkot;

    public SearchAngkotFragment(int position, MainActivity.PasAdapterPager adapter){
        this.position = position;
        this.adapter = adapter;
    }

    @Override
    public  void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);
        final View rootView = inflater.inflate(R.layout.angkot_searcher, container, false);

        searchAngkot = (Button) rootView.findViewById(R.id.button);
        searchAngkot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment newFragment = new AngkotSolutionFragment();
                adapter.replaceFragment(position, newFragment);
                adapter.notifyDataSetChanged();
            }
        });

        return rootView;
    }
}
