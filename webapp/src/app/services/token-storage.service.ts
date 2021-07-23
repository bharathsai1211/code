import { Injectable } from '@angular/core';

export const TOKEN_KEY:string = 'auth-token';

@Injectable({
  providedIn: 'root'
})
export class TokenStorageService {

  constructor() { }

  //clears all token and user details saved in the session storage

  signOut(): void{
    window.sessionStorage.clear();
    localStorage.clear();
  }

  //used to save token generated on sucessful login to session storage

  saveToken(token: string){
    window.sessionStorage.setItem(TOKEN_KEY, token);
  }

  public getToken(): string | null {
    return window.sessionStorage.getItem(TOKEN_KEY);
  }

  public isUserLoggedIn(): String
  {
    return this.getToken();
  }

  //checks if the user is logged in

  isAuthenticated(){
    if(this.getToken()){
      return true;
    }
    else{
      return false;
    }
  }
}
