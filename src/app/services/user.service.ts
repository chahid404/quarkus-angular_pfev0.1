import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Users } from '../models/project/user.module';
import { KeycloakSecurityService } from './keycloak-security.service';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private httpClient: HttpClient,
    private ks: KeycloakSecurityService) { }
  SERVER_URL = "http://localhost:8082/keycloak";



  public getAllUsers(): Observable<Users[]> {
    return this.httpClient.get<Users[]>(this.SERVER_URL + "/getallusers?search=&currentuser=" + this.ks.getUserId());
  }
  public getAllUsersv2() {
    return this.httpClient.get(this.SERVER_URL + "/getallusers?currentuser=" + this.ks.getUserId());
  }
  public getAllUsersMinesCurrentUserWithSearch(currentUser: string, searchParam: string) {
    return this.httpClient.get<Users[]>(this.SERVER_URL + "/getallusers?currentuser=" + currentUser + "&search=" + searchParam);
  }



  public getUserById(id) {
    return this.httpClient.get<Users>(this.SERVER_URL + "/getuserbyid/" + id);
  }
  createuser

  public createUser(newUser) {
    return this.httpClient.post(this.SERVER_URL + "/createuser", newUser);
  }

  public updateUser(id, user: any) {
    return this.httpClient.put<Users>(this.SERVER_URL + "/updateuser/" + id, user);
  }

  public changeUserStatus(id) {
    return this.httpClient.put<Users>(this.SERVER_URL + "/changeuserstatus/" + id, {});
  }



  public resetPassword(iduser: string, oldpass: string, newpass: string) {
    return this.httpClient.get<Users>(this.SERVER_URL + "/restpassword/" + iduser + "/" + oldpass + "/" + newpass);
  }

  public updateUserPic(userid: string, formData) {
    return this.httpClient.put<Users>(this.SERVER_URL + "/updateuserpic?userid=" + userid, formData);
  }




  public listOfMembers(array): Users[] {
    let usersAssigned: Users[] = [];
    array.forEach(userid => {
      this.getUserById(userid).subscribe(user => {
        usersAssigned.push(user);
      }, err => {
        console.log(err);
      })
    });
    return usersAssigned;
  }


  public returnUserFullName(userid: string): Users {
    let user: Users;

    this.getUserById(userid).subscribe(x => {
      user = x;
    });
    console.log(user);
    return user;
  }


}
