import { Component, OnInit } from '@angular/core';
import { MatchService } from '../../match.service';
import { MatSnackBar } from '@angular/material';
import { match } from '../../match';

@Component({
  selector: 'match-favourite',
  templateUrl: './favourite.component.html',
  styleUrls: ['./favourite.component.css']
})
export class FavouriteComponent implements OnInit {

  matches:Array<match>;
  useFavouriteListApi:boolean=true;
  constructor(private matchService:MatchService,private snackbar:MatSnackBar) {
    this.matches=[];
   }

  ngOnInit() {

    this.matchService.getFavouriteList().subscribe((matches)=>{
      if(matches.length==0){
        this.snackbar.open('My favourites list is empty','',{
          duration:1000
        });
      }

      this.matches=matches;
      console.log(matches);
    })
  }

  

  deleteFromFavouriteList(match){
    this.matchService.deleteMatchFromFavouriteList(match).subscribe((result)=>{
      let message=`${match.name} ${result}`;
      this.snackbar.open("Match deleted successfully",'',{
        duration:1000
      });
      const index =this.matches.indexOf(match);
      this.matches.splice(index,1);

    });
  }


  }


