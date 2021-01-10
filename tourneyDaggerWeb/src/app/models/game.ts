import { IPlayer } from '../models/player'
import { ITournamentRound } from '../models/tournament-round';
import { Winner } from '../models/enumerations/winner.model';

export interface IGame {
  id?: number;
  winner?: Winner;
  player1?: IPlayer;
  player2?: IPlayer;
  rounds?: ITournamentRound[];
}

export class Game implements IGame {
  constructor(
    public id?: number,
    public winner?: Winner,
    public player1?: IPlayer,
    public player2?: IPlayer,
    public rounds?: ITournamentRound[]
  ) {}
}