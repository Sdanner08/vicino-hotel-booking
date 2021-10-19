import { MapsAPILoader} from '@agm/core';
import { Component, ElementRef, NgZone, ViewChild, OnInit, OnChanges, Output, EventEmitter, SimpleChange, SimpleChanges } from '@angular/core';
import { HotelsListComponent } from './components/hotels-list/hotels-list.component';
//import { EventEmitter } from 'stream';
import { HotelService } from './services/hotel/hotel.service';
import { VariablesService } from './services/variables/variables.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnChanges {
  title = 'hotel-app';
  latitude: number;
  longitude: number;
  zoom:number;
  address: string;
  private geoCoder;
  hotels: any = [];
  wait: boolean = false;

  @ViewChild('search')
  public searchElementRef: ElementRef;

  @Output() refreshHotels: EventEmitter<any> = new EventEmitter();

  @ViewChild(HotelsListComponent) child

  sendRefresh() {
    this.refreshHotels.emit;
  }

  constructor(
    private mapsAPILoader: MapsAPILoader,
    private ngZone: NgZone,
    private hotelService: HotelService,
    private variable: VariablesService
  ) { }


  ngOnInit() {
    //load Places Autocomplete
    this.mapsAPILoader.load().then(() => {
      this.setCurrentLocation();
      this.geoCoder = new google.maps.Geocoder;

      let autocomplete = new google.maps.places.Autocomplete(this.searchElementRef.nativeElement);
      autocomplete.addListener("place_changed", () => {
        this.ngZone.run(() => {
          //get the place result
          let place: google.maps.places.PlaceResult = autocomplete.getPlace();

          //verify result
          if (place.geometry === undefined || place.geometry === null) {
            return;
          }

          //set latitude, longitude and zoom
          this.latitude = place.geometry.location.lat();
          this.longitude = place.geometry.location.lng();
          this.zoom = 12;
        });
      });
    });
  }

  ngOnChanges(changes: SimpleChanges) {
    console.log(changes)
  }

  // Get Current Location Coordinates
  private setCurrentLocation() {
    console.log("----------------------------------------")
    if ('geolocation' in navigator) {
      navigator.geolocation.getCurrentPosition((position) => {
        this.latitude = position.coords.latitude;
        this.longitude = position.coords.longitude;
        this.zoom = 8;
        this.getAddress(this.latitude, this.longitude);
        this.variable.setLatAndLong(this.latitude, this.longitude)
        this.child.ngOnInit();
      });
    }
  }

  markerDragEnd($event: google.maps.MouseEvent) {
    console.log($event);
    this.latitude = $event.latLng.lat();
    this.longitude = $event.latLng.lng();
    this.getAddress(this.latitude, this.longitude);
  }

  getAddress(latitude, longitude) {
    this.geoCoder.geocode({ 'location': { lat: latitude, lng: longitude } }, (results, status) => {
      console.log(results);
      console.log(status);
      this.variable.setLatAndLong(latitude, longitude);
      if (status === 'OK') {
        if (results[0]) {
          this.zoom = 12;
          this.address = results[0].formatted_address;
        } else {
          window.alert('No results found');
        }
      } else {
        window.alert('Geocoder failed due to: ' + status);
      }
      this.variable.setLatAndLong(this.latitude, this.longitude)
    });
  }

  findHotels() {
    console.log(this.latitude)
    console.log(this.longitude)
    this.hotelService.getHotelInfo(12.91285,100.87808, this.variable.getAdultNum(), this.variable.getRoomNum(),
      this.variable.getDate().year.valueOf(), this.variable.getDate().month, this.variable.getDate().day, this.variable.getNumOfNights()).subscribe(data => {
      this.hotels = [];
      data.data.forEach(element => {
        this.hotels.push(element);
      });
      /* console.log(data); */
    })
  }

  refreshList() {
    this.variable.setLatAndLong(this.latitude, this.longitude);
    this.child.ngOnInit();
  }

}
