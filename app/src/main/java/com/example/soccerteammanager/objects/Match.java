package com.example.soccerteammanager.objects;

public class Match implements SoccerEntity {

    private String homeTeam;
    private String awayTeam;
    private String score;

    //Constructor
    public Match(String homeTeam, String awayTeam, String score){
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.score = score;
    }

    //Getters
    @Override
    public String getName(){
        return homeTeam+" vs "+awayTeam;
    }
    @Override
    public String getID() {
        return "Match";
    }
    public String getHomeTeam(){
        return homeTeam;
    }
    public String getAwayTeam(){
        return awayTeam;
    }
    public String getScore(){
        return score;
    }


}
