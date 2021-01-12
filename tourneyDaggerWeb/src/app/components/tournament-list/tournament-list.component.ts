import { Component, OnInit } from '@angular/core';
import { TournamentService } from '../../services/tournament.service';

@Component({
  selector: 'app-tournament-list',
  templateUrl: './tournament-list.component.html',
  styleUrls: ['./tournament-list.component.css']
})

export class TournamentListComponent implements OnInit {

  tournament: any;
  currentTournament = null;
  currentId = -1;
  name = '';

  constructor(private tournamentService: TournamentService) { }

  ngOnInit(): void {
    this.retrieveTournaments();
  }
  
  
  retrieveTournaments(): void {
    this.tournamentService.getAll()
    .subscribe(
      data => {
        this.tournament = data;
        console.log(data);
      },
      error => {
        console.log(error);
     });
  }

  refreshList(): void {
    this.retrieveTournaments();
    this.currentTournament = null;
    this.currentId = -1;
  }

  setActiveTournament(tournament, id): void {
    this.currentTournament = tournament;
    this.currentId = id;
  }

  removeAllTournaments(): void {
    this.tournamentService.deleteAll()
    .subscribe(
      response => {
        console.log(response);
        this.retrieveTournaments;
      },
      error => {
        console.log(error);
      });
  }

  searchName() : void {
    this.tournamentService.findByName(this.name)
    .subscribe(
      data => {
        this.tournament = data;
        console.log(data);
      },
      error => {
        console.log(error);
      });
  }

}
