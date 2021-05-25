import { Component, OnInit } from '@angular/core';
import { Users } from 'src/app/models/project/user.module';
import { KeycloakSecurityService } from 'src/app/services/keycloak-security.service';
import { UserService } from 'src/app/services/user.service';
import { MessageService } from 'primeng/api';
import { FormControl } from "@angular/forms";
import { FileValidators } from "ngx-file-drag-drop";
import { NzUploadFile } from 'ng-zorro-antd/upload';


@Component({
  selector: 'app-editprofile',
  templateUrl: './editprofile.component.html',
  providers: [MessageService],
  styleUrls: ['./editprofile.component.scss'
  ]
})
export class EditprofileComponent implements OnInit {
  public currentUser: Users = new Users();
  public onLoadPhoto: boolean = true;
  public SERVER_URL = "http://localhost:8082/keycloak/download?filename=";
  public formData = new FormData();
  fileControl = new FormControl(
    [],
    [FileValidators.required,
    FileValidators.maxFileCount(2)]
  );

  constructor(
    private userService: UserService,
    private kcService: KeycloakSecurityService,
    private messageService: MessageService
  ) { }

  urlserver(imgUrl): string {
    return this.SERVER_URL + imgUrl;
  }
  ngOnInit(): void {
    this.userService.getUserById(this.kcService.getUserId()).subscribe(user => {
      this.currentUser = user;
      this.onLoadPhoto = false;
    }, err => {
      console.log(err);
      this.messageService.add({ severity: 'error', summary: err.statusText, detail: err.status });
    });
    this.fileControl.valueChanges.subscribe((files: File[]) =>
      console.log(this.fileControl.value, this.fileControl.valid)
    );
  }
  uploadProfilePic() {
    this.onLoadPhoto = true;
    console.log(this.formData);
    this.userService.updateUserPic(this.kcService.getUserId(), this.formData).subscribe(user => {
      this.currentUser.attributes.imgUrl = user.attributes.imgUrl;
      this.messageService.add({ severity: 'success', summary: "Successfully", detail: "User Profile Pic update successfully !" });
      this.onLoadPhoto = false;
    }, err => {
      console.log(err);
      this.messageService.add({ severity: 'error', summary: err.statusText, detail: err.status });
    })
  }

  onValueChange(file: File[], event) {
    console.log(file[0].name);
    console.log(event);
    this.formData.append('file', file[0]);
    this.formData.append('fileName', file[0].name);
  }

}
