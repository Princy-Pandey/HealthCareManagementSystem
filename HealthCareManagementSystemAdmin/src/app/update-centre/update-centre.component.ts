import { Component, OnInit } from '@angular/core';
import { AdminserviceService } from '../service/adminservice.service';
import { Router } from '@angular/router';
import { DiagnosticCentre } from '../diagnostic-centre';

@Component({
  selector: 'app-update-centre',
  templateUrl: './update-centre.component.html',
  styleUrls: ['./update-centre.component.css']
})
export class UpdateCentreComponent implements OnInit {

  centre:DiagnosticCentre=new DiagnosticCentre();
  centreId:number;
  errorInfo:string=undefined;
  info:string=undefined;
  updateId:number;

  
  constructor(private adminService:AdminserviceService, private router:Router) { }

  ngOnInit(){
     this.updateId=this.adminService.IdToUpdate;
    this.adminService.findById(this.updateId).subscribe(data=>this.centre=data);
  }

  updateCentre(){
    console.log("Row Updated!!")
    this.adminService.updateCentre(this.centre).subscribe(data=>
      {
        this.centre=data;
        this.info=data;
        this.errorInfo=undefined;
      },error=>{
        this.info=undefined;
        this.errorInfo=JSON.stringify(error.error.text);
      }
      );
      
     // alert('Updated successfully');
  }

   
    
  

}
