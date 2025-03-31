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

import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

/**
 * This handles ui and calling of functions
 * This project was made with the help of ChatGPT
 *
 * @author Arpadev
 * @version 1.0.0
 */
public class MainActivity extends AppCompatActivity {

    private SoccerAdapter adapter;
    private DataProvider dataProvider;
    private String option1, option2, option3;
    private int selectedTabIndex = 0;

    //Start Method
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

        //Initialize UI
        TabLayout tabLayout = findViewById(R.id.tabLayout);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        CardView cardView = findViewById(R.id.cardView);
        Button leftButton = findViewById(R.id.button4);
        Button middleButton = findViewById(R.id.button5);
        Button rightButton = findViewById(R.id.button6);
        Button allIteratorButton = findViewById(R.id.button2);
        SearchView searchView = findViewById(R.id.searchView);

        //Initialize Repos
        TeamRepository teamRepo = new TeamRepository();
        PlayerRepository playerRepo = new PlayerRepository();
        MatchRepository matchRepo = new MatchRepository();

        //Initialize the adapter
        adapter = new SoccerAdapter(new ArrayList<>());
        recyclerView.setAdapter(adapter);

        //Create Data
        dataProvider = new DataProvider();
        dataProvider.createSamplePlayers();
        dataProvider.createSampleTeams();
        dataProvider.createSampleMatches();

        //Start state
        loadAllData();
        disableCardView(cardView);

        //TabSelectedListener to handle tab switches
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                selectedTabIndex = tab.getPosition();
                //Handle different tabs
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

            //Other tab methods
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

        //Handle searching
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
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

        //Iterator options
        allIteratorButton.setOnClickListener(view -> {
            List<Player> players = dataProvider.getPlayers();
            PlayerIterator playerIterator = new PlayerIterator(players);
            //Iterate through the list of players and log each one
            while (playerIterator.hasNext()) {
                Player player = playerIterator.next();
                Log.d("Iterator", "Player: " + player.getName() + ", Team: " + player.getTeam() + ", Position: " + player.getPosition());
            }

            List<Team> teams = dataProvider.getTeams();
            TeamIterator teamIterator = new TeamIterator(teams);
            //Iterate through the list of teams and log each one
            while (teamIterator.hasNext()) {
                Team team = teamIterator.next();
                Log.d("Iterator", "Team: " + team.getName() + ", League: " + team.getLeague() + ", Country: " + team.getCountry());
            }

            List<Match> matches = dataProvider.getMatches();
            MatchIterator matchIterator = new MatchIterator(matches);
            //Iterate through the list of matches and log each one
            while (matchIterator.hasNext()) {
                Match match = matchIterator.next();
                Log.d("Iterator", "Match: " + match.getHomeTeam() + " vs " +  match.getAwayTeam() + ", Score:" + match.getScore());
            }
        });



    }

    //Method to update the buttons texts when switching tabs
    private void updateButtonTexts(String option1, String option2, String option3){
        Button leftButton = findViewById(R.id.button4);
        Button middleButton = findViewById(R.id.button5);
        Button rightButton = findViewById(R.id.button6);

        leftButton.setText(option1);
        middleButton.setText(option2);
        rightButton.setText(option3);
    }

    //Method to load players
    private void loadPlayers() {
        List<Player> players = dataProvider.getPlayers();
        adapter.updateData((List<SoccerEntity>) (List<?>) players);
    }

    //Method to load teams
    private void loadTeams() {
        List<Team> teams = dataProvider.getTeams();
        adapter.updateData((List<SoccerEntity>) (List<?>) teams);
    }

    //Method to load matches
    private void loadMatches() {
        List<Match> matches = dataProvider.getMatches();
        adapter.updateData((List<SoccerEntity>) (List<?>) matches);
    }

    //Method to load all
    private void loadAllData() {
        List<SoccerEntity> allItems = new ArrayList<>();
        allItems.addAll(dataProvider.getPlayers());
        allItems.addAll(dataProvider.getTeams());
        allItems.addAll(dataProvider.getMatches());
        adapter.updateData(allItems);
    }

    //Method to disable cardView + it's child objects
    public void disableCardView(CardView cardView) {
        cardView.setEnabled(false);
        cardView.setVisibility(View.GONE);

        for (int i = 0; i < cardView.getChildCount(); i++) {
            View child = cardView.getChildAt(i);
            if (child instanceof Button) {
                child.setVisibility(View.GONE);
            }
        }
    }

    //Method to enable cardView + it's child objects
    public void enableCardView(CardView cardView) {
        cardView.setEnabled(true);
        cardView.setVisibility(View.VISIBLE);

        for (int i = 0; i < cardView.getChildCount(); i++) {
            View child = cardView.getChildAt(i);
            if (child instanceof Button) {
                child.setVisibility(View.VISIBLE);
            }
        }
    }
}