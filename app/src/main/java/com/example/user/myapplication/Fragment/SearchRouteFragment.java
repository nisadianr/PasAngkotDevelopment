package com.example.user.myapplication.Fragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.user.myapplication.R;

/**
 * Created by user on 10/8/2015.
 */
public class SearchRouteFragment extends Fragment {

    private FragmentManager fm;
    private FragmentTransaction transaction;
    Button pindahbutton;

    @Override
    public  void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);
        final View rootView = inflater.inflate(R.layout.fragment_first, container, false);

        pindahbutton = (Button) rootView.findViewById(R.id.button);
        pindahbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fm = getFragmentManager();
                rootView.setEnabled(false);
                transaction = fm.beginTransaction()
                        .add(R.id.container, new AngkotSolutionFragment())
                        .hide(SearchRouteFragment.this)
                        .addToBackStack(SearchAngkotFragment.class.getName());
                transaction.commit();
            }
        });

        return rootView;
    }
}
