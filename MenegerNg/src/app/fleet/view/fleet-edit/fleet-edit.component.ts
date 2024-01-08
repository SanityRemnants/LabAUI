import { Component, OnInit } from '@angular/core';
import { FleetService } from '../../service/fleet.service';
import { ActivatedRoute, Router } from '@angular/router';
import {FleetForm} from "../../model/fleet-form";

@Component({
  selector: 'app-fleet-edit',
  templateUrl: './fleet-edit.component.html',
  styleUrls: ['./fleet-edit.component.css']
})
export class FleetEditComponent implements OnInit {

  /**
   * Fleet's id.
   */
  uuid: string | undefined;

  /**
   * Single fleet.
   */
  fleet: FleetForm | undefined;

  /**
   * Single fleet.
   */
  original: FleetForm | undefined;


  /**
   * @param service fleet service
   * @param route activated route
   * @param router router
   */
  constructor(
    private service: FleetService,
    private route: ActivatedRoute,
    private router: Router
  ) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.service.getFleet(params['uuid'])
        .subscribe(fleet => {
          this.uuid = fleet.id;
          this.fleet = {
            fleetName: fleet.fleetName,
            profit: fleet.profit,
            countryOfOrigin:fleet.countryOfOrigin
          };
          this.original = {...this.fleet};
        });
    });
  }

  /**
   * Updates fleet.
   */
  onSubmit(): void {
    this.service.putFleet(this.uuid!, this.fleet!)
      .subscribe(() => this.router.navigate(['/fleets']));
  }

}
