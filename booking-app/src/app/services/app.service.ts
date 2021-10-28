import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { of } from 'rxjs';
import { LightRestaurant } from '../shared/models/restaurant-ligth-model';
import { Booking } from '../shared/models/booking-models';

const API = 'http://localhost:8080/booking-restaurant/v1/';

@Injectable({
  providedIn: 'root'
})
export class AppService {

  constructor(
    private http: HttpClient
  ) { }

  getAllRestaurants() {
    return this.http.get(API + 'restaurant/restaurants');
  }

  getRestaurant(id: number) {
    return this.http.get(API + 'restaurant' + '/' + id);
  }


  createReservation(booking: Booking) {
    const options = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Access-Control-Allow-Methods': 'POST',
        'Access-Control-Allow-Origin': 'http://localhost:4200'
      })
    };
    return this.http.post(API + 'reservation/createReservation', booking, options);
    // return this.http.post('/booking-restaurant/v1/createReservation', booking);
  }


  cancelReservation(reservationCode: string) {
    const options = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    };
    return this.http.delete(API + 'deleteReservation?locator=' + reservationCode, options);
  }

  // si no se pone private o public, es por defecto público
  getAllRestaurantsMock() {

    const restaurants: LightRestaurant[] = [];
    // let
    const restaurant = new LightRestaurant();
    restaurant.address = 'De Goya 210';
    restaurant.id = 1;
    restaurant.image = 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSDpPIEejX6JfU1o75G-LrW2Qv3v_Vm1xv3pg&usqp=CAU';
    restaurant.name = 'El Lote Malo';

    const restaurant2: LightRestaurant = {
      address : 'Le Monet 44',
      id : 2,
      image : 'https://www.surparrillagourmet.com/wp-content/uploads/2018/11/foto-quienes-somos-nueva-01.jpg',
      name : 'Galaxy Grill'
    };

    restaurants.push(restaurant);
    restaurants.push(restaurant2);

    return of(restaurants);
  }
}
