package com.sayeedul.recyclerlogin;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class DisplayRecyclerview extends AppCompatActivity {


    RecyclerView recyclerView;
    MyAdapter myAdapter;
    List<ItemData> itemData;
    Button edit;

    String User,Pass,Country,Gender;
    Integer Pos;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_main);

        edit = (Button)findViewById(R.id.editBTN);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DisplayRecyclerview.this, MainActivity.class);
                intent.putExtra("USERNAME1",getIntent().getStringExtra("USERNAME"));
                intent.putExtra("PASSWORD1",getIntent().getStringExtra("PASSWORD"));
                intent.putExtra("GENDER1",getIntent().getStringExtra("GENDER"));
                intent.putExtra("COUNTRY1",getIntent().getStringExtra("COUNTRY"));
                intent.putExtra("POSITION1",getIntent().getIntExtra("POSITION",0));
                startActivity(intent);
            }
        });

       recyclerView = findViewById(R.id.recyclerVIEW);
       recyclerView.setHasFixedSize(true);
       recyclerView.setLayoutManager(new LinearLayoutManager(this));

       itemData = new ArrayList<>();

       itemData.add(new ItemData(R.drawable.ion,"USERNAME",getIntent().getStringExtra("USERNAME")));
       itemData.add(new ItemData(R.drawable.password,"PASSWORD",getIntent().getStringExtra("PASSWORD")));
       itemData.add(new ItemData(R.drawable.country,"COUNTRY",getIntent().getStringExtra("COUNTRY")));
       itemData.add(new ItemData(R.drawable.gender,"GENDER",getIntent().getStringExtra("GENDER")));

       myAdapter = new MyAdapter(this,itemData);
       recyclerView.setAdapter(myAdapter);

    }
}
