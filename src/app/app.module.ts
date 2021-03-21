import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
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
import { DatePipe } from '@angular/common'
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
;








const routes: Routes = [
  { path: "project", component: AddProjectComponent },

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
    UploadComponent
  ],
  imports: [
    BrowserModule,
    MatSliderModule,
    BrowserAnimationsModule,
    MatTabsModule,
    MatGridListModule,
    MatInputModule,
    MatDatepickerModule,
    RouterModule.forRoot(routes),
    FormsModule,
    ReactiveFormsModule,
    MatNativeDateModule,
    MatCardModule,
    HttpClientModule,
    MatSnackBarModule,
    AngularEditorModule,
    DialogModule,
    ButtonModule,
    FileUploadModule,
    NgxMatTagInputModule,
    MatSelectModule,
    SliderModule, TagModule,
    MatProgressBarModule

  ],
  providers: [DatePipe],
  bootstrap: [AppComponent]
})
export class AppModule { }
