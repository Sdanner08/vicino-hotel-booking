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

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    LocationInputComponent,
    DateSelectComponent,
    PriceRangeComponent,
    RoomFormComponent
  ],
  imports: [
    BrowserModule,
    NgbModule,
    FormsModule,
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
