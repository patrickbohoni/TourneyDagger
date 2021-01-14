import { Component, OnInit } from '@angular/core';
import { GameService } from '../../services/game.service';


@Component({
  selector: 'app-add-game',
  templateUrl: './add-game.component.html',
  styleUrls: ['./add-game.component.css']
})

export class AddGameComponent implements OnInit {
  game = {
    id: '',
    winner: '',
    player1: '',
    player2: '',
    rounds: ''
  };

  submitted = false; constructor(private gameService: GameService) {
  } ngOnInit(): void {
  } saveGame(): void {
    const data = {
      id: this.game.id,
      winner: this.game.winner,
      player1: this.game.player1,
      player2: this.game.player2,
      rounds: this.game.rounds

    }; this.gameService.create(data)
      .subscribe(
        response => {
          console.log(response);
          this.submitted = true;
        },
        error => {
          console.log(error);
        });
  } newGame(): void {
    this.submitted = false;
    this.game = {
      id: '',
      winner: '',
      player1: '',
      player2: '',
      rounds: ''
    };
  }
}
