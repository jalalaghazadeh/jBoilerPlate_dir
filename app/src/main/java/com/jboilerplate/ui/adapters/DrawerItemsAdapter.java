package com.jboilerplate.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jboilerplate.R;
import com.jboilerplate.events.DrawerItem;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.greenrobot.event.EventBus;

/**
 * Created by jalal on 12/3/2017.
 */

public class DrawerItemsAdapter extends RecyclerView.Adapter<DrawerItemsAdapter.ViewHolder> {

    private ArrayList<DrawerItem> drawerItems = new ArrayList<>();

    public DrawerItemsAdapter(ArrayList<DrawerItem> items) {
        this.drawerItems = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_list_item_drawer, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.ivItemIcon.setImageResource(drawerItems.get(position).getItemIconId());
        holder.tvItemTitle.setText(drawerItems.get(position).getItemTitle());
    }

    @Override
    public int getItemCount() {
        return drawerItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.iv_item_icon)
        ImageView ivItemIcon;
        @BindView(R.id.tv_item_title)
        TextView tvItemTitle;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            EventBus.getDefault().post(drawerItems.get(getAdapterPosition()));
        }
    }
}
