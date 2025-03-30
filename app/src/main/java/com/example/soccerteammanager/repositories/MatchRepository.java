package com.example.soccerteammanager.repositories;

import com.example.soccerteammanager.main.DataProvider;
import com.example.soccerteammanager.objects.Match;
import java.util.List;
import java.util.function.Predicate;

/**
 * This class has methods for filtering and retrieving matches
 *
 * @author Arpadev
 */
public class MatchRepository extends Repository<Match> {

    //Method to filter matches by Team
    public List<Match> filterByTeam(String team){
        DataProvider dataP = new DataProvider();
        List<Match> allMatches = dataP.getMatches();
        Repository<Match> matchRepo = new Repository<>(allMatches);

        //Filter method
        Predicate<Match> byTeam = match -> match.getHomeTeam().trim().equalsIgnoreCase(team.trim())
                || match.getAwayTeam().trim().equalsIgnoreCase(team.trim());

        return matchRepo.filter(byTeam);
    }

    //Getter
    public List<Match> getAll() {
        return super.getAll();
    }

}
