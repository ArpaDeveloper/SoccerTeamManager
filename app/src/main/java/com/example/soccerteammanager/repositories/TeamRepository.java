package com.example.soccerteammanager.repositories;

import com.example.soccerteammanager.main.DataProvider;
import com.example.soccerteammanager.objects.Team;

import java.util.List;
import java.util.function.Predicate;

public class TeamRepository extends Repository<Team> {

    DataProvider dataP;
    public List<Team> filterByLeague(String league){
        DataProvider dataP = new DataProvider();
        List<Team> allTeams = dataP.getTeams();
        Predicate<Team> byLeague = team -> team.getLeague().equals(league);

        //Use the filter method from the parent class
        return filter(byLeague);
    }
    //Pain
    public List<Team> getAll() {
        return super.getAll();
    }
}
