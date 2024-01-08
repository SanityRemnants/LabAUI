import { Fleet } from "../../fleet/model/fleet";

/**
 * Represents single ship in list.
 */
export interface ShipDetails {

  /**
   * Unique id identifying ship.
   */
  id: string;

  /**
   * Name of the ship.
   */
  name: string;

  displacement: number;

  /**
   * Ship's fleet.
   */
  fleet: Fleet;

}
