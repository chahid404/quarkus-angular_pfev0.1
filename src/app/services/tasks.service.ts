import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Project } from '../models/project/project.module';
import { Projects } from '../models/project/projects.module';
import { Task, TaskDirectEditRequest, TaskRequest } from '../models/task.module';

@Injectable({
  providedIn: 'root'
})
export class TasksService {

  public host: string = "http://localhost:8083";

  constructor(private httpClient: HttpClient) { }

  public deleteTask(taskid: number) {
    return this.httpClient.get(this.host + "/tasks/deletetaskby/" + taskid);
  }
  public directUpdateTask(taskid: number, taskBody: TaskDirectEditRequest) {
    return this.httpClient.put(this.host + "/tasks/directedittask/" + taskid, taskBody);
  }

  public createNewTask(idproject: number, iduser: string) {
    return this.httpClient.get(this.host + "/tasks/createnewtask/" + idproject + "/" + iduser);
  }
  public updateTask(idtask,task:TaskRequest){
   return this.httpClient.put(this.host+"/tasks/"+idtask,task);
  }

}
