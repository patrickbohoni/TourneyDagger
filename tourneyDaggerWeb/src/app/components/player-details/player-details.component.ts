import { Component, OnInit } from '@angular/core';
import { PlayerService } from '../../services/player.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-player-details',
  templateUrl: './player-details.component.html',
  styleUrls: ['./player-details.component.css']
})
export class PlayerDetailsComponent implements OnInit {
  currentPlayer = null;
  message = '';

  constructor(
    private playerService: PlayerService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.message = '';
    this.getPlayer(this.route.snapshot.paramMap.get('id'));
  }

  getPlayer(id): void {
    this.playerService.get(id)
    .subscribe(
      data => {
        this.currentPlayer = data;
        console.log(data);
      },
      error => {
        console.log(error);
      })
  }

  updatePlayer(): void {
    this.playerService.update(this.currentPlayer)
    .subscribe(
      response => {
        console.log(response);
        this.message = 'The player was updated successfully!';
      },
      error => {
        console.log(error);
      });
  }

  deletePlayer(): void {
    this.playerService.delete(this.currentPlayer.id)
    .subscribe(
      response => {
        console.log(response);
        this.router.navigate(['/player']);
      },
      error => {
        console.log(error);
      });
  }
}