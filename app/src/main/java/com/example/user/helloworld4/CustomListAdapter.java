package com.example.user.helloworld4;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by user on 8/4/2016.
 */
public class CustomListAdapter extends ArrayAdapter {

    private final Activity context;
    private final List<EventModel> eList;
    EventModel tempValues = null;

    public CustomListAdapter(Activity context,  List<EventModel> eList) {
        super(context, R.layout.mylist, eList);
        this.context=context;
        this.eList = eList;

    }

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.mylist, null,true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.item);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        TextView extratxt = (TextView) rowView.findViewById(R.id.textView1);

        tempValues = eList.get(position);
        txtTitle.setText(tempValues.getNama());
        imageView.setImageResource(tempValues.getImage());
        extratxt.setText(tempValues.getTanggal());
        return rowView;

    };
}
