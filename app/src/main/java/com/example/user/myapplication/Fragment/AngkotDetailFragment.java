package com.example.user.myapplication.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.myapplication.R;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by user on 12/9/2015.
 */
public class AngkotDetailFragment extends Fragment {
    public JSONObject angkotDetail;
    private TextView detailView;
    private TextView nameView;
    private ImageView iconView;

    public AngkotDetailFragment(JSONObject angkotDetail){
        this.angkotDetail = angkotDetail;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.angkot_detail, parent, false);
        detailView= (TextView) v.findViewById(R.id.angkot_detail);
        nameView = (TextView) v.findViewById(R.id.angkot_name);
        iconView = (ImageView) v.findViewById(R.id.icon_angkot);

        iconView.setImageResource(R.drawable.icon_angkot);
        try {
            String detail;
            String angkotName = angkotDetail.getString("nama");
            nameView.setText(angkotName);

            detail  = "No. Trayek    :"+angkotDetail.getString("no")+"\n";
            detail += "Jam Operasi   :"+angkotDetail.getString("jam")+"\n";
            detail += "Jumlah Armada :"+angkotDetail.getString("jumlah")+"\n";
            detail += "Jenis Mobil   :"+angkotDetail.getString("jenis")+"\n";
            detail += "Warna Mobil   :"+angkotDetail.getString("warna")+"\n";

            detailView.setText(detail);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return v;
    }
}
