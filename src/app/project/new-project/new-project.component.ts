import { DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, FormBuilder } from '@angular/forms';
import { ProjectService } from 'src/app/services/project.service';
import { MatSnackBar, MatSnackBarHorizontalPosition, MatSnackBarVerticalPosition } from '@angular/material/snack-bar';
import { ProjectSettingsService } from 'src/app/services/project-settings.service';
import { AngularEditorConfig } from '@kolkov/angular-editor';
import { DocumentService } from 'src/app/services/document.service';

@Component({
  selector: 'app-new-project',
  templateUrl: './new-project.component.html',
  styleUrls: ['./new-project.component.css']
})
export class NewProjectComponent implements OnInit {
  constructor(private documentService: DocumentService, private formBuilder: FormBuilder, public projectSettingsServ: ProjectSettingsService, public datepipe: DatePipe, public projectService: ProjectService, private _snackBar: MatSnackBar) { }
  public todayDate = new Date();
  horizontalPosition: MatSnackBarHorizontalPosition = 'end';
  verticalPosition: MatSnackBarVerticalPosition = 'bottom';

  uploadForm: FormGroup;
  public fileName: string;
  public fileFullPath: string;
  uploadedFiles: any[] = [];
  display: boolean = false;
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
    this.uploadForm = this.formBuilder.group({
      profile: ['']
    });
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
          duration: 3000,
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

  restForms() {
    this.projectForm.reset();
    this.projectSettingsForm.reset();
  }

  editorConfig: AngularEditorConfig = {
    editable: true,
    spellcheck: true,
    height: 'auto',
    minHeight: '150px',
    maxHeight: 'auto',
    width: 'auto',
    minWidth: '0',
    translate: 'yes',
    enableToolbar: true,
    showToolbar: true,
    placeholder: 'Enter your description here...',
    defaultParagraphSeparator: '',
    defaultFontName: '',
    defaultFontSize: '',
    fonts: [
      { class: 'arial', name: 'Arial' },
      { class: 'times-new-roman', name: 'Times New Roman' },
      { class: 'calibri', name: 'Calibri' },
      { class: 'comic-sans-ms', name: 'Comic Sans MS' }
    ],
    customClasses: [
      {
        name: 'quote',
        class: 'quote',
      },
      {
        name: 'redText',
        class: 'redText'
      },
      {
        name: 'titleText',
        class: 'titleText',
        tag: 'h1',
      },
    ],
    sanitize: true,
    toolbarPosition: 'top',
    toolbarHiddenButtons: [
      ['bold', 'italic'],
      ['fontSize']
    ]
  };
  // uploadFile method
  showDialog() {
    this.display = true;
  }
  onUpload(event) {
    console.log(event.files[0].name);
    const formData = new FormData();
    formData.append('file', event.files[0]);
    formData.append('fileName', event.files[0].name);
    this.documentService.uploadFile(formData).subscribe(data => {
      this.fileFullPath = data;
    }, err => {
      console.log(err);
    });
  }

}

