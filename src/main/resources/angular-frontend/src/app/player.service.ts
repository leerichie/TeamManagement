import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Player } from './player';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class PlayerService {
  private baseUrl = 'http://localhost:8282/api/v1/players';
  constructor(private httpClient: HttpClient) {}

  getPlayersList(): Observable<Player[]> {
    return this.httpClient.get<Player[]>(`${this.baseUrl}`);
  }

  createPlayer(player: Player): Observable<Object> {
    return this.httpClient.post(`${this.baseUrl}`, player);
  }

  getPlayerById(id: number): Observable<Player> {
    return this.httpClient.get<Player>(`${this.baseUrl}/${id}`);
  }

  updatePLayer(id: number, player: Player): Observable<Object> {
    return this.httpClient.put(`${this.baseUrl}/${id}`, player);
  }

  deletePlayer(id: number): Observable<Object>{
    return this.httpClient.delete(`${this.baseUrl}/${id}`);
  }

  
}
