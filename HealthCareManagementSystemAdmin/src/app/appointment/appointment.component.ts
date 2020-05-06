import { Component, OnInit } from '@angular/core';
import { AdminserviceService } from '../service/adminservice.service';
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

  /*****************************************************************************
     * creating centres array of DiagnosticCentre type to store the centre detail 
    *****************************************************************************/

  centres: DiagnosticCentre[];

  /*************************************************************************
   * creating centreId instance for every time manupulate the data
   *************************************************************************/

  centreId: DiagnosticCentre;

  /*****************************************************************************
   * creating tests array of Test type to store the Test detail 
  /*****************************************************************************/

  tests: Test[];

  /*************************************************************************
   * creating testId instance for every time manupulate the data
   *************************************************************************/

  testId: Test;

  /*****************************************************************************
   * creating users array of User type to store the User detail 
  /*****************************************************************************/

  users: User[];

  /*************************************************************************
   * creating userId instance for every time manupulate the data
   *************************************************************************/

  userId: User;

  /**********************************************************************************
   * creating appointments array of Appointment type to store the Appointment detail 
  /**********************************************************************************/

  appointments: Appointment[];

  /*************************************************************************************
   * creating appointmentList array of Appointment type to store the Appointment detail 
  /*************************************************************************************/

  appointmentList: Array<Appointment> = [];

  /*************************************************************************
   * creating msg and errorMsg of string type to pass exception 
   ************************************************************************/

  msg: string;
  errorMsg: string;


  constructor(private adminService: AdminserviceService, private router: Router) { }

  /*********************************************************************
   * Method: ngOnInit is life cycle hook called by angular at first
   * Description: ngOnInit first check the flag value if it is true then check
   *              and loads all the Appointment in the starting and it is
   *              checking if Appointment array length is zero then load Appointment 
   *              and set the Appointment into the current array
   * Created Date: 27 APR 2020
   * Author: Princy Pandey
   ************************************************************************/

  ngOnInit() {
    console.log("inside ngOninit centre component");

    this.adminService.getAppointment().subscribe(data => { this.appointments = data; });
    this.adminService.getTest().subscribe(data => { this.tests = data; });
    this.adminService.getCentre().subscribe(data => { this.centres = data; });
    this.adminService.getUser().subscribe(data => { this.users = data; });

  }

  appointment(): void {
    alert('Approved');

  }


  val: Boolean = false;
  showDetails() {
    this.val = !this.val;
    this.appointmentList.forEach(element => {
      //console.log(element.test_id+" "+element.test_name+" ");
    });
  }

  ngOnDestroy() {
    this.appointmentList.slice();
  }

}
