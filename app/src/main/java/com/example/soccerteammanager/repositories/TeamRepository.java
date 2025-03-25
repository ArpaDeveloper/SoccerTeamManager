package com.example.soccerteammanager.repositories;

import com.example.soccerteammanager.objects.Team;

import java.util.List;
import java.util.function.Predicate;

public class TeamRepository extends Repository<Team> {

    public List<Team> filterByLeague(String league){
        Predicate<Team> byLeague = team -> team.getLeague().equals(league);

        //Use the filter method from the parent class
        return filter(byLeague);
    }
}
