import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AgmCoreModule } from '@agm/core'
import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { LocationInputComponent } from './components/location-input/location-input.component';
import { DateSelectComponent } from './components/date-select/date-select.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { PriceRangeComponent } from './components/price-range/price-range.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RoomFormComponent } from './components/room-form/room-form.component';
import { HotelAdComponent } from './components/hotel-ad/hotel-ad.component';
import { HotelsListComponent } from './components/hotels-list/hotels-list.component';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    LocationInputComponent,
    DateSelectComponent,
    PriceRangeComponent,
    RoomFormComponent,
    HotelAdComponent,
    HotelsListComponent
  ],
  imports: [
    BrowserModule,
    NgbModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    AgmCoreModule.forRoot({
      apiKey: 'AIzaSyBfnx_hhyeBK6NYgMHxJlBCZWRm33zSgWU',
      libraries: ['places']
    })
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
