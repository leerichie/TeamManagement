import { Component } from '@angular/core';
import { Player } from '../player';
import { PlayerService } from '../player.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-user',
  templateUrl: './create-player.component.html',
  styleUrls: ['./create-player.component.css']
})
export class CreateUserComponent {

  player: Player = new Player;

  constructor(private playerService: PlayerService,
    private router: Router) { }

  ngOnInit(): void{

  }
  savePlayer(){
    this.playerService.createPlayer(this.player).subscribe(data =>{
      console.log(data);
      // this.goToPlayerList();
      this.router.navigate(['/players']);
    },
    error => console.log(error));
  }

  // goToPlayerList(){
  //   this.router.navigate(['/players']);
  // }

  onSubmit(){
    console.log(this.player);
    this.savePlayer();
  }
}
