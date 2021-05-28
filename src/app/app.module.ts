import { BrowserModule } from '@angular/platform-browser';
import { APP_INITIALIZER, NgModule } from '@angular/core';
import { FileUploadModule } from 'primeng/fileupload';
import { DialogModule } from 'primeng/dialog';
import { AppComponent } from './app.component';
import { SidebarComponent } from './sections/sidebar/sidebar.component';
import { HeaderComponent } from './sections/header/header.component';
import { SidebarrightComponent } from './sections/sidebarright/sidebarright.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatSliderModule } from '@angular/material/slider';
import { AddProjectComponent } from './project/add-project/add-project.component';
import { RouterModule, Routes } from '@angular/router';
import { MatTabsModule } from '@angular/material/tabs';
import { NewProjectComponent } from './project/new-project/new-project.component';
import { ListProjectComponent } from './project/list-project/list-project.component';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatInputModule } from '@angular/material/input';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatNativeDateModule } from '@angular/material/core';
import { MatCardModule } from '@angular/material/card';
import { DatePipe, registerLocaleData } from '@angular/common'
import { HttpClientModule } from '@angular/common/http';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { AngularEditorModule } from '@kolkov/angular-editor';
import { UploadComponent } from './project/upload/upload.component';
import { ButtonModule } from 'primeng/button';
import { NgxMatTagInputModule } from 'ngx-mat-tag-input';
import { MatSelectModule } from '@angular/material/select';
import { SliderModule } from 'primeng/slider';
import { TagModule } from 'primeng/tag';
import { MatProgressBarModule } from '@angular/material/progress-bar';
import { RatingModule } from 'primeng/rating';
import { AvatarModule } from 'primeng/avatar';
import { TableModule } from 'primeng/table';
import { ToastModule } from 'primeng/toast';
import { CalendarModule } from 'primeng/calendar';
import { MultiSelectModule } from 'primeng/multiselect';
import { ContextMenuModule } from 'primeng/contextmenu';
import { DropdownModule } from 'primeng/dropdown';
import { ProgressBarModule } from 'primeng/progressbar';
import { InputTextModule } from 'primeng/inputtext';
import { AvatarGroupModule } from 'primeng/avatargroup';
import { DemoComponent } from './project/demo/demo.component';
import { MatFormFieldModule } from '@angular/material/form-field';
import { NgxMatSelectSearchModule } from 'ngx-mat-select-search';
import { KeycloakSecurityService } from './services/keycloak-security.service';
import { TooltipModule } from 'primeng/tooltip';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { ConfirmDialogModule } from 'primeng/confirmdialog';
import { MatMenuModule } from '@angular/material/menu';
import { NZ_I18N } from 'ng-zorro-antd/i18n';
import { en_US } from 'ng-zorro-antd/i18n';
import en from '@angular/common/locales/en';
import { NzButtonModule } from 'ng-zorro-antd/button';
import { NzDatePickerModule } from 'ng-zorro-antd/date-picker';
import { NzPopoverModule } from 'ng-zorro-antd/popover';
import { NzSelectModule } from 'ng-zorro-antd/select';
import { NzIconModule } from 'ng-zorro-antd/icon';
import { NzCommentModule } from 'ng-zorro-antd/comment';
import { NzFormModule } from 'ng-zorro-antd/form';
import { NzAvatarModule } from 'ng-zorro-antd/avatar';
import { NzListModule } from 'ng-zorro-antd/list';
import { InputTextareaModule } from 'primeng/inputtextarea';
import { NzSpinModule } from 'ng-zorro-antd/spin';
import { NzModalModule } from 'ng-zorro-antd/modal';
import { FullCalendarModule } from '@fullcalendar/angular'; // the main connector. must go first
import dayGridPlugin from '@fullcalendar/daygrid'; // a plugin
import interactionPlugin from '@fullcalendar/interaction'; // a plugin
import timeGridPlugin from '@fullcalendar/timegrid';
import { NzResultModule } from 'ng-zorro-antd/result';




registerLocaleData(en);
export function kcFactory(kcSecurity: KeycloakSecurityService) {
  return () => kcSecurity.init();
}


FullCalendarModule.registerPlugins([ // register FullCalendar plugins
  dayGridPlugin,
  interactionPlugin,
  timeGridPlugin
]);

const routes: Routes = [
  { path: "project", component: DemoComponent },
  { path: "newproject", component: NewProjectComponent },
  { path: 'profile', loadChildren: () => import('./profile/profile.module').then(m => m.ProfileModule) },
  { path: 'dashbord', loadChildren: () => import('./admin/admin.module').then(m => m.AdminModule) }


];

@NgModule({
  declarations: [
    AppComponent,
    SidebarComponent,
    HeaderComponent,
    SidebarrightComponent,
    AddProjectComponent,
    NewProjectComponent,
    ListProjectComponent,
    UploadComponent,
    DemoComponent
  ],
  imports: [
    BrowserModule, MatSliderModule, BrowserAnimationsModule, MatTabsModule, MatGridListModule, MatInputModule, MatDatepickerModule,
    RouterModule.forRoot(routes), FormsModule, ReactiveFormsModule, MatNativeDateModule, MatCardModule, HttpClientModule, MatSnackBarModule,
    AngularEditorModule, DialogModule, ButtonModule, FileUploadModule, NgxMatTagInputModule, MatSelectModule, SliderModule, TagModule, MatProgressBarModule,
    RatingModule, AvatarModule, AvatarGroupModule, MultiSelectModule, MatFormFieldModule, NgxMatSelectSearchModule,
    TableModule, ToastModule, CalendarModule, ContextMenuModule, DropdownModule, ProgressBarModule, InputTextModule, TooltipModule, NgbModule,
    ConfirmDialogModule, MatMenuModule, NzButtonModule, NzDatePickerModule, NzPopoverModule, NzSelectModule, NzIconModule,
    NzCommentModule, NzFormModule, NzAvatarModule, NzListModule, InputTextareaModule, NzSpinModule, FullCalendarModule, NzModalModule, NzResultModule


  ],
  providers: [DatePipe, { provide: APP_INITIALIZER, deps: [KeycloakSecurityService], useFactory: kcFactory, multi: true }, { provide: NZ_I18N, useValue: en_US }],
  bootstrap: [AppComponent]
})
export class AppModule { }
