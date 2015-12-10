package com.example.user.myapplication.Fragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.user.myapplication.adapter.AdapterRouteSolution;
import com.example.user.myapplication.R;
import com.example.user.myapplication.Route;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by user on 11/12/2015.
 */
public class RouteSolutionFragment extends Fragment{

    private ListView listView;
    private ArrayList<Route> customRoute;

    @Override
    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);

        //search route
        customRoute = new ArrayList<>();
        try {
            Route route = new Route();
            route.dummyRouteOne();
            customRoute.add(route);

            route = new Route();
            route.dummyRouteTwo();
            customRoute.add(route);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.list_solution, parent, false);
        listView = (ListView) v.findViewById(R.id.listviewsolution);

        //get first step
        ArrayList<JSONObject> firstStep = new ArrayList<>();
        for(int i = 0; i<customRoute.size();i++){
            firstStep.add(customRoute.get(i).getFirstStep());
        }

        final AdapterRouteSolution adapter = new AdapterRouteSolution(getActivity(),firstStep);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {
                final FragmentManager fm = getFragmentManager();
                final FragmentTransaction transaction = fm.beginTransaction().replace(R.id.container,new RouteStepFragment(customRoute.get(position).listStep));
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        return v;
    }

//    @Override
//    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        FragmentManager fm = getFragmentManager();
//        FragmentTransaction transaction = fm.beginTransaction().replace(R.id.container,new ListStepFragment(customRoute.get(position).listStep));
//        transaction.commit();
//    }
}
