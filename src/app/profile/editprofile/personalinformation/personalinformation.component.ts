import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { MessageService } from 'primeng/api';
import { Users, UsersForUpdate } from 'src/app/models/project/user.module';
import { KeycloakSecurityService } from 'src/app/services/keycloak-security.service';
import { UserService } from 'src/app/services/user.service';
import { CountryList } from '../countryList.module';

@Component({
  selector: 'app-personalinformation',
  templateUrl: './personalinformation.component.html',
  providers: [MessageService],
  styleUrls: ['./personalinformation.component.css']
})
export class PersonalinformationComponent implements OnInit {

  public isLoading: boolean = false;
  public currentUser: Users = new Users();
  public genderList: string[] = ['Female', 'Male'];
  public allCountries = CountryList;
  public loadingData: boolean = true;
  currentUserForm = new FormGroup({
    firstName: new FormControl(''),
    lastName: new FormControl(''),
    username: new FormControl(''),
    email: new FormControl(''),
    enabled: new FormControl(''),
    attributes: new FormGroup({
      birthday: new FormControl(''),
      nationality: new FormControl(''),
      gender: new FormControl(''),
      telephone: new FormControl(''),
      zip_code: new FormControl('')
    })
  });


  constructor(
    private userService: UserService,
    private kcService: KeycloakSecurityService,
    private messageService: MessageService
  ) { }

  ngOnInit(): void {
    this.userService.getUserById(this.kcService.getUserId()).subscribe(user => {
      this.currentUser = user;
      this.currentUserForm.patchValue(user);
      this.loadingData = false;
    }, err => {
      console.log(err);
      this.messageService.add({ severity: 'error', summary: err.statusText, detail: "Please try again" });
    });

  }

  onSubmit() {
    this.isLoading = true;
    console.log(this.currentUserForm.value);
    let userBody: UsersForUpdate;
    userBody = this.currentUserForm.value;
    userBody.attributes.birthday = [this.currentUserForm.value.attributes.birthday];
    userBody.attributes.gender = [this.currentUserForm.value.attributes.gender];
    userBody.attributes.nationality = [this.currentUserForm.value.attributes.nationality];
    userBody.attributes.telephone = [this.currentUserForm.value.attributes.telephone];
    userBody.attributes.zip_code = [this.currentUserForm.value.attributes.zip_code];
    console.log(userBody);
    this.userService.updateUser(this.kcService.getUserId(), userBody).subscribe(user => {
      this.currentUserForm.patchValue(user);
      this.currentUser = user;
      this.messageService.add({ severity: 'success', summary: 'success', detail: 'Profile update successfully' });
    }, err => {
      console.log(err);
      this.messageService.add({ severity: 'error', summary: err.statusText, detail: err.status });
    })
    this.isLoading = false;
  }
  onRestForm() {
    this.currentUserForm.patchValue(this.currentUser);
  }

}
