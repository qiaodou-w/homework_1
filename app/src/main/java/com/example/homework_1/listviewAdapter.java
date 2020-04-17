package com.example.homework_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class listviewAdapter extends ArrayAdapter<list_item> {
    private int resourceId;
    public listviewAdapter(@NonNull Context context, int TextId, @NonNull List objects) {
        super(context, TextId, objects);
        resourceId = TextId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        list_item list_item = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        TextView name = (TextView) view.findViewById(R.id.item_text);
        name.setText(list_item.getName());
        return view;
    }
}
