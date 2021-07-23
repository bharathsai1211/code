import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpParams } from '@angular/common/http';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class CricapiService {
// dependency injection of HttpClient service
constructor(private http: HttpClient) { }

// generated Api key from cricapi
apikey: string = "dLGeON2q1aTVihU2hxeInpYKUNM2";

// Get method to search players with the help of Player Name
searchPlayer(name: string): Observable<any> {
  return this.http.get(`https://cricapi.com/api/playerFinder?apikey=${this.apikey}`, {
    params: new HttpParams().set("name", name)
  });
}
// Get method to get the statistics of a particular player with the help of his pid
statsPlayer(pid: number): Observable<any> {
  return this.http.get(`https://cricapi.com/api/playerStats?apikey=${this.apikey}`, {
    params: new HttpParams().set("pid", pid.toString())
  })
}
}