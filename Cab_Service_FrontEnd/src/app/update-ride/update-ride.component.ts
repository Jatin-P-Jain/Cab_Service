import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Fare } from '../book-ride/fare';
import { UpdateRideService } from './update-ride.service';

@Component({
  selector: 'app-update-ride',
  templateUrl: './update-ride.component.html',
  styleUrls: ['./update-ride.component.css']
})
export class UpdateRideComponent implements OnInit {
  updateRideForm!: FormGroup;
  updateRideDetailsForm!: FormGroup;
  rides:any[]=[];
  errorMessage!:any;
  showRides:boolean=false;
  showError:boolean=false;
  showForm:boolean=true;
  showFare=false;
  fares: Fare[] = [];
  successMessage!: any;
  updateErrorMessage!: any;
  updateErrorMessageArray: string[]= [];
  noOfErrors!:number;
  source!:string;
  destination!:string;
  showUpdateForm:boolean=false;
  rideDetails:any;
  userMobile!:number;
  travelDate!:Date;
  constructor(private fb: FormBuilder,private updateRideService:UpdateRideService) { }

  ngOnInit(): void {
    this.updateRideForm = this.fb.group({
      userMobile: ['',[Validators.required,Validators.min(6000000000),Validators.max(9999999999)]]
    });
    this.updateRideDetailsForm = this.fb.group({
      userMobile: ['',[Validators.required,Validators.min(6000000000),Validators.max(9999999999)]],
      source: ['',Validators.required],
      destination: ['',Validators.required],
      travelDate: ['',Validators.required]
    })
  }

  showRide(){
    this.showForm=false;
    this.updateRideService.getRides(this.updateRideForm.value['userMobile']).subscribe(
      response=>{
        this.showError=false,
        this.rides=response,
        this.showRides=true},
      error=>{
        this.showRides=false,
        this.errorMessage=error.error.errorMessage,
        this.showError=true, 
        this.showForm=this.errorMessage!=null?true:false}
    );
  }
  changeNumber(){
    this.updateRideForm.reset();
    this.showRides=false;
    this.showForm=true;
    this.successMessage=null;
    this.errorMessage=null;
  }

  updateRide(rideDetails:any){
    this.rideDetails=rideDetails;
    this.userMobile=this.rideDetails['userMobile'];
    this.source=this.rideDetails['source'];
    this.destination=this.rideDetails['destination'];
    this.travelDate=this.rideDetails['travelDate'];
    this.showForm=false;
    this.showUpdateForm=true;
    this.showRides=false;
    this.successMessage=null;
    this.errorMessage=null;
  }

  fareSelected(f:Fare){
    console.log(f);
    this.showFare=false;
    this.source=f.source;
    this.destination=f.destination;
  }
  showFares(){
    this.showFare=!this.showFare
    this.updateRideService.getFares().subscribe(
      fares=>{this.fares=fares, console.log(this.fares)},
      error=>this.errorMessage=error.error.message
    );
  }
  cancelUpdateForm(){
    this.updateRideDetailsForm.reset();
    this.showRides=true;
    this.showUpdateForm=false;
    this.updateErrorMessage=null;
  }
  submitUpdateRide(){
    this.updateRideService.updateRide(this.rideDetails['bookingId'],this.updateRideDetailsForm.value).subscribe(
      response=> {
        this.successMessage=response.successMessage,
        this.updateRideDetailsForm.reset(),
        this.showUpdateForm=false,
        this.showRides=true,
        this.showRide()},
      errorMessage=>{
        this.updateErrorMessage=errorMessage.error.errorMessage, 
        this.updateErrorMessageArray=this.updateErrorMessage.split(","),
        this.noOfErrors=this.updateErrorMessageArray.length}
    );
  }
}
