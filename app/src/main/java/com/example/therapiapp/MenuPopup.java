package com.example.therapiapp;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.widget.PopupMenu;

public class MenuPopup implements PopupMenu.OnMenuItemClickListener {

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        View view = item.getActionView();
        Context context = view != null ? context = view.getContext() : MainActivity.myContext;


        switch (item.getItemId()) {
            case R.id.startseite:
                context.startActivity(MainActivity.startseiteIntent);
                return true;
            case R.id.chat_bot:
                context.startActivity(MainActivity.chatbotIntent);
                return true;
            case R.id.tagebuch:
                System.out.println("tagebuch");

                return true;
            case R.id.tagesziel:
                System.out.println("tagesziel");
                return true;
            case R.id.ubungen:
                System.out.println("ubungen");
                return true;
            case R.id.wiki:
                System.out.println("wiki");
                return true;
            case R.id.kontakte:
                context.startActivity(MainActivity.kontactsIntent);
                return true;
            case R.id.einstellungen:
                System.out.println("einstellungen");
                return true;
            default:
                return false;
        }
    }
}
