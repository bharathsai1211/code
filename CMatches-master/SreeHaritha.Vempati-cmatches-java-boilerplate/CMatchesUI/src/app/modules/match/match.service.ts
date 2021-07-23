import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { match } from './match';
import {retry,map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class MatchService {
apiKey:string;
baseUrl:string;
addToFavouriteListEndPoint:string;
getFavouriteListEndPoint:string;

  constructor(private http:HttpClient) { 
    this.apiKey = '7JkL4rjpFZV5lKCPO1He4CpPTGL2';
    this.addToFavouriteListEndPoint='http://localhost:5612/api/v1/favouriteservice/match';
    this.getFavouriteListEndPoint='http://localhost:5612/api/v1/favouriteservice/match';
    this.baseUrl="http://localhost:5612/api/v1/favouriteservice/";

  }
  getUpcomingMatches(): Observable<any> {
    return this.http.get('http://cricapi.com/api/matches?apikey=' + this.apiKey);
  }
  getPreviousMatchs(): Observable<any> {
    return this.http.get('http://cricapi.com/api/cricket?apikey=' + this.apiKey);
  }
  getMatchScore(matchId): Observable<any> {
    return this.http.get('http://cricapi.com/api/cricketScore?apikey=' + this.apiKey + '&unique_id=' + matchId)
  }
  getMatchCalendar(): Observable<any>{
    return this.http.get('http://cricapi.com/api/matchCalendar?apikey=' + this.apiKey);
  }

  getMatches():Observable<Array<match>>{
    const endPoint='http://cricapi.com/api/matches?apikey=' + this.apiKey;
    return this.http.get(endPoint).pipe(
      retry(3),
      map(this.pickMatchResults),
     
    );
  }
  
pickMatchResults(response){
  return response['matches'];
}

addToFavouriteList(match){
  console.log(match);
  return this.http.post(this.baseUrl+'match',match);
}

getFavouriteList():Observable<Array<match>>{
  return this.http.get<Array<match>>(`${this.getFavouriteListEndPoint}`);
}

deleteMatchFromFavouriteList(match){
  const deUrl=`${this.addToFavouriteListEndPoint}/${match.id}`;
  return this.http.delete(deUrl,{responseType:'text'});
}



}
