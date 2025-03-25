package com.example.soccerteammanager;

public class Team{

    private String name;
    private String country;
    private String league;

    //Constructor
    Team(String name, String country, String league){
        this.name = name;
        this.country = country;
        this.league = league;
    }

    //Getters
    public String getName(){
        return name;
    }
    public String getCountry(){
        return country;
    }
    public String getLeague(){
        return league;
    }

}
