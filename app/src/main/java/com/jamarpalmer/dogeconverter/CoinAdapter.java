package com.jamarpalmer.dogeconverter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class CoinAdapter extends BaseAdapter {

    Context context;
    List<String> items;

    public CoinAdapter(@NonNull Context context, List items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setBackgroundColor(Color.parseColor("#EAEDB9"));
        TextView textView = new TextView(context);
        textView.setText(items.get(position));
        textView.setGravity(Gravity.CENTER);
        textView.setTextSize(20);
        textView.setPadding(20, 5, 20, 5);
        linearLayout.addView(textView);
        textView.setTypeface(textView.getTypeface(), Typeface.BOLD);

        return linearLayout;

    }


}
