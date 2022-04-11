import { TestBed } from '@angular/core/testing';

import { BookRideService } from './book-ride.service';

describe('BookRideService', () => {
  let service: BookRideService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BookRideService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
