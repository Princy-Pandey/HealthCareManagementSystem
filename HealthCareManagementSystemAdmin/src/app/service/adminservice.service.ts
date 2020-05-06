import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Test } from '../test';
import { DiagnosticCentre } from '../diagnostic-centre';




@Injectable({
  providedIn: 'root'
})
export class AdminserviceService {

  successInfo:string;
  IdToUpdate:number;

  getSuccessInfo():string{

    return this.successInfo;
}

setSuccessInfo(msg:string){

     this.successInfo=msg;
}

  constructor(private http: HttpClient) {
   }

   public getCentre():Observable<any>
  {
    console.log("get centre");
    return this.http.get("http://localhost:8082/getCentre");
  }

  public addCentre(centre:DiagnosticCentre):Observable<any>
  {
    console.log("add centre call");
    return this.http.post("http://localhost:8082/addCentre",centre,{responseType:'text'});
  }

  public deleteCentre(centreId:number):Observable<any>
  {
         console.log("deleted");
         //let endpoint=centreId;
         return this.http.delete<DiagnosticCentre>("http://localhost:8082/deleteCentre" +  "/" +centreId);
  }
  
  public updateCentre(centre:DiagnosticCentre):Observable<any>
  {
    console.log("updated");
         let end=centre.centreId;
         return this.http.put<DiagnosticCentre>("http://localhost:8082/updateCentre/"+end, centre);
  }



  public getTest():Observable<any>
  {
    console.log("get test");
    return this.http.get("http://localhost:8082/getTest");
  }
  public addTest(test:Test):Observable<any>
  {
    console.log("add test call");
    return this.http.post("http://localhost:8082/addTest",test,{responseType:'text'});
  }

  public deleteTest(testId:number):Observable<any>
  {
    console.log("delete test call");
    let endpoint=testId;
    return this.http.delete<Test>("http://localhost:8082/deleteTest/"+endpoint);
  }


  public getAppointment():Observable<any>
  {
    console.log("get appointment");
    return this.http.get("http://localhost:8082/getAppointment");
  }

  public getUser():Observable<any>
  {
    console.log("get user");
    return this.http.get("http://localhost:8082/getUser");
  }

  findById(centreId:number):Observable<any>{

    const httpOptions={

         headers:new HttpHeaders({'Content-type':'application/json'})
    };
    let endpoint=centreId
    return this.http.get("http://localhost:8082/viewcentrebyid/"+endpoint,httpOptions);
  }
}
