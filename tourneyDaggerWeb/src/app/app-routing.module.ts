import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddTournamentRoundComponent } from './components/add-tournament-round/add-tournament-round.component';
import { AddTournamentComponent } from './components/add-tournament/add-tournament.component';
import { TournamentDetailsComponent } from './components/tournament-details/tournament-details.component';
import { TournamentListComponent } from './components/tournament-list/tournament-list.component';
import { TournamentRoundDetailsComponent } from './components/tournament-round-details/tournament-round-details.component';
import { TournamentRoundListComponent } from './components/tournament-round-list/tournament-round-list.component';
import { GamesListComponent } from './components/games-list/games-list.component';
import { GameDetailsComponent } from './components/game-details/game-details.component';
import { AddGameComponent } from './components/add-game/add-game.component'; 
import { PlayersListComponent } from './components/players-list/players-list.component';
import { PlayerDetailsComponent } from './components/player-details/player-details.component';
import { AddPlayerComponent } from './components/add-player/add-player.component';
import { LoginComponent } from './login/login.component';



const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: '', component: LoginComponent},
  // { path: '', redirectTo: 'tournament', pathMatch: 'full'},
  { path: 'tournament', component: TournamentListComponent},
  { path: 'tournament/:id', component: TournamentDetailsComponent},
  { path: 'add', component: AddTournamentComponent},
  { path: 'tournament-round', component: TournamentRoundListComponent},
  { path: 'tournament-round/:id', component: TournamentRoundDetailsComponent},
  { path: 'addTR', component: AddTournamentRoundComponent},
  { path: 'game', component: GamesListComponent},
  { path: 'game/:id', component: GameDetailsComponent},
  { path: 'addGame', component: AddGameComponent},
  { path: 'player', component: PlayersListComponent},
  { path: 'player/:id', component: PlayerDetailsComponent},
  { path: 'addPlayer', component: AddPlayerComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
