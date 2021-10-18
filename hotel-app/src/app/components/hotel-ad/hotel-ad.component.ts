import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { HotelService } from 'src/app/services/hotel/hotel.service';

@Component({
  selector: 'app-hotel-ad',
  templateUrl: './hotel-ad.component.html',
  styleUrls: ['./hotel-ad.component.css']
})
export class HotelAdComponent implements OnInit {

  hotelList: Array<any> = [];
  observer: Subscription = new Subscription;
  latitude: number;
  longitude: number;
  adults: number;
  numOfRooms: number;



  constructor(private hotelServ: HotelService) { }

  ngOnInit(): void {
   
  }

}
