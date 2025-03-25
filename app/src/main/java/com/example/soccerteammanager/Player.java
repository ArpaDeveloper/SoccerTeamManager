package com.example.soccerteammanager;

public class Player {

    private String name;
    private String position;
    private String team;

    //Constructor
    Player(String name, String position, String team){
        this.name = name;
        this.position = position;
        this.team = team;
    }

    //Getters
    public String getName(){
        return name;
    }
    public String getPosition(){
        return position;
    }
    public String getTeam(){
        return team;
    }

}
