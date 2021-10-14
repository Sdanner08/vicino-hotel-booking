import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { LocationInputComponent } from './components/location-input/location-input.component';
import { DateSelectComponent } from './components/date-select/date-select.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { PriceRangeComponent } from './components/price-range/price-range.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    LocationInputComponent,
    DateSelectComponent,
    PriceRangeComponent
  ],
  imports: [
    BrowserModule,
    NgbModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
