import { Component, OnInit,Inject } from '@angular/core';
import { Find } from '../find';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { CricapiService } from '../cricapi.service';
import { RouterService } from '../router.service';
import {StatisticsOpenerComponent} from '../statistics-opener/statistics-opener.component'

@Component({
  selector: 'app-statview',
  templateUrl: './statisticsview.component.html',
  styleUrls: ['./statisticsview.component.css']
})
export class StatisticsviewComponent implements OnInit {
  stat :any;


  // dependency injection of cricapi service and also using @Inject to specify that some the value is injected
  constructor(private diaRef: MatDialogRef<StatisticsOpenerComponent>, @Inject(MAT_DIALOG_DATA) private data: any,
   private cric: CricapiService, private route :RouterService) { }

  ngOnInit(): void {

    if (sessionStorage.getItem('token') == null || sessionStorage.getItem('username') == null) {
      this.route.tologin();
    }
    // call api to get all the stats of a particular player by his pid
    this.cric.statsPlayer(this.data.pid).subscribe(
      res => {
        this.stat = res
      },
      err => console.log(err)
    )
  }

}
