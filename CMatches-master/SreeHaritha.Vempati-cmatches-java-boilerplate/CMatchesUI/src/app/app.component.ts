
import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from './modules/authentication/authentication.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  loginStatus:boolean=true;
    title = 'CMatchesUI';
  constructor(private authService: AuthenticationService,
    private router: Router) { }
    ngOnInit() {
      if(this.authService.isTokenExpired()===true)
      { this.loginStatus=false;}

    }

logout() {
this.authService.deleteToken();
this.router.navigate(['/login']);
}

login(){
  this.router.navigate(['/login']);
}
}
