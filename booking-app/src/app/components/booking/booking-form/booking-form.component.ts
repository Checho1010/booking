import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { AppService } from 'src/app/services/app.service';
import { Booking } from 'src/app/shared/models/booking-models';
import { InfoDialogComponent } from '../../../shared/dialogs/info-dialog/info-dialog.component';
import { Restaurant } from '../../../shared/models/restaurant-model';
import { PaymentService } from '../../../services/payment.service';

@Component({
  selector: 'app-booking-form',
  templateUrl: './booking-form.component.html',
  styleUrls: ['./booking-form.component.css']
})
export class BookingFormComponent implements OnInit {

  public bookingForm;
  public booking = new Booking();
  @Input() restaurant: Restaurant;


  constructor(
    public dialog: MatDialog,
    private fb: FormBuilder,
    private service: AppService,
    private paymentService: PaymentService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.initForm();
  }

  sendBooking() {
    this.setBooking();
    this.service.createReservation(this.booking).subscribe((result: any ) => {
      console.log(result.data);
      const title = 'CÓDIGO DE RESERVA: ' + result.data;
      const info = 'Necesitarás el código para poder acceder al restaurante o cancelar la reserva. Por favor guardalo en un lugar seguro';
      this.openDialog( title, info);
    });
    // console.log('Sending booking', this.bookingForm.get('date').value);
  }

  payBooking() {
    this.setBooking();
    this.service.createReservation(this.booking).subscribe((result: any ) => {
      this.paymentService.setBooked({ ...this.booking, locator: result.data});
      this.router.navigate(['payment']);
    });
    // this.paymentService.setBooked({ ...this.booking, locator: 'HOLA-LOCATOR'});
    // this.router.navigate(['payment']);
  }

  initForm() {
    this.bookingForm = this.fb.group({
      date: [new Date(), Validators.required],
      time: ['', Validators.required],
      customers: ['', Validators.required],
      email: ['', Validators.required],
      name: ['', Validators.required]
    });
  }
  setBooking() {
    this.booking.restaurantId = this.restaurant.id;
    this.booking.turnId = this.bookingForm.get('time').value;
    this.booking.date = this.bookingForm.get('date').value;
    this.booking.person = this.bookingForm.get('customers').value;
    this.booking.name = this.bookingForm.get('name').value;
    this.booking.email = this.bookingForm.get('email').value;
    this.booking.price = this.restaurant.price;
  }

  openDialog(title: string, info: string): void {
    const dialogRef = this.dialog.open(InfoDialogComponent, {
      width: '350px',
      data: {title: title, info: info}
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
    });
  }

}





