import { DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { ProjectService } from 'src/app/services/project.service';
import { MatSnackBar, MatSnackBarHorizontalPosition, MatSnackBarVerticalPosition } from '@angular/material/snack-bar';

@Component({
  selector: 'app-new-project',
  templateUrl: './new-project.component.html',
  styleUrls: ['./new-project.component.css']
})
export class NewProjectComponent implements OnInit {
  constructor(public datepipe: DatePipe, public projectService: ProjectService, private _snackBar: MatSnackBar) { }
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
    projectSettings: "",
    status: "",
    subProject: "",
    tags: "",
    tasks: "",
  };


  ngOnInit(): void {
  }


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
    projectSettings: new FormControl(),
    createdDate: new FormControl(),
    subProject: new FormControl()
  });

  dateFromat(date) {
    return this.datepipe.transform(date, 'yyyy-MM-dd');
  }
  onSubmit() {
    this.project = this.projectForm.value;
    this.project.createdDate = this.dateFromat(this.todayDate);
    this.project.startDate = this.dateFromat(this.projectForm.value.startDate);
    this.project.deadline = this.dateFromat(this.projectForm.value.deadline);
    this.project.creator = "chahid";
    this.project.projectSettings = "settings 1"
    this.project.subProject = "projectsub1"
    this.projectService.newProduct(this.project).subscribe(data => {
      console.log(data);
      this._snackBar.open(this.project.name + " added successfully", "close", {
        duration: 2000,
        horizontalPosition: this.horizontalPosition,
        verticalPosition: this.verticalPosition,
      });
      this.projectForm.reset();
    }, err => {
      console.log(err);
    })
  }

}

