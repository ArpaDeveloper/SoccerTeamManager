package com.example.soccerteammanager.objects;

public class Team implements SoccerEntity {

    private String name;
    private String country;
    private String league;

    //Constructor
    public Team(String name, String country, String league){
        this.name = name;
        this.country = country;
        this.league = league;
    }

    //Getters
    @Override
    public String getName(){
        return name;
    }
    @Override
    public String getID() {
        return "Team";
    }
    public String getCountry(){
        return country;
    }
    public String getLeague(){
        return league;
    }

}
