import { IGame } from '../models/game';
import { ITournament } from "../models/tournament";

export interface ITournamentRound {
  id?: number;
  name?: string;
  roundNumber?: number;
  games?: IGame[];
  tournaments?: ITournament[];
}

export class TournamentRound implements ITournamentRound {
  constructor(
    public id?: number,
    public name?: string,
    public roundNumber?: number,
    public games?: IGame[],
    public tournaments?: ITournament[]
  ) {}
}