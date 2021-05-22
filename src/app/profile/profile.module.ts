import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';
import { ProfileComponent } from './profile.component';
import { ListprofilesComponent } from './listprofiles/listprofiles.component';
import { ProfildetailsComponent } from './profildetails/profildetails.component';
import { EditprofileComponent } from './editprofile/editprofile.component';
import { MatInputModule } from '@angular/material/input';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { InputSwitchModule } from 'primeng/inputswitch';
import { CalendarModule } from 'primeng/calendar';
import { ToastModule } from 'primeng/toast';
import { MatSelectModule } from '@angular/material/select';
import { RestpasswordComponent } from './editprofile/restpassword/restpassword.component';
import { PersonalinformationComponent } from './editprofile/personalinformation/personalinformation.component';



const routes: Routes = [
  {
    path: '', component: ProfileComponent, children: [
      {
        path: 'edit', component: EditprofileComponent, children: [
          { path: 'personalinformations', component: PersonalinformationComponent },
          { path: 'restpassword', component: RestpasswordComponent }
        ]
      },
      { path: 'list', component: ListprofilesComponent },
      { path: 'details', component: ProfildetailsComponent }
    ]
  },
];

@NgModule({
  declarations: [ProfileComponent, ListprofilesComponent, ProfildetailsComponent, EditprofileComponent,PersonalinformationComponent,RestpasswordComponent],
  imports: [
    CommonModule,
    MatInputModule,
    FormsModule,
    ReactiveFormsModule,
    InputSwitchModule,
    CalendarModule,
    ToastModule,
    MatSelectModule,
    RouterModule.forChild(routes)
  ]
})
export class ProfileModule { }
