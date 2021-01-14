import { Component, OnInit } from '@angular/core';
import { TournamentRoundService } from '../../services/tournament-round.service';
import { TournamentRound } from '../../models/tournament-round';

@Component({
  selector: 'app-tournament-round-list',
  templateUrl: './tournament-round-list.component.html',
  styleUrls: ['./tournament-round-list.component.css']
})

export class TournamentRoundListComponent implements OnInit {

  tournamentRound: TournamentRound;
  currentTournamentRound = null;
  currentId = -1;
  name = '';

  constructor(private tournamentRoundService: TournamentRoundService) { }

  ngOnInit(): void {
    this.retrieveTournamentRounds();
  }
  
  
  retrieveTournamentRounds(): void {
    this.tournamentRoundService.getAll()
    .subscribe(
      data => {
        this.tournamentRound = data;
        console.log(data);
      },
      error => {
        console.log(error);
     });
  }

  refreshList(): void {
    this.retrieveTournamentRounds();
    this.currentTournamentRound = null;
    this.currentId = -1;
  }

  setActiveTournamentRound(tournamentRound, id): void {
    this.currentTournamentRound = tournamentRound;
    this.currentId = id;
  }

  removeAllTournamentRounds(): void {
    this.tournamentRoundService.deleteAll()
    .subscribe(
      response => {
        console.log(response);
        this.retrieveTournamentRounds;
      },
      error => {
        console.log(error);
      });
  }

  searchRoundName() : void {
    this.tournamentRoundService.findByName(this.name)
    .subscribe(
      data => {
        this.tournamentRound = data;
        console.log(data);
      },
      error => {
        console.log(error);
      });
  }

}