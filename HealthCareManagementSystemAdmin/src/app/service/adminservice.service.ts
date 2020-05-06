import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Test } from '../test';
import { DiagnosticCentre } from '../diagnostic-centre';


/************************************************************************************
 * @author             Princy Pandey  
 * Discription:        It is a service class that process action for adding,
 *                     removing and displaying centre,test,user and appointments 
 * Version             1.0 
 * Created             Date 22-APR-2020
 ************************************************************************************/

@Injectable({
  providedIn: 'root'
})
export class AdminserviceService {

  successInfo: string;
  IdToUpdate: number;

  getSuccessInfo(): string {

    return this.successInfo;
  }

  setSuccessInfo(msg: string) {

    this.successInfo = msg;
  }

  constructor(private http: HttpClient) {
  }

  /*********************************************************************
   * Method: getCentre
   * return: Observable
   * Description: this method is hitting json file 
   ************************************************************************/

  public getCentre(): Observable<any> {
    console.log("get centre");
    return this.http.get("http://localhost:8082/getCentre");
  }

  /*********************************************************************
   * Method: addCentre
   * params: centre
   * Description: this method pushing the data using centre instance
   ************************************************************************/

  public addCentre(centre: DiagnosticCentre): Observable<any> {
    console.log("add centre call");
    return this.http.post("http://localhost:8082/addCentre", centre, { responseType: 'text' });
  }

  /*********************************************************************
   * Method: deleteCentre 
   * params: centreId
   * return: DiagnosticCentre[]
   * Description: this method is deleting the value which we not need
   ************************************************************************/

  public deleteCentre(centreId: number): Observable<any> {
    console.log("deleted");
    //let endpoint=centreId;
    return this.http.delete<DiagnosticCentre>("http://localhost:8082/deleteCentre" + "/" + centreId);
  }

  /*********************************************************************
   * Method: updateCentre 
   * params: centreId
   * return: DiagnosticCentre[]
   * Description: this method is updating the value 
   ************************************************************************/

  public updateCentre(centre: DiagnosticCentre): Observable<any> {
    console.log("updated");
    let end = centre.centreId;
    return this.http.put<DiagnosticCentre>("http://localhost:8082/updateCentre/" + end, centre);
  }

  /*********************************************************************
   * Method: findById 
   * params: centreId
   * return: DiagnosticCentre[]
   * Description: this method is updating the value 
   ************************************************************************/

  public findById(centreId: number): Observable<any> {

    const httpOptions = {

      headers: new HttpHeaders({ 'Content-type': 'application/json' })
    };
    let endpoint = centreId
    return this.http.get("http://localhost:8082/viewcentrebyid/" + endpoint, httpOptions);
  }


  /*********************************************************************
   * Method: getTest
   * return: Observable
   * Description: this method is hitting json file 
   ************************************************************************/

  public getTest(): Observable<any> {
    console.log("get test");
    return this.http.get("http://localhost:8082/getTest");
  }

  /*********************************************************************
   * Method: addTest
   * params: test
   * Description: this method pushing the data using test instance
   ************************************************************************/

  public addTest(test: Test): Observable<any> {
    console.log("add test call");
    return this.http.post("http://localhost:8082/addTest", test, { responseType: 'text' });
  }

  /*********************************************************************
   * Method: deleteTest 
   * params: testId
   * return: Test[]
   * Description: this method is deleting the value which we not need
   ************************************************************************/

  public deleteTest(testId: number): Observable<any> {
    console.log("delete test call");
    let endpoint = testId;
    return this.http.delete<Test>("http://localhost:8082/deleteTest/" + endpoint);
  }


  /*********************************************************************
   * Method: getAppointment
   * return: Observable
   * Description: this method is hitting json file 
   ************************************************************************/

  public getAppointment(): Observable<any> {
    console.log("get appointment");
    return this.http.get("http://localhost:8082/getAppointment");
  }

  /*********************************************************************
   * Method: getUser
   * return: Observable
   * Description: this method is hitting json file 
   ************************************************************************/

  public getUser(): Observable<any> {
    console.log("get user");
    return this.http.get("http://localhost:8082/getUser");
  }


}
