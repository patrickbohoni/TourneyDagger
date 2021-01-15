import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Tournament } from '../models/tournament';

const baseUrl = 'http://localhost:8080/api/tournaments';
const generatorUrl = 'http://localhost:8080/api/tournaments/round-generator';
const rosterUrl = 'http://localhost:8080/api/tournaments/tournament-roster';

@Injectable({
    providedIn: 'root'
})
export class TournamentService {

    constructor(private http: HttpClient) { }

    getAll(): Observable<Tournament> {
        return this.http.get(baseUrl);
    }

    get(id): Observable<Tournament> {
        return this.http.get(`${baseUrl}/${id}`);
    }

    create(data): Observable<Tournament> {
        return this.http.post(baseUrl, data);
    }

    update(data): Observable<Tournament> {
        return this.http.put(baseUrl, data);
    
    }

    createPlayerRoster(data): Observable<Tournament> {
        return this.http.put(rosterUrl, data)
    }

    generateRound(data): Observable<Tournament> {
        return this.http.put(generatorUrl, data)
    }


    delete(id): Observable<Tournament> {
        return this.http.delete(`${baseUrl}/${id}`);
    }

    deleteAll(): Observable<Tournament> {
        return this.http.delete(baseUrl);
    }

    findByName(name): Observable<Tournament> {
        return this.http.get(`${baseUrl}?name=${name}`);
    }

}

