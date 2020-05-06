import { Component, OnInit } from '@angular/core';
import { AdminserviceService } from '../service/adminservice.service';
import { DiagnosticCentre } from '../diagnostic-centre';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';




@Component({
  selector: 'app-delete-centre',
  templateUrl: './delete-centre.component.html',
  styleUrls: ['./delete-centre.component.css']
})
export class DeleteCentreComponent implements OnInit {

  centre:DiagnosticCentre=new DiagnosticCentre();
  centres:DiagnosticCentre[]=[];
  centreId:number;
  centreList: Array<DiagnosticCentre> = [];
  deleteMessage=false;
  msg:string;
  errorMsg:string;
  errorInfo:string=undefined;
  
  Info:string=undefined;

  successInfo:string=undefined;

  
  constructor(private adminService:AdminserviceService, private router:Router) { }

  ngOnInit(): void {
    this.adminService.getCentre().subscribe(
      data =>{this.centres=data;
      },
      error=>{ this.errorInfo=JSON.stringify(error.error.text);
        this.centreList=undefined;
        } );
     this.successInfo=this.adminService.successInfo;
     
  }
  update(centreId:number)
  {
    this.adminService.IdToUpdate=centreId;
  }
  /*deleteCentre(centre:DiagnosticCentre):void{
    console.log("Row Deleted!!")
    this.adminService.deleteCentre(centre).subscribe(data=>{this.centres=this.centres.filter(c=>c!==centre);})
    alert('Deleted successfully');
  }*/

  deleteCentre(centreId:number){
    console.log("Row Deleted!!")

    this.adminService.deleteCentre(centreId).subscribe(data=>{
      console.log(data);
      this.router.navigateByUrl("/delete-centre");
    },
    error=>console.log(error));
   // alert('Deleted successfully');
  }

  val:Boolean=false;
  showDetails()
  {
    this.val=!this.val;
    this.centreList.forEach(element => {
     console.log(element.centreId+" "+element.centreName+" "+element.centreContactNumber+" "+element.centreAddress);
  });
}

ngOnDestroy() {
this.centreList.slice();
}




}
