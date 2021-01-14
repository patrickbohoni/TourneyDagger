import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Player } from '../models/player';

const baseUrl = 'http://localhost:8080/api/players';

@Injectable({
  providedIn: 'root'
})
export class PlayerService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<Player> {
      return this.http.get(baseUrl);
  }

  get(id): Observable<Player> {
      return this.http.get(`${baseUrl}/${id}`);
  }

  create(data): Observable<Player> {
      return this.http.post(baseUrl, data);
  }

  update(data): Observable<Player> {
      return this.http.put(baseUrl, data);
  
  }

  delete(id): Observable<Player> {
      return this.http.delete(`${baseUrl}/${id}`);
  }

  deleteAll(): Observable<Player> {
      return this.http.delete(baseUrl);
  }

  findByPlayerName(name): Observable<Player> {
      return this.http.get(`${baseUrl}?name=${name}`);
  }

}