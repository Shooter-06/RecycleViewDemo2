package com.example.recycleviewdemo2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHoler>{

    private List<String> mData;
    private LayoutInflater mInflator;

    //data is passed to the constructor
    public RecycleViewAdapter(Context context, List<String> mData){
        this.mInflator= LayoutInflater.from(context);
        this.mData= mData;
    }

    //inflates the row layout child item from te xml when needed
    @NonNull
    @Override
    public ViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflator.inflate(R.layout.recycleview_row, parent, false);
        return new ViewHoler(view);
    }

    // binds the data to the textView in each row
    @Override
    public void onBindViewHolder(@NonNull ViewHoler holder, int position) {
        String data = mData.get(position);
        holder.myTextView.setText(data);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHoler extends RecyclerView.ViewHolder {
        TextView myTextView;

        public ViewHoler(@NonNull View itemView) {
            super(itemView);
            myTextView=itemView.findViewById(R.id.textView);
        }
    }
}
