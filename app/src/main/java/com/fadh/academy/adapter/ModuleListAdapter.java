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

public class ModuleListAdapter extends RecyclerView.Adapter<ModuleListAdapter.ModulViewHolder> {
    private final MyAdapterClickListener listener;
    private List<ModuleEntity> listModules = new ArrayList<>();

    public ModuleListAdapter(MyAdapterClickListener listener) {
        this.listener = listener;
    }

    public void setModules(List<ModuleEntity> listModules) {
        if (listModules == null) return;
        listModules.clear();
        listModules.addAll(listModules);
    }

    @NonNull
    @Override
    public ModulViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ModulViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.items_module_list_costume, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull ModulViewHolder holder, int position) {
        ModuleEntity module = listModules.get(position);
        holder.bind(module);
        holder.itemView.setOnClickListener(v ->
                listener.onItemClicked(holder.getAdapterPosition(), listModules.get(holder.getAdapterPosition()).getmModuleId())
        );
    }

    @Override
    public int getItemCount() {
        return listModules.size();
    }

    public class ModulViewHolder extends RecyclerView.ViewHolder {
        final TextView textTitle;
        public ModulViewHolder(View itemView) {
            super(itemView);
            textTitle = itemView.findViewById(R.id.text_module_title);
        }

        public void bind(ModuleEntity module) {
            textTitle.setText(module.getmTitle());
        }
    }
}
