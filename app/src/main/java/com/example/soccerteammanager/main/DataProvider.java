package com.example.soccerteammanager.main;

import com.example.soccerteammanager.objects.Match;
import com.example.soccerteammanager.objects.Player;
import com.example.soccerteammanager.objects.Team;

import java.util.List;
import java.util.ArrayList;

/**
 * This class provides all the data
 *
 * @author Arpadev
 */
public class DataProvider {

    //Lists
    private List<Player> players;
    private List<Team> teams;
    private List<Match> matches;

    //Constructor
    public DataProvider() {
        teams = createSampleTeams();
        players = createSamplePlayers();
        matches = createSampleMatches();
    }

    //Method to create sample teams
    List<Team> createSampleTeams() {
        teams = new ArrayList<>();
        teams.add(new Team("FC Barcelona", "Spain", "La Liga"));
        teams.add(new Team("Manchester United", "England", "Premier League"));
        teams.add(new Team("Bayern Munich", "Germany", "Bundesliga"));
        teams.add(new Team("Juventus", "Italy", "Serie A"));
        teams.add(new Team("AC Milan", "Italy", "Serie A"));
        teams.add(new Team("Paris Saint-Germain", "France", "Ligue 1"));
        teams.add(new Team("Ajax Amsterdam", "Netherlands", "Eredivisie"));
        teams.add(new Team("River Plate", "Argentina", "Primera División"));
        teams.add(new Team("Flamengo", "Brazil", "Brasileirão"));
        return teams;
    }
    //Method to create sample players
    List<Player> createSamplePlayers() {
        players = new ArrayList<>();
        players.add(new Player("Lionel Messi", "Forward", "FC Barcelona"));
        players.add(new Player("Cristiano Ronaldo", "Forward", "Juventus"));
        players.add(new Player("Robert Lewandowski", "Forward", "Bayern Munich"));
        players.add(new Player("Kevin De Bruyne", "Midfielder", "Manchester City"));
        players.add(new Player("Virgil van Dijk", "Defender", "Liverpool"));
        players.add(new Player("Manuel Neuer", "Goalkeeper", "Bayern Munich"));
        players.add(new Player("Antoine Griezmann", "Midfielder", "Atletico Madrid"));
        players.add(new Player("Erling Haaland", "Forward", "Borussia Dortmund"));
        players.add(new Player("Bruno Fernandes", "Midfielder", "Manchester United"));
        players.add(new Player("Joshua Kimmich", "Midfielder", "Bayern Munich"));
        players.add(new Player("Jan Oblak", "Goalkeeper", "Atletico Madrid"));
        players.add(new Player("Neymar Jr.", "Forward", "Paris Saint-Germain"));
        players.add(new Player("Phil Foden", "Forward", "Manchester City"));
        return players;
    }
    //Method to create sample matches
    List<Match> createSampleMatches() {
        matches = new ArrayList<>();
        matches.add(new Match("FC Barcelona", "Real Madrid", "2-1"));
        matches.add(new Match("Manchester United", "Liverpool", "0-3"));
        matches.add(new Match("Bayern Munich", "Borussia Dortmund", "4-2"));
        matches.add(new Match("Juventus", "AC Milan", "1-1"));
        matches.add(new Match("Paris Saint-Germain", "Lyon", "3-0"));
        matches.add(new Match("FC Barcelona", "Bayern Munich", "0-3"));
        matches.add(new Match("Manchester City", "Paris Saint-Germain", "2-1"));
        matches.add(new Match("Liverpool", "Ajax Amsterdam", "1-0"));
        return matches;
    }

    //Getters
    public List<Player> getPlayers() { return players; }
    public List<Team> getTeams() { return teams; }
    public List<Match> getMatches() { return matches; }
}
