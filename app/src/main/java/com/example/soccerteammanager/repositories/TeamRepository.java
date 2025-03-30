package com.example.soccerteammanager.repositories;

import com.example.soccerteammanager.main.DataProvider;
import com.example.soccerteammanager.objects.Team;
import java.util.List;
import java.util.function.Predicate;

/**
 * This class has methods for filtering and retrieving teams
 *
 * @author Arpadev
 */
public class TeamRepository extends Repository<Team> {

    //Method to filter teams by League
    public List<Team> filterByLeague(String league){
        DataProvider dataP = new DataProvider();
        List<Team> allTeams = dataP.getTeams();
        Repository<Team> teamRepo = new Repository<>(allTeams);

        //Filter method
        Predicate<Team> byLeague = team -> team.getLeague().trim().equalsIgnoreCase(league.trim());

        return teamRepo.filter(byLeague);
    }

    //Method to filter teams by all (used for search bar)
    public List<Team> filterByAll(String all){
        DataProvider dataP = new DataProvider();
        List<Team> allTeams = dataP.getTeams();
        Repository<Team> teamRepo = new Repository<>(allTeams);

        //Filter method
        Predicate<Team> byAll = team -> team.getLeague().trim().equalsIgnoreCase(all.trim())
                || team.getName().trim().equalsIgnoreCase(all.trim())
                || team.getCountry().trim().equalsIgnoreCase(all.trim());

        return teamRepo.filter(byAll);
    }

    //Getter
    public List<Team> getAll() {
        return super.getAll();
    }
}
