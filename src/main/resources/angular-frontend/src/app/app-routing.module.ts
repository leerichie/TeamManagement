import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PlayerListComponent } from './player-list/player-list.component';
import { CreateUserComponent } from './create-player/create-player.component';
import { UpdatePlayerComponent } from './update-player/update-player.component';
import { PlayerDetailsComponent } from './player-details/player-details.component';
import { ImagesComponent } from './images/images.component';

const routes: Routes = [
  {path: 'players', component: PlayerListComponent},
  {path: 'create-player', component: CreateUserComponent},
  {path: '', redirectTo: 'players', pathMatch: 'full'},
  {path: 'update-player/:id', component: UpdatePlayerComponent},
  {path: 'player-details/:id', component: PlayerDetailsComponent},
  {path: 'images', component: ImagesComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
