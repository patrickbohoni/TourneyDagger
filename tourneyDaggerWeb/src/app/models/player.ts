// import { IUser } from '../models/'
import { ITournament } from '../models/tournament';

export interface IPlayer {
  id?: number;
  name?: string;
  points?: number;
  ranking?: number;
  wLR?: string;
//   user?: IUser;
  tournament?: ITournament;
}

export class Player implements IPlayer {
  constructor(
    public id?: number,
    public name?: string,
    public points?: number,
    public ranking?: number,
    public wLR?: string,
    // public user?: IUser,
    public tournament?: ITournament
  ) {}
}