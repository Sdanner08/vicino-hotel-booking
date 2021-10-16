import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-price-range',
  templateUrl: './price-range.component.html',
  styleUrls: ['./price-range.component.css']
})
export class PriceRangeComponent implements OnInit {
  @Input()
  range:number = 300;

  constructor() { }

  ngOnInit(): void {
    
  }

}
