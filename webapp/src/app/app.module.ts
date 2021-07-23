import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FooterComponent } from './components/footer/footer.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { AuthserviceService } from './services/authservice.service';
import { HomeComponent } from './components/home/home.component';
import { NgxPaginationModule } from 'ngx-pagination';
import { HotspotsComponent } from './components/hotspots/hotspots.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HeaderComponent } from './components/header/header.component';
import { MatDialogModule } from '@angular/material/dialog';
import { AlertboxComponent } from './components/alertbox/alertbox.component';


@NgModule({
  declarations: [
    AppComponent,
    FooterComponent,
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    HotspotsComponent,
    HeaderComponent,
    AlertboxComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    NgxPaginationModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    MatDialogModule
  ],
  providers: [AuthserviceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
