import { Component, OnInit } from '@angular/core';
import { AdminserviceService } from './service/adminservice.service';
import { Router } from '@angular/router';
import { FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'HealthCareManagementSystemAdmin';

  constructor(){}
    

  ngOnInit() {}
}
