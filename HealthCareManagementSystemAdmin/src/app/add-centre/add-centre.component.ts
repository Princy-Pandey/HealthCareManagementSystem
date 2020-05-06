import { Component, OnInit } from '@angular/core';
import { AdminserviceService } from '../service/adminservice.service';
import { DiagnosticCentre } from '../diagnostic-centre';

@Component({
  selector: 'app-add-centre',
  templateUrl: './add-centre.component.html',
  styleUrls: ['./add-centre.component.css']
})
export class AddCentreComponent implements OnInit {

  centre:DiagnosticCentre=new DiagnosticCentre();
  centres:DiagnosticCentre[];
  centreList: Array<DiagnosticCentre> = [];
  msg:string;
  errorMsg:string;

  constructor(private adminService:AdminserviceService ) { }

  ngOnInit(): void {
    console.log("inside ngOninit centre component");
    
      this.adminService.getCentre().subscribe(
        data =>{this.centres=data;
        }
       );

  }

  addCentre()
  {
    this.adminService.addCentre(this.centre).subscribe((data)=>{
      console.log("data",data);
      this.msg=data;
      this.errorMsg=undefined;
      this.centre=new DiagnosticCentre()},

      error=>{
      this.errorMsg=JSON.parse(error.error).message;
      console.log(error.error);
      this.msg=undefined});
    //alert('Added successfully');
    }
  

  val:Boolean=false;
      showDetails()
      
      {
        this.val=!this.val;
        this.centreList.forEach(element => {
         console.log(element.centreId+" "+element.centreName+" "+element.centreContactNumber+" "+element.centreAddress);
      });
    }

    addDetails()
    {
      document.getElementById("myForm").style.display = "block";
    }

ngOnDestroy() {
  this.centreList.slice();
    }

    

  }
