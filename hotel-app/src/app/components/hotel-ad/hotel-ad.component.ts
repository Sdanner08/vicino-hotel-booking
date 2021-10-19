import { Component, Input, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { HotelService } from 'src/app/services/hotel/hotel.service';

@Component({
  selector: 'app-hotel-ad',
  templateUrl: './hotel-ad.component.html',
  styleUrls: ['./hotel-ad.component.css']
})
export class HotelAdComponent implements OnInit {

  @Input()
  hotel: any = {
    /* Location_id: 0,
    name: "",
    num_reviews: "",
    photo : {images: {small:{ url: ""}}},
    rating: "",
    ranking */
  }

  hotelList: Array<any> = [];
  observer: Subscription = new Subscription;
  latitude: number;
  longitude: number;
  adults: number;
  numOfRooms: number;
  _has: boolean = true;


  constructor(private hotelServ: HotelService) { }

  ngOnInit(): void {
    console.log(this.hotel)
    if (this.hotel.ad_position != null) {
      this._has = false;
      console.log("is true")
    } else {
      this._has = true;
      console.log("is true")
    }
  }

  book(){
    window.location.href= this.hotel.hac_offers.offers[0].link;
  }
}
