package com.example.soccerteammanager.iterators;

import com.example.soccerteammanager.objects.Match;
import com.example.soccerteammanager.objects.Player;

import java.util.List;
import java.util.NoSuchElementException;

public class MatchIterator implements CustomIterator<Match> {
    private List<Match> matches;
    private int index = 0;

    public MatchIterator(List<Match> matches) {
        this.matches = matches;
    }

    @Override
    public boolean hasNext() {
        return index < matches.size();
    }

    @Override
    public Match next() {
        if (hasNext()) {
            return matches.get(index++);
        } else {
            throw new NoSuchElementException("No more matches to iterate over.");
        }
    }
}
