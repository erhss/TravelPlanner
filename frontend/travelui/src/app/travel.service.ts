import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { City } from './city';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class TravelService {

  private apiAddr = environment.apiAddr;
  constructor(private http: HttpClient) {}

  public getCities(): Observable<City[]>{
    return this.http.get<City[]>(`${this.apiAddr}/api/v1/all`)
  }
}
