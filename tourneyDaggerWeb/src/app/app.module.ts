import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule} from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';import { AppRoutingModule } from './app-routing.module';
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
import { AddPlayerComponent } from './components/add-player/add-player.component';
import { PlayerDetailsComponent } from './components/player-details/player-details.component';
import { PlayersListComponent } from './components/players-list/players-list.component';
import { LoginComponent } from './login/login.component';
import { HttpInterceptorService } from './login/authinterceptor.service';
import { MenuComponent } from './menu/menu.component';

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
    AddPlayerComponent,
    PlayerDetailsComponent,
    PlayersListComponent,
    LoginComponent,
    MenuComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    {provide: HTTP_INTERCEPTORS,
     useClass: HttpInterceptorService,
    multi: true
  }],
  bootstrap: [AppComponent]
})

export class AppModule { }