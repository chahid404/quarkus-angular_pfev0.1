import { Component, OnInit } from '@angular/core';
import { ProjectService } from 'src/app/services/project.service';

@Component({
  selector: 'app-list-project',
  templateUrl: './list-project.component.html',
  styleUrls: ['./list-project.component.css']
})
export class ListProjectComponent implements OnInit {
  constructor(public serviceProject: ProjectService) { }

  projectList: any;
  val2: number = 3;
  val3: number = 1;
  ngOnInit(): void {
    this.serviceProject.listProject().subscribe(project => {
      this.projectList = project;
      console.log(this.projectList);
    })
  }

}
