package com.example.project2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.speech.tts.TextToSpeech;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.TextView;

import static android.speech.tts.TextToSpeech.ERROR;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    androidx.appcompat.widget.Toolbar toolbar;

    Button materialbutton;
    Button effectbutton;
    Button famousbutton;
    Button checkbutton;
    private TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=findViewById(R.id.toolbar1);   //툴바
        TextView title=findViewById(R.id.title);    //툴바의 타이틀
        tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != ERROR) {
                    // 언어를 선택한다.
                    tts.setLanguage(Locale.KOREAN);
                }
            }
        });

        setSupportActionBar(toolbar);  //툴바를 액션바로 지정
        getSupportActionBar().setDisplayShowCustomEnabled(true);    //툴바를 보여줌
        getSupportActionBar().setDisplayShowTitleEnabled(false);    //기본 제목을 없애줌
        title.setText("이 요리 어뗘");

        //메인화면 텍스트
        final TextView text=findViewById(R.id.text);
        text.setText("효능 : 효능별로 좋은 음식"+
                "\n" +
                "재료 : 해당 재료를 이용한 음식."+
                "\n"+
                "유행하는 음식 : 연령대별로 유행하는 음식"+
                "\n" +
                "즐겨찾기 : 즐겨찾기 체크된 요리법 바로 확인");

        text.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                tts.setPitch(1f);         // 음성 톤을 0.5배 내려준다.
                tts.setSpeechRate(0.8f);    // 읽는 속도는 기본 설정
                // editText에 있는 문장을 읽는다.
                tts.speak(text.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
            }
        });

        //버튼기능
        effectbutton=findViewById(R.id.button1);
        materialbutton=findViewById(R.id.button2);
        famousbutton=findViewById(R.id.button3);
        checkbutton=findViewById(R.id.button4);

        effectbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, EffectActivity.class);
                startActivity(intent);
            }
        });

        materialbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, MaterialActivity.class);
                startActivity(intent);
            }
        });
        famousbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, FamousActivity.class);
                startActivity(intent);
            }
        });
        checkbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, CheckActivity.class);
                startActivity(intent);
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