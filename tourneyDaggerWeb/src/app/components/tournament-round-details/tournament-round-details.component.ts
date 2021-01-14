import { Component, OnInit } from '@angular/core';
import { TournamentRoundService } from '../../services/tournament-round.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-tournament-round-details',
  templateUrl: './tournament-round-details.component.html',
  styleUrls: ['./tournament-round-details.component.css']
})
export class TournamentRoundDetailsComponent implements OnInit {
  currentTournamentRound = null;
  message = '';

  constructor(
    private tournamentRoundService: TournamentRoundService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.message = '';
    this.getTournamentRound(this.route.snapshot.paramMap.get('id'));
  }

  getTournamentRound(id): void {
    this.tournamentRoundService.get(id)
    .subscribe(
      data => {
        this.currentTournamentRound = data;
        console.log(data);
      },
      error => {
        console.log(error);
      })
  }

  updateTournamentRound(): void {
    this.tournamentRoundService.update(this.currentTournamentRound)
    .subscribe(
      response => {
        console.log(response);
        this.message = 'The tournament round was updated successfully!';
      },
      error => {
        console.log(error);
      });
  }

  deleteTournamentRound(): void {
    this.tournamentRoundService.delete(this.currentTournamentRound.id)
    .subscribe(
      response => {
        console.log(response);
        this.router.navigate(['/tournament-round']);
      },
      error => {
        console.log(error);
      });
  }
}