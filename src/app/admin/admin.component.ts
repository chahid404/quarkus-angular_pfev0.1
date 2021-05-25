import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MessageService } from 'primeng/api';
import { Users } from '../models/project/user.module';
import { DashbordService } from '../services/dashbord.service';
import { KeycloakSecurityService } from '../services/keycloak-security.service';
import { UserService } from '../services/user.service';
import { interval, Subscription } from 'rxjs';



@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  providers: [MessageService],
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {
  public isVisible: boolean = false;
  public isLoading: boolean = false
  public userList: Users[] = [];
  public isLoadingData: boolean = true;
  public isLoadingTable: boolean = true;
  public isConfirmLoading: boolean;
  public searchQuary: string = "";
  public dashbordInformations: any = "";
  private mySubscription: Subscription;
  private SERVER_URL = "http://localhost:8082/keycloak/download?filename=";
  public newUserForm = new FormGroup({
    firstName: new FormControl('', [
      Validators.required,
    ]),
    lastName: new FormControl('', [
      Validators.required,
    ]),
    username: new FormControl('', [
      Validators.required,
    ]),
    email: new FormControl('', [
      Validators.required,
      Validators.email,
    ])
  });


  constructor(
    private userService: UserService,
    private kcService: KeycloakSecurityService,
    private messageService: MessageService,
    private dIService: DashbordService,
  ) {
    this.mySubscription = interval(30000).subscribe((x => {
      this.getDashbordInformations();
    }));
  }
  get newUserFormControl() {
    return this.newUserForm.controls;
  }
  ngOnInit(): void {
    this.getAllUser();
    this.getDashbordInformations();
  }

  getAllUser() {
    this.isLoadingTable = true;
    this.userService.getAllUsersMinesCurrentUserWithSearch(this.kcService.getUserId(), this.searchQuary).subscribe(users => {
      this.userList = users;
      this.isLoadingTable = false;
    }, err => {
      this.messageService.add({ severity: 'error', summary: err.statusText, detail: err.status });
    });
  }

  showModal(): void {
    this.isVisible = true;
  }

  handleOk(): void {
    this.isConfirmLoading = true;
    console.log(this.newUserForm.value);
    this.userService.createUser(this.newUserForm.value).subscribe(user => {
      this.getAllUser();
      this.messageService.add({ severity: 'success', summary: "success", detail: "User created successfully" });
      this.newUserForm.reset();
      this.isConfirmLoading = false;
      this.isVisible = false;
    }, err => {
      if (err.status === 302) {
        this.messageService.add({ severity: 'error', summary: err.statusText, detail: "user already exist" });
      } else {
        this.messageService.add({ severity: 'error', summary: err.statusText, detail: err.status });
      }
      this.isVisible = false;
      this.isConfirmLoading = false;
    });
  }

  handleCancel(): void {
    this.newUserForm.reset();
    this.isVisible = false;
  }
  changeUserStatus(userid) {
    this.userService.changeUserStatus(userid).subscribe(x => {
      this.messageService.add({ severity: 'success', summary: "success", detail: "User status changed successfully" });
      this.getAllUser();
    }, err => {
      this.messageService.add({ severity: 'error', summary: err.statusText, detail: err.status });
    })
  }

  getDashbordInformations() {
    this.isLoadingData = true;
    this.dIService.getDashbordInfo().subscribe(info => {
      console.log(info);
      this.dashbordInformations = info;
      this.isLoadingData = false;
    }, err => {
      this.messageService.add({ severity: 'error', summary: "dashbord " + err.statusText, detail: err.status });
    });
  }
  urlserver(imgUrl): string {
    return this.SERVER_URL + imgUrl;
  }
}
