import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { HotelService } from 'src/app/services/hotel/hotel.service';
import { VariablesService } from 'src/app/services/variables/variables.service';

@Component({
  selector: 'app-room-form',
  templateUrl: './room-form.component.html',
  styleUrls: ['./room-form.component.css']
})
export class RoomFormComponent implements OnInit {

  @Input()
  public adultNum:number=0;
  public childNum:number=0;
  public roomNum:number=0;
  
  hotels:any = [];
  
  roomguestForm = this.fb.group({
    adult: [null],
    children: [null],
    rooms: [null]
  })
  constructor(private fb: FormBuilder, private variable: VariablesService, private hotelService: HotelService) { }

  ngOnInit(): void {
  }

  subtract(type: string){
    if(type == "adult"){
      if(this.adultNum == 0){
        this.adultNum == 0
      }else{
        this.adultNum -= 1;
      }
    }else if (type == "child"){
      if(this.childNum == 0){
        this.childNum == 0
      }else{
        this.childNum -= 1;
      }
    }else {
      if(this.roomNum == 0){
        this.roomNum == 0
      }else{
        this.roomNum -= 1;
      }
    }

    this.variable.setAdultAndRoom(this.adultNum, this.roomNum);
  }

  add(type: string){
    if(type == "adult"){
      this.adultNum += 1;
    }else if (type == "child"){
      this.childNum += 1;
    }else {
      this.roomNum += 1;
    }

    this.variable.setAdultAndRoom(this.adultNum, this.roomNum);
  }
  
  apply(){
    this.hotelService.getHotelInfo(12.91285,100.87808, this.variable.getAdultNum(), this.variable.getRoomNum(),
      this.variable.getDate().year.valueOf(), this.variable.getDate().month, this.variable.getDate().day, this.variable.getNumOfNights()).subscribe(data => {
      this.hotels = [];
      data.data.forEach(element => {
        this.hotels.push(element);
      });/* 
      console.log(data); */
    })
  }
}
