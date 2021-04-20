import { Component, OnInit } from '@angular/core';
import { Product } from './demo';
import { ProductService } from '../../services/product.service';
import { ProjectService } from 'src/app/services/project.service';
import { Projects } from 'src/app/models/project/projects.module';
import { Users } from 'src/app/models/project/user.module';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-demo',
  templateUrl: './demo.component.html',
  styleUrls: ['./demo.component.css']
})
export class DemoComponent implements OnInit {
  products: Product[];
  projectsList: Projects[] = [];

  constructor(private productService: ProductService, private serviceProject: ProjectService, private userService: UserService) { }


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
}
