import { Component, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Booking } from 'src/app/shared/models/booking-models';
import { AppService } from '../../services/app.service';
import { Restaurant } from '../../shared/models/restaurant-model';
import { BookingFormComponent } from './booking-form/booking-form.component';



@Component({
  selector: 'app-booking',
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.scss']
  // , providers: [DataService]
})
export class BookingComponent implements OnInit {

  @ViewChild(BookingFormComponent) bookingForm: BookingFormComponent;

  public restaurant = new Restaurant();
  // public booking = new Booking();
  private idRestaurant: number;

  constructor(
    private service: AppService,
    private route: ActivatedRoute
  ) { }


  // aqui es donde se construye el componente, como el PostConstruct de java, o el PageLoad de .net
  ngOnInit(): void {
    this.idRestaurant = Number(this.route.snapshot.paramMap.get('id'));
    this.getRestaurant();
  }

  getRestaurant() {
    this.service.getRestaurant(this.idRestaurant).subscribe((result: any) => {
      this.bookingForm.restaurant = result.data;
      this.restaurant = result.data;
    });
  }



}
