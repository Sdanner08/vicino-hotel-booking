import { Component, OnInit } from '@angular/core';
import { HotelService } from 'src/app/services//hotel/hotel.service';

@Component({
  selector: 'app-location-input',
  templateUrl: './location-input.component.html',
  styleUrls: ['./location-input.component.css']
})
export class LocationInputComponent implements OnInit {

  constructor(private hotelService: HotelService) { }

  ngOnInit(): void {
  }

  findHotels() {
    this.hotelService.getHotelInfo
  }

}
