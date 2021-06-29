package com.example.project2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.speech.tts.TextToSpeech.ERROR;

import java.util.Locale;

//첫화면
public class MainActivity extends AppCompatActivity {

    //툴바 생성
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

        //tts 적용
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

        //어플이름
        title.setText("이 요리 어뗘");

        //메인화면의 텍스트
        final TextView text=findViewById(R.id.text);
        text.setText("효능 : 효능별로 좋은 음식"+
                "\n" +
                "재료 : 해당 재료를 이용한 음식."+
                "\n"+
                "유행하는 음식 : 연령대별로 유행하는 음식"+
                "\n" +
                "즐겨찾기 : 즐겨찾기 체크된 요리법 바로 확인");

        //텍스트에 tts 적용
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

        //각각의 버튼에 다른화면에 이동하도록 기능 부여
        effectbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, EffectActivity.class);
                startActivity(intent);
            }
        }); //효능화면으로 이동

        materialbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, MaterialActivity.class);
                startActivity(intent);
            }
        }); //재료화면으로 이동

        famousbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, FamousActivity.class);
                startActivity(intent);
            }
        }); //유명한 음식 화면으로 이동

        checkbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, CheckActivity.class);
                startActivity(intent);
            }
        }); //즐겨찾기 화면으로 이동
    }

    //뒤로가기 기능 추가
    public void onBackPressed() {
        super.onBackPressed();
        if(tts != null){
            tts.stop();
            tts.shutdown();
            tts = null;
        }//뒤로가기시 음성 중단
    }
    protected void onPause() {
        super.onPause();
        if(tts != null){
            tts.stop();
            tts.shutdown();
            tts = null;
        } //tts 중지
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
