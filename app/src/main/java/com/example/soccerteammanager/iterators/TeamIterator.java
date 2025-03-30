package com.example.soccerteammanager.iterators;

import com.example.soccerteammanager.objects.Team;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * This Iterator defines Team specific things
 *
 * @author Arpadev
 */
public class TeamIterator implements CustomIterator<Team> {

    private final List<Team> teams;
    private int index = 0;

    //Constructor
    public TeamIterator(List<Team> teams) {
        this.teams = teams;
    }

    //Bool to check if there are more to iterate over
    @Override
    public boolean hasNext() {
        return index < teams.size();
    }

    //Method to go to next iteration or stop iteration
    @Override
    public Team next() {
        if (hasNext()) {
            return teams.get(index++);
        } else {
            throw new NoSuchElementException("No more teams to iterate over.");
        }
    }
}
