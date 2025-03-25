package com.example.soccerteammanager;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Repository<T> {

    private List<T> items;

    public Repository() {
        this.items = new ArrayList<>();
    }

    //Constructor to
    public Repository(List<T> items) {
        this.items = items;
    }

    public List<T> getAll(){
        return items;
    }
    public void add(T item){
        items.add(item);
    }

    public List<T> filter(Predicate<T> predicate){
        return items.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }
}
