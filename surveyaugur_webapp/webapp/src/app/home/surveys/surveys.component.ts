import {HttpClient, HttpErrorResponse} from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { UserinfoService } from 'src/app/service/userinfo.service';
import { ActiveSurveys } from './model/activeSurvey';
import { InActiveSurvey } from './model/inactiveSurvey';
import { MatTableDataSource } from "@angular/material/table";
import {catchError} from "rxjs/operators";
import {throwError} from "rxjs";
import {Router} from "@angular/router";


@Component({
  selector: 'app-surveys',
  templateUrl: './surveys.component.html',
  styleUrls: ['./surveys.component.css']
})
export class SurveysComponent implements OnInit {
  displayedColumns: string[] = ['position', 'name', 'updates', 'Actions'];
  dataSource: MatTableDataSource<ActiveSurveys>;
  dataSource1: MatTableDataSource<InActiveSurvey>;

  activeById: ActiveSurveys[] = [];
  inactiveSurvey: InActiveSurvey[] = [];
  activeSurvey: ActiveSurveys[] = []

  constructor(private http: HttpClient, private user: UserinfoService,private router:Router) { }
  ngOnInit(): void {
    setInterval(() => this.http.get("/surveyauthor/api/v1/surveys/users/" + this.user.userId).pipe(catchError(this.handleError)).subscribe((data) => {
      this.inactiveSurvey = [];
      this.inactiveSurvey = data["result"];
      console.log(data);
      console.log(this.inactiveSurvey)
      this.dataSource1 = new MatTableDataSource<InActiveSurvey>(this.inactiveSurvey);

    },(error)=>{
      console.log(error);

        this.router.navigateByUrl('/error',{state: {errorCode:error}})
      }), 10)

    setInterval(() => {
      this.http.get("/surveyengine/api/v1/surveys").pipe(catchError(this.handleError)).subscribe((data) => {
        console.log(data["result"])
        this.activeSurvey = data["result"]

        console.log(this.activeSurvey);
        this.activeById = [];
        this.getById()

        console.log(this.activeById)
        this.dataSource = new MatTableDataSource<ActiveSurveys>(this.activeById);
      },(error)=>{
        console.log(error);
  
          this.router.navigateByUrl('/error',{state: {errorCode:error}})
        })
    }, 10)
  }
  getById() {
    for (let i = 0; i < this.activeSurvey.length; i++) {
      if (this.activeSurvey[i].createdBy === this.user.userId) {
        this.activeById.push(this.activeSurvey[i]);
      }
    }
  }
  handleError(error:HttpErrorResponse) {
    return throwError(error.status)
  }


}









