package com.example.finalhw;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CartActivity extends AppCompatActivity {

    private int[] counts = {1, 1, 1, 1};
    private TextView[] countTexts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("기말프로젝트");
        }

        countTexts = new TextView[] {
                findViewById(R.id.count01),
                findViewById(R.id.count02),
                findViewById(R.id.count03),
                findViewById(R.id.count04)
        };

        Button[] decreaseButtons = new Button[] {
                findViewById(R.id.decrease01),
                findViewById(R.id.decrease02),
                findViewById(R.id.decrease03),
                findViewById(R.id.decrease04),
        };

        Button[] increaseButtons = new Button[] {
                findViewById(R.id.increase01),
                findViewById(R.id.increase02),
                findViewById(R.id.increase03),
                findViewById(R.id.increase04)
        };


        for (int i = 0; i < increaseButtons.length; i++) {
            final int index = i;

            decreaseButtons[i]. setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (counts[index] > 1) {
                        counts[index]--;
                        countTexts[index].setText(String.valueOf(counts[index]));
                    }
                }
            });

            increaseButtons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    counts[index]++;
                    countTexts[index].setText(String.valueOf(counts[index]));
                }
            });
        }

        Button orderButton = findViewById(R.id.orderButton);
        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "주문창이 열립니다.", Toast.LENGTH_SHORT).show();
                final Dialog orderDialog = new Dialog(CartActivity.this);
                orderDialog.setContentView(R.layout.order_dialog);
                orderDialog.setTitle("주문창 화면");
                orderDialog.show();

                Button orderok = orderDialog.findViewById(R.id.orderok);
                Button ordercancel = orderDialog.findViewById(R.id.ordercancel);
                orderok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "주문되었습니다.", Toast.LENGTH_SHORT).show();
                    }
                });
                ordercancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "주문창이 닫힙니다.", Toast.LENGTH_SHORT).show();
                        orderDialog.dismiss();
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
            // 이미 장바구니 화면이므로 화면 이동 안 하고 토스트 메세지만 출력
            return true;
        } return super.onOptionsItemSelected(item);
    }
}