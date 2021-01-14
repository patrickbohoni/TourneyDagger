import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddTournamentRoundComponent } from './add-tournament-round.component';

describe('AddTournamentRoundComponent', () => {
  let component: AddTournamentRoundComponent;
  let fixture: ComponentFixture<AddTournamentRoundComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddTournamentRoundComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddTournamentRoundComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
