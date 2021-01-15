import { Component, OnInit } from '@angular/core';
import { Game } from 'src/app/models/game';
import { TournamentRoundService } from '../../services/tournament-round.service';

@Component({
  selector: 'app-add-tournament-round',
  templateUrl: './add-tournament-round.component.html',
  styleUrls: ['./add-tournament-round.component.css']
})
export class AddTournamentRoundComponent implements OnInit {

  tournamentround = {
    id: '',
    name: '',
    roundNumber: '',
    games: [Game],
    tournament: ''
  };

  submitted = false; constructor(private tournamentRoundService: TournamentRoundService) {
  } ngOnInit(): void {
  }

  saveTournamentRound(): void {
    const data = {
      id: this.tournamentround.id,
      name: this.tournamentround.name,
      roundNumber: this.tournamentround.roundNumber,
      games: this.tournamentround.games,
      tournament: this.tournamentround.tournament,

    }; this.tournamentRoundService.create(data)
      .subscribe(
        response => {
          console.log(response);
          this.submitted = true;
        },
        error => {
          console.log(error);
        });
  }

  newTournamentRound(): void {
    this.submitted = false;
    this.tournamentround = {
      id: '',
      name: '',
      roundNumber: '',
      games: [Game],
      tournament: ''
    };
  }
}
