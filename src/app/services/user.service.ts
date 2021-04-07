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

  public getAllUsers() {
    return this.httpClient.get<Users[]>(this.SERVER_URL);
  }

  public getUserById(id) {
    return this.httpClient.get<Users>(this.SERVER_URL + "/byid/" + id);
  }
}
