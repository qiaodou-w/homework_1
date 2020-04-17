package com.example.homework_1;

import android.content.Context;
import android.view.View;
import android.widget.PopupMenu;

public class Popup_menu extends PopupMenu {
    public Popup_menu(Context context, View v) {
        super(context, v);
        PopupMenu popupMenu = new PopupMenu(context,v);
        popupMenu.getMenuInflater().inflate(R.menu.menu,popupMenu.getMenu());
        popupMenu.show();
    }
}
