package com.example.soccerteammanager.main;

import android.os.Bundle;
import android.util.Log;

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

import java.util.ArrayList;
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

        adapter = new SoccerAdapter(new ArrayList<>());
        recyclerView.setAdapter(adapter);

        // Default content to display (e.g., Players)
        dataProvider = new DataProvider();
        dataProvider.createSamplePlayers();
        dataProvider.createSampleTeams();
        dataProvider.createSampleMatches();

        loadAllData();

        // Add TabSelectedListener to handle tab switches
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        loadAllData();
                        break;
                    case 1:
                        loadTeams();  // Load Players when "Players" tab is selected
                        break;
                    case 2:
                        loadPlayers();  // Load Teams when "Teams" tab is selected
                        break;
                    case 3:
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
        //PlayerRepository playerRepository = new PlayerRepository();
        //List<Player> players = playerRepository.getAll();  // Get all players from the repository
        List<Player> players = dataProvider.getPlayers();
        Log.d("MainActivity", "Players loaded: " + players.size());
        adapter.updateData((List<SoccerEntity>) (List<?>) players); // Update adapter with player data
    }

    // Method to load teams
    private void loadTeams() {
       // TeamRepository teamRepository =  new TeamRepository();
        //List<Team> teams = teamRepository.getAll();
        List<Team> teams = dataProvider.getTeams();
        Log.d("MainActivity", "Players loaded: " + teams.size());
        adapter.updateData((List<SoccerEntity>) (List<?>) teams);
    }

    // Method to load matches
    private void loadMatches() {
        //MatchRepository matchRepository = new MatchRepository();
        //List<Match> matches = matchRepository.getAll();  // Get all matches from the repository
        List<Match> matches = dataProvider.getMatches();
        Log.d("MainActivity", "Players loaded: " + matches.size());
        adapter.updateData((List<SoccerEntity>) (List<?>) matches);  // Update adapter with match data
    }

    private void loadAllData() {
        List<SoccerEntity> allItems = new ArrayList<>();
        allItems.addAll(dataProvider.getPlayers()); // Add players
        allItems.addAll(dataProvider.getTeams());   // Add teams
        allItems.addAll(dataProvider.getMatches()); // Add matches

        Log.d("MainActivity", "Total items loaded: " + allItems.size()); // Debugging
        adapter.updateData(allItems); // Update RecyclerView with all data
    }
}