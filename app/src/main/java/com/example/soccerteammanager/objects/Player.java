package com.example.soccerteammanager.objects;

/**
 * This class defines object Player
 *
 * @author Arpadev
 */
public class Player implements SoccerEntity {

    //Variables
    private final String name;
    private final String position;
    private final String team;

    //Constructor
    public Player(String name, String position, String team){
        this.name = name;
        this.position = position;
        this.team = team;
    }

    //Getters
    @Override
    public String getName(){
        return name;
    }
    @Override
    public String getID() {
        return "Player";
    }
    public String getPosition(){
        return position;
    }
    public String getTeam(){
        return team;
    }
}
