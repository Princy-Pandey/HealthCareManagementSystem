import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AppointmentComponent } from './appointment/appointment.component';
import { FormsModule } from '@angular/forms';
import { AddCentreComponent } from './add-centre/add-centre.component';
import { DeleteCentreComponent } from './delete-centre/delete-centre.component';
import { AddTestComponent } from './add-test/add-test.component';
import { DeleteTestComponent } from './delete-test/delete-test.component';
import { AdminserviceService } from './service/adminservice.service';
import { HomeComponent } from './home/home.component';
import { UpdateCentreComponent } from './update-centre/update-centre.component';



@NgModule({
  declarations: [
    AppComponent,
    
    AppointmentComponent,
    AddCentreComponent,
    DeleteCentreComponent,
    AddTestComponent,
    DeleteTestComponent,
    HomeComponent,
    UpdateCentreComponent
    
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap:[AppComponent]
})
export class AppModule { }