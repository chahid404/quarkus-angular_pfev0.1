import { Component, OnInit } from '@angular/core';
import { Product } from './demo';
import { ProductService } from '../../services/product.service';
import { ProjectService } from 'src/app/services/project.service';
import { Projects } from 'src/app/models/project/projects.module';
import { Users } from 'src/app/models/project/user.module';
import { UserService } from 'src/app/services/user.service';
import { TasksService } from 'src/app/services/tasks.service';
import { TaskDirectEditRequest, TaskRequest } from 'src/app/models/task.module';
import { DatePipe } from '@angular/common';
import { MatSnackBar, MatSnackBarHorizontalPosition, MatSnackBarVerticalPosition } from '@angular/material/snack-bar';
interface Status {
  value: string;
  viewValue: string;
}
@Component({
  selector: 'app-demo',
  templateUrl: './demo.component.html',
  styleUrls: ['./demo.component.css']
})
export class DemoComponent implements OnInit {
  horizontalPosition: MatSnackBarHorizontalPosition = 'end';
  verticalPosition: MatSnackBarVerticalPosition = 'bottom';
  products: Product[];
  projectsList: Projects[] = [];
  status: Status[] = [
    { value: 'Not Started', viewValue: 'not Started' },
    { value: 'In Progress', viewValue: 'in Progress' },
    { value: 'On Hold', viewValue: 'on Hold' },
    { value: 'Cancelled', viewValue: 'Cancelled' },
    { value: 'Finished', viewValue: 'Finished' }
  ];
  taskToUpdate: TaskRequest = new TaskRequest();
  constructor(private _snackBar: MatSnackBar, private datepipe: DatePipe, private taskService: TasksService, private productService: ProductService, private serviceProject: ProjectService, private userService: UserService) { }


  ngOnInit(): void {
    this.initProjectsList();
  }

  private initProjectsList() {
    this.serviceProject.listProject().subscribe(projects => {
      this.projectsList = projects;
      this.projectsList.forEach(proj => {
        proj.membres = this.listOfMembers(proj.membres);

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
    this.serviceProject.createNewTask(idproject).subscribe(data => {
      this.initProjectsList();
    }, err => {
      console.log(err);

    });
  }

  public onDeleteTask(id) {
    console.log(id);

    this.taskService.deleteTask(id).subscribe(task => {
      console.log(task);
      this.initProjectsList();
    }, err => {
      console.log(err);
    });
  }

  dateFromat(date) {
    return this.datepipe.transform(date, 'yyyy-MM-dd');
  }
  onchowdate(v, task, num: number) {
    const newTask: TaskDirectEditRequest = new TaskDirectEditRequest()
    newTask.dueDate = this.dateFromat(task.dueDate);
    newTask.startDate = this.dateFromat(task.startDate);
    newTask.id = task.id;
    newTask.name = task.name;
    newTask.createdBy = task.createdBy;
    newTask.status = task.status;
    newTask.tags = task.tags;
    switch (num) {
      case 1:
        newTask.name = this.taskToUpdate.name;
        this._snackBar.open("Task Title Update Succesfully", "close", {
          duration: 5000,
          horizontalPosition: this.horizontalPosition,
          verticalPosition: this.verticalPosition,
        });
        break;
      case 2:
        newTask.startDate = this.dateFromat(this.taskToUpdate.startDate);
        this._snackBar.open("Task Start Date Update Succesfully", "close", {
          duration: 5000,
          horizontalPosition: this.horizontalPosition,
          verticalPosition: this.verticalPosition,
        }); break;
      case 3:
        newTask.dueDate = this.dateFromat(this.taskToUpdate.dueDate);
        this._snackBar.open("Task Due Date Update Succesfully", "close", {
          duration: 5000,
          horizontalPosition: this.horizontalPosition,
          verticalPosition: this.verticalPosition,
        }); break;
      case 4:
        newTask.tags = this.taskToUpdate.tags;
        this._snackBar.open("Task Tags Update Succesfully", "close", {
          duration: 5000,
          horizontalPosition: this.horizontalPosition,
          verticalPosition: this.verticalPosition,
        }); break;
      case 5:
        newTask.status = this.taskToUpdate.status;
        this._snackBar.open("Task Status Update Succesfully", "close", {
          duration: 5000,
          horizontalPosition: this.horizontalPosition,
          verticalPosition: this.verticalPosition,
        }); break;
      default:
        break;
    }

    this.taskService.directUpdateTask(newTask.id, newTask).subscribe(task => {
      this.initProjectsList();
    }, err => {
      console.log(err);

    });
  }
}
