import { Component, OnInit } from '@angular/core';
import { Player } from '../player';
import { PlayerService } from '../player.service';


@Component({
  selector: 'app-player-list',
  templateUrl: './player-list.component.html',
  styleUrls: ['./player-list.component.css']
})
export class PlayerListComponent implements OnInit{

  players: Player[];

  constructor(private playerService: PlayerService) { }

  ngOnInit(): void { 
    this.getPlayers();
  }

  private getPlayers(){
    this.playerService.getPlayersList().subscribe(data => {
      this.players = data;
    });
  }
}
