import { HttpErrorResponse } from '@angular/common/http';
import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { City } from './city';
import { TravelService } from './travel.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'UI';
  city!: City[];
  selectedCity!: string;
  weather!: string;
  description!: string;
  
  constructor (private travelService: TravelService){}

  // On initialize gets city data from backend, and sets description field and weather field.
  ngOnInit(){
    this.getCity();
    this.description = "Description of city";
    this.weather = "Weather of city";
  }
  
// updates the weather and description to match the city selected
updateWeatherAndDescription(){
  for (let i = 0; i < this.city.length; i++){
      if (JSON.stringify(this.city[i])===JSON.stringify(this.selectedCity)){
        this.description = "Description: " + this.city[i].description;
        this.weather = "Weather: " + this.city[i].weather;
      }
  }
}

// gets city from travel service/backend
  getCity():void{
    this.travelService.getCities().subscribe(
      (response: City[])=>{
        this.city = response;
      },
      (error: HttpErrorResponse) =>{
        console.log(error.message);
      }
    )
  }
}
