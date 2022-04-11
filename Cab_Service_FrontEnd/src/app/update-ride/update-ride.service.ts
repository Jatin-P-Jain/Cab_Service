import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Fare } from '../book-ride/fare';
import { Rides } from './rides';

@Injectable({
  providedIn: 'root'
})
export class UpdateRideService {

  constructor(private http:HttpClient) { }
  getRides(updateRideData: any) :Observable<Rides[]>{
    return this.http.get<Rides[]>("http://localhost:8765/bookings/"+updateRideData);
  }
  getFares() :Observable<Fare[]>{
    return this.http.get<Fare[]>("http://localhost:8765/bookings/fares");
  }
  updateRide(bookingId:any,updateRideData:any){
    return this.http.put<any>("http://localhost:8765/bookings/"+bookingId,updateRideData);
  }
}
