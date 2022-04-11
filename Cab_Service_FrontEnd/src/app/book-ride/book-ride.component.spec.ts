import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BookRideComponent } from './book-ride.component';

describe('BookRideComponent', () => {
  let component: BookRideComponent;
  let fixture: ComponentFixture<BookRideComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BookRideComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BookRideComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
