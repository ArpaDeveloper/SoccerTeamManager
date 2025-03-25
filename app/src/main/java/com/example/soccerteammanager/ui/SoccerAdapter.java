package com.example.soccerteammanager.ui;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.soccerteammanager.R;
import com.example.soccerteammanager.objects.SoccerEntity;
import com.example.soccerteammanager.objects.Player;
import com.example.soccerteammanager.objects.Team;
import com.example.soccerteammanager.objects.Match;

import java.util.List;

public class SoccerAdapter extends RecyclerView.Adapter<SoccerAdapter.SoccerViewHolder> {

    private List<SoccerEntity> items;

    public SoccerAdapter(List<SoccerEntity> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public SoccerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new SoccerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(SoccerViewHolder holder, int position) {
        SoccerEntity item = items.get(position);

        // Check the type of item and bind accordingly
        if (item instanceof Player) {
            Player player = (Player) item;
            holder.TextView1.setText(player.getName());
            holder.TextView2.setText(player.getTeam());
            holder.TextView3.setText(player.getPosition());
        } else if (item instanceof Team) {
            Team team = (Team) item;
            holder.TextView1.setText(team.getName());
            holder.TextView2.setText(team.getCountry());
            holder.TextView3.setText(team.getLeague());
        } else if (item instanceof Match) {
            Match match = (Match) item;
            holder.TextView1.setText(match.getID());
            holder.TextView2.setText(match.getName());
            holder.TextView3.setText(match.getScore());
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    //Method to update data
    public void updateData(List<SoccerEntity> newItems) {
        this.items = newItems;
        notifyDataSetChanged();
    }

    public static class SoccerViewHolder extends RecyclerView.ViewHolder {
        public TextView TextView1;
        public TextView TextView2;
        public TextView TextView3;

        public SoccerViewHolder(View view) {
            super(view);
            TextView1 = view.findViewById(R.id.TextView1);
            TextView2 = view.findViewById(R.id.TextView2);
            TextView3 = view.findViewById(R.id.TextView3);
        }
    }
}
