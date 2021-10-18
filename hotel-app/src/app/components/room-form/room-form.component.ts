import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
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
  
  
  roomguestForm = this.fb.group({
    adult: [null],
    children: [null],
    rooms: [null]
  })
  constructor(private fb: FormBuilder, private variable: VariablesService) { }

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
  
}
