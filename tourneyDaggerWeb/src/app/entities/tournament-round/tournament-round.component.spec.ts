import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TournamentRoundComponent } from './tournament-round.component';

describe('TournamentRoundComponent', () => {
  let component: TournamentRoundComponent;
  let fixture: ComponentFixture<TournamentRoundComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TournamentRoundComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TournamentRoundComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
