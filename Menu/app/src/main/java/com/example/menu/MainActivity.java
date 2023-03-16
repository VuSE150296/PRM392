package com.example.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.TooltipCompat;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnSetColor, btnButton, btnGoodbye, btnDemo, btnComment;
    ConstraintLayout screen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();

        setOnClick();
    }

    private void AnhXa() {
        btnSetColor = (Button) findViewById(R.id.buttonSetColor);
        btnButton = (Button) findViewById(R.id.buttonPopup);
        btnGoodbye = (Button) findViewById(R.id.buttonGoodbye);
        btnDemo = (Button) findViewById(R.id.buttonDemo);
        btnComment = (Button) findViewById(R.id.buttonComment);

        screen = (ConstraintLayout) findViewById(R.id.screen);
    }

    private void setOnClick() {
//        btnSetColor.setOnClickListener(this);
        registerForContextMenu(btnSetColor);

        btnButton.setOnClickListener(this);
        btnGoodbye.setOnClickListener(this);
        btnDemo.setOnClickListener(this);
        btnComment.setOnClickListener(this);
    }

    private void showPopupMenu() {
        PopupMenu popupMenu = new PopupMenu(this, btnButton);
        popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.itemThem:
                        btnButton.setText("Them");
                        break;
                    case R.id.itemXoa:
                        btnButton.setText("Xoa");
                        break;
                    case R.id.itemSua:
                        btnButton.setText("Sua");
                        break;
                }
                return false;
            }
        });
        popupMenu.show();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itemVang:
                screen.setBackgroundColor(Color.YELLOW);
                break;
            case R.id.itemDo:
                screen.setBackgroundColor(Color.RED);
                break;
            case R.id.itemXanh:
                screen.setBackgroundColor(Color.BLUE);
                break;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonSetColor:
                break;
            case R.id.buttonPopup:
                showPopupMenu();
                break;
            case R.id.buttonGoodbye:
                break;
            case R.id.buttonDemo:
                break;
            case R.id.buttonComment:
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.d("onCreateOptionsMenu", "onCreateOptionsMenu: ");
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuExit:
                finishAffinity();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreatePanelMenu(int featureId, @NonNull Menu menu) {
        Log.d("onCreatePanelMenu", "onCreatePanelMenu: ");
        getMenuInflater().inflate(R.menu.context_menu, menu);
        return super.onCreatePanelMenu(featureId, menu);
    }
}