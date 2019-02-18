package com.tzg.endgraduationwork.MyAdapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tzg.endgraduationwork.DataBean.PYJiGuoBean;
import com.tzg.endgraduationwork.R;

import java.util.List;

public class PYAdapter extends RecyclerView.Adapter {
    private List<PYJiGuoBean.ResultBean.ListBean> Madapterlist;
    private OnItem MonItem;

    public void setOnItem(OnItem onItem) {
        MonItem = onItem;
    }

    public interface OnItem{
        void onItemClick(int position);
    }

    public void setMadapterlist(List<PYJiGuoBean.ResultBean.ListBean> list){
        Madapterlist = list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item,parent,false);
        return new MyHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        ((MyHolder)holder).zi.setText(Madapterlist.get(position).getZi());
        ((MyHolder)holder).pinyin.setText(Madapterlist.get(position).getPinyin());
        ((MyHolder)holder).bushou.setText(Madapterlist.get(position).getBushou());
        ((MyHolder)holder).bihua.setText(Madapterlist.get(position).getBihua());
        ((MyHolder)holder).wubi.setText(Madapterlist.get(position).getWubi());
        ((MyHolder)holder).layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (MonItem != null){
                    MonItem.onItemClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        if (Madapterlist != null){
            return Madapterlist.size();
        }
        return 0;
    }
    public class MyHolder extends RecyclerView.ViewHolder{
        private final TextView zi;
        private final TextView pinyin;
        private final TextView bushou;
        private final TextView wubi;
        private final TextView bihua;
        private final LinearLayout layout;

        public MyHolder(View itemView) {
            super(itemView);
            zi = (TextView)itemView.findViewById(R.id.item_zi);
            pinyin = (TextView)itemView.findViewById(R.id.item_pinyin);
            bushou = (TextView)itemView.findViewById(R.id.item_bushou);
            wubi = (TextView)itemView.findViewById(R.id.item_wubi);
            bihua = (TextView)itemView.findViewById(R.id.item_bihua);
            layout = (LinearLayout) itemView.findViewById(R.id.item_layout);
        }
    }
}
