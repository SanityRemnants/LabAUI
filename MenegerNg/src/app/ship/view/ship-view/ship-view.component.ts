import { Component, OnInit } from '@angular/core';
import { ShipService } from "../../service/ship.service";
import { ActivatedRoute, Router } from "@angular/router";
import { ShipDetails } from "../../model/ship-details";

/**
 * Preview of single ship.
 */
@Component({
  selector: 'app-ship-view',
  templateUrl: './ship-view.component.html',
  styleUrls: ['./ship-view.component.css']
})
export class ShipViewComponent implements OnInit {

  /**
   * Single ship.
   */
  ship: ShipDetails | undefined;

  /**
   *
   * @param service ship service
   * @param route activated route
   * @param router router
   */
  constructor(private service: ShipService, private route: ActivatedRoute, private router: Router) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.service.getShip(params['uuid'])
        .subscribe(ship => this.ship = ship)
    });
  }

}
