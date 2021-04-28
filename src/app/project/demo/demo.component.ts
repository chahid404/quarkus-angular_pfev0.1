import { Component, OnInit } from '@angular/core';
import { Product } from './demo';
import { ProductService } from '../../services/product.service';
import { ProjectService } from 'src/app/services/project.service';
import { Projects } from 'src/app/models/project/projects.module';
import { Users } from 'src/app/models/project/user.module';
import { UserService } from 'src/app/services/user.service';
import { TasksService } from 'src/app/services/tasks.service';
import { Task, TaskDirectEditRequest, TaskRequest } from 'src/app/models/task.module';
import { DatePipe } from '@angular/common';
import { MatSnackBar, MatSnackBarHorizontalPosition, MatSnackBarVerticalPosition } from '@angular/material/snack-bar';
import { LocalStorageService } from 'src/app/services/local-storage.service';
import { NotificationService } from 'src/app/services/notification.service';
import { ConfirmationService, ConfirmEventType } from 'primeng/api';

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
  frozenCols: any[];
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

  constructor(private confirmationService: ConfirmationService, private _snackBar: MatSnackBar, private datepipe: DatePipe, private taskService: TasksService, private productService: ProductService,
    private serviceProject: ProjectService, private userService: UserService, private notifService: NotificationService, private lc: LocalStorageService) { }


  ngOnInit(): void {
    this.initProjectsList();
    this.frozenCols = [
      { field: 'name', header: 'name' }
  ];
  }

  private initProjectsList() {
    this.serviceProject.listProject().subscribe(projects => {
      this.projectsList = projects;
      this.projectsList.forEach(proj => {
        proj.membres = this.listOfMembers(proj.membres);
        proj.tasks.forEach(task =>{
          task.membres = this.listOfMembers(task.membres);
        })
      });
      console.log(this.projectsList);
    }, err => {
      console.log(err);
    });
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
    this.taskService.createNewTask(idproject, this.lc.getCurrentUser()).subscribe(data => {
      this.initProjectsList();
      this.notifService.sendNotifsForMultiUsersid(data["membres"], idproject, "add new task on ", data["creator"]);
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
  onchowdate(project: Projects, task:Task, num: number) {
    const newTask: TaskDirectEditRequest = new TaskDirectEditRequest()
    newTask.dueDate = this.dateFromat(task.dueDate);
    newTask.startDate = this.dateFromat(task.startDate);
    newTask.id = task.id;
    newTask.name = task.name;
    newTask.createdBy = task.createdBy;
    newTask.status = task.status;
    newTask.tags = task.tags;
    newTask.priority = task.priority;
    task.membres.forEach(x=>{
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
  showDetailTaskDialog() {
      this.displayDetailTaskDialog = true;
  }
  showEditTaskDialog() {
      this.displayEditTaskDialog = true;
  }
}
