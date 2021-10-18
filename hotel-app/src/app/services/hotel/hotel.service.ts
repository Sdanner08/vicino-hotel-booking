import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HotelService {

  constructor(private httpCli: HttpClient) { }

  getLocation(cityName: String) {
    return this.httpCli.get<any>(`http://localhost:9090/location/${cityName}`, {withCredentials: true});
  }

  getHotelInfo(latitude: number, longitude: number, adults: number, numOfRooms: number, numOfNights: number, checkinYear: number, checkinMonth: number, checkinDay: number) : Observable<any> {
    return this.httpCli.post<any>(`http://localhost:9090/booking`, {
      latitude: latitude,
      longitude: longitude,
      adults: adults,
      numOfRooms: numOfRooms,
      numOfNights: numOfNights,
      checkinYear: checkinYear,
      checkinMonth: checkinMonth,
      checkinDay: checkinDay
    }, {withCredentials: true})
  }
  // getHotelInfo(latitude: number, longitude: number, adults: number, numOfRooms: number, numOfNights: number, checkinYear: number, checkinMonth: number, checkinDay: number) {
  //   return this.httpCli.post<any>(`http://localhost:9090/booking`, {
  //     latitude: latitude,
  //     longitude: longitude
  //   }, {withCredentials: true})
  // }
}
