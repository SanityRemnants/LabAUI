import { Component, OnInit } from '@angular/core';
import { FleetService } from "../../service/fleet.service";
import { ActivatedRoute, Router } from "@angular/router";
import { FleetDetails } from "../../model/fleet-details";
import {Ships} from "../../../ship/model/ships";
import {Ship} from "../../../ship/model/ship";
import {ShipService} from "../../../ship/service/ship.service";

/**
 * Preview of single fleet.
 */
@Component({
  selector: 'app-fleet-view',
  templateUrl: './fleet-view.component.html',
  styleUrls: ['fleet-view.component.css']
})
export class FleetViewComponent implements OnInit {

  /**
   * Single fleet.
   */
  fleet: FleetDetails | undefined;
  ships: Ships | undefined;
  /**
   *
   * @param service fleet service
   * @param route activated route
   * @param router router
   */
  constructor(private service: FleetService, private shipService: ShipService,private route: ActivatedRoute, private router: Router) {
  }
  ngOnInit() {
    this.route.params.subscribe(params => {
      this.service.getFleet(params['uuid']).subscribe(fleet => this.fleet = fleet);
      this.service.getFleetShips(params['uuid']).subscribe(ships => this.ships = ships)
    });
  }
  onDelete(ship: Ship): void {
    this.shipService.deleteShip(ship.id).subscribe(() => this.ngOnInit());
  }

}
