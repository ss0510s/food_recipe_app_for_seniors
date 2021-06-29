package com.example.project2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.ArrayList;

//재료에 따른 음식들을 보여주는 화면
public class FoodActivity extends AppCompatActivity implements MainAdapter2.onItemListener{

    private Intent intent;
    int material;

    androidx.appcompat.widget.Toolbar toolbar;
    RecyclerView recyclerView;
    //리사이클러뷰의 아이템뷰들을 리니어레이아웃으로 표시
    //리니어 레이아웃
    RecyclerView.LayoutManager gridLayoutManager; //그리드 레이아웃
    MainAdapter2 adapter;// Adapter adapter;
    ArrayList<ItemList> itemList2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        toolbar = findViewById(R.id.toolbar3);   //툴바
        TextView title = findViewById(R.id.title);    //툴바의 타이틀
        setSupportActionBar(toolbar);  //툴바를 액션바로 지정
        getSupportActionBar().setDisplayShowCustomEnabled(true);    //툴바를 보여줌
        getSupportActionBar().setDisplayShowTitleEnabled(false);    //기본 제목을 없애줌
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //인수를 받음
        intent = getIntent();
        material = intent.getIntExtra("material", -1);

        //클릭시 다른 내용
        switch (material) {
            case 0:
                title.setText("멸치");
                break;
            case 1:
                title.setText("콩");
                break;
            case 2:
                title.setText("브로콜리");
                break;
            case 3:
                title.setText("양배추");
                setUpRecyclerView();
                break;
        }
    }


    //리사이클러뷰로 각각의 item들 나열
    private void setUpRecyclerView() {

        itemList2 = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerView); //리사이클러뷰 참조
        gridLayoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(gridLayoutManager); //그리드 배열
        fillData();
        adapter = new MainAdapter2(itemList2);
        recyclerView.setAdapter(adapter);
        adapter.setOnClickListener(this);
    }

    //음식 리스트
    private void fillData(){
        itemList2 = new ArrayList<>();
        itemList2.add(new ItemList(R.drawable.cabbagejeon,"양배추전"));
        itemList2.add(new ItemList(R.drawable.cabbagejjim,"양배추찜"));
        itemList2.add(new ItemList(R.drawable.cabbagemuchim,"양배추무침"));
        itemList2.add(new ItemList(R.drawable.cabbageroll,"양배추롤"));
        itemList2.add(new ItemList(R.drawable.gulsorcecabbagefried,"양배추굴소스볶음"));
        itemList2.add(new ItemList(R.drawable.koalslo,"양배추샐러드"));

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
    public void onItemClicked(int position) {
        Intent intent=new Intent(FoodActivity.this, ItemActivity.class);
        intent.putExtra("item", position);
        startActivity(intent);
    }
}
