import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError, toArray } from 'rxjs/operators';
import { Country } from '../model/Country';

@Injectable({
  providedIn: 'root'
})
export class HotspotServiceService {

  
  constructor(private http:HttpClient) { }

  // search method to get the search country typed by the user from the search service 

  search(country):Observable<any>
  {
    return this.http.get<any>(`http://localhost:8081/countries/${country}`).pipe(toArray<Country>()).pipe(catchError(error=>{
      return throwError(error.message)
    }));
  }

  //method to get all country details from the eternal api using the search service


  public displayAll():Observable<any>
  {
    return this.http.get<Country[]>("http://localhost:8081/countriess");
  }

  token:string=sessionStorage.getItem("auth-token")
  email:string=sessionStorage.getItem("email");
  emailstring:string="email="+this.email;


  //method to add a selected country to the hotspot with the help of country id , saved in momgodb
  
  public addToHotspot(favList):Observable<any>
  {
    const headers = {'authorization': 'Bearer '+this.token};
    const body = {"email": this.email,"countries":[
      {
        "id":favList.countrydata._id,
        "country":favList.country,
        "continent":favList.continent,
        "flag":favList.countrydata.flag,
        "cases":favList.cases,
        "deaths":favList.deaths,
        "recovered":favList.recovered,
        "active":favList.active

      }
    ]};
    return this.http.post("http://localhost:8082/api/v1/addhotspot",body,{headers}).pipe(catchError(error=>{
      return throwError(error.message)
    }));
  }

//method to get the details of hotspot countries for a particular user

  public getAllHotspots():Observable<any>
  {
    const headers = {'authorization': 'Bearer '+this.token};
    return this.http.get(`http://localhost:8082/api/v1/hotspots?${this.emailstring}`,{headers}).pipe(catchError(error=>{
      return throwError(error.message)
    }));
  }

  //method to delete country details form the hotspot list with the help of id

  public deleteHotspot(countryId):Observable<any>{
    const headers = {'authorization': 'Bearer '+this.token};
    return this.http.delete(`http://localhost:8082/api/v1/deletehotspot?${this.emailstring}&id=${countryId}`,{headers}).pipe(catchError(error=>{
      return throwError(error.message)
    }));
  }
}
