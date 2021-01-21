package com.example.project2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

import static com.example.project2.R.drawable.*;

public class ItemActivity extends AppCompatActivity {

    androidx.appcompat.widget.Toolbar toolbar;
    private Intent intent;

    private ImageView image_main;
    private ImageView process1;
    private ImageView process2;
    private ImageView process3;
    private ImageView process4;
    private ImageView process5;
    private ImageView process6;
    private TextView textpro1;
    private TextView textpro2;
    private TextView textpro3;
    private TextView textpro4;
    private TextView textpro5;
    private TextView textpro6;

    private TextToSpeech tts;

    private ImageView star1;
    private ImageView star2;


    int item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        toolbar = findViewById(R.id.toolbar10);   //툴바
        TextView title = findViewById(R.id.title);    //툴바의 타이틀

        setSupportActionBar(toolbar);  //툴바를 액션바로 지정
        getSupportActionBar().setDisplayShowCustomEnabled(true);    //툴바를 보여줌
        getSupportActionBar().setDisplayShowTitleEnabled(false);    //기본 제목을 없애줌
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        image_main=findViewById(R.id.image_main);
        process1=findViewById(R.id.process1);
        process2=findViewById(R.id.process2);
        process3=findViewById(R.id.process3);
        process4=findViewById(R.id.process4);
        process5=findViewById(R.id.process5);
        process6=findViewById(R.id.process6);
        textpro1=findViewById(R.id.textpro1);
        textpro2=findViewById(R.id.textpro2);
        textpro3=findViewById(R.id.textpro3);
        textpro4=findViewById(R.id.textpro4);
        textpro5=findViewById(R.id.textpro5);
        textpro6=findViewById(R.id.textpro6);

        //intent로 데이터를 받음
        intent=getIntent();
        item=intent.getIntExtra("item",-1);


        star1=findViewById(R.id.star1);
        star2=findViewById(R.id.star2);
        star2.setVisibility(View.INVISIBLE);
        star1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                star1.setVisibility(View.INVISIBLE);
                star2.setVisibility(View.VISIBLE);
                Intent intent=new Intent(ItemActivity.this, CheckActivity.class);
                intent.putExtra("item", item);
            }
        });

        //음성인식 기능
        tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int state) {
                if (state == TextToSpeech.SUCCESS) {
                    tts.setLanguage(Locale.KOREAN);
                } else {
                    return;
                }
            }
        });


        switch (item) {
            case 0:
                title.setText("양배추전");
                image_main.setImageResource(cabbagejeon);
                process1.setImageResource(d1);
                process2.setImageResource(d2);
                process3.setImageResource(d3);
                process4.setImageResource(d4);
                process5.setImageResource(d5);
                process6.setImageResource(d6);
                textpro1.setText("1) 전에 들어갈 채소들 (양배추, 애호박, 당근)을 채썰어서 비닐백에 넣어주세요");
                textpro2.setText("2) 야채들을 담은 비닐백에 부침가루를 넣고 흔들어주세요");
                textpro3.setText("3) 계란 두개를 풀고 물을 아주 조금 넣어주세요");
                textpro4.setText("4) 계란물에 부침가루옷 입은 야채들을 넣고 섞어주세요");
                textpro5.setText("5) 달굴 팬에 기름을 두른 후 작은 국자로 한 국자씩 떠서 얇게 핀 뒤 한쪽 면부터 중불에 익혀요");
                textpro6.setText("6) 한쪽 면이 익으면 뒤집어서 눌러가며 구워주세요.");
                break;
            case 1:
                title.setText("양배추찜");
                image_main.setImageResource(cabbagejjim);
                break;
            case 2:
                title.setText("양배추무침");
                image_main.setImageResource(cabbagemuchim);
                break;
            case 3:
                title.setText("양배추롤");
                image_main.setImageResource(cabbageroll);
                break;
            case 4:
                title.setText("양배추굴소스볶음");
                image_main.setImageResource(gulsorcecabbagefried);
                break;
            case 5:
                title.setText("양배추샐러드");
                image_main.setImageResource(koalslo);
                break;
        }

        textpro1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                tts.setPitch(1f);
                tts.setSpeechRate(0.8f);

                tts.speak(textpro1.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
            }
        });
        textpro2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                tts.setPitch(1f);
                tts.setSpeechRate(0.8f);

                tts.speak(textpro2.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
            }
        });
        textpro3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                tts.setPitch(1f);
                tts.setSpeechRate(0.8f);

                tts.speak(textpro3.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
            }
        });
        textpro4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                tts.setPitch(1f);
                tts.setSpeechRate(0.8f);

                tts.speak(textpro4.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
            }
        });
        textpro5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                tts.setPitch(1f);
                tts.setSpeechRate(0.8f);
                tts.speak(textpro5.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
            }
        });
        textpro6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                tts.setPitch(1f);
                tts.setSpeechRate(0.8f);
                tts.speak(textpro6.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
            }
        });
    }

    public void onBackPressed() {
        super.onBackPressed();
        if(tts != null){
            tts.stop();
            tts.shutdown();
            tts = null;
        }

    }

    protected void onPause() {
        super.onPause();
        if(tts != null){
            tts.stop();
            tts.shutdown();
            tts = null;
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        // TTS 객체가 남아있다면 실행을 중지하고 메모리에서 제거한다.
        if(tts != null){
            tts.stop();
            tts.shutdown();
            tts = null;
        }
    }
}