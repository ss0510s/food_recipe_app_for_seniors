package com.example.project2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.ArrayList;

public class FamousActivity extends AppCompatActivity implements MainAdapter3.onItemListener{


    androidx.appcompat.widget.Toolbar toolbar;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager linearLayoutManager; //리니어 레이아웃
    MainAdapter3 adapter;// Adapter adapter;
    private ArrayList<ItemList2> itemList=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_famous);

        toolbar=findViewById(R.id.toolbar5);   //툴바
        TextView title=findViewById(R.id.title);    //툴바의 타이틀
        setSupportActionBar(toolbar);  //툴바를 액션바로 지정
        getSupportActionBar().setDisplayShowCustomEnabled(true);    //툴바를 보여줌
        getSupportActionBar().setDisplayShowTitleEnabled(false);    //기본 제목을 없애줌
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        title.setText("유행하는 음식");

        setUpRecyclerView();
    }
    private void setUpRecyclerView() {

        itemList = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerView); //리사이클러뷰 참조
        //리니어 레이아웃
        linearLayoutManager = new LinearLayoutManager(this);
        //리사이클러뷰의 아이템뷰들을 리니어레이아웃으로 표시
        recyclerView.setLayoutManager(linearLayoutManager);
        fillData();
        adapter = new MainAdapter3(itemList);
        recyclerView.setAdapter(adapter);
        adapter.setOnClickListener(this);
    }

    private void fillData(){
        itemList = new ArrayList<>();
        itemList.add(new ItemList2(R.drawable.gambas,"감바스", "20대","올리브 오일에 새우, 마늘, 페페론치노 등을 넣고 끓인 스페인 전채 요리(느끼할 수 있어요!)",R.drawable.gambas_blog,R.drawable.gambas_y));
        itemList.add(new ItemList2(R.drawable.gimchibab,"김치밥","1-20대","쇠고기와 배추 등을 주재료로 한 전골 요리 (맛이 담백하고 깔끔해요!)",R.drawable.gimchi_b,R.drawable.gimchi_y));
        itemList.add(new ItemList2(R.drawable.mil,"밀푀유나베","3-40대","쌀에 김치를 섞어 지은 밥(기호에 따라 맵기를 조절하세요!)",R.drawable.mil_b,R.drawable.mil_y));
        itemList.add(new ItemList2(R.drawable.waffle,"와플팬요리","2-30대","밀가루에 야채를 주재료로 하여 와플팬 기계를 사용하여 지진 음식(느끼할 수 있어요!)",R.drawable.waffle_b,R.drawable.waffle_y));
    }
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
    public void onItemBlogClicked(int position) {
        switch (position) {
            case 0:
                Intent intent1=new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/tkmh1982/222203063097"));
                startActivity(intent1);
                break;
            case 1:
                Intent intent2=new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/lljjyy1983/221925250940"));
                startActivity(intent2);
                break;
            case 2:
                Intent intent3=new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/seohyun_9088/222118013074"));
                startActivity(intent3);
                break;
            case 3:
                Intent intent4=new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/darae9108/222194882972"));
                startActivity(intent4);
                break;
        }
    }
    public void onItemYoutubeClicked(int position) {
        switch (position) {
            case 0:
                Intent intent1=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=jBdQ65yHB_U&t=14s"));
                startActivity(intent1);
                break;
            case 1:
                Intent intent2=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=R6IT_f0XPT8&t=60s"));
                startActivity(intent2);
                break;
            case 2:
                Intent intent3=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=OrVSJv4emK4"));
                startActivity(intent3);
                break;
            case 3:
                Intent intent4=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=ju9F1ekgwbg"));
                startActivity(intent4);
                break;
        }
    }
}