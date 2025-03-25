package com.example.soccerteammanager.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.soccerteammanager.objects.SoccerEntity;
import com.example.soccerteammanager.objects.Player;
import com.example.soccerteammanager.objects.Match;
import com.example.soccerteammanager.objects.Team;
import com.example.soccerteammanager.R;


import java.util.List;

public class SoccerAdapter extends RecyclerView.Adapter<SoccerAdapter.ViewHolder> {

    private List<SoccerEntity> items;

    public SoccerAdapter(List<SoccerEntity> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout, parent, false);  // Use item layout for individual items
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        SoccerEntity entity = items.get(position);
        holder.TextView1.setText(entity.getName());  // Bind the name (Player, Team, or Match)
        holder.TextView2.setText(entity instanceof Player ? ((Player) entity).getTeam() :
                entity instanceof Match ? ((Match) entity).getID() :
                        ((Team) entity).getCountry());
        holder.TextView3.setText(entity instanceof Player ? ((Player) entity).getPosition() :
                entity instanceof Match ? ((Match) entity).getScore() :
                        ((Team) entity).getLeague());
    }

    @Override
    public int getItemCount() {
        return items != null ? items.size() : 0;
    }

    public void updateData(List<SoccerEntity> items) {
        this.items = items;
        notifyDataSetChanged();  // Notify that data has changed
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView TextView1;
        TextView TextView2;
        TextView TextView3;

        public ViewHolder(View itemView) {
            super(itemView);
            TextView1 = itemView.findViewById(R.id.TextView1);
            TextView2 = itemView.findViewById(R.id.TextView2);
            TextView3 = itemView.findViewById(R.id.TextView3);
        }
    }
}
