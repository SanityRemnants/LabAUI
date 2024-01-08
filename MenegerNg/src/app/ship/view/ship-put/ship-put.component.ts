import { Component, OnInit } from '@angular/core';
import { ShipService } from '../../service/ship.service';
import { ActivatedRoute, Router } from '@angular/router';
import {ShipForm} from "../../model/ship-form";
import { Ships } from "../../../ship/model/ships";
import { v4 as uuidv4 } from 'uuid';
@Component({
  selector: 'app-ship-put',
  templateUrl: './ship-put.component.html',
  styleUrls: ['./ship-put.component.css']
})
export class ShipPutComponent implements OnInit {

  /**
   * Single ship.
   */
  ship: ShipForm | undefined;
  ships: Ships | undefined;

  /**
   * @param service ship service
   * @param route activated route
   * @param router router
   */
  constructor(
    private service: ShipService,
    private route: ActivatedRoute,
    private router: Router
  ) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.ship = {
        name: "enter name",
        displacement: 0,
        fleet: params['uuid']
      };

      this.service.getShips().subscribe(ships => this.ships = ships);
    });

    this.service.getShips().subscribe(ships => this.ships = ships);
  }

  /**
   * Updates ship.
   */
  onSubmit(): void {
    let uuid = ""
    let rand:boolean = false
    do {
      uuid = uuidv4()
      rand = false
      for(let i=0; i<this.ships!.ships.length; i++){
        if(uuid==this.ships!.ships[i].id)
        {
          rand = true
        }
      }
    }while (rand)

    this.service.putShip(uuid, this.ship!)
      .subscribe(() => this.router.navigate(['/fleets/'+this.ship!.fleet]));
  }

}
