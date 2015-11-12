package com.example.user.myapplication;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import org.json.JSONException;

/**
 * Created by user on 10/8/2015.
 */
public class FirstFragment extends Fragment {

    private FragmentManager fm;
    private FragmentTransaction transaction;
    Button pindahbutton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);
        final View rootView = inflater.inflate(R.layout.fragment_first, container, false);

        pindahbutton = (Button) rootView.findViewById(R.id.button);
        pindahbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fm = getFragmentManager();
                transaction = fm.beginTransaction().replace(R.id.container, new ListSolution());
                transaction.commit();
            }
        });

        return rootView;
    }
}
