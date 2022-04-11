import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CancelRideComponent } from './cancel-ride.component';

describe('CancelRideComponent', () => {
  let component: CancelRideComponent;
  let fixture: ComponentFixture<CancelRideComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CancelRideComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CancelRideComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
