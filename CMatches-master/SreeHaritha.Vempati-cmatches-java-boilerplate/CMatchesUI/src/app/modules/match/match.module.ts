import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { MatCardModule, MatButtonModule, MatSnackBarModule, MatDialogModule, MatInputModule, MatDividerModule, MatListItem, MatListModule } from '@angular/material';
import { FormsModule } from '@angular/forms';
import { MatchService } from './match.service';
import { InterceptorService } from './interceptor.service';
import { MatchRouterModule } from './match-router.module';
import { ViewscoreComponent } from './components/viewscore/viewscore.component';
import { MatchcalendarComponent } from './components/matchcalendar/matchcalendar.component';

import { PreviousmatchesComponent } from './components/previousmatches/previousmatches.component';
import { UpcomingComponent } from './components/upcoming/upcoming.component';
import { ViewmatchdetailsComponent } from './components/viewmatchdetails/viewmatchdetails.component';
import { FavouriteComponent } from './components/favourite/favourite.component';


@NgModule({
  declarations: [
   
    ViewscoreComponent,
    MatchcalendarComponent,
    PreviousmatchesComponent,
    UpcomingComponent,
    ViewmatchdetailsComponent,
    FavouriteComponent 
        ],
  imports: [
   
    CommonModule,
    HttpClientModule,
    MatDividerModule,
    MatListModule,
    MatCardModule,
    MatButtonModule,
    MatSnackBarModule,
    MatInputModule,
    MatDialogModule,
    FormsModule,
    MatchRouterModule
    
  ],
   entryComponents:[ViewscoreComponent,ViewmatchdetailsComponent],

  exports:[
   MatchRouterModule,
    PreviousmatchesComponent,ViewmatchdetailsComponent,UpcomingComponent,FavouriteComponent,
    ViewscoreComponent,
    MatchcalendarComponent,
    PreviousmatchesComponent,
    UpcomingComponent,
    ViewmatchdetailsComponent,
    FavouriteComponent 
  ],

providers:
[MatchService,{
    provide: HTTP_INTERCEPTORS,
    useClass: InterceptorService,
    multi: true //multi means multi requests which we are making to be true
  }],
})
export class MatchModule {
  
 }
