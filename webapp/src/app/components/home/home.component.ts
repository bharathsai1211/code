import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { Country } from 'src/app/model/Country';
import { HotspotServiceService } from 'src/app/services/hotspot-service.service';
import { TokenStorageService } from 'src/app/services/token-storage.service';
import { AlertboxComponent } from '../alertbox/alertbox.component';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  

  constructor(private dialog:MatDialog, private changedetector:ChangeDetectorRef , private fb:FormBuilder , private hotspotService:HotspotServiceService, private tokenStorage:TokenStorageService, private router:Router) { }

  countrys:Country[]=[];
  hasContent:boolean=false;
  searchEmpty:boolean=false;
  invertColor:boolean[]=[];
  errormsg:string="";
  displaywelcome:boolean=false;
  username:string="";

  p:number=1;
  form= this.fb.group({
    availableunits:[]
  })

  ngOnInit(): void {
    this.hotspotService.displayAll().subscribe(data=>{this.countrys=data;
      if(this.countrys.length>0)
      this.hasContent=true;
      if(this.tokenStorage.isUserLoggedIn())
      {
        this.displaywelcome=true;
        this.username=sessionStorage.getItem("email");
      }
      console.log(data);})
  }

  onSubmit()
  {
    console.log(this.form.value['availableunits']);
    if(this.form.value['availableunits']== null)
    {
        this.searchEmpty=true;
        this.triggerAlert("Search Field Shoould Not be Empty!!. Please Enter a valid Country name");
    }
    else
    {
      this.hotspotService.search(this.form.value['availableunits']).subscribe(
        data=>{
          this.countrys=data;
          this.changedetector.detectChanges();
          console.log(data);
          console.log(this.countrys);
          if(this.countrys.length==0)
          {
            
            this.ngOnInit();
          }
        },(err)=>{this.errormsg=err;
          this.triggerAlert("Please Enter a valid Country Name");
        }
      )
    }
  }

  addCountry(data)
  {
    if(this.tokenStorage.isUserLoggedIn())
    {
      this.hotspotService.addToHotspot(data).subscribe(dat=>{console.log(dat);
        this.invertColor[data.countrydata._id]=!this.invertColor[data.countrydata._id];
        this.triggerAlert("Country Added")}
        ,(err)=>{this.errormsg=err;
          this.triggerAlert("Country already Exists in hotspot");}
        );
    }
    else
    {
      this.triggerAlert("Please Login To Access This Feature")
      this.router.navigate(['/login']);
    }
    
  }

  triggerAlert(message)
  {
    const dialogRef = this.dialog.open(AlertboxComponent,
      {
        width:"500px",
        data:message,
        panelClass:"modalbox"
      });
      dialogRef.afterClosed().subscribe(data=>{})
  }

}
