package com.example.user.myapplication;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 11/12/2015.
 */
public class Route {
    public ArrayList<JSONObject> listStep = new ArrayList<JSONObject>();

    public void addStep(JSONObject step){
        listStep.add(step);
    }

    public void dummyRouteOne() throws JSONException {
        listStep.add(new JSONObject()
                .put("how", "jalan kaki 1")
                .put("description", "jalan kaki ke arah barat 100m")
                .put("need", null));

        listStep.add(new JSONObject()
                .put("how", "Naik Angkot Panghegar-Dipati Ukur 1")
                .put("description", "menuju panghergar 592m")
                .put("need", "Rp2000"));

        listStep.add(new JSONObject()
                .put("how", "Naik Angkot Dago-St.Hall 1")
                .put("description", "menuju St.Hall 1.5 km")
                .put("need", "Rp2000"));
    }

    public void dummyRouteTwo() throws JSONException {
        listStep.add(new JSONObject()
                .put("how", "Naik Angkot Panghegar-Dipati Ukur 2")
                .put("description", "menuju panghergar 592m")
                .put("need", "Rp2000"));

        listStep.add(new JSONObject()
                .put("how", "jalan kaki")
                .put("description", "jalan kaki ke arah barat 100m 2")
                .put("need", null));

        listStep.add(new JSONObject()
                .put("how", "Naik Angkot Dago-St.Hall 2")
                .put("description", "menuju St.Hall 1.5 km")
                .put("need", "Rp2000"));
    }

    public JSONObject getFirstStep(){
        return  listStep.get(0);
    }
}
