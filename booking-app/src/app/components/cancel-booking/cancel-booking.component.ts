import { Component, OnInit } from '@angular/core';
import { AppService } from '../../services/app.service';

@Component({
  selector: 'app-cancel-booking',
  templateUrl: './cancel-booking.component.html',
  styleUrls: ['./cancel-booking.component.scss']
})
export class CancelBookingComponent implements OnInit {
  codeReservation: string;
  state = 'Tu reserva aún no ha sido cancelada';
  constructor(
    private service: AppService
  ) { }

  ngOnInit() {
  }

  sendCancel() {
    this.service.cancelReservation(this.codeReservation).subscribe((result: any) => {
      this.state = 'Tu reserva se ha cancelado con éxito';
      console.log(result);
    });
    console.log(this.codeReservation);
  }

}
