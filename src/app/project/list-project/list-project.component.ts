import { Component, OnInit } from '@angular/core';
import { ProjectService } from 'src/app/services/project.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-list-project',
  templateUrl: './list-project.component.html',
  styleUrls: ['./list-project.component.css']
})
export class ListProjectComponent implements OnInit {
  constructor(public serviceProject: ProjectService, private userService: UserService) { }
  public aaaa: number = 5;
  projectList: any;
  isLoading: boolean = true;

  ngOnInit(): void {
    this.serviceProject.listProject().subscribe(project => {
      this.projectList = project;
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
