package com.example.soccerteammanager.repositories;

import com.example.soccerteammanager.objects.Player;
import com.example.soccerteammanager.objects.Team;

import java.util.List;
import java.util.function.Predicate;
public class PlayerRepository extends Repository<Player> {

    public List<Player> filterByTeam(String team){
        Predicate<Player> byTeam = player -> player.getTeam().equals(team);

        //Use the filter method from the parent class
        return filter(byTeam);
    }
    public List<Player> getAll() {
        return super.getAll();
    }
}
