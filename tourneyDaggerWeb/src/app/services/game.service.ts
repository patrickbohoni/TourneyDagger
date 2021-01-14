import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Game } from '../models/game';


const baseUrl = 'http://localhost:8080/api/games';

@Injectable({
  providedIn: 'root'
})

export class GameService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<Game> {
      return this.http.get(baseUrl);
  }

  get(id): Observable<Game> {
      return this.http.get(`${baseUrl}/${id}`);
  }

  create(data): Observable<Game> {
      return this.http.post(baseUrl, data);
  }

  update(data): Observable<Game> {
      return this.http.put(baseUrl, data);
  
  }

  delete(id): Observable<Game> {
      return this.http.delete(`${baseUrl}/${id}`);
  }

  deleteAll(): Observable<Game> {
      return this.http.delete(baseUrl);
  }

  findById(id): Observable<Game> {
      return this.http.get(`${baseUrl}?name=${id}`);
  }

}
