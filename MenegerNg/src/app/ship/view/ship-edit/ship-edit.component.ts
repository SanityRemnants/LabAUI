import { Component, OnInit } from '@angular/core';
import { ShipService } from '../../service/ship.service';
import { ActivatedRoute, Router } from '@angular/router';
import { ShipForm } from '../../model/ship-form';
import { FleetService } from "../../../fleet/service/fleet.service";
import { Fleets } from "../../../fleet/model/fleets";

@Component({
  selector: 'app-ship-edit',
  templateUrl: './ship-edit.component.html',
  styleUrls: ['./ship-edit.component.css']
})
export class ShipEditComponent implements OnInit {

  /**
   * Ship's id.
   */
  uuid: string | undefined;

  /**
   * Single ship.
   */
  ship: ShipForm | undefined;

  /**
   * Single ship.
   */
  original: ShipForm | undefined;

  /**
   * Available fleets.
   */
  fleets: Fleets | undefined;

  /**
   * @param shipService ship service
   * @param fleetService fleet service
   * @param route activated route
   * @param router router
   */
  constructor(
    private shipService: ShipService,
    private fleetService: FleetService,
    private route: ActivatedRoute,
    private router: Router
  ) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.fleetService.getFleets()
        .subscribe(fleets => this.fleets = fleets);

      this.shipService.getShip(params['uuid'])
        .subscribe(ship => {
          this.uuid = ship.id;
          this.ship = {
            name: ship.name,
            displacement: ship.displacement,
            fleet: params['fleet']
          };
          this.original = {...this.ship};
        });
    });
  }

  /**
   * Updates ship.
   */
  onSubmit(): void {
    this.shipService.putShip(this.uuid!, this.ship!)
      .subscribe(() => this.router.navigate(['/ships']));
  }

}
