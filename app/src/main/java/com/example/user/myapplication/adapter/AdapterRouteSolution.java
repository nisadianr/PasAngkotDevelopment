package com.example.user.myapplication.adapter;

import android.support.v4.app.FragmentManager;
import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.myapplication.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 11/12/2015.
 */
public class AdapterRouteSolution extends BaseAdapter{

    List<JSONObject> datas;
    FragmentManager fm;

    public AdapterRouteSolution(){
        datas = new ArrayList<>();
    }

    public AdapterRouteSolution(Context context, List<JSONObject> listRoute){
        datas = listRoute;
        fm =  ((ActionBarActivity)context).getSupportFragmentManager();
    }

    public AdapterRouteSolution(List<JSONObject> datas){
        this.datas = datas;
    }

//    public void add(Route obj){
//        datas.add(obj);
//    }

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
    public View getView(final int position, View convertView, ViewGroup parent) {
        View v;
        if(convertView == null) {
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_route_solution, parent, false);
            TextView howTextView = (TextView) v.findViewById(R.id.howcol);
            TextView descriptionTextView = (TextView) v.findViewById(R.id.descriptioncol);
            TextView needTextView = (TextView) v.findViewById(R.id.needcol);
            ImageView howImageView = (ImageView) v.findViewById(R.id.howimage);
            ImageView needImageView = (ImageView) v.findViewById(R.id.needimage);
//            v.setClickable(true);

            try {
                JSONObject current = datas.get(position);
                howTextView.setText(current.getString("how"));
                descriptionTextView.setText(current.getString("description"));

                howImageView.setImageResource(R.drawable.icon_angkot);
                if(current.getString("need") != null){
                    needTextView.setText(current.getString("need"));
                    needImageView.setImageResource(R.drawable.money);
                }else{
                    needTextView.setVisibility(View.GONE);
                    needImageView.setVisibility(View.GONE);
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


