package com.example.lightningandroidtalk.UI;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lightningandroidtalk.R;

import java.util.List;
import java.util.zip.Inflater;

public class ComponentAdapter extends RecyclerView.Adapter<ComponentAdapter.ComponentViewHolder> {

    public class ComponentViewHolder extends RecyclerView.ViewHolder {

        private final TextView listItem;

        private ComponentViewHolder(View view) {
            super(view);

            listItem = view.findViewById(R.id.listItem);

        }
    }

    private List<String> listComponents;
    private final Context context;
    private final LayoutInflater inflater;

    public ComponentAdapter(Context context) {
        inflater = LayoutInflater.from(context);
        this.context = context;
    }

    @NonNull
    @Override
    public ComponentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.component_list_item, parent, false);
        return new ComponentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ComponentViewHolder holder, int position) {
        if(listComponents != null) {
            String item = listComponents.get(position);
            holder.listItem.setText(item);
        }
    }

    @Override
    public int getItemCount() {
        return listComponents.size();
    }

    public void setListItems(List<String> list) {
        listComponents = list;
        notifyDataSetChanged();
    }


}
