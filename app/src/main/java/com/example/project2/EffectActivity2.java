package com.example.project2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class EffectActivity2 extends AppCompatActivity {

    ImageView mainimage;
    ImageView image1;
    ImageView image2;
    ImageView image3;
    ImageView image4;
    ImageView image5;
    ImageView image6;
    ImageView image7;
    ImageView image8;
    ImageView image9;
    ImageView image10;
    TextView text;
    private Intent intent;
    private int effect;

    androidx.appcompat.widget.Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_effect2);

        toolbar=findViewById(R.id.toolbar6);   //툴바
        TextView title=findViewById(R.id.title);    //툴바의 타이틀
        setSupportActionBar(toolbar);  //툴바를 액션바로 지정
        getSupportActionBar().setDisplayShowCustomEnabled(true);    //툴바를 보여줌
        getSupportActionBar().setDisplayShowTitleEnabled(false);    //기본 제목을 없애줌
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        text=findViewById(R.id.quiz);
        mainimage = findViewById(R.id.mainimage);
        image1=findViewById(R.id.image1);
        image2=findViewById(R.id.image2);
        image3=findViewById(R.id.image3);
        image4=findViewById(R.id.image4);
        image5=findViewById(R.id.image5);
        image6=findViewById(R.id.image6);
        image7=findViewById(R.id.image7);
        image8=findViewById(R.id.image8);
        image9=findViewById(R.id.image9);
        image10=findViewById(R.id.image10);

        intent=getIntent();
        effect = intent.getIntExtra("effect", -1);

        switch (effect) {
            case 0:
                title.setText("혈액순환 효능");
                text.setText("혈액 순환에 좋은 것은?");
                break;
            case 1:
                title.setText("뼈 효능");
                text.setText("뼈에 좋은 것은?");
                break;
            case 2:
                title.setText("치매 효능");
                text.setText("치매 예방에 좋은 것은?");
                break;
            case 3:
                title.setText("머리카락 효능");
                text.setText("머리카락에 좋은 것은?");
                break;
            case 4:
                title.setText("장 효능");
                text.setText("장에 좋은 것은?");
                break;
            case 5:
                title.setText("관절 효능");
                text.setText("관절에 좋은 것은?");
                break;
            case 6:
                title.setText("간 효능");
                text.setText("간에 좋은 것은?");
                break;
            case 7:
                title.setText("위장 효능");
                text.setText("소화 기능이 떨어져 있을 때는 " +
                        "위액 분비에 도움이 되는 음식과 " +
                        "식이 섬유 성분이 적은 음식을 먹는게 좋다");
                mainimage.setImageResource(R.drawable.stomach);
                image1.setImageResource(R.drawable.gamja);
                image2.setImageResource(R.drawable.gim);
                image3.setImageResource(R.drawable.sigm);
                image4.setImageResource(R.drawable.you);
                image5.setImageResource(R.drawable.coffe);
                image6.setImageResource(R.drawable.gimchi);
                image7.setImageResource(R.drawable.sul);
                image8.setImageResource(R.drawable.tee);
                image9.setImageResource(R.drawable.gosari);
                image10.setImageResource(R.drawable.cabbage);

                image10.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(EffectActivity2.this, FoodActivity.class);
                        intent.putExtra("material", 3);
                        startActivity(intent);
                    }
                });
                break;
        }


    }
}