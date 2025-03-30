package com.example.soccerteammanager.iterators;

import com.example.soccerteammanager.objects.Player;

import java.util.List;
import java.util.NoSuchElementException;

public class PlayerIterator implements CustomIterator<Player>{

    private List<Player> players;
    private int index = 0;

    public PlayerIterator(List<Player> players) {
        this.players = players;
    }
    @Override
    public boolean hasNext() {
        return index < players.size();
    }

    @Override
    public Player next() {
        if (hasNext()) {
            return players.get(index++);
        } else {
            throw new NoSuchElementException("No more players to iterate over.");
        }
    }
}
