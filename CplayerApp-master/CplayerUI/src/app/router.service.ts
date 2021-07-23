import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Location } from '@angular/common';

@Injectable({
  providedIn: 'root'
})
export class RouterService {
   //dependency injection of Router and Location services
  constructor(private router: Router, private location: Location) { }

  //method to go to login form
  tologin(){
    this.router.navigate(["/login"])
  }
  
  //method to go to signup form 
  tosignup(){
    this.router.navigate(["/signup"])
  }
  
  //method to load the dashboard component
  todashboard(){
    this.router.navigate(["/dashboard"])
  }

  //method to load the favourites component
  tofav(){
    this.router.navigate(["/favs"])
  }

  // method to navigate to statistics-opener with the player pid whose statistics are to be shown
  tostatOpener(pid){
    this.router.navigate(['/dashboard',{
      outlets:{
        statOpener:['statOpener',pid,'view']
      }
    }])
  }

  back(){
    this.location.back();
  }
}
