import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './component/header/header.component';
import { NavComponent } from './component/nav/nav.component';
import { MainComponent } from './component/main/main.component';
import { FleetListComponent } from './fleet/view/fleet-list/fleet-list.component';
import { FleetViewComponent} from "./fleet/view/fleet-view/fleet-view.component";
import { FleetEditComponent} from "./fleet/view/fleet-edit/fleet-edit.component";
import { HttpClientModule } from "@angular/common/http";
import {FleetService} from "./fleet/service/fleet.service";
import { ShipListComponent } from './ship/view/ship-list/ship-list.component';
import { ShipService } from './ship/service/ship.service';
import { ShipViewComponent } from './ship/view/ship-view/ship-view.component';
import { ShipEditComponent } from './ship/view/ship-edit/ship-edit.component';
import { FormsModule } from "@angular/forms";
import {FleetPutComponent} from "./fleet/view/fleet-put/fleet-put.component";
import {ShipPutComponent} from "./ship/view/ship-put/ship-put.component";

/**
 * Application main module.
 */
@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    NavComponent,
    MainComponent,
    FleetListComponent,
    FleetEditComponent,
    FleetPutComponent,
    FleetViewComponent,
    ShipListComponent,
    ShipViewComponent,
    ShipEditComponent,
    ShipPutComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    ShipService,
    FleetService
  ],
  bootstrap: [
    AppComponent
  ]
})
export class AppModule {

}
