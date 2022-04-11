import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { BookRideService } from './book-ride.service';
import { Fare } from './fare';

@Component({
  selector: 'app-book-ride',
  templateUrl: './book-ride.component.html',
  styleUrls: ['./book-ride.component.css']
})
export class BookRideComponent implements OnInit {
  bookRideForm!: FormGroup;
  showFare=false;
  fares: Fare[] = [];
  errorMessage!: any;
  successMessage!: any;
  bookErrorMessage!: any;
  bookErrorMessageArray: string[]= [];
  noOfErrors!:number;
  source!:string;
  destination!:string;
  constructor(private fb: FormBuilder,private bookRideService:BookRideService) { }
  ngOnInit(): void {
    this.bookRideForm = this.fb.group({
      userMobile: ['',[Validators.required,Validators.min(6000000000),Validators.max(9999999999)]],
      source: ['',Validators.required],
      destination: ['',Validators.required],
      travelDate: ['',Validators.required]
    })
  }
  fareSelected(f:Fare){
    console.log(f);
    this.showFare=false;
    this.source=f.source;
    this.destination=f.destination;
    console.log(this.source);
    console.log(this.destination);
  }
  showFares(){
    this.showFare=!this.showFare
    this.errorMessage=null;
    this.bookRideService.getFares().subscribe(
      fares=>{this.fares=fares, console.log(this.fares)},
      error=>this.errorMessage=error.error.message
    );
  }
  bookRide(){
    this.successMessage=null;
    this.bookErrorMessage=null;
    console.log(this.bookRideForm.value)
    this.bookRideService.bookRide(this.bookRideForm.value).subscribe(
      response=> {this.successMessage=response.successMessage,this.bookRideForm.reset()},
      errorMessage=>{this.bookErrorMessage=errorMessage.error.errorMessage, 
        this.bookErrorMessageArray=this.bookErrorMessage.split(","),
        this.noOfErrors=this.bookErrorMessageArray.length}
    );
    
  }
}
