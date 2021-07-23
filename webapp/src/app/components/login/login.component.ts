import { HttpErrorResponse } from '@angular/common/http';
import { Component, Injector, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthserviceService } from 'src/app/services/authservice.service';
import { TokenStorageService } from 'src/app/services/token-storage.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  form: any={};
  isLoggedIn = false;
  isLoginFailed = false;
  errorMessage = '';
  emails:string="";
  
  constructor(private injector:Injector, private tokenstorage: TokenStorageService, private router:Router) { }

  ngOnInit(): void {
    if(this.tokenstorage.getToken())
    {
      this.isLoggedIn = true;
    }
  }

  onSubmit(){
    const{ email, password } = this.form;
    this.injector.get(AuthserviceService).login(this.form).subscribe(
      data=> {
        console.log(data);
        this.tokenstorage.saveToken(data['token']);
        this.isLoginFailed=false;
        this.isLoggedIn=true;
        this.handleResponse(this.form.email);
        this.reloadPage();
      },
      err =>{
        this.errorMessage= err.error.message;
        this.isLoginFailed = true;
        
      }
    );
  }

  public handleResponse(email)
  {
    sessionStorage.setItem('email',email);
    this.emails=email;
  }

  reloadPage(): void{
    window.location.reload();
  }
}
