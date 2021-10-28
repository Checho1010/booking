import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Booked, PaymentConfirm, PaymentIntent } from '../shared/models/payment-model';

@Injectable({
  providedIn: 'root'
})
export class PaymentService {
  private booked: Booked;
  private API = 'http://localhost:8080/booking-restaurant/v1/payment/';

  constructor(
    private http: HttpClient

  ) { }
  setBooked(booked: Booked) {
    this.booked = booked;
  }
  getBooked() {
    return this.booked;
  }
  buy(payment: PaymentIntent) {
    return this.http.post(this.API + 'paymentIntent', payment);
  }
  cancel(id: string) {
    return this.http.post(this.API + 'cancel/' + id, {});
  }
  confirm(paymentConfirm: PaymentConfirm) {
    /*const options = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Access-Control-Allow-Methods': 'POST',
        'Access-Control-Allow-Origin': 'http://localhost:4200'
      })
    };*/
    /*paymentConfirm.headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Access-Control-Allow-Methods': 'POST',
      'Access-Control-Allow-Origin': 'http://localhost:4200'
    });*/
    // return this.http.post(this.API + 'confirm/' + paymentConfirm.paymentId, paymentConfirm);
    return this.http.post(this.API + 'confirm', paymentConfirm);
  }
}
