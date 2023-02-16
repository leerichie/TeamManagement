import { Component } from '@angular/core';
import { Router } from '@angular/router'
import { Player } from '../player';
import { PlayerService } from '../player.service';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent {

player: Player = new Player;

  constructor(private playerService: PlayerService,
    private router: Router) { }

  ngOnInit(): void{

  }
  savePlayer(){
    this.playerService.createPlayer(this.player).subscribe(data =>{
      console.log(data);
      this.router.navigate(['/players']);
    },
    error => console.log(error));
  }

  onSubmit(){
    console.log(this.player);
    this.savePlayer();
  }
}
