package com.example.androidhormwork;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {

    private List<TaskModel> list = new ArrayList<>();
    private LayoutInflater inflater;

    public TaskAdapter(MainActivity mainActivity, Context context) {
        this.inflater = LayoutInflater.from(context);
    }

    public void addData(TaskModel model) {
        list.add(model);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_task, parent, false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        holder.bind(list.get(position));
//        holder.txtTitle.setText(list.get(position).getTitle());
//        holder.txtDescription.setText(list.get(position).getDescription());
//        holder.txtDate.setText(list.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class TaskViewHolder extends RecyclerView.ViewHolder {
        TextView txtTitle;
        TextView txtDescription;
        TextView txtDate;

        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.item_title_txt);
            txtDescription = itemView.findViewById(R.id.item_description_txt);
            txtDate = itemView.findViewById(R.id.item_date_txt);
        }

        public void bind(TaskModel model) {
            txtTitle.setText(model.getTitle());
            txtDescription.setText(model.getDescription());
            txtDate.setText(model.getDate());
        }
    }
}
