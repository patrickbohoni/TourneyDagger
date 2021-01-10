import { ITournamentRound } from '../models/tournament-round';
import { TournamentType } from '../models/enumerations/tournament-type.model';

export interface ITournament {
  id?: number;
  name?: string;
  location?: string;
  date?: Date;
  type?: TournamentType;
  tournamentrounds?: ITournamentRound[];
}

export class Tournament implements ITournament {
  constructor(
    public id?: number,
    public name?: string,
    public location?: string,
    public date?: Date,
    public type?: TournamentType,
    public tournamentrounds?: ITournamentRound[]
  ) {}
}