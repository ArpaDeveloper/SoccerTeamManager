package com.example.soccerteammanager.repositories;

import com.example.soccerteammanager.main.DataProvider;
import com.example.soccerteammanager.objects.Player;
import java.util.List;
import java.util.function.Predicate;

/**
 * This class has methods for filtering and retrieving players
 *
 * @author Arpadev
 */
public class PlayerRepository extends Repository<Player> {

    //Method to filter players by Team
    public List<Player> filterByTeam(String team){
        DataProvider dataP = new DataProvider();
        List<Player> allPlayers = dataP.getPlayers();
        Repository<Player> playerRepo = new Repository<>(allPlayers);

        //Filter method
        Predicate<Player> byTeam = player -> player.getTeam().trim().equalsIgnoreCase(team.trim());

        return playerRepo.filter(byTeam);
    }

    //Method to filter players by all (used for search bar)
    public List<Player> filterByAll(String all){
        DataProvider dataP = new DataProvider();
        List<Player> allPlayers = dataP.getPlayers();
        Repository<Player> playerRepo = new Repository<>(allPlayers);

        //Filter method
        Predicate<Player> byAll = player -> player.getTeam().trim().equalsIgnoreCase(all.trim())
                || player.getName().trim().equalsIgnoreCase(all.trim())
                || player.getPosition().trim().equalsIgnoreCase(all.trim());

        return playerRepo.filter(byAll); //allPlayers,
    }

    //Getter
    public List<Player> getAll() {
        return super.getAll();
    }
}
