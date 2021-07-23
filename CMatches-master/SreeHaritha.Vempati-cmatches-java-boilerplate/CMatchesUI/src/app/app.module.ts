import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AuthenticationModule } from './modules/authentication/authentication.module';

import { FormsModule } from '@angular/forms';
import { MatButtonModule, MatToolbarModule, MatInputModule, MatDialogModule, MatFormFieldModule, MatCheckboxModule, MatNavList, MatIconModule, MatSidenavModule, MatListModule } from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuardService } from './auth-guard.service';
import { MatchModule } from './modules/match/match.module';
import { FlexLayoutModule } from "@angular/flex-layout";

const appRoutes: Routes=[
  {
    path:'',
    redirectTo:'/login',
    pathMatch:'full'
  }
]
@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    AuthenticationModule,
   MatIconModule,
   MatToolbarModule,
    MatSidenavModule,
    MatListModule,
    MatIconModule,
    MatButtonModule,
    FlexLayoutModule,
    MatchModule,
    FlexLayoutModule,
    FormsModule,
    MatButtonModule,
    BrowserModule,
    MatToolbarModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule,
    MatInputModule,
    MatCheckboxModule,
    MatToolbarModule,
    MatDialogModule,
    MatButtonModule,
   MatFormFieldModule,
  
    MatInputModule,
    RouterModule.forRoot(appRoutes),
  ],
  providers: [AuthGuardService],
  bootstrap: [AppComponent]
})
export class AppModule {

  
 }
