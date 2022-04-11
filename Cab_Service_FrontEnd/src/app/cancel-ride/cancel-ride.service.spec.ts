import { TestBed } from '@angular/core/testing';

import { CancelRideService } from './cancel-ride.service';

describe('CancelRideService', () => {
  let service: CancelRideService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CancelRideService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
