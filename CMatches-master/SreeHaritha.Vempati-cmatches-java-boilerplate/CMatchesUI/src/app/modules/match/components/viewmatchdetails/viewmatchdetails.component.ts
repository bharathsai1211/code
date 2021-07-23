import { Component, OnInit, Inject } from '@angular/core';
import { MatSnackBar, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { match } from '../../match';
import { MatchService } from '../../match.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'match-viewmatchdetails',
  templateUrl: './viewmatchdetails.component.html',
  styleUrls: ['./viewmatchdetails.component.css']
})
export class ViewmatchdetailsComponent implements OnInit {

  viewDetails:any;
  constructor(public snackbar:MatSnackBar,
  public dialogRef:MatDialogRef<ViewmatchdetailsComponent>,@Inject(MAT_DIALOG_DATA)
  public data:any,private cricketService:MatchService,private route:ActivatedRoute) {
    console.log(this.route);

    

   }

   ngOnInit() {

   
 console.log(this.data['obj']);
     
    this.viewDetails=this.data['obj'];
   
  }

   onNoClick(){
    this.dialogRef.close();
  }
  
 

}
