package com.example.project2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.Filterable;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.ArrayList;

//재료들을 보여줄 화면
public class MaterialActivity extends AppCompatActivity implements MainAdapter.onItemListener {

    androidx.appcompat.widget.Toolbar toolbar;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager linearLayoutManager; //리니어 레이아웃
    MainAdapter adapter;// Adapter adapter;
    private ArrayList<ItemList> itemList=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material);
        toolbar=findViewById(R.id.toolbar2);   //툴바
        TextView title=findViewById(R.id.title);    //툴바의 타이틀
        setSupportActionBar(toolbar);  //툴바를 액션바로 지정
        getSupportActionBar().setDisplayShowCustomEnabled(true);    //툴바를 보여줌
        getSupportActionBar().setDisplayShowTitleEnabled(false);    //기본 제목을 없애줌
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        title.setText("재료실");

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
        adapter = new MainAdapter(itemList);
        recyclerView.setAdapter(adapter);
        adapter.setOnClickListener(this);
    }

    //재료 아이템 추가
    private void fillData(){
        itemList = new ArrayList<>();
        itemList.add(new ItemList(R.drawable.anchovy,"멸치"));
        itemList.add(new ItemList(R.drawable.bean,"콩"));
        itemList.add(new ItemList(R.drawable.broccoli,"브로콜리"));
        itemList.add(new ItemList(R.drawable.cabbage,"양배추"));
        itemList.add(new ItemList(R.drawable.carrot,"당근"));
        itemList.add(new ItemList(R.drawable.egg,"달걀"));
        itemList.add(new ItemList(R.drawable.peanut,"땅콩"));
        itemList.add(new ItemList(R.drawable.pumpkin,"호박"));
        itemList.add(new ItemList(R.drawable.radish,"무"));
        itemList.add(new ItemList(R.drawable.tomato,"토마토"));
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

    //아이템 클릭시 화면전환
    public void onItemClicked(int position) {
        Intent intent=new Intent(MaterialActivity.this, FoodActivity.class);
        intent.putExtra("material", position);
        startActivity(intent);
    }
}
