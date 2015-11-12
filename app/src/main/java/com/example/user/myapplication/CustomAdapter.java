package com.example.user.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 11/12/2015.
 */
public class CustomAdapter extends BaseAdapter {

    List<JSONObject> datas;

    public CustomAdapter(){
        datas = new ArrayList<>();
    }

    public CustomAdapter(List<JSONObject> datas){
        this.datas = datas;
    }

    public void add(JSONObject obj){
        datas.add(obj);
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v;
        if(convertView == null) {
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_list, parent, false);
            TextView howTextView = (TextView) v.findViewById(R.id.howcol);
            TextView descriptionTextView = (TextView) v.findViewById(R.id.descriptioncol);
            TextView needTextView = (TextView) v.findViewById(R.id.needcol);
            ImageView howImageView = (ImageView) v.findViewById(R.id.howimage);
            ImageView needImageView = (ImageView) v.findViewById(R.id.needimage);

            try {
                JSONObject current = datas.get(position);
                howTextView.setText(current.getString("how"));
                descriptionTextView.setText(current.getString("description"));

                howImageView.setImageResource(R.drawable.angkot);
                if(current.getString("need") != null){
                    needTextView.setText(current.getString("need"));
                    needImageView.setImageResource(R.drawable.money);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        else
            v = convertView;
        return v;
    }
}
