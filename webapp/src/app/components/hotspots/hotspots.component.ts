import { Component, OnInit } from '@angular/core';
import { Country } from 'src/app/model/Country';
import { HotspotServiceService } from 'src/app/services/hotspot-service.service';

@Component({
  selector: 'app-hotspots',
  templateUrl: './hotspots.component.html',
  styleUrls: ['./hotspots.component.css']
})
export class HotspotsComponent implements OnInit {

  constructor(private hotspotservice:HotspotServiceService) { }

  countrys:Country;
  p:number=1;
  isEmpty:boolean=true;

  ngOnInit(): void {
    this.hotspotservice.getAllHotspots().subscribe(data=>{console.log(data);
    this.countrys=data;
    if(this.countrys.countries.length>0)
    this.isEmpty=false;
  console.log(this.countrys)});
  }

  deleteCountry(countryId)
  {
      this.hotspotservice.deleteHotspot(countryId).subscribe(data=>{console.log(data);
      this.ngOnInit();})

  }

 


}
