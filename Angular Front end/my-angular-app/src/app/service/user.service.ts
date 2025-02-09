import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {UserAuthService} from "./user-auth.service";
import { Signup } from '../dto/signup';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private BASE_URL = "http://localhost:8084";

  private requestHeader = new HttpHeaders({
    "No-Auth": "True"
  });

  constructor(private httpClient: HttpClient,
              private userAuthService: UserAuthService) {
  }

  public login(loginData: any): Observable<any> {
    return this.httpClient.post(`${this.BASE_URL}/authentication`, loginData, {headers: this.requestHeader});
  }

  public registerNewUser(signup:Signup): Observable<Signup>{
     return this.httpClient.post<Signup>(`${this.BASE_URL}/user/register-new-user`,signup,{headers: this.requestHeader});  
  }

  // @ts-ignore
  public roleEqual(allowRoles): boolean {
    let isMatch = false;
    const userRoles: any = this.userAuthService.getRoles();

    if (userRoles != null && userRoles) {
      for (let i = 0; i < userRoles.length; i++) {
        for (let j = 0; j < allowRoles.length; j++) {
          if (userRoles[i].roleName === allowRoles[j]) {
            isMatch = true;
            console.log(allowRoles[j])
            return isMatch;
          } else {
            return isMatch;
          }
        }
      }
    }
  }
}
