package com.example.soccerteammanager.iterators;

import com.example.soccerteammanager.objects.Team;

import java.util.List;
import java.util.NoSuchElementException;

public class TeamIterator implements CustomIterator<Team> {

    private List<Team> teams;
    private int index = 0;

    @Override
    public boolean hasNext() {
        return index < teams.size();
    }

    @Override
    public Team next() {
        if (hasNext()) {
            return teams.get(index++);
        } else {
            throw new NoSuchElementException("No more teams to iterate over.");
        }
    }
}
