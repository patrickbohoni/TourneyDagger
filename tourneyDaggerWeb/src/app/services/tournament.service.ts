import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Tournament } from '../models/tournament';

const baseUrl = 'http://localhost:4200/api/tournament';

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

    update(id, data): Observable<Tournament> {
        return this.http.put(`${baseUrl}/${id}`, data);
    
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

