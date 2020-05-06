import { Component, OnInit } from '@angular/core';
import { Test } from '../test';
import { AdminserviceService } from '../service/adminservice.service';
import { DiagnosticCentre } from '../diagnostic-centre';
import { Router } from '@angular/router';


@Component({
  selector: 'app-delete-test',
  templateUrl: './delete-test.component.html',
  styleUrls: ['./delete-test.component.css']
})
export class DeleteTestComponent implements OnInit {

  /*****************************************************************************
   * creating centres array of DiagnosticCentre type to store the centre detail 
  /*****************************************************************************/

  centres: DiagnosticCentre[];

  /*************************************************************************
   * creating centre instance for every time manupulate the data
   *************************************************************************/

  centre: DiagnosticCentre;

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

  /*********************************************************************
   * Method: deleteTest
   * params: testId
   * return: void
   * Description: this method collecting the value from service deleteTest method
   *              and delete the specific test
   *              
   * Created Date: 28 APR 2020
   * Author: Princy Pandey
   ************************************************************************/

  deleteTest(testId: number) {
    console.log("Row Deleted!!")
    this.adminService.deleteTest(testId).subscribe(data => { this.tests = data; })
    //alert('Deleted successfully');
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
