package com.fadh.academy.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fadh.academy.R;
import com.fadh.academy.data.ModuleEntity;

import java.util.ArrayList;
import java.util.List;

public class DetailCourseAdapter extends RecyclerView.Adapter<DetailCourseAdapter.ModuleViewHolder> {

    private List<ModuleEntity> listModules = new ArrayList<>();

    public void setModules(List<ModuleEntity> modules){
        if(modules != null) return;
        listModules.clear();
        listModules.addAll(modules);
    }
    @NonNull
    @Override
    public ModuleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_module_list, parent, false);
        return new ModuleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ModuleViewHolder holder, int position) {
        ModuleEntity module = listModules.get(position);
        holder.bind(module);
    }

    @Override
    public int getItemCount() {
        return listModules.size();
    }

    public class ModuleViewHolder extends RecyclerView.ViewHolder {
        final TextView textTitle;
        public ModuleViewHolder(@NonNull View itemView) {
            super(itemView);
            textTitle = itemView.findViewById(R.id.text_module_title);
        }

        public void bind(ModuleEntity module) {
            textTitle.setText(module.getmTitle());
        }
    }
}
