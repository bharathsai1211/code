import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { MatchService } from '../../match.service';
import { MatSnackBar, MatDialog } from '@angular/material';
import { ViewscoreComponent } from '../viewscore/viewscore.component';

@Component({
  selector: 'match-previousmatches',
  templateUrl: './previousmatches.component.html',
  styleUrls: ['./previousmatches.component.css']
})
export class PreviousmatchesComponent implements OnInit {
  previousMatches:Array<any>;
  constructor(private matchService:MatchService,private route:ActivatedRoute,private snackBar:MatSnackBar,public dialog: MatDialog) {
    console.log(this.route);
    this.previousMatches=[];
 
   }

  ngOnInit() {
    this.matchService.getPreviousMatchs().subscribe((matches)=>{
      console.log("match calendar matches")
      this.previousMatches = matches['data'];
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

    viewScore(match){
      console.log("score card");
      
      const dialogRef = this.dialog.open(ViewscoreComponent, {
        width: '80%',
        data: {obj:match}
      });
 
      dialogRef.afterClosed().subscribe(result => {
        console.log('The dialog was closed');
      });
  }

    }


