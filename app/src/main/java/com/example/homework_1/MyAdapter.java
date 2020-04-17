package com.example.homework_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;



import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private Context context;
    private List<String> mList;

    public MyAdapter(Context context,List<String> mList){
        this.context = context;
        this.mList = mList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =LayoutInflater.from(context).inflate(R.layout.list_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        //根据位置得到对应数据
        String data = mList.get(position);
        holder.item_text.setText(data);

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView item_text;

        public ViewHolder(View v){
            super(v);
            item_text = (TextView) v.findViewById(R.id.item_text);
        }
    }

    public void addData(int position){
        mList.add(position,"hello");
        notifyItemInserted(position);
    }

    public void removeData(int position){
        mList.remove(position);
        notifyItemRemoved(position);
    }

//    public interface OnClickListener{
//        void onClick(int position);
//    }
//    private View.OnClickListener listener;
//
//    public void setOnItemClickListener(View.OnClickListener listener){
//        this.listener = listener;
//    }
//    public interface OnItemLongClickListener{
//        void onClick(int position);
//    }
//    private OnItemLongClickListener longClickListener;
//    public void setOnItemLongClickListener(OnItemLongClickListener longClickListener){
//        this.longClickListener = longClickListener;
//    }


}
