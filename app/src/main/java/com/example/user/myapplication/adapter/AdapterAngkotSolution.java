package com.example.user.myapplication.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.myapplication.AngkotSearcher;
import com.example.user.myapplication.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by user on 12/9/2015.
 */
public class AdapterAngkotSolution extends BaseAdapter {
    ArrayList <JSONObject> angkot = new ArrayList<>();

    public AdapterAngkotSolution(){
        AngkotSearcher angkotSearcher = new AngkotSearcher();
        angkotSearcher.searchAngkot();
        angkot = angkotSearcher.getAngkotFinded();
    }

    @Override
    public int getCount() {
        return angkot.size();
    }

    @Override
    public Object getItem(int position) {
        return angkot.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;

        if(convertView == null) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_angkot_solution, parent, false);
            TextView angkotName = (TextView) view.findViewById(R.id.angkot_name);
            ImageView iconAngkot = (ImageView) view.findViewById(R.id.icon_angkot);
//            v.setClickable(true);

            try {
                JSONObject current = angkot.get(position);

                iconAngkot.setImageResource(R.drawable.icon_angkot);
                angkotName.setText(current.getString("nama"));

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        else
            view = convertView;

        return view;
    }
}
