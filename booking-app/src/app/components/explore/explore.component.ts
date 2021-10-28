import { Component, OnInit } from '@angular/core';
import { AppService } from '../../services/app.service';
import { LightRestaurant } from '../../shared/models/restaurant-ligth-model';

@Component({
  selector: 'app-explore',
  templateUrl: './explore.component.html',
  styleUrls: ['./explore.component.scss']
})
export class ExploreComponent implements OnInit {
  public restaurants: LightRestaurant[];
  constructor(private service: AppService) { }

  ngOnInit() {
    /*this.service.getAllRestaurantsMock().subscribe((result: any) => {
      this.restaurants = result;
    });*/
    this.service.getAllRestaurants().subscribe((result: any) => {
      this.restaurants = result.data;
    });
  }

}
