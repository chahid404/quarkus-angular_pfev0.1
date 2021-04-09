import { Component, OnInit } from '@angular/core';
import { Users } from 'src/app/models/project/user.module';
import { ProjectService } from 'src/app/services/project.service';
import { UserService } from 'src/app/services/user.service';
import { Projects } from '../../models/project/projects.module';
@Component({
  selector: 'app-list-project',
  templateUrl: './list-project.component.html',
  styleUrls: ['./list-project.component.css']
})
export class ListProjectComponent implements OnInit {
  constructor(public serviceProject: ProjectService, private userService: UserService) { }
  projectList: Projects[];
  isLoading: boolean = true;
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
    tasks: "",
    subProject: "",
    tags: [],
  };


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
  ngOnInit(): void {
    this.serviceProject.listProject().subscribe(projects => {
      this.projectList = projects;
      this.projectList.forEach(proj => {
        proj.membres = this.listOfMembers(proj.membres);
      });
      console.log(this.projectList);
    }, err => {
      console.log(err);
    });

    //console.log(this.projectList["members"]);


    //this.userService.getUserById
  }
  labelLoaded() {
    this.isLoading = false;
    console.log("aaaaa");

  }

}
