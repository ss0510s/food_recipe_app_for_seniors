package com.example.project2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.ArrayList;

//효능에 따른 분류 화면
public class EffectActivity extends AppCompatActivity implements MainAdapter.onItemListener{
    androidx.appcompat.widget.Toolbar toolbar;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager linearLayoutManager; //리니어 레이아웃
    MainAdapter adapter;// Adapter adapter;

    //아이템을 저장할 리스트
    private ArrayList<ItemList> itemList=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_effect);

        toolbar=findViewById(R.id.toolbar4);   //툴바
        TextView title=findViewById(R.id.title);    //툴바의 타이틀
        setSupportActionBar(toolbar);  //툴바를 액션바로 지정
        getSupportActionBar().setDisplayShowCustomEnabled(true);    //툴바를 보여줌
        getSupportActionBar().setDisplayShowTitleEnabled(false);    //기본 제목을 없애줌
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);  //home화면으로 이동하는 버튼
        title.setText("효능");

        setUpRecyclerView();
    }

    //리사이클러뷰로 아이템들을 보여줌
    private void setUpRecyclerView() {
        itemList = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerView); //리사이클러뷰 참조
        //리니어 레이아웃
        linearLayoutManager = new LinearLayoutManager(this);
        //리사이클러뷰의 아이템뷰들을 리니어레이아웃으로 표시
        recyclerView.setLayoutManager(linearLayoutManager);
        fillData();
        adapter = new MainAdapter(itemList);
        recyclerView.setAdapter(adapter);
        adapter.setOnClickListener(this);
    }

    //아이템 리스트
    private void fillData(){
        itemList = new ArrayList<>();
        itemList.add(new ItemList(R.drawable.blood,"혈액순환"));
        itemList.add(new ItemList(R.drawable.bone,"뼈"));
        itemList.add(new ItemList(R.drawable.dementia_cheeme,"치매"));
        itemList.add(new ItemList(R.drawable.hair,"머리카락"));
        itemList.add(new ItemList(R.drawable.jang,"장"));
        itemList.add(new ItemList(R.drawable.joint,"관절"));
        itemList.add(new ItemList(R.drawable.liver,"간"));
        itemList.add(new ItemList(R.drawable.stomach,"위장"));
    }

    //메뉴 생성
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
    //아이템 클릭시 효과
    public void onItemClicked(int position) {
        Intent intent=new Intent(EffectActivity.this, EffectActivity2.class);
        //인수를 넘겨줌
        intent.putExtra("effect", position);
        startActivity(intent);
    }
}
