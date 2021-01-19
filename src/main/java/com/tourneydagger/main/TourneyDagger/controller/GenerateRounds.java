package com.tourneydagger.main.TourneyDagger.controller;


import java.util.*;

import com.tourneydagger.main.TourneyDagger.entities.Game;
import com.tourneydagger.main.TourneyDagger.entities.Player;
import com.tourneydagger.main.TourneyDagger.entities.Tournament;
import com.tourneydagger.main.TourneyDagger.entities.TournamentRound;
import com.tourneydagger.main.TourneyDagger.entities.enumeration.Winner;
import com.tourneydagger.main.TourneyDagger.controller.errors.BadRequestAlertException;


public class GenerateRounds {

    private static final String ENTITY_NAME = "tournamentRound";



    public TournamentRound generateNextRound(Tournament tournament) {
        System.out.println("Generating round one");
        if (tournament.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
//        if(tournament.getTournamentrounds() != null && !tournament.getTournamentrounds().isEmpty()) {
//            throw new BadRequestAlertException("Round exists", ENTITY_NAME, "Round Already Exists");
//        }  - asta trebuie corectata - probabil sa dea eroarea daca avem mai mult de 3 runde.
        TournamentRound nextRound = new TournamentRound();
        System.out.println("created empty new round");

        //DONE: check if tournament rounds is null, if null - create an empty list
        if (tournament.getTournamentrounds() == null) {
            tournament.addTournamentrounds(nextRound);
            System.out.println("Added empty round to tournament");
        }

        if(tournament.getTournamentrounds().isEmpty()) {
            System.out.println("Matching for first round #players: " + tournament.getPlayers().size());
            nextRound.setGames(new HashSet<>(matchPlayers(tournament.getPlayers())));
            System.out.println("Created games");
            nextRound.setRoundNumber(1);
            nextRound.setTournaments(tournament);
            nextRound.setName("Round 1");
        } else {
            ArrayList<Player> bagOfWinners = new ArrayList<>();
            ArrayList<Player> bagOfLosers = new ArrayList<>();
            System.out.println("Matching for subsequent rounds #players: " + tournament.getPlayers().size());
            int maxValue = Integer.MIN_VALUE;
            TournamentRound lastRound = new TournamentRound();
            for(Iterator<TournamentRound> it = tournament.getTournamentrounds().iterator(); it.hasNext(); ) {
                TournamentRound whichRound = it.next();
                if (whichRound.getRoundNumber() > maxValue) {
                    maxValue = whichRound.getRoundNumber();
                    lastRound = whichRound;
                }
            }
            ArrayList<Game> lastRoundGames = new ArrayList<Game>(lastRound.getGames());
            for (int i = 0; i < lastRoundGames.size() ; i++) {
                if(lastRoundGames.get(i).getWinner() == Winner.PLAYER_A) {
                    bagOfWinners.add(lastRoundGames.get(i).getPlayer1());
                    bagOfLosers.add(lastRoundGames.get(i).getPlayer2());
                }
                if(lastRoundGames.get(i).getWinner() == Winner.PLAYER_B) {
                    bagOfWinners.add(lastRoundGames.get(i).getPlayer2());
                    bagOfLosers.add(lastRoundGames.get(i).getPlayer1());
                }
            }

            nextRound.setGames(new HashSet<>(matchPlayers(bagOfWinners)));
            nextRound.getGames().addAll(new HashSet<>(matchPlayers(bagOfLosers)));
            nextRound.setRoundNumber(maxValue + 1);
            nextRound.setTournaments(tournament);
            nextRound.setName("Round " + (maxValue + 1));

        }

        tournament.addTournamentrounds(nextRound); //save round in tournament
        System.out.println("Added Next Round to tournament");
        return nextRound;
    }






    private List<Game> matchPlayers (List<Player> players) {
        ArrayList<Player> bagOfPlayers = new ArrayList<>(players);
        ArrayList<Game> bagofGames = new ArrayList<>();
        Random randomness = new Random();
        while (bagOfPlayers.size() >= 2) {
            int player1Index = randomness.nextInt(bagOfPlayers.size());
            Player playerOne = bagOfPlayers.remove(player1Index);
            int player2Index = randomness.nextInt(bagOfPlayers.size());
            Player playerTwo = bagOfPlayers.remove(player2Index);
            Game game = new Game();
            game.setPlayer1(playerOne);
            game.setPlayer2(playerTwo);
            bagofGames.add(game);
            System.out.println("Game created");

        }
        if(bagOfPlayers.size() == 1) {
            Game game = new Game();
            game.setPlayer1(bagOfPlayers.get(0));
            game.setPlayer2(bagOfPlayers.get(0));
            game.setWinner(Winner.PLAYER_A);
            bagofGames.add(game);
            System.out.println("Bye game created");
        }
        return bagofGames;
    }

    private void increasePlayerScore(Player player) {
        int playerScore = player.getPoints();
        playerScore++;
        player.setPoints(playerScore);
    }

    private void setWinnerpl1(Game game) {
        game.setWinner(Winner.PLAYER_A);
        increasePlayerScore(game.getPlayer1());
    }



    private void setWinnerpl2(Game game) {
        game.setWinner(Winner.PLAYER_B);
        increasePlayerScore(game.getPlayer2());
    }







}
