import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TournamentRoundListComponent } from './tournament-round-list.component';

describe('TournamentRoundListComponent', () => {
  let component: TournamentRoundListComponent;
  let fixture: ComponentFixture<TournamentRoundListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TournamentRoundListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TournamentRoundListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
