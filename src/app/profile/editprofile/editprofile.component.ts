import { Component, OnInit } from '@angular/core';
import { Users } from 'src/app/models/project/user.module';
import { KeycloakSecurityService } from 'src/app/services/keycloak-security.service';
import { UserService } from 'src/app/services/user.service';
import {MessageService} from 'primeng/api';

@Component({
  selector: 'app-editprofile',
  templateUrl: './editprofile.component.html',
  providers: [MessageService],
  styleUrls: ['./editprofile.component.css'
]
})
export class EditprofileComponent implements OnInit {
  public currentUser:Users = new Users();
  
  constructor(
    private userService:UserService,
    private kcService:KeycloakSecurityService,
    private messageService: MessageService
    ) { }

  ngOnInit(): void {    
    this.userService.getUserById(this.kcService.getUserId()).subscribe(user=>{
      this.currentUser = user;
    },err=>{
      console.log(err);
      this.messageService.add({severity:'error', summary: err.statusText, detail:err.status});
    });
    
  }

 
}
