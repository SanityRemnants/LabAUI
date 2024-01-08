import { Component, OnInit } from '@angular/core';
import { FleetService } from '../../service/fleet.service';
import { ActivatedRoute, Router } from '@angular/router';
import {FleetForm} from "../../model/fleet-form";
import { Fleets } from "../../../fleet/model/fleets";
import { v4 as uuidv4 } from 'uuid';
@Component({
  selector: 'app-fleet-put',
  templateUrl: './fleet-put.component.html',
  styleUrls: ['./fleet-put.component.css']
})
export class FleetPutComponent implements OnInit {

  /**
   * Single fleet.
   */
  fleet: FleetForm | undefined;
  fleets: Fleets | undefined;

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
    this.fleet = {
      fleetName: "enter name",
      profit: 0,
      countryOfOrigin: "enter country"
    }
    this.service.getFleets().subscribe(fleets => this.fleets = fleets)
  }

  /**
   * Updates fleet.
   */
  onSubmit(): void {
    let uuid = ""
    let rand:boolean = false
    do {
      uuid = uuidv4()
      rand = false
      for(let i=0; i<this.fleets!.fleets.length; i++){
        if(uuid==this.fleets!.fleets[i].id)
        {
          rand = true
        }
      }
    }while (rand)

    this.service.putFleet(uuid, this.fleet!)
      .subscribe(() => this.router.navigate(['/fleets']));
  }

}
