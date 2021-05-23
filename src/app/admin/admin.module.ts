import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';
import { AdminComponent } from './admin.component';
import { MatInputModule } from '@angular/material/input';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { InputSwitchModule } from 'primeng/inputswitch';
import { CalendarModule } from 'primeng/calendar';
import { ToastModule } from 'primeng/toast';
import { MatSelectModule } from '@angular/material/select';
import { NzSpinModule } from 'ng-zorro-antd/spin';
import { NzTableModule } from 'ng-zorro-antd/table';
import { AvatarModule } from 'primeng/avatar';
import { TagModule } from 'primeng/tag';
import { NzButtonModule } from 'ng-zorro-antd/button';
import { NzModalModule } from 'ng-zorro-antd/modal';

const routes: Routes = [
  { path: '', component: AdminComponent }
];

@NgModule({
  declarations: [AdminComponent],
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
    NzTableModule,
    AvatarModule,
    TagModule,
    NzButtonModule,
    NzModalModule,
    RouterModule.forChild(routes)
  ]

})
export class AdminModule { }
