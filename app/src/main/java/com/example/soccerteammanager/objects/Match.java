package com.example.soccerteammanager.objects;

/**
 * This class defines object Match
 *
 * @author Arpadev
 */
public class Match implements SoccerEntity {

    //Variables
    private final String homeTeam;
    private final String awayTeam;
    private final String score;

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
