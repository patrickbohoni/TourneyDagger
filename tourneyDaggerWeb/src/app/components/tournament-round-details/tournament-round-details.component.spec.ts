import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TournamentRoundDetailsComponent } from './tournament-round-details.component';

describe('TournamentRoundDetailsComponent', () => {
  let component: TournamentRoundDetailsComponent;
  let fixture: ComponentFixture<TournamentRoundDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TournamentRoundDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TournamentRoundDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
