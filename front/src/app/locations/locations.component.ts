import { Component, OnInit } from '@angular/core';
import { LocationsService } from '../services/locations.service';
import { Location } from '../services/location';

@Component({
  selector: 'app-locations',
  templateUrl: './locations.component.html',
  styleUrls: ['./locations.component.css']
})
export class LocationsComponent implements OnInit { 
  location: Location=new Location;
  submitted = false;
  constructor(private locationService: LocationsService) { }
 
  ngOnInit() {
  }
 newLocation(): void {
    this.submitted = false;
    this.location = new Location();
  }
 
  save() {
    this.locationService.createLocation(this.location)
      .subscribe(data => console.log(data), error => console.log(error));
    this.location = new Location();
  }
 
  onSubmit() {
    this.submitted = true;
    this.save();
  }
  
}
