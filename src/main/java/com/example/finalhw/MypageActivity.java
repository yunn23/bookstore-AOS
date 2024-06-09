package com.example.finalhw;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MypageActivity extends AppCompatActivity {

    private static final String PrefsName = "AppPrefs";
    private static final String UserId = "ID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("기말프로젝트");
        }

        SharedPreferences prefs = getSharedPreferences(PrefsName, MODE_PRIVATE);
        String id = prefs.getString(UserId, null);

        if (id != null) {
            TextView username = findViewById(R.id.id);
            username.setText(id);
        }


        ImageButton mymenu01 = findViewById(R.id.mymenu01);
        mymenu01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "주문/결제 메뉴를 클릭했습니다.", Toast.LENGTH_SHORT).show();
            }
        });

        ImageButton mymenu02 = findViewById(R.id.mymenu02);
        mymenu02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "배송 메뉴를 클릭했습니다.", Toast.LENGTH_SHORT).show();
            }
        });

        ImageButton mymenu03 = findViewById(R.id.mymenu03);
        mymenu03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "취소/교환/반품 메뉴를 클릭했습니다.", Toast.LENGTH_SHORT).show();
            }
        });

        ImageButton mymenu04 = findViewById(R.id.mymenu04);
        mymenu04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "회원계정 메뉴를 클릭했습니다.", Toast.LENGTH_SHORT).show();
            }
        });

        Button recentButton = findViewById(R.id.recentButton);
        recentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "최근 본 상품 버튼을 클릭했습니다.", Toast.LENGTH_SHORT).show();
            }
        });

        Button logoutButton = findViewById(R.id.logoutButton);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "로그아웃 합니다.", Toast.LENGTH_SHORT).show();
                SharedPreferences prefs = getSharedPreferences(PrefsName, MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString(UserId, "ooo");
                editor.apply();
                Intent intent = new Intent(MypageActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.actionmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if ( id == R.id.home) {
            Toast.makeText(getApplicationContext(), "홈으로 메뉴가 클릭되었습니다.", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.booklist) {
            Toast.makeText(getApplicationContext(), "도서목록 메뉴가 클릭되었습니다.", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, BooklistActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.cart) {
            Toast.makeText(getApplicationContext(), "장바구니 메뉴가 클릭되었습니다.", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, CartActivity.class);
            startActivity(intent);
            return true;
        } return super.onOptionsItemSelected(item);
    }

}