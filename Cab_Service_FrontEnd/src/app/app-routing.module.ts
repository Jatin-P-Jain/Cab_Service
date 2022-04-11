import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BookRideComponent } from './book-ride/book-ride.component';
import { CancelRideComponent } from './cancel-ride/cancel-ride.component';
import { HomeComponent } from './home/home.component';
import { UpdateRideComponent } from './update-ride/update-ride.component';

const routes: Routes = [
  {path:'', component:HomeComponent},
  {path:'bookRide', component:BookRideComponent},
  {path:'updateRide', component:UpdateRideComponent},
  {path:'cancelRide', component:CancelRideComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
