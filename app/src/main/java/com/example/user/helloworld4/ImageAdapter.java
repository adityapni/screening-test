package com.example.user.helloworld4;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by user on 8/4/2016.
 */
public class ImageAdapter extends BaseAdapter {

    private Context context;
    private final List<Guest> guests;

    public ImageAdapter(Context context, ArrayList<Guest> guests) {
        this.context = context;
        this.guests = guests;
        Log.i("adapter","guests: " +String.valueOf(guests));
    }

    @Override
    public int getCount() {
        return guests.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View gridView;

        if (convertView == null) {

            gridView = new View(context);

            // get layout from mobile.xml
            gridView = inflater.inflate(R.layout.mygrid, null);

            // set value into textview
            TextView textView = (TextView) gridView
                    .findViewById(R.id.grid_item_label);

            textView.setText(guests.get(position).getNama());

            // set image based on selected text
            ImageView imageView = (ImageView) gridView
                    .findViewById(R.id.grid_item_image);
            Log.i("adapter","test ");
            Log.i("adapter","guests: " +String.valueOf(guests));
            int img = guests.get(position).getImage();
            Log.i("adapter","img: " +String.valueOf(img));
            if (img==1) {
                imageView.setImageResource(R.drawable.ic_launcher);
            } else if (img==2) {
                imageView.setImageResource(R.drawable.ic_launcher2);
            } else if (img==3) {
                imageView.setImageResource(R.drawable.ic_launcher3);
            } else {
                imageView.setImageResource(R.drawable.ic_launcher4);
            }

        } else {
            gridView = (View) convertView;
        }

        return gridView;
    }
}
