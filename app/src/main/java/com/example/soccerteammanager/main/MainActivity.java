package com.example.soccerteammanager.main;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.soccerteammanager.R;
import com.example.soccerteammanager.iterators.MatchIterator;
import com.example.soccerteammanager.iterators.PlayerIterator;
import com.example.soccerteammanager.iterators.TeamIterator;
import com.example.soccerteammanager.objects.Match;
import com.example.soccerteammanager.objects.Player;
import com.example.soccerteammanager.objects.SoccerEntity;
import com.example.soccerteammanager.objects.Team;
import com.example.soccerteammanager.repositories.MatchRepository;
import com.example.soccerteammanager.repositories.PlayerRepository;
import com.example.soccerteammanager.repositories.TeamRepository;
import com.example.soccerteammanager.ui.SoccerAdapter;
import com.google.android.material.tabs.TabLayout;
import androidx.cardview.widget.CardView;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {

    private SoccerAdapter adapter;
    private DataProvider dataProvider;
    private String option1, option2, option3;
    private int selectedTabIndex = 0;
    private TeamRepository teamRepo;
    private PlayerRepository playerRepo;
    private MatchRepository matchRepo;

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
        CardView cardView = findViewById(R.id.cardView);

        Button leftButton = findViewById(R.id.button4);
        Button middleButton = findViewById(R.id.button5);
        Button rightButton = findViewById(R.id.button6);

        Button allIteratorButton = findViewById(R.id.button2);

        TeamRepository teamRepo = new TeamRepository();
        PlayerRepository playerRepo = new PlayerRepository();
        MatchRepository matchRepo = new MatchRepository();

        // Initialize the adapter with an empty list initially

        adapter = new SoccerAdapter(new ArrayList<>());
        recyclerView.setAdapter(adapter);
        SearchView searchView = findViewById(R.id.searchView);


        // Default content to display (e.g., Players)
        dataProvider = new DataProvider();
        dataProvider.createSamplePlayers();
        dataProvider.createSampleTeams();
        dataProvider.createSampleMatches();

        loadAllData();
        disableCardView(cardView);



        // Add TabSelectedListener to handle tab switches
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                selectedTabIndex = tab.getPosition();
                switch (selectedTabIndex) {
                    case 0:
                        loadAllData();
                        disableCardView(cardView);
                        break;
                    case 1:
                        loadTeams();
                        enableCardView(cardView);
                        option1 = "Serie A";
                        option2 = "Ligue 1";
                        option3 = "La Liga";
                        updateButtonTexts(option1, option2, option3);
                        break;
                    case 2:
                        loadPlayers();
                        enableCardView(cardView);
                        option1 = "Juventus";
                        option2 = "Bayern Munich";
                        option3 = "Liverpool";
                        updateButtonTexts(option1, option2, option3);
                        break;
                    case 3:
                        loadMatches();
                        enableCardView(cardView);
                        option1 = "Ajax Amsterdam";
                        option2 = "Juventus";
                        option3 = "AC Milan";
                        updateButtonTexts(option1, option2, option3);
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) { }

            @Override
            public void onTabReselected(TabLayout.Tab tab) { }
        });

        //Left Button options
        leftButton.setOnClickListener(view -> {
            if (selectedTabIndex == 1) {
                List<Team> filteredTeams = teamRepo.filterByLeague(option1);
                adapter.updateData((List<SoccerEntity>) (List<?>) filteredTeams);
            }
            else if(selectedTabIndex == 2){
                List<Player> filteredPlayers = playerRepo.filterByTeam(option1);
                adapter.updateData((List<SoccerEntity>) (List<?>) filteredPlayers);
            }
            else if(selectedTabIndex == 3){
                List<Match> filteredMatches = matchRepo.filterByTeam(option1);
                adapter.updateData((List<SoccerEntity>) (List<?>) filteredMatches);
            }
        });

        //Middle Button options
        middleButton.setOnClickListener(view -> {
            if (selectedTabIndex == 1) {
                List<Team> filteredTeams = teamRepo.filterByLeague(option2);
                adapter.updateData((List<SoccerEntity>) (List<?>) filteredTeams);
            }
            else if(selectedTabIndex == 2){
                List<Player> filteredPlayers = playerRepo.filterByTeam(option2);
                adapter.updateData((List<SoccerEntity>) (List<?>) filteredPlayers);
            }
            else if(selectedTabIndex == 3){
                List<Match> filteredMatches = matchRepo.filterByTeam(option2);
                adapter.updateData((List<SoccerEntity>) (List<?>) filteredMatches);
            }
        });

        //Right Button options
        rightButton.setOnClickListener(view -> {
            if (selectedTabIndex == 1) {
                List<Team> filteredTeams = teamRepo.filterByLeague(option3);
                adapter.updateData((List<SoccerEntity>) (List<?>) filteredTeams);
            }
            else if(selectedTabIndex == 2){
                List<Player> filteredPlayers = playerRepo.filterByTeam(option3);
                adapter.updateData((List<SoccerEntity>) (List<?>) filteredPlayers);
            }
            else if(selectedTabIndex == 3){
                List<Match> filteredMatches = matchRepo.filterByTeam(option3);
                adapter.updateData((List<SoccerEntity>) (List<?>) filteredMatches);
            }
        });

        // Handle search query changes
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // Optionally handle submit if you need it
                if (selectedTabIndex == 1) {
                    List<Team> filteredTeams = teamRepo.filterByAll(query);
                    adapter.updateData((List<SoccerEntity>) (List<?>) filteredTeams);
                }
                else if(selectedTabIndex == 2){
                    List<Player> filteredPlayers = playerRepo.filterByAll(query);
                    adapter.updateData((List<SoccerEntity>) (List<?>) filteredPlayers);
                }
                else if(selectedTabIndex == 3){
                    List<Match> filteredMatches = matchRepo.filterByTeam(query);
                    adapter.updateData((List<SoccerEntity>) (List<?>) filteredMatches);
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // Handle search text change and filter based on the selected tab
                if (selectedTabIndex == 1) {
                    List<Team> filteredTeams = teamRepo.filterByAll(newText);
                    adapter.updateData((List<SoccerEntity>) (List<?>) filteredTeams);
                }
                else if(selectedTabIndex == 2){
                    List<Player> filteredPlayers = playerRepo.filterByAll(newText);
                    adapter.updateData((List<SoccerEntity>) (List<?>) filteredPlayers);
                }
                else if(selectedTabIndex == 3){
                    List<Match> filteredMatches = matchRepo.filterByTeam(newText);
                    adapter.updateData((List<SoccerEntity>) (List<?>) filteredMatches);
                }
                return false;
            }
        });

        //Right Button options
        allIteratorButton.setOnClickListener(view -> {
            List<Player> players = dataProvider.getPlayers();
            PlayerIterator playerIterator = new PlayerIterator(players);

            // Iterate through the list of players and log each one
            while (playerIterator.hasNext()) {
                Player player = playerIterator.next();
                Log.d("Iterator", "Player: " + player.getName() + ", Team: " + player.getTeam() + ", Position: " + player.getPosition());
            }

            List<Team> teams = dataProvider.getTeams();
            TeamIterator teamIterator = new TeamIterator(teams);

            // Iterate through the list of players and log each one
            while (teamIterator.hasNext()) {
                Team team = teamIterator.next();
                Log.d("Iterator", "Team: " + team.getName() + ", League: " + team.getLeague() + ", Country: " + team.getCountry());
            }

            List<Match> matches = dataProvider.getMatches();
            MatchIterator matchIterator = new MatchIterator(matches);

            // Iterate through the list of players and log each one
            while (matchIterator.hasNext()) {
                Match match = matchIterator.next();
                Log.d("Iterator", "Match: " + match.getHomeTeam() + " vs " +  match.getAwayTeam() + ", Score:" + match.getScore());
            }
        });



    }

    private void updateButtonTexts(String option1, String option2, String option3){
        Button leftButton = findViewById(R.id.button4);
        Button middleButton = findViewById(R.id.button5);
        Button rightButton = findViewById(R.id.button6);

        leftButton.setText(option1);
        middleButton.setText(option2);
        rightButton.setText(option3);
    }
    // Method to load players
    private void loadPlayers() {
        List<Player> players = dataProvider.getPlayers();
        Log.d("MainActivity", "Players loaded: " + players.size());
        adapter.updateData((List<SoccerEntity>) (List<?>) players); // Update adapter with player data
    }

    // Method to load teams
    private void loadTeams() {
        List<Team> teams = dataProvider.getTeams();
        Log.d("MainActivity", "Players loaded: " + teams.size());
        adapter.updateData((List<SoccerEntity>) (List<?>) teams);
    }

    // Method to load matches
    private void loadMatches() {
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

    public void disableCardView(CardView cardView) {
        // Disable the CardView
        cardView.setEnabled(false);
        cardView.setVisibility(View.GONE);

        // Get all the child views of the CardView and make buttons invisible or gone
        for (int i = 0; i < cardView.getChildCount(); i++) {
            View child = cardView.getChildAt(i);
            if (child instanceof Button) {
                child.setVisibility(View.GONE); // Or View.INVISIBLE if you want to keep layout space
            }
        }
    }

    public void enableCardView(CardView cardView) {
        // Enable the CardView
        cardView.setEnabled(true);
        cardView.setVisibility(View.VISIBLE);

        // Get all the child views of the CardView and make buttons visible again
        for (int i = 0; i < cardView.getChildCount(); i++) {
            View child = cardView.getChildAt(i);
            if (child instanceof Button) {
                child.setVisibility(View.VISIBLE); // Or View.INVISIBLE if you want to hide but keep space
            }
        }
    }

}