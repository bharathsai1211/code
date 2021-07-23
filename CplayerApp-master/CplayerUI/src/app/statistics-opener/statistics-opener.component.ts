import { Component, OnInit } from '@angular/core';
import { StatisticsviewComponent } from 'src/app/statisticsview/statisticsview.component';
import { RouterService } from 'src/app/router.service';
import { MatDialog } from '@angular/material/dialog';
import { ActivatedRoute } from '@angular/router';
@Component({
  selector: 'app-stat-opener',
  templateUrl: './statistics-opener.component.html',
  styleUrls: ['./statistics-opener.component.css']
})
export class StatisticsOpenerComponent implements OnInit {

  // dependency injection of MatDialogue to specify the component as a dialogue
  constructor(private dialogue: MatDialog, private route: RouterService, private actiRoute: ActivatedRoute) {
    const id = +this.actiRoute.snapshot.paramMap.get('pid');

    // Open the stat view component in the dialogue and give pid with it
    this.dialogue.open(StatisticsviewComponent, {
      data: {
        pid: id
      }
    }).afterClosed().subscribe(
      result => {
        this.route.back();
      }
    )
  }

  ngOnInit(): void {

    if (sessionStorage.getItem('token') == null || sessionStorage.getItem('username') == null) {
      this.route.tologin();
    }

  }

}
