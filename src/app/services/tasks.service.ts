import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Task, TaskDirectEditRequest } from '../models/task.module';

@Injectable({
  providedIn: 'root'
})
export class TasksService {

  public host: string = "http://localhost:8083";

  constructor(private httpClient: HttpClient) { }

  public deleteTask(taskid: number) {
    return this.httpClient.delete(this.host + "/tasks/deletetaskby/" + taskid);
  }
  public directUpdateTask(taskid: number, taskBody: TaskDirectEditRequest) {
    return this.httpClient.put(this.host + "/tasks/directedittask/" + taskid, taskBody);
  }

}
