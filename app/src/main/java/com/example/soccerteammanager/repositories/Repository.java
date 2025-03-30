package com.example.soccerteammanager.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * This class has methods for filtering and retrieving objects
 *
 * @author Arpadev
 */
public class Repository<T> {

    private final List<T> items;

    //Default constructor
    public Repository() {
        this.items = new ArrayList<>();
    }

    //Parameterized constructor
    public Repository(List<T> items) {
        this.items = items;
    }

    //Getter
    public List<T> getAll(){
        return items;
    }

    //Filter method
    public List<T> filter(Predicate<T> predicate){
        return items.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }
}
