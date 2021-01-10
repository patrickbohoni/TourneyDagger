import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule} from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MainComponent } from './main/main.component';
import { NavbarComponent } from './navbar/navbar.component';
import { HomeComponent } from './home/home.component';
import { TournamentRoundComponent } from './entities/tournament-round/tournament-round.component';
import { TournamentComponent } from './entities/tournament/tournament.component';
import { PlayerComponent } from './entities/player/player.component';
import { GameComponent } from './entities/game/game.component';


import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { AddTournamentComponent } from './components/add-tournament/add-tournament.component';
import { TournamentDetailsComponent } from './components/tournament-details/tournament-details.component';
import { TournamentListComponent } from './components/tournament-list/tournament-list.component';

@NgModule({
  declarations: [
    AppComponent,
    MainComponent,
    NavbarComponent,
    HomeComponent,
    TournamentRoundComponent,
    TournamentComponent,
    PlayerComponent,
    GameComponent,
    AddTournamentComponent,
    TournamentDetailsComponent,
    TournamentListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
