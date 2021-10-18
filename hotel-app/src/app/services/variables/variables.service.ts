import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class VariablesService {

  constructor() { }
  adultNum: number = 0;
  roomNum: number = 0;

  numOfNights: number = 1;
  date: number = 0;

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

  setDateAndDays(nights: number, date: number) {
    this.numOfNights = nights;
    this.date = date;
  }

  getNumOfNights() : number {
    return this.numOfNights;
  }

  getDate() : number {
    return this.date;
  }
}
