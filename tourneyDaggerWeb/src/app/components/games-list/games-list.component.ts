import { Component, OnInit } from '@angular/core';
import { Game } from 'src/app/models/game';
import { GameService } from '../../services/game.service';

@Component({
  selector: 'app-games-list',
  templateUrl: './games-list.component.html',
  styleUrls: ['./games-list.component.css']
})
export class GamesListComponent implements OnInit {

  game: Game;
  currentGame = null;
  currentId = -1;
  number = '';
  id = '';
  

  constructor(private gameService: GameService) { }

  ngOnInit(): void {
    this.retrieveGames();
  }
  
  
  retrieveGames(): void {
    this.gameService.getAll()
    .subscribe(
      data => {
        this.game = data;
        console.log(data);
      },
      error => {
        console.log(error);
     });
  }

  refreshList(): void {
    this.retrieveGames();
    this.currentGame = null;
    this.currentId = -1;
  }

  setActiveGame(game, id): void {
    this.currentGame = game;
    this.currentId = id;
  }

  removeAllGames(): void {
    this.gameService.deleteAll()
    .subscribe(
      response => {
        console.log(response);
        this.retrieveGames;
      },
      error => {
        console.log(error);
      });
  }

  searchByGameID() : void {
    this.gameService.findById(this.id)
    .subscribe(
      data => {
        this.game = data;
        console.log(data);
      },
      error => {
        console.log(error);
      });
  }

}

