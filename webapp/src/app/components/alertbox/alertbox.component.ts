import { Component, Inject, OnInit } from '@angular/core';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-alertbox',
  templateUrl: './alertbox.component.html',
  styleUrls: ['./alertbox.component.css']
})
export class AlertboxComponent implements OnInit {

  constructor(private dialog: MatDialog, public dialogRef: MatDialogRef<AlertboxComponent>,
    @Inject(MAT_DIALOG_DATA) public message:any) { }

  ngOnInit(): void {
    setTimeout(()=>{
      this.dialogRef.close();

    },2000)
  }

  onNoClick():void{
    this.dialogRef.close();
  }
  

}
