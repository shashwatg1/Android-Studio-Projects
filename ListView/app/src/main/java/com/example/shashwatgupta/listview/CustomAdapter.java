package com.example.shashwatgupta.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Shashwat Gupta on 13-Jun-15.
 */
class CustomAdapter extends ArrayAdapter<String>{

    CustomAdapter(Context context, String[] weather) {
        super(context, R.layout.custom_row, weather);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater myInflater = LayoutInflater.from(getContext());
        View customView = myInflater.inflate(R.layout.custom_row, parent, false);

        String singleItem = getItem(position);
        TextView myText = (TextView) customView.findViewById(R.id.myText);
        ImageView myImage = (ImageView) customView.findViewById(R.id.myImage);

        myText.setText(singleItem);
        myImage.setImageResource(R.drawable.abc_btn_radio_to_on_mtrl_000);
        return customView;
    }
}
