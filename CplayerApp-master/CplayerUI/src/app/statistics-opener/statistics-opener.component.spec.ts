import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StatisticsOpenerComponent } from './statistics-opener.component';

describe('StatisticsOpenerComponent', () => {
  let component: StatisticsOpenerComponent;
  let fixture: ComponentFixture<StatisticsOpenerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StatisticsOpenerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(StatisticsOpenerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
