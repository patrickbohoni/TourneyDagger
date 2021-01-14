import { TestBed } from '@angular/core/testing';

import { TournamentRoundService } from './tournament-round.service';

describe('TournamentRoundService', () => {
  let service: TournamentRoundService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TournamentRoundService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
