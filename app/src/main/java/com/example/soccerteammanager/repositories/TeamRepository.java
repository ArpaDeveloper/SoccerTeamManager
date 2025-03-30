package com.example.soccerteammanager.repositories;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import com.example.soccerteammanager.main.DataProvider;
import com.example.soccerteammanager.objects.Team;

import java.util.List;
import java.util.function.Predicate;

public class TeamRepository extends Repository<Team> {

    DataProvider dataP;
    public List<Team> filterByLeague(String league){

        DataProvider dataP = new DataProvider();
        List<Team> allTeams = dataP.getTeams();

        Repository<Team> teamRepo = new Repository<>(allTeams);

        Predicate<Team> byLeague = team -> team.getLeague().trim().equalsIgnoreCase(league.trim());
        //Use the filter method from the parent class
        return teamRepo.filter(byLeague);

    }

    public List<Team> getAll() {
        return super.getAll();
    }
}
