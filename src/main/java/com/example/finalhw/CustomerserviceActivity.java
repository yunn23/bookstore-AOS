package com.example.finalhw;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CustomerserviceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customerservice);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("기말프로젝트");
        }

        EditText searchFAQ = findViewById(R.id.searchFAQ);
        searchFAQ.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                if (event != null && (event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) {
                    String inputText = searchFAQ.getText().toString().trim();
                    if (!inputText.isEmpty()) {
                        Toast.makeText(getApplicationContext(), inputText + "를 검색하였습니다.", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "검색어를 입력하세요.", Toast.LENGTH_SHORT).show();
                    }
                    return true;
                }
                return false;
            }
        });

        ImageButton faqmenu01 = findViewById(R.id.faqmenu01);
        ImageButton faqmenu02 = findViewById(R.id.faqmenu02);
        ImageButton faqmenu03 = findViewById(R.id.faqmenu03);
        ImageButton faqmenu04 = findViewById(R.id.faqmenu04);

        faqmenu01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "상품 FAQ가 클릭되었습니다.", Toast.LENGTH_SHORT).show();
            }
        });

        faqmenu02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "매장 FAQ가 클릭되었습니다.", Toast.LENGTH_SHORT).show();
            }
        });

        faqmenu03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "중고 FAQ가 클릭되었습니다.", Toast.LENGTH_SHORT).show();
            }
        });

        faqmenu04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "기타 FAQ가 클릭되었습니다.", Toast.LENGTH_SHORT).show();
            }
        });

        Button buttonFAQ = findViewById(R.id.buttonFAQ);
        buttonFAQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "1대 1 문의하기", Toast.LENGTH_SHORT).show();
                final Dialog faqDialog = new Dialog(CustomerserviceActivity.this);
                faqDialog.setContentView(R.layout.faq_dialog);
                faqDialog.setTitle("1대1문의 화면");
                faqDialog.show();

                Button faqok = faqDialog.findViewById(R.id.faqok);
                Button faqcancel = faqDialog.findViewById(R.id.faqcancel);
                faqok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "해당 문의가 정상적으로 등록되었습니다.", Toast.LENGTH_SHORT).show();
                    }
                });
                faqcancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        faqDialog.dismiss();
                    }
                });
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