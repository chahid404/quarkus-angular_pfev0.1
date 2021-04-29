import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Users } from '../models/project/user.module';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private httpClient: HttpClient) { }
  SERVER_URL = "http://localhost:8083/users";
  private user:Users;
  public getAllUsers() {
    return this.httpClient.get<Users[]>(this.SERVER_URL);
  }

  public getUserById(id) {
    return this.httpClient.get<Users>(this.SERVER_URL + "/byid/" + id);
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
  public returnUserFullName(userid):Users{
    this.getUserById(userid).subscribe(x=>{
      this.user=x;
    });
    console.log(this.user);
    return this.user;
  }
}
