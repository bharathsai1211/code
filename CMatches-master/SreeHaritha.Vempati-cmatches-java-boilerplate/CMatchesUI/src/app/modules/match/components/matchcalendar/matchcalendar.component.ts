import { Component, OnInit } from '@angular/core';
import { MatchService } from '../../match.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'match-matchcalendar',
  templateUrl: './matchcalendar.component.html',
  styleUrls: ['./matchcalendar.component.css']
})
export class MatchcalendarComponent implements OnInit {
  matchescalendar:Array<any>
  constructor(private matchService:MatchService,private route:ActivatedRoute) { 
    console.log(this.route);
    this.matchescalendar=[];
  }

  ngOnInit() {
    this.matchService.getMatchCalendar().subscribe((matches)=>{
      console.log("match calendar matches")
      this.matchescalendar = matches['data'];
      console.log(matches);


    });
  }

}
