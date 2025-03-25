package com.example.soccerteammanager.objects;

public class Player implements SoccerEntity {

    private String name;
    private String position;
    private String team;

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
