import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';



const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'}),
  responseType:'text' as 'json'
};
@Injectable({
  providedIn: 'root'
})
export class AuthserviceService {
  

  constructor(private http:HttpClient) { }

  login(data):Observable<any>
  {
   return this.http.post("http://localhost:8080/api/v1/login",data);
  }

  register(data):Observable<any>
  {
    console.log(data);
    return this.http.post("http://localhost:8080/api/v1/user",data, httpOptions);
  }
}
