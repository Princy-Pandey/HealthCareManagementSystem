import { Component, OnInit } from '@angular/core';
import { Test } from '../test';
import { AdminserviceService } from '../service/adminservice.service';
import { Router } from '@angular/router';
import { DiagnosticCentre } from '../diagnostic-centre';


@Component({
  selector: 'app-add-test',
  templateUrl: './add-test.component.html',
  styleUrls: ['./add-test.component.css']
})
export class AddTestComponent implements OnInit {

  /*****************************************************************************
   * creating centres array of DiagnosticCentre type to store the centre detail 
  /*****************************************************************************/

  centres: DiagnosticCentre[];

  /*************************************************************************
   * creating centre instance for every time manupulate the data
   *************************************************************************/

  centre: DiagnosticCentre;

  /*************************************************************************
   * creating test instance for every time manupulate the data
   *************************************************************************/

  test: Test = new Test();

  /*****************************************************************************
   * creating tests array of Test type to store the Test detail 
  /*****************************************************************************/

  tests: Test[] = [];

  /*****************************************************************************
   * creating testList array of Test type to store the Test detail 
  /*****************************************************************************/

  testList: Array<Test> = [];

  /*************************************************************************
   * creating msg and errorMsg of string type to pass exception 
   ************************************************************************/

  msg: string;
  errorMsg: string;

  constructor(private adminService: AdminserviceService, private router: Router) { }

  /*********************************************************************
   * Method: ngOnInit is life cycle hook called by angular at first
   * Description: ngOnInit first check the flag value if it is true then check
   *              and loads all the test in the starting and it is
   *              checking if test array length is zero then load test 
   *              and set the test into the current array
   * Created Date: 27 APR 2020
   * Author: Princy Pandey
   ************************************************************************/

  ngOnInit() {

    this.adminService.getTest().subscribe(data => { this.tests = data; });

    this.adminService.getCentre().subscribe(data => { this.centres = data; });

  }

  /********************************************************************************
   * Method: addTest
   * params: test
   * return: msg based on action
   * Description: this method call service addTest method and add tests every time
   *              and routes the page to display all test detail after adding
   * Created Date: 27 APR 2020
   * Author: Princy Pandey
   **********************************************************************************/

  addTest() {
    this.adminService.addTest(this.test).subscribe((data) => {
      console.log("data", data);
      this.msg = data;
      this.errorMsg = undefined;
      this.test = new Test()
    },

      error => {
        this.errorMsg = JSON.parse(error.error).message;
        console.log(error.error);
        this.msg = undefined
      });
    //alert('Added successfully');
  }



  val: Boolean = false;
  showDetails() {
    this.val = !this.val;
    this.testList.forEach(element => {
      console.log(element.testId + " " + element.testName + " ");
    });
  }



  ngOnDestroy() {
    this.testList.slice();
  }




}
