import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { MessageService } from 'primeng/api';
import { KeycloakSecurityService } from 'src/app/services/keycloak-security.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-restpassword',
  templateUrl: './restpassword.component.html',
  providers: [MessageService],
  styleUrls: ['./restpassword.component.css']
})
export class RestpasswordComponent implements OnInit {
  public isLoading: boolean = false;
  public restPasswordForum = new FormGroup({
    oldpassword: new FormControl(''),
    newPassword: new FormControl(''),
    repeatnewPassword: new FormControl('')
  });
  constructor(
    private userService: UserService,
    private kcService: KeycloakSecurityService,
    private messageService: MessageService
  ) { }

  ngOnInit(): void {
    this.restPasswordForum.reset();
  }


  onSubmit() {
    this.isLoading = true;
    console.log(this.restPasswordForum);

    if (this.restPasswordForum.value.oldpassword === this.restPasswordForum.value.newPassword) {
      this.messageService.add({ severity: 'error', summary: "Worng Password", detail: "old and new password are the same" });

    } else if (this.restPasswordForum.value.newPassword != this.restPasswordForum.value.repeatnewPassword) {
      this.messageService.add({ severity: 'error', summary: "Worng Password", detail: "Please enter the same password" });

    } else {
      this.userService.resetPassword(this.kcService.getUserId(), this.restPasswordForum.value.oldpassword, this.restPasswordForum.value.newPassword).subscribe(x => {
        this.messageService.add({ severity: 'success', summary: 'success', detail: 'Password update successfully' });
        console.log(x);
      }, err => {
        console.log(err);
        this.messageService.add({ severity: 'error', summary: "Worng Password", detail: "Please try again" });
      });
      this.restPasswordForum.reset();
    } 
    this.isLoading = false;
  }


}
