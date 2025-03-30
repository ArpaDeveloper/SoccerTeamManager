package com.example.soccerteammanager.objects;

/**
 * This class defines object Team
 *
 * @author Arpadev
 */
public class Team implements SoccerEntity {

    //Variables
    private final String name;
    private final String country;
    private final String league;

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
