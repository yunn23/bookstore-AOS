package com.example.finalhw;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private ImageView coverImage;
    private boolean isCover01 = true;
    private ImageButton menu01, menu02, menu03, menu04;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        coverImage = findViewById(R.id.coverImage);
        coverImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isCover01) {
                    coverImage.setImageResource(R.drawable.cover02);
                } else {
                    coverImage.setImageResource(R.drawable.cover01);
                }
                isCover01 = !isCover01;

            }
        });

        // 도서목록
        menu01 = findViewById(R.id.menu01);
        menu01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "도서목록 버튼이 클릭되었습니다.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, BooklistActivity.class);
                startActivity(intent);
            }
        });


        // 로그인
        menu02 = findViewById(R.id.menu02);
        menu02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "로그인 버튼이 클릭되었습니다.", Toast.LENGTH_SHORT).show();
            }
        });


        // 고객센터
        menu03 = findViewById(R.id.menu03);
        menu03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "고객센터 버튼이 클릭되었습니다.", Toast.LENGTH_SHORT).show();
            }
        });


        // 마이페이지
        menu04 = findViewById(R.id.menu04);
        menu04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "마이페이지 버튼이 클릭되었습니다.", Toast.LENGTH_SHORT).show();

            }
        });

    }
}