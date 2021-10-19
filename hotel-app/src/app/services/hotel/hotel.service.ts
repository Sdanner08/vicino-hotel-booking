import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { NgbDate } from '@ng-bootstrap/ng-bootstrap';

@Injectable({
  providedIn: 'root'
})
export class HotelService {
  numOfNights:number;
  constructor(private httpCli: HttpClient) { }

  getLocation(cityName: String) {
    return this.httpCli.get<any>(`http://localhost:9090/location/${cityName}`, {withCredentials: true});
  }

  // getHotelInfo(latitude: number, longitude: number, adults: number, numOfRooms: number, checkinYear: number, checkinMonth: number, checkinDay: number, toDate: NgbDate) : Observable<any> {
    
  //   if (toDate != null)
  //     this.numOfNights = Math.floor(Date.UTC(checkinYear, checkinMonth, checkinDay) - Date.UTC(toDate.year, toDate.month, toDate.day))  / (1000 * 60 * 60 * 24);
  //   else 
  //     this.numOfNights = 1;
  //   console.log(this.numOfNights);
  //   adults = 1;
  //   numOfRooms = 1;
  //   console.log(checkinMonth)
  //   return this.httpCli.post<any>(`http://localhost:9090/booking`, {
  //     latitude: latitude,
  //     longitude: longitude,
  //     adults: adults,
  //     numOfRooms: numOfRooms,
  //     numOfNights: this.numOfNights,
  //     checkinYear: checkinYear,
  //     checkinMonth: checkinMonth,
  //     checkinDay: checkinDay
  //   }, {withCredentials: true})
  // }
  getHotelInfo(latitude: number, longitude: number, adults: number, numOfRooms: number, checkinYear: number, checkinMonth: number, checkinDay: number, toDate: NgbDate) : Observable<any> {
    return this.httpCli.post<any>(`http://localhost:9090/booking/s`, {
      latitude: latitude,
      longitude: longitude
    }, {withCredentials: true})
  }
}
