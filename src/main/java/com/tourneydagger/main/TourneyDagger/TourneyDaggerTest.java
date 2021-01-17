package com.tourneydagger.main.TourneyDagger;

import com.tourneydagger.main.TourneyDagger.entities.Player;
import com.tourneydagger.main.TourneyDagger.entities.Tournament;
import com.tourneydagger.main.TourneyDagger.controller.GenerateRounds;

import java.util.ArrayList;
import java.util.List;

public class TourneyDaggerTest {

    public static void main(String[] args) {

        Tournament testTournament = new Tournament();

        Player player1 = new Player("Joe");
        Player player2 = new Player("Ann");
        Player player3 = new Player("Bob");
        Player player4 = new Player("Nick");
        Player player5 = new Player("Hal");
        Player player6 = new Player("Jordan");

        testTournament.setId(1L);
        List<Player> participants = new ArrayList<Player>();
        participants.add(player1);
        participants.add(player2);
        participants.add(player3);
        participants.add(player4);
        participants.add(player5);
//        participants.add(player6);

        testTournament.setPlayers(participants);
        GenerateRounds roundGenerator = new GenerateRounds();

        player1.setTournament(testTournament);
        System.out.println(testTournament.getPlayers());






//        roundGenerator.generateNextRound(testTournament);
//
//        System.out.println(testTournament.getTournamentrounds());
//        System.out.println(" ");
//        System.out.println(" ");
//
//        for(TournamentRound currentRound : testTournament.getTournamentrounds()) {
//            System.out.println(currentRound.getGames());
//        }
//
//        player1.setPoints(1);
//        player3.setPoints(1);
//        player2.setPoints(1);
//        player4.setPoints(0);
//        player5.setPoints(0);
//        player5.setPoints(0);
//
//        roundGenerator.generateNextRound(testTournament);
//
//        System.out.println(testTournament.getTournamentrounds());
//        System.out.println(" ");
//        System.out.println(" ");
//
//        for(TournamentRound currentRound : testTournament.getTournamentrounds()) {
//            System.out.println(currentRound.getGames());
//        }
//
    }

}
