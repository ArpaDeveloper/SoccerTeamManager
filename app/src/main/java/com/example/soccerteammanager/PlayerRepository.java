package com.example.soccerteammanager;

import java.util.List;
import java.util.function.Predicate;
public class PlayerRepository extends Repository<Player>{

    public List<Player> filterByTeam(String team){
        Predicate<Player> byTeam = player -> player.getTeam().equals(team);

        //Use the filter method from the parent class
        return filter(byTeam);
    }
}
