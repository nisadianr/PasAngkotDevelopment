package com.example.user.myapplication.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.user.myapplication.AngkotSearcher;
import com.example.user.myapplication.R;
import com.example.user.myapplication.adapter.AdapterAngkotSolution;

import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by user on 12/8/2015.
 */
public class AngkotSolutionFragment extends Fragment {
    private android.app.FragmentManager fm;
    private FragmentTransaction transaction;
    private ListView listView;
    private ArrayList<JSONObject> angkot = new ArrayList<>();

    @Override
    public  void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);

        AngkotSearcher angkotSearcher = new AngkotSearcher();
        angkotSearcher.searchAngkot();
        angkot = angkotSearcher.getAngkotFinded();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);
        final View rootView = inflater.inflate(R.layout.list_solution, container, false);
        listView = (ListView) rootView.findViewById(R.id.listviewsolution);

        listView.setAdapter(new AdapterAngkotSolution());

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {
                JSONObject result = angkot.get(position);
                final FragmentManager fm = getFragmentManager();
                final FragmentTransaction transaction = fm.beginTransaction().replace(R.id.container,new AngkotDetailFragment(result));
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        return rootView;
    }
}
