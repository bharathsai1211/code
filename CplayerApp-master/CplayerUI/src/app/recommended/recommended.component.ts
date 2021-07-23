import { Component, OnInit } from '@angular/core';
import {RecommmendedService} from '../recommmended.service';
import { RouterService} from '../router.service';

@Component({
  selector: 'app-recommended',
  templateUrl: './recommended.component.html',
  styleUrls: ['./recommended.component.css']
})
export class RecommendedComponent implements OnInit {

  list: Array<any>;

  constructor(private recomser: RecommmendedService, private route: RouterService) { }

  // get all the recommended data from our DB
  ngOnInit(): void {

    if (sessionStorage.getItem('token') == null || sessionStorage.getItem('username') == null) {
      this.route.tologin();
    }

    this.recomser.getData(sessionStorage.getItem('token')).subscribe(
      res => this.list = res
    )
  }
}
