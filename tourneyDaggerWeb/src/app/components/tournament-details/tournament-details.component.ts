import { Component, OnInit } from '@angular/core';
import { TournamentService } from '../../services/tournament.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-tournament-details',
  templateUrl: './tournament-details.component.html',
  styleUrls: ['./tournament-details.component.css']
})
export class TournamentDetailsComponent implements OnInit {
  currentTournament = null;
  message = '';

  constructor(
    private tournamentService: TournamentService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.message = '';
    this.getTournament(this.route.snapshot.paramMap.get('id'));
  }

  getTournament(id): void {
    this.tournamentService.get(id)
    .subscribe(
      data => {
        this.currentTournament = data;
        console.log(data);
      },
      error => {
        console.log(error);
      })
  }

  updateTournament(): void {
    this.tournamentService.update(this.currentTournament)
    .subscribe(
      response => {
        console.log(response);
        this.message = 'The tournament was updated successfully!';
      },
      error => {
        console.log(error);
      });
  }

  runTournament(): void {
    this.tournamentService.generateRound(this.currentTournament)
    .subscribe(
      response => {
        console.log(response);
        this.message = 'A new round has been added and the players have been matched';
      },
      error => {
        console.log(error);
      }
    )
  }

  addPlayerRoster(): void {
    this.tournamentService.createPlayerRoster(this.currentTournament)
    .subscribe(
      response => {
        console.log(response);
        this.message = 'Players have been added to the tournament';
      },
      error => {
        console.log(error);
      }
    )
  }

  deleteTournament(): void {
    this.tournamentService.delete(this.currentTournament.id)
    .subscribe(
      response => {
        console.log(response);
        this.router.navigate(['/tournament']);
      },
      error => {
        console.log(error);
      });
  }
}
