import { Component, OnInit } from '@angular/core';
import { ShipService } from "../../service/ship.service";
import { Ships } from "../../model/ships";
import { Ship } from "../../model/ship";

@Component({
  selector: 'app-ship-list',
  templateUrl: './ship-list.component.html',
  styleUrls: ['./ship-list.component.css']
})
export class ShipListComponent implements OnInit{

  /**
   * @param service ships service
   */
  constructor(private service: ShipService) {
  }

  /**
   * Available ships.
   */
  ships: Ships | undefined;

  ngOnInit(): void {
    this.service.getShips().subscribe(ships => this.ships = ships);
  }

  /**
   * Deletes selected ship.
   *
   * @param ship to be removed
   */
  onDelete(ship: Ship): void {
    this.service.deleteShip(ship.id).subscribe(() => this.ngOnInit());
  }

}
