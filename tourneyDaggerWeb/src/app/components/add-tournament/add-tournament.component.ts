import { Component, OnInit } from '@angular/core';
import { TournamentService } from 'c:/Users/Patrick/Documents/TourneyDagger/tourneyDaggerWeb/src/app/services/tournament.service';

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
    tournamentrounds: ''
  };
  submitted = false;

  constructor(private TournamentService: TournamentService) { }

  ngOnInit(): void {
  }

  saveTournament(): void {
    const data = {
      id: this.tournament.id,
      name: this.tournament.name,
      location: this.tournament.location,
      date: this.tournament.date,
      type: this.tournament.type,
      tournamentrounds: this.tournament.tournamentrounds
    };
    
    this.TournamentService.create(data)
    .subscribe(
      response => {
        console.log(response);
        this.submitted = true;
      },
      error => {
        console.log(error);
      });

  }

  newTournament(): void {
    this.submitted = false;
    this.tournament = {
      id: '',
      name: '',
      location: '',
      date: '',
      type: '',
      tournamentrounds: ''
    };
  }

}
