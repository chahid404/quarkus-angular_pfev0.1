import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Project } from '../models/project/project.module';
import { Projects } from '../models/project/projects.module';

@Injectable({
  providedIn: 'root'
})
export class ProjectService {

  public host: string = "http://localhost:8083";

  constructor(private httpClient: HttpClient) { }

  public newProject(data, setting_id, document_id): Observable<Project> {
    return this.httpClient.post<Project>(this.host + "/projects/" + setting_id + "/" + document_id, data);
  }

  public listProject() {
    return this.httpClient.get<Projects[]>(this.host + "/projects");
  }

  public getProjectByCreator(idUser: string): Observable<Projects[]> {
    return this.httpClient.get<Projects[]>(this.host + "/getprojectsbycreator");
  }
  public createNewTask(idproject) {
    return this.httpClient.get(this.host + "/projects" + "/createnewtask/" + idproject);
  }
}
