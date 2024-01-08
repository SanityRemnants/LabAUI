import { Component, OnInit } from '@angular/core';
import { Fleets } from "../../model/fleets";
import { Fleet } from "../../model/fleet";
import { FleetService } from "../../service/fleet.service";

/**
 * Navigable view with list of all fleets.
 */
@Component({
  selector: 'app-fleet-list',
  templateUrl: './fleet-list.component.html',
  styleUrls: ['./fleet-list.component.css']
})
export class FleetListComponent implements OnInit {

  /**
   * @param service fleets service
   */
  constructor(private service: FleetService) {
  }

  /**
   * Available fleets.
   */
  fleets: Fleets | undefined;

  ngOnInit(): void {
    this.service.getFleets().subscribe(fleets => this.fleets = fleets);
  }

  /**
   * Deletes selected fleet.
   *
   * @param fleet fleet to be removed
   */
  onDelete(fleet: Fleet): void {
    this.service.deleteFleet(fleet.id).subscribe(() => this.ngOnInit());
  }

}
