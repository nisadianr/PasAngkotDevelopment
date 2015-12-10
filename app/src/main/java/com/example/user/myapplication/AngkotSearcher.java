package com.example.user.myapplication;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by user on 12/9/2015.
 */
public class AngkotSearcher {
    private ArrayList <JSONObject> angkotFinded = new ArrayList<>();

    public void searchAngkot(){
        try {
            angkotFinded.add(new JSONObject()
                    .put("nama","Margahayu-Ledeng")
                    .put("no","15")
                    .put("jam","06.00-21.00 WIB")
                    .put("jumlah","29")
                    .put("jenis","Toyota Kijang, Suzuki APV")
                    .put("warna","Biru muda, Kuning muda"));

            angkotFinded.add(new JSONObject()
                    .put("nama","Margahayu-Buah Batu")
                    .put("no","10")
                    .put("jam","00.00-00.00 WIB")
                    .put("jumlah","0")
                    .put("jenis","Toyota Kijang, Suzuki APV")
                    .put("warna","Biru muda, Kuning muda"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<JSONObject> getAngkotFinded(){
        return angkotFinded;
    }
}
