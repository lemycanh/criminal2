package com.uni.officecriminal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.uni.officecriminal.model.Criminal;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CriminalAdapter extends RecyclerView.Adapter<CriminalAdapter.ViewHolder> {
    private List<Criminal> criminals;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_criminal, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    int count = 0;
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if(count > 20) return;
        Criminal criminal = criminals.get(position);
        holder.mTvTitle.setText(criminal.getTitle());
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        holder.mTvDate.setText(dateFormat.format(criminal.getCreationDate()));
        count++;
    }

    @Override
    public int getItemCount() {
        return criminals.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView mTvTitle;
        public final TextView mTvDate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTvTitle = itemView.findViewById(R.id.item_tv_title);
            mTvDate = itemView.findViewById(R.id.item_tv_date);
        }
    }

    public CriminalAdapter(List<Criminal> criminals) {
        this.criminals = criminals;
    }
}
