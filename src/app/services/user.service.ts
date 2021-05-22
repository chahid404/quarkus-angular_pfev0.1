import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Users } from '../models/project/user.module';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private httpClient: HttpClient) { }
  SERVER_URL = "http://localhost:8082/keycloak";



  public getAllUsers() {
    return this.httpClient.get<Users[]>(this.SERVER_URL+"/getallusers");
  }

  public getUserById(id) {
    return this.httpClient.get<Users>(this.SERVER_URL + "/getuserbyid/" + id);
  }

  public updateUser(id,user:any) {
    return this.httpClient.put<Users>(this.SERVER_URL + "/updateuser/" + id,user);
  }

  public resetPassword(iduser:string,oldpass:string,newpass:string) {
    return this.httpClient.get<Users>(this.SERVER_URL + "/restpassword/" + iduser+"/"+oldpass+"/"+newpass);
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
