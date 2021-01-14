import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { TournamentRound } from '../models/tournament-round';

const baseUrl = 'http://localhost:8080/api//tournament-rounds';

@Injectable({
  providedIn: 'root'
})
export class TournamentRoundService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<TournamentRound> {
    return this.http.get(baseUrl);
  }

  get(id): Observable<TournamentRound> {
    return this.http.get(`${baseUrl}/${id}`);
  }

  create(data): Observable<TournamentRound> {
    return this.http.post(baseUrl, data);
  }

  update(data): Observable<TournamentRound> {
    return this.http.put(baseUrl, data);
  }

  delete(id): Observable<TournamentRound> {
    return this.http.delete(`${baseUrl}/${id}`);
  }

  deleteAll(): Observable<TournamentRound> {
    return this.http.delete(baseUrl);
  }

  findByName(name): Observable<TournamentRound> {
    return this.http.get(`${baseUrl}?title=${name}`);
  }
}