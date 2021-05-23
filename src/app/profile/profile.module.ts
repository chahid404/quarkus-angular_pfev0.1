import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';
import { ProfileComponent } from './profile.component';
import { EditprofileComponent } from './editprofile/editprofile.component';
import { MatInputModule } from '@angular/material/input';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { InputSwitchModule } from 'primeng/inputswitch';
import { CalendarModule } from 'primeng/calendar';
import { ToastModule } from 'primeng/toast';
import { MatSelectModule } from '@angular/material/select';
import { RestpasswordComponent } from './editprofile/restpassword/restpassword.component';
import { PersonalinformationComponent } from './editprofile/personalinformation/personalinformation.component';
import { NzSpinModule } from 'ng-zorro-antd/spin';



const routes: Routes = [
  {
    path: '', component: ProfileComponent, children: [
      {
        path: 'edit', component: EditprofileComponent, children: [
          { path: 'personalinformations', component: PersonalinformationComponent },
          { path: 'restpassword', component: RestpasswordComponent }
        ]
      }
    ]
  },
];

@NgModule({
  declarations: [ProfileComponent, EditprofileComponent, PersonalinformationComponent, RestpasswordComponent],
  imports: [
    CommonModule,
    MatInputModule,
    FormsModule,
    ReactiveFormsModule,
    InputSwitchModule,
    CalendarModule,
    ToastModule,
    MatSelectModule,
    NzSpinModule,
    RouterModule.forChild(routes)
  ]
})
export class ProfileModule { }
