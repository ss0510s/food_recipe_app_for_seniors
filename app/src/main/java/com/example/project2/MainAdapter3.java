package com.example.project2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

//famous activity에서 사용할 adapter
//리사이틀러뷰에 표시할 아이템 뷰 생성
public class MainAdapter3 extends RecyclerView.Adapter<MainAdapter3.MainHolder> implements Filterable {
    private List<ItemList2> mDataList;
    private List<ItemList2> mDataListAll;

    //각 아이템 뷰에 들어갈 변수
    public MainAdapter3(List<ItemList2> items) {
        mDataList=items;
        mDataListAll=new ArrayList<>(items);
    }

    private onItemListener mListener;
    public void setOnClickListener(onItemListener listener){
        mListener = listener;
    }
    //data set changed
    public void dataSetChanged(List<ItemList2> exampleList) {
        mDataList = exampleList;
        notifyDataSetChanged();
    }

    //화면에 표시할 아이템 뷰 저장
    public static class MainHolder extends RecyclerView.ViewHolder {
        public ImageView main_image;
        public TextView main_text;
        public TextView year;
        public TextView explain;
        public ImageView blog;
        public ImageView youtube;

        public MainHolder(View view) {
            super(view);
            //뷰객체에 대한 참조
            this.main_image = view.findViewById(R.id.image);
            this.main_text = view.findViewById(R.id.item_text);
            this.year=view.findViewById(R.id.year);
            this.explain=view.findViewById(R.id.explain);
            this.blog=view.findViewById(R.id.blog);
            this.youtube=view.findViewById(R.id.youtube);
        }
    }

    @NonNull
    @Override
    //아이템뷰를 위한 뷰홀터 객체를 생성하여 리턴
    public MainHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View holderView = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_holder_view3, parent, false);
        return new MainHolder(holderView);
    }

    @Override
    //position에 해당하는 데이터를 뷰홀더의 아이템뷰에 표시
    public void onBindViewHolder(@NonNull final MainHolder mainHolder, final int i) {
        ItemList2 currentItem=mDataList.get(i);
        mainHolder.main_image.setImageResource(currentItem.getImage());
        mainHolder.blog.setImageResource(currentItem.getBlog());
        mainHolder.youtube.setImageResource(currentItem.getYoutube());
        mainHolder.main_text.setText(currentItem.getText());
        mainHolder.year.setText(currentItem.getYear());
        mainHolder.explain.setText(currentItem.getExplain());
        mainHolder.blog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onItemBlogClicked(i);
            }
        });
        mainHolder.youtube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onItemYoutubeClicked(i);
            }
        });
    }

    @Override
    public Filter getFilter() {
        return exampleFilter;
    }

    private Filter exampleFilter = new Filter() {
        //Automatic on background thread
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<ItemList2> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(mDataListAll);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (ItemList2 item : mDataListAll) {
                    //TODO filter 대상 setting
                    if (item.getText().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }

        //Automatic on UI thread
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            mDataList.clear();
            mDataList.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };
    @Override
    //전체 아이템의 갯수 리턴
    public int getItemCount() {
        return mDataList.size();
    }
    public interface onItemListener {
        void onItemYoutubeClicked(int position);
        void onItemBlogClicked(int position);
        //void onItemClicked(ItemModel model); 모델값을 넘길수 있음
        //다른버튼도 정의할 수 있음 onShareButtonClicked(int position);
    }
}
