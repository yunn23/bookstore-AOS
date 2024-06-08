package com.example.finalhw;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class BooklistActivity extends AppCompatActivity {

    private ImageView list1, list2;
    private TableLayout table1, table2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booklist);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("기말프로젝트");
        }

        list1 = findViewById(R.id.list1);
        list2 = findViewById(R.id.list2);
        table1 = findViewById(R.id.table1);
        table2 = findViewById(R.id.table2);
        list1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list1.setImageResource(R.drawable.list_type1);
                list2.setImageResource(R.drawable.list_type22);
                table1.setVisibility(View.VISIBLE);
                table2.setVisibility(View.GONE);
            }
        });

        list2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list1.setImageResource(R.drawable.list_type12);
                list2.setImageResource(R.drawable.list_type2);
                table1.setVisibility(View.GONE);
                table2.setVisibility(View.VISIBLE);
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
            return true;
        } else if (id == R.id.booklist) {
            return true;
        } else if (id == R.id.cart) {
            return true;
        } return super.onOptionsItemSelected(item);
    }


}