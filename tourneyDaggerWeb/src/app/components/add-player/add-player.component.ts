import { Component, OnInit } from '@angular/core';
import { Tournament } from 'src/app/models/tournament';
import { PlayerService } from '../../services/player.service';

@Component({
  selector: 'app-add-player',
  templateUrl: './add-player.component.html',
  styleUrls: ['./add-player.component.css']
})
export class AddPlayerComponent implements OnInit {

  player = {
    id: '',
    name: '',
    points: '',
    ranking: '',
    wLR: '',
    // tournament: [Tournament]
  };

  submitted = false; constructor(private playerService: PlayerService) {
  } ngOnInit(): void {
  } savePlayer(): void {
    const data = {
      id: this.player.id,
      name: this.player.name,
      points: this.player.points,
      ranking: this.player.ranking,
      wLR: this.player.wLR,
      // tournament: this.player.tournament

    }; this.playerService.create(data)
      .subscribe(
        response => {
          console.log(response);
          this.submitted = true;
        },
        error => {
          console.log(error);
        });
  } newPlayer(): void {
    this.submitted = false;
    this.player = {
      id: '',
      name: '',
      points: '',
      ranking: '',
      wLR: '',
      // tournament: [Tournament]
    };
  }
}
