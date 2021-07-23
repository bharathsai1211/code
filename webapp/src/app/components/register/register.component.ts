
import { Component, Injector, OnInit } from '@angular/core';
import { AuthserviceService } from 'src/app/services/authservice.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  form: any={} ;
  isSuccessful = false;
  isSignUpFailed = false;
  errorMessage ='';

  constructor(private injector:Injector) { }

  message:any;
  ngOnInit(): void {
  }

  onSubmit(): void {
    const {email, password} = this.form;
    console.log(this.form);

    this.injector.get(AuthserviceService).register(this.form).subscribe(
      data=> {
        //console.log(data);
        this.isSuccessful = true;
        this.isSignUpFailed = false;
      },
      err=> {
        this.errorMessage = err.console.error.message;
        this.isSignUpFailed = true;
      }
    );
  }

}
