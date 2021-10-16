import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-room-form',
  templateUrl: './room-form.component.html',
  styleUrls: ['./room-form.component.css']
})
export class RoomFormComponent implements OnInit {

  @Input()
  adultNum:number=0;
  childNum:number=0;
  roomNum:number=0;
  
  
  roomguestForm = this.fb.group({
    adult: [null],
    children: [null],
    rooms: [null]
  })
  constructor(private fb: FormBuilder) { }

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
  }

  add(type: string){
    if(type == "adult"){
      this.adultNum += 1;
    }else if (type == "child"){
      this.childNum += 1;
    }else {
      this.roomNum += 1;
    }
  }
  
}
