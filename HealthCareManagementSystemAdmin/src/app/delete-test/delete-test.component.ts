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

  centres:DiagnosticCentre[];
  tests:Test[]=[];
  centre:DiagnosticCentre;
  testList: Array<Test> = [];
  deleteMessage=false;
  msg:string;
  errorMsg:string;
  Info:string;
  

  constructor(private adminService:AdminserviceService,private router:Router) { }

  ngOnInit(){
   this.adminService.getTest().subscribe(data =>{this.tests=data;});
   this.adminService.getCentre().subscribe(data =>{this.centres=data;});
  }

  deleteTest(testId:number){
    console.log("Row Deleted!!")
    this.adminService.deleteTest(testId).subscribe(data=>{this.tests=data;})
    //alert('Deleted successfully');
  }

      val:Boolean=false;
      showDetails()
      {
        this.val=!this.val;
        this.testList.forEach(element => {
         console.log(element.testId+" "+element.testName+" ");
      });
    }



ngOnDestroy() {
  this.testList.slice();
}

}
