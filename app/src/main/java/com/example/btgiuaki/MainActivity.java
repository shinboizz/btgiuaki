package com.example.btgiuaki;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvfruit;
    ArrayList<Fruit> arrayfruit = new ArrayList<>();
    FruitAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();


        adapter = new FruitAdapter(this, R.layout.dong_fruit, arrayfruit);
        lvfruit.setAdapter(adapter);


    }


    private void Anhxa() {
        lvfruit = (ListView) findViewById(R.id.listviewfruit);
        arrayfruit = new ArrayList<>();
        arrayfruit.add(new Fruit("Xoài", "Xoài Cát", R.drawable.xoai_1));
        arrayfruit.add(new Fruit("Cam", "Cam Sành", R.drawable.cam));
        arrayfruit.add(new Fruit("Táo", "Táo Đỏ", R.drawable.tao));
        arrayfruit.add(new Fruit("Thanh Long", "Thanh Long Phan Thiết", R.drawable.thanhlong_1));
        arrayfruit.add(new Fruit("Cherry", "Cherry Pháp", R.drawable.cherry));
        arrayfruit.add(new Fruit("Ổi", "Ổi 5roi", R.drawable.oi));


        registerForContextMenu(lvfruit);


    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.setHeaderTitle("Vui Lòng chọn : ");
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_ngucanh, menu);
        super.onCreateContextMenu(menu, v, menuInfo);

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case R.id.love:
                displayMessage("add to favorites list selected...");
                return true;


            case R.id.xoa:
                arrayfruit.remove(info.position);
                adapter.notifyDataSetChanged();
                return true;

            case R.id.music1:
                Intent intent = new Intent(MainActivity.this,Music.class);
                startActivity(intent);

            default:
                return super.onContextItemSelected(item);
        }
    }
    private void displayMessage(String message)
    {
        Snackbar.make(findViewById(R.id.listviewfruit),message,Snackbar.LENGTH_SHORT).show();

    }
}






