import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule} from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MainComponent } from './main/main.component';
import { NavbarComponent } from './navbar/navbar.component';
import { HomeComponent } from './home/home.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { AddTournamentComponent } from './components/add-tournament/add-tournament.component';
import { TournamentDetailsComponent } from './components/tournament-details/tournament-details.component';
import { TournamentListComponent } from './components/tournament-list/tournament-list.component';
import {TournamentService} from './services/tournament.service';
import { AddTournamentRoundComponent } from './components/add-tournament-round/add-tournament-round.component';
import { TournamentRoundDetailsComponent } from './components/tournament-round-details/tournament-round-details.component';
import { TournamentRoundListComponent } from './components/tournament-round-list/tournament-round-list.component';
import { AddGameComponent } from './components/add-game/add-game.component';
import { GameDetailsComponent } from './components/game-details/game-details.component';
import { GamesListComponent } from './components/games-list/games-list.component';

@NgModule({
  declarations: [
    AppComponent,
    MainComponent,
    NavbarComponent,
    HomeComponent,
    AddTournamentComponent,
    TournamentDetailsComponent,
    TournamentListComponent,
    AddTournamentRoundComponent,
    TournamentRoundDetailsComponent,
    TournamentRoundListComponent,
    AddGameComponent,
    GameDetailsComponent,
    GamesListComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [TournamentService],
  bootstrap: [AppComponent]
})

export class AppModule { }