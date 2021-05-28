import { DatePipe } from '@angular/common';
import { AfterViewInit, Component, OnDestroy, OnInit } from '@angular/core';
import { FormGroup, FormControl, FormBuilder } from '@angular/forms';
import { ProjectService } from 'src/app/services/project.service';
import { MatSnackBar, MatSnackBarHorizontalPosition, MatSnackBarVerticalPosition } from '@angular/material/snack-bar';
import { ProjectSettingsService } from 'src/app/services/project-settings.service';
import { AngularEditorConfig } from '@kolkov/angular-editor';
import { DocumentService } from 'src/app/services/document.service';
import { Validators } from '@angular/forms';
import { Subject } from 'rxjs';
import { takeUntil } from 'rxjs/operators';
import { Users } from 'src/app/models/project/user.module';
import { UserService } from 'src/app/services/user.service';

interface Status {
  value: string;
  viewValue: string;
}
@Component({
  selector: 'app-new-project',
  templateUrl: './new-project.component.html',
  styleUrls: ['./new-project.component.scss']
})
export class NewProjectComponent implements OnInit, AfterViewInit, OnDestroy {

  constructor(private documentService: DocumentService, private formBuilder: FormBuilder, public projectSettingsServ: ProjectSettingsService,
    public datepipe: DatePipe, public projectService: ProjectService, private _snackBar: MatSnackBar, private userService: UserService) {

  }
  public todayDate = new Date();
  horizontalPosition: MatSnackBarHorizontalPosition = 'end';
  verticalPosition: MatSnackBarVerticalPosition = 'bottom';
  selectedValues = ['AdvyTeam', 'STAGE', 'PFE'];
  uploadForm: FormGroup;
  public fileName: string;
  public fileFullPath: string;
  uploadedFiles: any[] = [];
  tagsValues: string[] = [];
  display: boolean = false;
  displayModal: boolean = false;
  selectedValue: string;
  usersList: Users[];
  currentUserId: string = localStorage.getItem("userId");
  currentUser: Users;
  //////users///////
  public userMultiCtrl: FormControl = new FormControl('', Validators.required);
  public userMultiFilterCtrl: FormControl = new FormControl();
  /** Subject that emits when the component has been destroyed. */
  protected _onDestroy = new Subject<void>();
  //////end users//////
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
    name: new FormControl('', Validators.required),
    description: new FormControl(""),
    startDate: new FormControl('', Validators.required),
    deadline: new FormControl('', Validators.required),
    status: new FormControl('', Validators.required),
    tags: new FormControl(),
    creator: new FormControl(),
    createdDate: new FormControl(),
    subProject: new FormControl(),

  });

  status: Status[] = [
    { value: 'Not Started', viewValue: 'not Started' },
    { value: 'In Progress', viewValue: 'in Progress' },
    { value: 'On Hold', viewValue: 'on Hold' },
    { value: 'Cancelled', viewValue: 'Cancelled' },
    { value: 'Finished', viewValue: 'Finished' }
  ];

  public document = {
    documentName: "",
    uploadDate: "",
    path: ""
  }

  public fileParams = {
    fileName: "",
    fullPath: "",
    regenaratedFileName: ""
  }
  public project = {
    name: "",
    description: "",
    creator: "",
    startDate: "",
    deadline: "",
    createdDate: "",
    membres: [],
    progress: 0,
    status: "",
    subProject: "",
    tags: [],
  };


  ngOnInit(): void {
    this.uploadForm = this.formBuilder.group({
      profile: ['']
    });
    this.setInitialValue();
    // initusers
    this.userMultiFilterCtrl.valueChanges
      .pipe(takeUntil(this._onDestroy))
      .subscribe(() => {
        this.filterUsersMulti();
      });
    // endinitUsers

  }

  ngAfterViewInit() {
    this.setInitialValue();
  }

  ngOnDestroy() {
    this._onDestroy.next();
    this._onDestroy.complete();
  }


  dateFromat(date) {
    return this.datepipe.transform(date, 'yyyy-MM-dd');
  }

  public listOfMembers(array): Users[] {
    let usersAssigned: Users[] = [];
    array.forEach(userid => {
      this.userService.getUserById(userid).subscribe(user => {
        usersAssigned.push(user);
      }, err => {
        console.log(err);
      })
    });
    return usersAssigned;
  }

  onSubmit() {

    this.projectSettingsServ.newProjectSettings(this.projectSettingsForm.value).subscribe(res => {
      //console.log(res);
      this.project = this.projectForm.value;
      this.project.createdDate = this.dateFromat(this.todayDate);
      this.project.startDate = this.dateFromat(this.projectForm.value.startDate);
      this.project.deadline = this.dateFromat(this.projectForm.value.deadline);
      this.project.creator = this.currentUser.id;
      this.project.subProject = "projectsub1";
      this.project.tags = this.tagsValues;
      //create membreslist
      this.project.membres = this.userMultiCtrl.value;
      console.log(this.userMultiCtrl.value);
      //DocumentHttpClient
      this.document.uploadDate = this.dateFromat(this.todayDate);;
      this.document.path = this.fileParams.fullPath;
      this.document.documentName = this.fileParams.regenaratedFileName;
      this.documentService.addDocument(this.document).subscribe(document => {
        console.log(this.project);
        this.projectService.newProject(this.project, res.id, document.id).subscribe(data => {
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
      //end DocumentHttpClient
    }, err => {
      console.log(err);
    });
  }

  restForms() {
    this.projectForm.reset();
    this.projectSettingsForm.reset();
    this.selectedValues = ['AdvyTeam', 'STAGE', 'PFE'];
    //this.otherForm.setValue({ tagss: ['AdvyTeam', 'STAGE', 'PFE'] })

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
    const formData = new FormData();
    formData.append('file', event.files[0]);
    formData.append('fileName', event.files[0].name);
    this.documentService.uploadFile(formData).subscribe(data => {
      this.fileParams = data;
      // this._snackBar.open(event.files[0].name + " added successfully", "close", {
      //   duration: 3000,
      //   horizontalPosition: this.horizontalPosition,
      //   verticalPosition: this.verticalPosition,
      // });
      this.displayModal = true;

    }, err => {
      console.log(err);
    });

  }

  change($event) {
    this.tagsValues = $event;
  }

  // users
  /**
   * Sets the initial value after the filteredBanks are loaded initially
   */
  protected setInitialValue() {
    this.userService.getUserById(this.currentUserId).subscribe(user => {
      this.currentUser = user;
      this.userService.getAllUsers().subscribe(users => {
        this.usersList = users;
        var indexOfSepecificUser = this.usersList.findIndex(u => u.id === user.id);
        this.usersList.splice(indexOfSepecificUser, 1);
        console.log(this.usersList);

      }, error => {
        console.log(error);
      });
    }, err => {
      console.log(err);
    });
  }

  protected filterUsersMulti() {
    if (!this.usersList) {
      return;
    }
    // get the search keyword
    let search = this.userMultiFilterCtrl.value;
    if (!search) {
      this.setInitialValue();
      return;
    } else {
      search = search.toLowerCase();
    }
    this.usersList = this.usersList.filter(user => user.username.toLowerCase().indexOf(search) > -1);

  }
  // endUsers



}

