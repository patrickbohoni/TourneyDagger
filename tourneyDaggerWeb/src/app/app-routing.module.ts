import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddTournamentComponent } from './components/add-tournament/add-tournament.component';
import { TournamentDetailsComponent } from './components/tournament-details/tournament-details.component';
import { TournamentListComponent } from './components/tournament-list/tournament-list.component';

const routes: Routes = [
  { path: '', redirectTo: 'tournament', pathMatch: 'full'},
  { path: 'tournament', component: TournamentListComponent},
  { path: 'tournament/:id', component: TournamentDetailsComponent},
  { path: 'add', component: AddTournamentComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
