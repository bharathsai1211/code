import { Component, OnInit } from '@angular/core';
import { TokenStorageService } from 'src/app/services/token-storage.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private tokenStorageService: TokenStorageService) { }

  isLoggedIn = false;
  username?: string;

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
