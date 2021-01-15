import {Component, OnInit} from '@angular/core';
import { TournamentRound } from 'src/app/models/tournament-round';
import {TournamentService} from '../../services/tournament.service';

@Component({
  selector: 'app-add-tournament',
  templateUrl: './add-tournament.component.html',
  styleUrls: ['./add-tournament.component.css']
})

export class AddTournamentComponent implements OnInit {
  tournament = {
    id: '',
    name: '',
    location: '',
    date: '',
    type: '',
    tournamentrounds: [TournamentRound]
  };
  
  submitted = false;  constructor(private tournamentService: TournamentService) {
  }  ngOnInit(): void {
  }  saveTournament(): void {
    const data = {
      id: this.tournament.id,
      name: this.tournament.name,
      location: this.tournament.location,
      date: this.tournament.date,
      type: this.tournament.type,
      tournamentrounds: this.tournament.tournamentrounds
    };    this.tournamentService.create(data)
      .subscribe(
        response => {
          console.log(response);
          this.submitted = true;
        },
        error => {
          console.log(error);
        });  }  newTournament(): void {
    this.submitted = false;
    this.tournament = {
      id: '',
      name: '',
      location: '',
      date: '',
      type: '',
      tournamentrounds: [TournamentRound]
    };
  }}