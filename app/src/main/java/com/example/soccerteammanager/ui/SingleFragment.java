package com.example.soccerteammanager.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.soccerteammanager.R;
import com.example.soccerteammanager.objects.Player;
import com.example.soccerteammanager.objects.SoccerEntity;
import com.example.soccerteammanager.objects.Team;
import com.example.soccerteammanager.objects.Match;
import com.example.soccerteammanager.repositories.PlayerRepository;
import com.example.soccerteammanager.repositories.TeamRepository;
import com.example.soccerteammanager.repositories.MatchRepository;

import java.util.List;

public class SingleFragment extends Fragment {

    private SoccerAdapter adapter;

    public SingleFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_single, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        //Initialize adapter
        adapter = new SoccerAdapter(null);  // Initialize with no data
        recyclerView.setAdapter(adapter);

        // Example of switching content (can be triggered by tab selection or button press)
        loadPlayers();  // Load Players data
        // loadTeams();    // Load Teams data
        // loadMatches();  // Load Matches data

        return view;
    }

    //Method to load players
    private void loadPlayers() {
        PlayerRepository playerRepository = new PlayerRepository();
        List<Player> players = playerRepository.getAll();  // Get all players
        adapter.updateData((List<SoccerEntity>) (List<?>) players);  // Update adapter with players
    }

    //Method to load teams
    private void loadTeams() {
        TeamRepository teamRepository = new TeamRepository();
        List<Team> teams = teamRepository.getAll();  // Get all teams
        adapter.updateData((List<SoccerEntity>) (List<?>) teams);  // Update adapter with teams
    }

    //Method to load matches
    private void loadMatches() {
        MatchRepository matchRepository = new MatchRepository();
        List<Match> matches = matchRepository.getAll();  // Get all matches
        adapter.updateData((List<SoccerEntity>) (List<?>) matches);  // Update adapter with matches
    }
}
