import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Ships } from "../model/ships";
import { ShipDetails } from "../model/ship-details";
import { ShipForm } from "../model/ship-form";

/**
 * Ship management service. Calls REST endpoints.
 */
@Injectable()
export class ShipService {

  /**
   * @param http HTTP client
   */
  constructor(private http: HttpClient) {

  }

  /**
   * Fetches all ships.
   *
   * @return list of ships
   */
  getShips(): Observable<Ships> {
    return this.http.get<Ships>('/api/ships');
  }

  /**
   * Fetches single ships.
   *
   * @param uuid ship's id
   * @return single ships
   */
  getShip(uuid: string): Observable<ShipDetails> {
    return this.http.get<ShipDetails>('/api/ships/' + uuid);
  }

  /**
   * Removes single ship.
   *
   * @param uuid ship's id
   */
  deleteShip(uuid: string): Observable<any> {
    return this.http.delete('/api/ships/' + uuid);
  }

  /**
   * Updates single ship.
   *
   * @param uuid ship's id
   * @param request request body
   */
  putShip(uuid: string, request: ShipForm): Observable<any> {
    return this.http.put('/api/ships/' + uuid, request);
  }

}
