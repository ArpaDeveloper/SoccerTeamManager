package com.example.soccerteammanager.main;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.soccerteammanager.R;
import com.example.soccerteammanager.objects.Match;
import com.example.soccerteammanager.objects.Player;
import com.example.soccerteammanager.objects.SoccerEntity;
import com.example.soccerteammanager.objects.Team;
import com.example.soccerteammanager.repositories.MatchRepository;
import com.example.soccerteammanager.repositories.PlayerRepository;
import com.example.soccerteammanager.repositories.TeamRepository;
import com.example.soccerteammanager.ui.SoccerAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private SoccerAdapter adapter;
    private DataProvider dataProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize TabLayout and RecyclerView
        TabLayout tabLayout = findViewById(R.id.tabLayout);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize the adapter with an empty list initially
        dataProvider = new DataProvider();
        adapter = new SoccerAdapter(null);
        recyclerView.setAdapter(adapter);

        // Default content to display (e.g., Players)
        dataProvider.createSamplePlayers();
        dataProvider.createSampleTeams();
        dataProvider.createSampleMatches();

        loadPlayers();

        // Add TabSelectedListener to handle tab switches
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        loadPlayers();  // Load Players when "Players" tab is selected
                        break;
                    case 1:
                        loadTeams();  // Load Teams when "Teams" tab is selected
                        break;
                    case 2:
                        loadMatches();  // Load Matches when "Matches" tab is selected
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) { }

            @Override
            public void onTabReselected(TabLayout.Tab tab) { }
        });
    }

    // Method to load players
    private void loadPlayers() {
        PlayerRepository playerRepository = new PlayerRepository();
        List<Player> players = playerRepository.getAll();  // Get all players from the repository
        adapter.updateData((List<SoccerEntity>) (List<?>) players); // Update adapter with player data
    }

    // Method to load teams
    private void loadTeams() {
        List<Team> teamList = dataProvider.createSampleTeams();
        adapter.updateData(teamList);
    }

    // Method to load matches
    private void loadMatches() {
        MatchRepository matchRepository = new MatchRepository();
        List<Match> matches = matchRepository.getAll();  // Get all matches from the repository
        adapter.updateData((List<SoccerEntity>) (List<?>) matches);  // Update adapter with match data
    }
}