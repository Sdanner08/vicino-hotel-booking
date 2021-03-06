import { Injectable } from '@angular/core';
import {NgbDate} from '@ng-bootstrap/ng-bootstrap';

@Injectable({
  providedIn: 'root'
})
export class VariablesService {

  constructor() { }
  adultNum: number = 0;
  roomNum: number = 0;

  numOfNights: NgbDate;
  date: NgbDate;

  lat: number = 0;
  lng: number = 0;

  setAdultAndRoom(adult: number, room: number) {
    this.adultNum = adult;
    this.roomNum = room;
  }

  getAdultNum() : number{
    return this.adultNum;
  }

  getRoomNum() : number {
    return this.roomNum;
  }

  setDateAndDays(nights: NgbDate, date: NgbDate) {
    this.numOfNights = nights;
    this.date = date;
  }

  getNumOfNights() : NgbDate {
    return this.numOfNights;
  }

  getDate() : NgbDate {
    return this.date;
  }

  setLatAndLong(lat: number, lng: number) {
    this.lat = lat;
    this.lng = lng;
  }

  getLat() : number {
    return this.lat;
  }

  getLng() : number {
    return this.lng;
  }
}
