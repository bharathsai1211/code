import { Component, OnInit } from '@angular/core';
import { Country } from './model/Country';
import { TokenStorageService } from './services/token-storage.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
 
  isLoggedIn = false;
  username?: string;
  

  constructor(private tokenStorageService: TokenStorageService) { }

  ngOnInit(): void {
    this.isLoggedIn = !!this.tokenStorageService.getToken();

    if(this.isLoggedIn)
    {
      const email=localStorage.getItem('email');
      this.username=email;
    }


  }



  logout(): void {
    this.tokenStorageService.signOut();
    window.location.reload();
  }
}
