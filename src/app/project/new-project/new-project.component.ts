import { DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { ProjectService } from 'src/app/services/project.service';
import { MatSnackBar, MatSnackBarHorizontalPosition, MatSnackBarVerticalPosition } from '@angular/material/snack-bar';
import { ProjectSettingsService } from 'src/app/services/project-settings.service';

@Component({
  selector: 'app-new-project',
  templateUrl: './new-project.component.html',
  styleUrls: ['./new-project.component.css']
})
export class NewProjectComponent implements OnInit {
  constructor(public projectSettingsServ: ProjectSettingsService, public datepipe: DatePipe, public projectService: ProjectService, private _snackBar: MatSnackBar) { }
  public todayDate = new Date();
  horizontalPosition: MatSnackBarHorizontalPosition = 'end';
  verticalPosition: MatSnackBarVerticalPosition = 'bottom';
  public project = {
    name: "",
    description: "",
    creator: "",
    startDate: "",
    deadline: "",
    createdDate: "",
    documents: "",
    membres: "",
    progress: 0,
    status: "",
    subProject: "",
    tags: "",
    tasks: "",
  };


  ngOnInit(): void {
  }

  projectSettingsForm = new FormGroup({
    EditTasks: new FormControl(false),
    commentOnTasks: new FormControl(false),
    viewTaskAttachements: new FormControl(false),
    uploadAttachementsOnTask: new FormControl(false),
    viewActivityLog: new FormControl(false),
    viewTeamMembers: new FormControl(false),
    hideProjectTasksOnMainTasksTable: new FormControl(false),
  });

  projectForm = new FormGroup({
    name: new FormControl(),
    description: new FormControl(),
    startDate: new FormControl(),
    deadline: new FormControl(),
    documents: new FormControl(),
    membres: new FormControl(),
    progress: new FormControl(),
    status: new FormControl(),
    tags: new FormControl(),
    tasks: new FormControl(),
    creator: new FormControl(),
    createdDate: new FormControl(),
    subProject: new FormControl()
  });

  dateFromat(date) {
    return this.datepipe.transform(date, 'yyyy-MM-dd');
  }
  onSubmit() {
    this.projectSettingsServ.newProjectSettings(this.projectSettingsForm.value).subscribe(res => {
      console.log(res);
      this.project = this.projectForm.value;
      this.project.createdDate = this.dateFromat(this.todayDate);
      this.project.startDate = this.dateFromat(this.projectForm.value.startDate);
      this.project.deadline = this.dateFromat(this.projectForm.value.deadline);
      this.project.creator = "chahid";
      this.project.subProject = "projectsub1";
      this.projectService.newProduct(this.project, res.id).subscribe(data => {
        console.log(data);
        this._snackBar.open(this.project.name + " added successfully", "close", {
          duration: 2000,
          horizontalPosition: this.horizontalPosition,
          verticalPosition: this.verticalPosition,
        });
        this.projectForm.reset();
        this.projectSettingsForm.reset();
      }, err => {
        console.log(err);
      });
    }, err => {
      console.log(err);
    });
  }

}

