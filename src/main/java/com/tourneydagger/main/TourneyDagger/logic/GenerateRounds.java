package com.tourneydagger.main.TourneyDagger.logic;


import java.util.*;

import com.tourneydagger.main.TourneyDagger.entities.Game;
import com.tourneydagger.main.TourneyDagger.entities.Player;
import com.tourneydagger.main.TourneyDagger.entities.Tournament;
import com.tourneydagger.main.TourneyDagger.entities.TournamentRound;
import com.tourneydagger.main.TourneyDagger.entities.enumeration.Winner;
import com.tourneydagger.main.TourneyDagger.logic.errors.BadRequestAlertException;


public class GenerateRounds {

    private static final String ENTITY_NAME = "tournamentRound";


    private Tournament generateNextRound(Tournament tournament) {
        if (tournament.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if(tournament.getTournamentrounds() != null && !tournament.getTournamentrounds().isEmpty()) {
            throw new BadRequestAlertException("Round exists", ENTITY_NAME, "Round Already Exists");
        }
        TournamentRound nextRound = new TournamentRound();

        //DONE: check if tournament rounds is null, if null - create an empty list
        if (tournament.getTournamentrounds() == null) {
            List<TournamentRound> threeRoundTournament = new ArrayList<>();
        }
        // DONE: Verifica legaturile  - un joc trebuie sa aibe un singur round one-to-one
        // Updated Game entity cu un one to one mapping

        //tournament should have a list of players(verifica si aici legatura)
        //DONE: Creat one to many relationship in Tournament



        if(tournament.getTournamentrounds().isEmpty()) {
            nextRound.setGames((Set<Game>) matchPlayers(tournament.getPlayers()));
            nextRound.setRoundNumber(1);
            nextRound.setTournaments(tournament); //aici sa fie un singur tournament nu o lista de turnamente - verifica si aici
            nextRound.setName("Round One");
//            List<TournamentRound> threeRoundTournament = new ArrayList<>();
//            threeRoundTournament.add(nextRound);
        } else {
//            make two empty lists of players(winners and losers) - done
//            find last round in tournament - find in set round with largest number - done
//            parcurge lista de games din runda adaugand in cele 2 liste castigatorii si pierzatorii in listele relevante - done
//             o data ce avem cele 2 liste facem match players, folosind cele 2 liste - rezulte 2 liste de games care vor fi adaugate rundei noi
            ArrayList<Player> bagOfWinners = new ArrayList<>();
            ArrayList<Player> bagOfLosers = new ArrayList<>();
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

            nextRound.setGames((Set<Game>) matchPlayers(bagOfWinners));
            nextRound.setGames((Set<Game>) matchPlayers(bagOfLosers));
            nextRound.setRoundNumber(maxValue + 1);
            nextRound.setTournaments(tournament);
            nextRound.setName("Round" + (maxValue + 1));

        }
        tournament.addTournamentrounds(nextRound); //save round in tournament
        return tournament;
    }






    private List<Game> matchPlayers (List<Player> players) {
        ArrayList<Player> bagOfPlayers = new ArrayList<>(players);
        ArrayList<Game> bagofGames = new ArrayList<>();
        Random randomness = new Random();
        while (bagOfPlayers.size() > 2) {
            int player1Index = randomness.nextInt(bagOfPlayers.size());
            Player playerOne = bagOfPlayers.remove(player1Index);
            int player2Index = randomness.nextInt(bagOfPlayers.size());
            Player playerTwo = bagOfPlayers.remove(player2Index);
            Game game = new Game();
            game.setPlayer1(playerOne);
            game.setPlayer2(playerTwo);
            bagofGames.add(game);
        }
        if(bagOfPlayers.size() == 1) {
            Game game = new Game();
            game.setPlayer1(bagOfPlayers.get(0));
            game.setPlayer2(bagOfPlayers.get(0));
            game.setWinner(Winner.PLAYER_A);
            bagofGames.add(game);
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
