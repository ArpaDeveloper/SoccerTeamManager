package com.example.soccerteammanager;

public class Match {

    private String homeTeam;
    private String awayTeam;
    private String score;

    //Constructor
    Match(String homeTeam, String awayTeam, String score){
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.score = score;
    }

    //Getters
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
