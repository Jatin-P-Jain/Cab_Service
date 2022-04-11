import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BookRideComponent } from './book-ride/book-ride.component';
import { HomeComponent } from './home/home.component';
import { ReactiveFormsModule } from '@angular/forms';
import { BookRideService } from './book-ride/book-ride.service';
import { HttpClientModule }     from '@angular/common/http';
import { UpdateRideComponent } from './update-ride/update-ride.component';
import { UpdateRideService } from './update-ride/update-ride.service';
import { CancelRideComponent } from './cancel-ride/cancel-ride.component';



@NgModule({
  declarations: [
    AppComponent,
    BookRideComponent,
    HomeComponent,
    UpdateRideComponent,
    CancelRideComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [BookRideService,UpdateRideService],
  bootstrap: [AppComponent]
})
export class AppModule { }
