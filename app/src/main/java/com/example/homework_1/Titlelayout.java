package com.example.homework_1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.widget.PopupMenu;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Titlelayout extends ConstraintLayout {
    public Titlelayout(final Context context, final AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.bar, this);
        final FloatingActionButton title_back = findViewById(R.id.back_button);
        final FloatingActionButton title_menu = findViewById(R.id.menu_button);
        title_back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity)getContext()).finish();
                Toast.makeText(context, "title_back", Toast.LENGTH_SHORT).show();
            }
        });
        title_menu.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                onMenuClick(title_menu);//输入逻辑   弹出popup菜单
            }
        });

    }

    public void onMenuClick(View v) {                   //定义popup菜单
        PopupMenu popupMenu = new PopupMenu(getContext(), v);
        popupMenu.getMenuInflater().inflate(R.menu.menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.rename_item:
                        Toast.makeText(getContext(),"rename",Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.delete_item:
                        Toast.makeText(getContext(),"delete",Toast.LENGTH_SHORT).show();
                        break;
                    default:

                }
                return true;
            }
        });
        popupMenu.show();

    }
}

