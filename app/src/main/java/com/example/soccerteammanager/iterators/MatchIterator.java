package com.example.soccerteammanager.iterators;

import com.example.soccerteammanager.objects.Match;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * This Iterator defines Match specific things
 *
 * @author Arpadev
 */
public class MatchIterator implements CustomIterator<Match> {

    private final List<Match> matches;
    private int index = 0;

    //Constructor
    public MatchIterator(List<Match> matches) {
        this.matches = matches;
    }

    //Bool to check if there are more to iterate over
    @Override
    public boolean hasNext() {
        return index < matches.size();
    }

    //Method to go to next iteration or stop iteration
    @Override
    public Match next() {
        if (hasNext()) {
            return matches.get(index++);
        } else {
            throw new NoSuchElementException("No more matches to iterate over.");
        }
    }
}
