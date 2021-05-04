import { Component, OnInit } from '@angular/core';
import { Product } from './demo';
import { ProductService } from '../../services/product.service';
import { ProjectService } from 'src/app/services/project.service';
import { Projects } from 'src/app/models/project/projects.module';
import { Users } from 'src/app/models/project/user.module';
import { UserService } from 'src/app/services/user.service';
import { TasksService } from 'src/app/services/tasks.service';
import { Task, TaskDirectEditRequest, TaskFilter, TaskRequest } from 'src/app/models/task.module';
import { DatePipe } from '@angular/common';
import { MatSnackBar, MatSnackBarHorizontalPosition, MatSnackBarVerticalPosition } from '@angular/material/snack-bar';
import { LocalStorageService } from 'src/app/services/local-storage.service';
import { NotificationService } from 'src/app/services/notification.service';
import { ConfirmationService, ConfirmEventType } from 'primeng/api';
import { formatDistance } from 'date-fns';
import { CommentService } from 'src/app/services/comment.service';
import { CommentEntiy, CommentRequest } from 'src/app/models/comment.module';
import { DocumentService } from 'src/app/services/document.service';
import { Document } from 'src/app/models/document.module';


interface Status {
  value: string;
  viewValue: string;
}
@Component({
  selector: 'app-demo',
  templateUrl: './demo.component.html',
  providers: [ConfirmationService],
  styleUrls: ['./demo.component.css']
})
export class DemoComponent implements OnInit {
  horizontalPosition: MatSnackBarHorizontalPosition = 'end';
  verticalPosition: MatSnackBarVerticalPosition = 'bottom';
  taskToUpdate: TaskRequest = new TaskRequest();
  products: Product[];
  displayDetailTaskDialog: boolean = false;
  displayEditTaskDialog: boolean = false;
  projectsList: Projects[] = [];
  selectedTask: Task = new Task();
  taskForUpdate: Task = new Task();
  currentProject: Projects = new Projects();
  userOfSelectedTask: Users = new Users();
  usersForTaskFilter: Users[] = [];
  uploadedFileList:any[]=[];
  Ondetails: boolean;
  filterVisible: boolean = false;
  TaskFilter: TaskFilter = new TaskFilter();
  clickOnFilter: Boolean = false;
  displayModal: boolean = false;
  status: Status[] = [
    { value: 'Not Started', viewValue: 'Not Started' },
    { value: 'In Progress', viewValue: 'In Progress' },
    { value: 'On Hold', viewValue: 'On Hold' },
    { value: 'Cancelled', viewValue: 'Cancelled' },
    { value: 'Finished', viewValue: 'Finished' }
  ];
  prioritys: Status[] = [
    { value: 'LOW', viewValue: 'LOW' },
    { value: 'MEDIUM', viewValue: 'MEDIUM' },
    { value: 'HIGH', viewValue: 'HIGH' },
  ];
  public document :Document = new Document();
  ///////////////////////////////////////////////
  //commentList: any[] = [];
  commentList: CommentEntiy[] = [];
  submitting = false;
  commentValue = '';


  ///////////////////////////////////////////////
  constructor(private confirmationService: ConfirmationService,
    private _snackBar: MatSnackBar,
    private datepipe: DatePipe,
    private taskService: TasksService,
    private productService: ProductService,
    private serviceProject: ProjectService,
    private userService: UserService,
    private notifService: NotificationService,
    private lc: LocalStorageService,
    private commentService: CommentService,
    private documentService:DocumentService
  ) { }

  clickMe(): void {
    this.filterVisible = false;
  }

  change(value: boolean): void {
    console.log(value);
  }
  ngOnInit(): void {
    this.initProjectsList();
    this.getAllUsers();
  }
  getAllUsers() {
    this.userService.getAllUsers().subscribe(x => {
      this.usersForTaskFilter = x;
    })
  }

  public initProjectsList() {
    this.serviceProject.getProjectWithFiltredTasks("", "", "", "", "", "", "").subscribe(projects => {
      this.projectsList = projects;
      this.projectsList.forEach(proj => {
        proj.membres = this.listOfMembers(proj.membres);
        proj.tasks.forEach(task => {
          task.membres = this.listOfMembers(task.membres);
        })
      });
    }, err => {
      console.log(err);
    });
    this.TaskFilter = new TaskFilter();
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
  public Newtask(idproject) {
    console.log(idproject);
    this.taskService.createNewTask(idproject, this.lc.getCurrentUser()).subscribe(commentList => {
      this.initProjectsList();
      this.notifService.sendNotifsForMultiUsersid(commentList["membres"], idproject, "add new task on ", commentList["creator"]);
      this._snackBar.open("New Task Added Succesfully", "close", {
        duration: 5000,
        horizontalPosition: this.horizontalPosition,
        verticalPosition: this.verticalPosition,
      });
    }, err => {
      console.log(err);

    });
  }

  public onDeleteTask(idtask, project: Projects) {
    this.taskService.deleteTask(idtask).subscribe(task => {
      this.initProjectsList();
      this._snackBar.open("Delete Task Succesfully", "close", {
        duration: 5000,
        horizontalPosition: this.horizontalPosition,
        verticalPosition: this.verticalPosition,
      });
      this.notifService.sendNotifsForMultiUsersidvs(project.membres, project.id, "remove task from ", project.creator);
    }, err => {
      console.log(err);
    });
  }

  dateFromat(date) {
    return this.datepipe.transform(date, 'yyyy-MM-dd');
  }
  onchowdate(project: Projects, task: Task, num: number) {
    const newTask: TaskDirectEditRequest = new TaskDirectEditRequest()
    newTask.dueDate = this.dateFromat(task.dueDate);
    newTask.startDate = this.dateFromat(task.startDate);
    newTask.id = task.id;
    newTask.name = task.name;
    newTask.createdBy = task.createdBy;
    newTask.status = task.status;
    newTask.tags = task.tags;
    newTask.priority = task.priority;
    newTask.score = task.score;
    task.membres.forEach(x => {
      newTask.membres.push(x.id);
    });
    switch (num) {
      case 1:
        newTask.name = this.taskToUpdate.name;
        this.notifService.sendNotifsForMultiUsersidvs(project.membres, project.id, "change Task Title ", project.creator);
        this._snackBar.open("Task Title Update Succesfully", "close", {
          duration: 5000,
          horizontalPosition: this.horizontalPosition,
          verticalPosition: this.verticalPosition,
        });
        break;
      case 2:
        newTask.startDate = this.dateFromat(this.taskToUpdate.startDate);
        this.notifService.sendNotifsForMultiUsersidvs(project.membres, project.id, "change Task Start Date ", project.creator);
        this._snackBar.open("Task Start Date Update Succesfully", "close", {
          duration: 5000,
          horizontalPosition: this.horizontalPosition,
          verticalPosition: this.verticalPosition,
        }); break;
      case 3:
        newTask.dueDate = this.dateFromat(this.taskToUpdate.dueDate);
        this.notifService.sendNotifsForMultiUsersidvs(project.membres, project.id, "change Task Due Date ", project.creator);
        this._snackBar.open("Task Due Date Update Succesfully", "close", {
          duration: 5000,
          horizontalPosition: this.horizontalPosition,
          verticalPosition: this.verticalPosition,
        }); break;
      case 4:
        newTask.tags = this.taskToUpdate.tags;
        this.notifService.sendNotifsForMultiUsersidvs(project.membres, project.id, "change Task Tags ", project.creator);
        this._snackBar.open("Task Tags Update Succesfully", "close", {
          duration: 5000,
          horizontalPosition: this.horizontalPosition,
          verticalPosition: this.verticalPosition,
        }); break;
      case 5:
        newTask.status = this.taskToUpdate.status;
        this.notifService.sendNotifsForMultiUsersidvs(project.membres, project.id, "change Task Status ", project.creator);
        this._snackBar.open("Task Status Update Succesfully", "close", {
          duration: 5000,
          horizontalPosition: this.horizontalPosition,
          verticalPosition: this.verticalPosition,
        }); break;
      case 6:
        newTask.priority = this.taskToUpdate.priority;
        this.notifService.sendNotifsForMultiUsersidvs(project.membres, project.id, "change Task priority ", project.creator);
        this._snackBar.open("Task Priority Update Succesfully", "close", {
          duration: 5000,
          horizontalPosition: this.horizontalPosition,
          verticalPosition: this.verticalPosition,
        }); break;
      case 7:
        newTask.score = task.score;
        this.notifService.sendNotifsForMultiUsersidvs(project.membres, project.id, "Give rate you " + newTask.score + " stars", project.creator);
        this._snackBar.open("Task Rating Update Succesfully", "close", {
          duration: 5000,
          horizontalPosition: this.horizontalPosition,
          verticalPosition: this.verticalPosition,
        }); break;
      case 8:
        this.notifService.sendNotifsForMultiUsersidvs(task.membres, project.id, "add you to" + newTask.score + " stars", project.creator);
        this._snackBar.open("Task members Update Succesfully", "close", {
          duration: 5000,
          horizontalPosition: this.horizontalPosition,
          verticalPosition: this.verticalPosition,
        }); break;
      default:
        break;
    }

    this.taskService.directUpdateTask(newTask.id, newTask).subscribe(task => {
      this.initProjectsList();
      this.taskToUpdate = new TaskRequest();
    }, err => {
      console.log(err);
    });
  }
  deleteConfirm(idtask, project) {
    this.confirmationService.confirm({
      message: 'Do you want to delete this record?',
      header: 'Delete Confirmation',
      icon: 'pi pi-info-circle',
      accept: () => {
        this.onDeleteTask(idtask, project);
      },
      reject: (type) => {
        switch (type) {
          case ConfirmEventType.REJECT:
            //this.messageService.add({severity:'error', summary:'Rejected', detail:'You have rejected'});
            break;
          case ConfirmEventType.CANCEL:
            //this.messageService.add({severity:'warn', summary:'Cancelled', detail:'You have cancelled'});
            break;
        }
      }
    });
  }
  selectCar(event) {
    console.log(event);

  }
  showEditTaskDialog(task: Task, project: Projects) {
    this.currentProject = project;
    this.taskForUpdate = task;
    this.userService.getUserById(this.taskForUpdate.createdBy).subscribe(x => {
      this.userOfSelectedTask = x;
    });
    this.displayDetailTaskDialog = true;
    this.Ondetails = false;
    this.uploadedFileList=[];
    task.document.forEach(doc=>{
      this.uploadedFileList=[
        ...this.uploadedFileList,
        {
          fileName:doc.documentName,
          url:this.documentService.downloadUrl+doc.documentName
        }
      ];
    })

  }
  showDetailTaskDialog(task: Task, project: Projects) {
    this.currentProject = project;
    this.taskForUpdate = task;
    this.userService.getUserById(this.taskForUpdate.createdBy).subscribe(x => {
      this.userOfSelectedTask = x;
      this.Ondetails = true;
    });
    this.displayDetailTaskDialog = true;
  }
  OnEditSelectedTask(task: Task, project: Projects) {
    let taskforedit: TaskRequest = new TaskRequest();
    taskforedit.description = this.taskForUpdate.description;
    taskforedit.dueDate = this.dateFromat(this.taskForUpdate.dueDate);
    taskforedit.name = this.taskForUpdate.name;
    taskforedit.priority = this.taskForUpdate.priority;
    taskforedit.score = this.taskForUpdate.score;
    taskforedit.startDate = this.dateFromat(this.taskForUpdate.startDate);
    taskforedit.status = this.taskForUpdate.status;
    taskforedit.tags = this.taskForUpdate.tags;
    this.taskForUpdate.membres.forEach(u => {
      taskforedit.membres.push(u.id);
    });
    this.taskService.updateTask(task.id, taskforedit).subscribe(x => {
      this._snackBar.open("Task Update Succesfully", "close", {
        duration: 5000,
        horizontalPosition: this.horizontalPosition,
        verticalPosition: this.verticalPosition,
      });
      this.initProjectsList();
      this.displayDetailTaskDialog = false;
    });
    this.notifService.sendNotifsForMultiUsersidvs(project.membres, project.id, "Update Task", project.creator);
  }
  onTaskFilter() {
    this.TaskFilter.dueDate = this.dateFromat(this.TaskFilter.dueDate);
    this.TaskFilter.startDate = this.dateFromat(this.TaskFilter.startDate);
    this.serviceProject.getProjectWithFiltredTasks(this.TaskFilter.name, this.TaskFilter.status, this.TaskFilter.priority, this.TaskFilter.startDate, this.TaskFilter.dueDate, this.TaskFilter.membres, this.TaskFilter.score).subscribe(x => {
      this.projectsList = x;
      this.projectsList.forEach(proj => {
        proj.membres = this.listOfMembers(proj.membres);
        proj.tasks.forEach(task => {
          task.membres = this.listOfMembers(task.membres);
        })
      });
    })
    this.filterVisible = false;
  }
  onShowCommentsModal(task: Task) {
    this.displayModal = true;
    this.selectedTask = task;
    this.commentList = [];
    //let newComment: CommentEntiy = new CommentEntiy();
    if (this.selectedTask.comments.length != 0) {
      this.selectedTask.comments.forEach(com => {
        const newComment: CommentEntiy = new CommentEntiy();
        this.userService.getUserById(com.createdBy).subscribe(x => {
          newComment.createdBy = x.firstName + " " + x.lastName;
        })
        newComment.comment = com.comment;
        newComment.commentDate = new Date(com.commentDate);
        newComment.id = com.id;
        newComment.displayTime = formatDistance(new Date(), new Date(newComment.commentDate))
        this.commentList.push(newComment);
      });
    }
    this.commentList.sort((a, b) => (a.commentDate > b.commentDate) ? 1 : -1)
    console.log(this.commentList);

  }

  onAddComment() {
    let comment: CommentRequest = new CommentRequest();
    let newComment: CommentEntiy = new CommentEntiy();
    comment.comment = this.commentValue;
    comment.createdBy = this.lc.getCurrentUser();
    this.userService.getUserById(this.lc.getCurrentUser()).subscribe(x => {
      newComment.createdBy = x.firstName + " " + x.lastName;
    })
    newComment.commentDate = new Date();
    newComment.comment = this.commentValue;
    this.submitting = true;
    this.commentValue = '';
    setTimeout(() => {
      this.submitting = false;
      this.commentList = [
        ...this.commentList,
        {
          comment: newComment.comment,
          commentDate: newComment.commentDate,
          createdBy: newComment.createdBy,
          id: 0,
          displayTime: formatDistance(new Date(), new Date())
        }
      ].map(e => {
        return {
          ...e,
          displayTime: formatDistance(new Date(), new Date(e.commentDate))
        };
      });
    }, 800);
    this.commentService.addcomment(this.selectedTask.id, comment).subscribe(x => {
    });
  }
  myUploader(event,idtask) {
    const formData = new FormData();
    formData.append('file', event.files[0]);
    formData.append('fileName', event.files[0].name);
    this.documentService.uploadFile(formData).subscribe(data => {
      console.log(data);
      this.uploadedFileList=[
        ...this.uploadedFileList,
        {
          fileName:data.fileName,
          url:this.documentService.downloadUrl+data.regenaratedFileName
        }
      ];
      this.document.uploadDate = this.dateFromat(new Date());;
      this.document.path = data.fullPath;
      this.document.documentName = data.regenaratedFileName;
      this.taskService.addDocumentToTask(idtask,this.document).subscribe();
    }, err => {
      console.log(err);
    });
    
  }
}
