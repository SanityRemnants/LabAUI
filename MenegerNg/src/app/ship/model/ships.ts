import { Ship } from "./ship";

/**
 * GET ships response. Contains list of available ships. Can be used to list particular user's ships as
 * well as all ships in the game.
 */
export interface Ships {

  /**
   * Name of the selected ships.
   */
  ships:Ship[];

}
