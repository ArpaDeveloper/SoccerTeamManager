package com.example.soccerteammanager.repositories;

import com.example.soccerteammanager.main.DataProvider;
import com.example.soccerteammanager.objects.Match;
import com.example.soccerteammanager.objects.Player;
import com.example.soccerteammanager.objects.Team;

import java.util.List;
import java.util.function.Predicate;

public class MatchRepository extends Repository<Match> {

    public List<Match> filterByTeam(String team){
        DataProvider dataP = new DataProvider();
        List<Match> allMatches = dataP.getMatches();

        Repository<Match> matchRepo = new Repository<>(allMatches);

        Predicate<Match> byTeam = match -> match.getHomeTeam().trim().equalsIgnoreCase(team.trim())
                || match.getAwayTeam().trim().equalsIgnoreCase(team.trim());
        ;

        return matchRepo.filter(byTeam);
    }

    public List<Match> getAll() {
        return super.getAll();
    }

}
