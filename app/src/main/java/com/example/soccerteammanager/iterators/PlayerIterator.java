package com.example.soccerteammanager.iterators;

import com.example.soccerteammanager.objects.Player;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * This Iterator defines Player specific things
 *
 * @author Arpadev
 */
public class PlayerIterator implements CustomIterator<Player>{

    private final List<Player> players;
    private int index = 0;

    //Constructor
    public PlayerIterator(List<Player> players) {
        this.players = players;
    }

    //Bool to check if there are more to iterate over
    @Override
    public boolean hasNext() {
        return index < players.size();
    }

    //Method to go to next iteration or stop iteration
    @Override
    public Player next() {
        if (hasNext()) {
            return players.get(index++);
        } else {
            throw new NoSuchElementException("No more players to iterate over.");
        }
    }
}
