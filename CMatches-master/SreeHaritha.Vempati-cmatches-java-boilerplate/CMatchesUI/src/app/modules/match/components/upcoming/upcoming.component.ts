import { Component, OnInit } from '@angular/core';
import { MatchService } from '../../match.service';
import { ActivatedRoute } from '@angular/router';
import { MatSnackBar, MatDialog } from '@angular/material';
import { ViewmatchdetailsComponent } from '../viewmatchdetails/viewmatchdetails.component';

@Component({
  selector: 'match-upcoming',
  templateUrl: './upcoming.component.html',
  styleUrls: ['./upcoming.component.css']
})
export class UpcomingComponent implements OnInit {
  upcomingMatches:Array<any>;
  constructor(private matchService:MatchService,private route:ActivatedRoute,private snackBar:MatSnackBar,public dialog: MatDialog) 
  {
    console.log(this.route);
    this.upcomingMatches=[];
   }
  
  ngOnInit() {
    this.matchService.getUpcomingMatches().subscribe((matches)=>{
      console.log("upcoming matches")
      this.upcomingMatches = matches['matches'];
      console.log(matches);
    });

  }

  addToFavouriteList(match){
    console.log("match added");

       this.matchService.addToFavouriteList(match).subscribe((match)=>{
this.snackBar.open('Match added To List','',{
duration:1000
});
         });

  }

  viewDetails(match){
    console.log("match details card");
    console.log(match);
    const dialogRef = this.dialog.open(ViewmatchdetailsComponent, {
      width: '80%',
      data: {obj:match}
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
    });
}

  



}
