package com.example.soccerteammanager.repositories;

import com.example.soccerteammanager.main.DataProvider;
import com.example.soccerteammanager.objects.Player;
import com.example.soccerteammanager.objects.Team;

import java.util.List;
import java.util.function.Predicate;
public class PlayerRepository extends Repository<Player> {

    public List<Player> filterByTeam(String team){
        DataProvider dataP = new DataProvider();
        List<Player> allPlayers = dataP.getPlayers();

        Repository<Player> playerRepo = new Repository<>(allPlayers);

        Predicate<Player> byTeam = player -> player.getTeam().trim().equalsIgnoreCase(team.trim());

        return playerRepo.filter(byTeam); //allPlayers,

    }

    public List<Player> filterByAll(String all){
        DataProvider dataP = new DataProvider();
        List<Player> allPlayers = dataP.getPlayers();

        Repository<Player> playerRepo = new Repository<>(allPlayers);

        Predicate<Player> byAll = player -> player.getTeam().trim().equalsIgnoreCase(all.trim())
                || player.getName().trim().equalsIgnoreCase(all.trim())
                || player.getPosition().trim().equalsIgnoreCase(all.trim());

        return playerRepo.filter(byAll); //allPlayers,

    }
    public List<Player> getAll() {
        return super.getAll();
    }
}
