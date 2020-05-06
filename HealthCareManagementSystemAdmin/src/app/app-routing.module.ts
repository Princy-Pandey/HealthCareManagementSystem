import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AppointmentComponent } from './appointment/appointment.component';
import { AddCentreComponent } from './add-centre/add-centre.component';
import { DeleteCentreComponent } from './delete-centre/delete-centre.component';
import { AddTestComponent } from './add-test/add-test.component';
import { DeleteTestComponent } from './delete-test/delete-test.component';
import { HomeComponent } from './home/home.component';
import { UpdateCentreComponent } from './update-centre/update-centre.component';


const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full'},
  { path: 'add-centre', component: AddCentreComponent},
  { path: 'delete-centre', component: DeleteCentreComponent},
  { path: 'add-test', component: AddTestComponent},
  { path: 'delete-test', component: DeleteTestComponent},
  { path: 'appointment', component: AppointmentComponent},
  { path: 'home', component: HomeComponent},
  { path: 'update-centre', component: UpdateCentreComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
