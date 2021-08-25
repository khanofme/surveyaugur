import { Injectable } from '@angular/core';
import {HttpClient, HttpErrorResponse, HttpParams} from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';


import {Observable, throwError} from 'rxjs';
import { catchError } from 'rxjs/operators';

import { ProfileData } from './profileData';

const httpOptions = {
    headers: new HttpHeaders({
        'Content-Type': 'application/json',
        Authorization: 'my-auth-token'
    })
};

@Injectable({
    providedIn: 'root'
  })
export class ProfileService {
    // Add userid here
    url = '/userservice/api/v1/users/';

    constructor(
        private http: HttpClient) {

    }

    getProfile(): Observable<ProfileData> {
        return this.http.get<ProfileData>(this.url).pipe(catchError(this.handleError));
    }

    saveProfile(profileData: ProfileData): Observable<ProfileData> {
        // httpOptions.headers =
        //   httpOptions.headers.set('Authorization', 'my-new-auth-token');

        return this.http.put<ProfileData>(this.url, profileData, httpOptions).pipe(catchError(this.handleError));
    }
  handleError(error:HttpErrorResponse) {
    return throwError(error.status)
  }

}
