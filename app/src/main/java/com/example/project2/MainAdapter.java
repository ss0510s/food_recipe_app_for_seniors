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

//리사이틀러뷰에 표시할 아이템 뷰 생성
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainHolder> implements Filterable {
    private List<ItemList> mDataList;
    private List<ItemList> mDataListAll;

    //각 아이템 뷰에 들어갈 변수
    public MainAdapter(List<ItemList> items) {
        mDataList=items;
        mDataListAll=new ArrayList<>(items);
    }

    private onItemListener mListener;
    public void setOnClickListener(onItemListener listener){
        mListener = listener;
    }
    //data set changed
    public void dataSetChanged(List<ItemList> exampleList) {
        mDataList = exampleList;
        notifyDataSetChanged();
    }

    //화면에 표시할 아이템 뷰 저장
    public static class MainHolder extends RecyclerView.ViewHolder {
        public ImageView main_image;
        public TextView main_text;

        public MainHolder(View view) {
            super(view);
            //뷰객체에 대한 참조
            this.main_image = view.findViewById(R.id.image);
            this.main_text = view.findViewById(R.id.item_text);
        }
    }

    @NonNull
    @Override
    //아이템뷰를 위한 뷰홀터 객체를 생성하여 리턴
    public MainHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View holderView = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_holder_view, parent, false);
        return new MainHolder(holderView);
    }

    @Override
    //position에 해당하는 데이터를 뷰홀더의 아이템뷰에 표시
    public void onBindViewHolder(@NonNull final MainHolder mainHolder, final int i) {
        ItemList currentItem=mDataList.get(i);
        mainHolder.main_image.setImageResource(currentItem.getImage());
        mainHolder.main_text.setText(currentItem.getText());
        mainHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onItemClicked(i);
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
            List<ItemList> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(mDataListAll);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (ItemList item : mDataListAll) {
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
        void onItemClicked(int position);
        //void onItemClicked(ItemModel model); 모델값을 넘길수 있음
        //다른버튼도 정의할 수 있음 onShareButtonClicked(int position);
    }

}