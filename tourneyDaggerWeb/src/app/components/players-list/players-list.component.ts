import { Component, OnInit } from '@angular/core';
import { Player } from 'src/app/models/player';
import { PlayerService } from '../../services/player.service';

@Component({
  selector: 'app-players-list',
  templateUrl: './players-list.component.html',
  styleUrls: ['./players-list.component.css']
})

export class PlayersListComponent implements OnInit {

  player: Player;
  currentPlayer = null;
  currentId = -1;
  name = '';
  id = '';

  constructor(private playerService: PlayerService) { }

  ngOnInit(): void {
    this.retrievePlayers();
  }
  
  
  retrievePlayers(): void {
    this.playerService.getAll()
    .subscribe(
      data => {
        this.player = data;
        console.log(data);
      },
      error => {
        console.log(error);
     });
  }

  refreshList(): void {
    this.retrievePlayers();
    this.currentPlayer = null;
    this.currentId = -1;
  }

  setActivePlayer(player, id): void {
    this.currentPlayer = player;
    this.currentId = id;
  }

  removeAllPlayers(): void {
    this.playerService.deleteAll()
    .subscribe(
      response => {
        console.log(response);
        this.retrievePlayers;
      },
      error => {
        console.log(error);
      });
  }

  searchPlayerName() : void {
    this.playerService.findByPlayerName(this.player.name)
    .subscribe(
      data => {
        this.player = data;
        console.log(data);
      },
      error => {
        console.log(error);
      });
  }

}

