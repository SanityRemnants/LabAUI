import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import {Fleets} from "../model/fleets";
import {ShipDetails} from "../../ship/model/ship-details";
import {FleetDetails} from "../model/fleet-details";
import {Ships} from "../../ship/model/ships";
import {ShipForm} from "../../ship/model/ship-form";
import {FleetForm} from "../model/fleet-form";

/**
 * User management service. Calls REST endpoints.
 */
@Injectable()
export class FleetService {

  /**
   * @param http HTTP client
   */
  constructor(private http: HttpClient) {

  }

  /**
   * Fetches all fleets.
   *
   * @return list of fleets
   */
  getFleets(): Observable<Fleets> {
    return this.http.get<Fleets>('/api/fleets');
  }
  getFleet(uuid: string): Observable<FleetDetails> {
    return this.http.get<FleetDetails>('/api/fleets/' + uuid);
  }
  getFleetShips(uuid: string): Observable<Ships> {
    return this.http.get<Ships>('/api/fleets/' + uuid + '/ships');
  }
  putFleet(uuid: string, request: FleetForm): Observable<any> {
    return this.http.put('/api/fleets/' + uuid, request);
  }

  /**
   * Removes single fleet.
   *
   * @param uuid fleet's id
   */
  deleteFleet(uuid: string): Observable<any> {
    return this.http.delete('/api/fleets/' + uuid);
  }

}
