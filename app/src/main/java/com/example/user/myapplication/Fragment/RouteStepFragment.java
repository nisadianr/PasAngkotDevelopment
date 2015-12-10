package com.example.user.myapplication.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.user.myapplication.adapter.AdapterRouteStep;
import com.example.user.myapplication.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 10/8/2015.
 */
public class RouteStepFragment extends Fragment {

    public List<JSONObject> steps = new ArrayList<>();
    private ListView listView;

    public RouteStepFragment(List<JSONObject> steps){
        this.steps = steps;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.list_step, parent, false);
        listView = (ListView) v.findViewById(R.id.listviewsolution);

        AdapterRouteStep adapter = new AdapterRouteStep(steps);

        listView.setAdapter(adapter);
        return v;
    }

    public List<JSONObject> getDummyRoute() throws JSONException {
        List<JSONObject>ls = new ArrayList<JSONObject>();

        ls.add(new JSONObject()
                .put("how", "jalan kaki")
                .put("description", "jalan kaki ke arah barat 100m")
                .put("need", null));

        ls.add(new JSONObject()
                .put("how", "Naik Angkot Panghegar-Dipati Ukur")
                .put("description", "menuju panghergar 592m")
                .put("need", "Rp2000"));

        ls.add(new JSONObject()
                .put("how", "Naik Angkot Dago-St.Hall")
                .put("description", "menuju St.Hall 1.5 km")
                .put("need", "Rp2000"));

        return ls;
    }


}
