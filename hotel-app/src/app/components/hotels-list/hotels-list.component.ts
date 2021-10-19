import { Component, OnInit } from '@angular/core';
import { HotelService } from 'src/app/services/hotel/hotel.service';
import { VariablesService } from 'src/app/services/variables/variables.service';

@Component({
  selector: 'app-hotels-list',
  templateUrl: './hotels-list.component.html',
  styleUrls: ['./hotels-list.component.css']
})
export class HotelsListComponent implements OnInit {

  hotels: any = [];
  hotelId:number;

  constructor(private hotelService: HotelService,
    private variable: VariablesService) { }

  ngOnInit(): void {
    //12.91285
    //100.87808
    console.log(this.variable.getLat())
    console.log("Hello")
    this.hotelService.getHotelInfo(this.variable.getLat(), this.variable.getLng(), this.variable.getAdultNum(), this.variable.getRoomNum(),
      this.variable.getDate().year.valueOf(), this.variable.getDate().month, this.variable.getDate().day, this.variable.getNumOfNights()).subscribe(data => {
        console.log(data)
      this.hotels = [];
      data.data.forEach(element => {
        this.hotels.push(element);
      });
    })
  }

  refresh() {
    console.log(this.variable.getLat())
    console.log("Hello")
    this.hotelService.getHotelInfo(this.variable.getLat(), this.variable.getLng(), this.variable.getAdultNum(), this.variable.getRoomNum(),
      this.variable.getDate().year.valueOf(), this.variable.getDate().month, this.variable.getDate().day, this.variable.getNumOfNights()).subscribe(data => {
        console.log(data)
      this.hotels = [];
      data.data.forEach(element => {
        this.hotels.push(element);
      });
    })
  }

}
