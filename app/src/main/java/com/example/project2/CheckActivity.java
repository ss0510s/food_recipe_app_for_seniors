package com.example.project2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

//즐겨찾기
public class CheckActivity extends AppCompatActivity {

    TextView textView;
    androidx.appcompat.widget.Toolbar toolbar;
    Intent intent2;
    int item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);

        toolbar=findViewById(R.id.toolbar11);   //툴바
        TextView title=findViewById(R.id.title);    //툴바의 타이틀
        setSupportActionBar(toolbar);  //툴바를 액션바로 지정
        getSupportActionBar().setDisplayShowCustomEnabled(true);    //툴바를 보여줌
        getSupportActionBar().setDisplayShowTitleEnabled(false);    //기본 제목을 없애줌
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        title.setText("즐겨찾기");

        intent2=getIntent();
        textView=findViewById(R.id.text);
        item=intent2.getIntExtra("item",-1);
        textView.setText("양배추전");
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(CheckActivity.this, ItemActivity.class);
                intent.putExtra("item", 0);
                startActivity(intent);
            }
        });

    }
}
