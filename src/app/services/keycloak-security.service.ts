import { ClassMethod } from '@angular/compiler';
import { Injectable } from '@angular/core';
import { KeycloakInstance } from "keycloak-js";
import { LocalStorageService } from './local-storage.service';
declare var Keycloak: any;

@Injectable({
  providedIn: 'root'
})
export class KeycloakSecurityService {

  public kc: KeycloakInstance;
  constructor(private ls: LocalStorageService) { }
  async init() {
    console.log("Security initialisation ...");
    this.kc = new Keycloak({
      url: "http://localhost:8080/",
      realm: "quarkus",
      clientId: "angularpfe"
    });
    await this.kc.init({
      onLoad: 'login-required'
      //onLoad: 'check-sso'
    });
    this.ls.saveItem("userId", this.kc.tokenParsed.sub);
    
    //this.ls.saveItem("")
    //console.log(this.kc.loadUserInfo());
    // console.log(this.kc.hasRealmRole("admin"));
  }
  getUserId():string{
    return this.kc.tokenParsed.sub;
  }
}


