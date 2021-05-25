import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DashbordService {

  constructor(private httpClient: HttpClient) { }
  SERVER_URL = "http://localhost:8082/keycloak";



  public getDashbordInfo() {
    return this.httpClient.get(this.SERVER_URL + "/getRealmSession");
  }

}
