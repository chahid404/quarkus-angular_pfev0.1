import { Component, OnInit } from '@angular/core';
import { KeycloakSecurityService } from 'src/app/services/keycloak-security.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(public kcService: KeycloakSecurityService) { }

  ngOnInit(): void {
    console.log(this.kcService.kc.tokenParsed.sub);
  }
  onLogout() {
    this.kcService.kc.logout();
  }
  onLogin() {
    this.kcService.kc.login();
  }
}
