import { Component, OnInit } from '@angular/core';
import { GameService } from '../../services/game.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-game-details',
  templateUrl: './game-details.component.html',
  styleUrls: ['./game-details.component.css']
})

export class GameDetailsComponent implements OnInit {
  currentGame = null;
  message = '';

  constructor(
    private gameService: GameService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.message = '';
    this.getGame(this.route.snapshot.paramMap.get('id'));
  }

  getGame(id): void {
    this.gameService.get(id)
    .subscribe(
      data => {
        this.currentGame = data;
        console.log(data);
      },
      error => {
        console.log(error);
      })
  }

  updateGame(): void {
    this.gameService.update(this.currentGame)
    .subscribe(
      response => {
        console.log(response);
        this.message = 'The game was updated successfully!';
      },
      error => {
        console.log(error);
      });
  }

  deleteGame(): void {
    this.gameService.delete(this.currentGame.id)
    .subscribe(
      response => {
        console.log(response);
        this.router.navigate(['/game']);
      },
      error => {
        console.log(error);
      });
  }
}