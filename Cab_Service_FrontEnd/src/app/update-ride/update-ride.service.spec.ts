import { TestBed } from '@angular/core/testing';

import { UpdateRideService } from './update-ride.service';

describe('UpdateRideService', () => {
  let service: UpdateRideService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UpdateRideService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
