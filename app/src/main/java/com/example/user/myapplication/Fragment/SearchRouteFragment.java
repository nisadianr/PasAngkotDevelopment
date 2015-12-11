package com.example.user.myapplication.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.user.myapplication.MainActivity;
import com.example.user.myapplication.OnBackPressListener;
import com.example.user.myapplication.R;

/**
 * Created by user on 10/8/2015.
 */
public class SearchRouteFragment extends Fragment implements OnBackPressListener {

    private int position;
    private MainActivity.PasAdapterPager adapter;
    Button pindahbutton;

    public SearchRouteFragment(int position, MainActivity.PasAdapterPager adapter){
        this.position = position;
        this.adapter = adapter;

    }

    @Override
    public  void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.route_searcher, container, false);

        pindahbutton = (Button) rootView.findViewById(R.id.button);
        pindahbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment newFragment = new RouteSolutionFragment();
                getChildFragmentManager().beginTransaction()
                        .addToBackStack(null)
                        .replace(R.id.container, newFragment)
                        .commit();
//                adapter.replaceFragment(position, newFragment);
            }
        });


        return rootView;
    }

    @Override
    public boolean onBackPressed() {
        return false;
    }
}
