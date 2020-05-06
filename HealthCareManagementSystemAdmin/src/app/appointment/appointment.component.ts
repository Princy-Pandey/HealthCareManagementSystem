import { Component, OnInit } from '@angular/core';
import { AdminserviceService} from '../service/adminservice.service';
import { Appointment } from '../appointment';
import { User } from '../user';
import { DiagnosticCentre } from '../diagnostic-centre';
import { Test } from '../test';
import { Router } from '@angular/router';

@Component({
  selector: 'app-appointment',
  templateUrl: './appointment.component.html',
  styleUrls: ['./appointment.component.css']
})
export class AppointmentComponent implements OnInit {


  centres:DiagnosticCentre[];
  centreId:DiagnosticCentre;
  tests:Test[];
  testId:Test;
  users:User[];
  userId:User;
  appointments:Appointment[];
  appointmentList:Array<Appointment>=[];

  
  
  
  deleteMessage=false;
  msg:string;
  errorMsg:string;
  Info:string;

  
  
  

  constructor(private adminService:AdminserviceService, private router:Router) { }

  ngOnInit() {
    console.log("inside ngOninit centre component");
    
      this.adminService.getAppointment().subscribe(data =>{this.appointments=data;});
      this.adminService.getTest().subscribe(data =>{this.tests=data;});
      this.adminService.getCentre().subscribe(data =>{this.centres=data;});
      this.adminService.getUser().subscribe(data =>{this.users=data;});

  }

appointment():void{
  alert('Approved');
  
}


  val:Boolean=false;
      showDetails()
      {
        this.val=!this.val;
        this.appointmentList.forEach(element => {
         //console.log(element.test_id+" "+element.test_name+" ");
      });
    }



ngOnDestroy() {
  this.appointmentList.slice();
    }

}
