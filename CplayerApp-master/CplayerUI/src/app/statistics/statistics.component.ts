import { Component, OnInit } from '@angular/core';
import { Find } from '../find';
import { CricapiService } from '../cricapi.service';
import { RouterService } from '../router.service';

@Component({
  selector: 'app-stats',
  templateUrl: './statistics.component.html',
  styleUrls: ['./statistics.component.css']
})
export class StatisticsComponent implements OnInit {
  config: any;
  val: string;
  list: Array<Find> = [];

  constructor(private cricapi: CricapiService, private route: RouterService) {
    //pagination
    this.val = "";
    this.config = {
      itemsPerPage: 10,
      currentPage: 1,
      totalItems: this.list.length
    };

  }

  // note if the page is changed
  pageChanged(event) {
    this.config.currentPage = event;
  }
  ngOnInit() {

    if (sessionStorage.getItem('token') == null || sessionStorage.getItem('username') == null) {
      this.route.tologin();
    }

  }
  // this method will search player by his name as privided in val
  getData(val) {
    this.cricapi.searchPlayer(val).subscribe(
      res => {
        this.list = res.data;
        for (let obj of this.list) {
          obj.status = true;
        }
      },
      err => {
        console.log(err +"something wrong while fectching palyer data...")
      })
  }

  // this method will redirect to stat Opener component by taking player id (pid) with it
  viewStats(data){
    this.route.tostatOpener(data.pid);
  }

}
