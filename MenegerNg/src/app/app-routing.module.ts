import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FleetListComponent} from "./fleet/view/fleet-list/fleet-list.component";
import { ShipListComponent } from "./ship/view/ship-list/ship-list.component";
import { ShipViewComponent } from "./ship/view/ship-view/ship-view.component";
import { ShipEditComponent } from "./ship/view/ship-edit/ship-edit.component";
import {FleetViewComponent} from "./fleet/view/fleet-view/fleet-view.component";
import {FleetEditComponent} from "./fleet/view/fleet-edit/fleet-edit.component";
import {FleetPutComponent} from "./fleet/view/fleet-put/fleet-put.component";
import {ShipPutComponent} from "./ship/view/ship-put/ship-put.component";

/**
 * All available routes.
 */
const routes: Routes = [
  {
    component: ShipPutComponent,
    path: "fleets/:uuid/ships/create"
  },
  {
    component: FleetListComponent,
    path: "fleets"
  },
  {
    component: ShipListComponent,
    path: "ships"
  },
  {
    component: ShipViewComponent,
    path: "fleets/:fleet/ships/:uuid"
  }
  ,
  {
    component: ShipEditComponent,
    path: "fleets/:fleet/ships/:uuid/edit"
  },
  {
    component: FleetEditComponent,
    path: "fleets/:uuid/edit"
  },
  {
    component: FleetPutComponent,
    path: "fleets/create"
  },
  {
    component: FleetViewComponent,
    path: "fleets/:uuid"
  }
];

/**
 * Global routing module.
 */
@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule {

}
