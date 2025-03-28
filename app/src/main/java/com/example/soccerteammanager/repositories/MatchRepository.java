package com.example.soccerteammanager.repositories;

import com.example.soccerteammanager.objects.Match;
import com.example.soccerteammanager.objects.Team;

import java.util.List;
import java.util.function.Predicate;

public class MatchRepository extends Repository<Match> {

    public List<Match> filterByTeam(String team){
        Predicate<Match> byTeam = match -> match.getHomeTeam().equals(team) || match.getAwayTeam().equals(team);

        //Use the filter method from the parent class
        return filter(byTeam);
    }

    public List<Match> getAll() {
        return super.getAll();
    }

}
