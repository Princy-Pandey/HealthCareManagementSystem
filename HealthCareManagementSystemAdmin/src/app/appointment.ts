import { User } from './user';
import { Test } from './test';
import { DiagnosticCentre } from './diagnostic-centre';


export class Appointment {

    appointmentId:number;
    userId:User=new User();
    centreId:DiagnosticCentre=new DiagnosticCentre();
    testId:Test=new Test();
    appointmentDate:Date;
    appointmentTime:string;
    approvalStatus:boolean;

    
}
