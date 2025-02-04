import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private BASE_URL = "http://localhost:8084";

  constructor(private httpClient: HttpClient) { }

  // Make sure to type the login request and response data properly
  public login(loginData: any): Observable<any> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'  // Set Content-Type header
    });

    return this.httpClient.post<any>(`${this.BASE_URL}/authentication`, loginData, { headers });
  }
}
