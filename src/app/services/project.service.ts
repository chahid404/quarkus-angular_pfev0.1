import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Project } from '../models/project/project.module';

@Injectable({
  providedIn: 'root'
})
export class ProjectService {

  public host: string = "http://localhost:8080";

  constructor(private httpClient: HttpClient) { }

  public newProduct(data, setting_id, document_id): Observable<Project> {
    return this.httpClient.post<Project>(this.host + "/projects/" + setting_id + "/" + document_id, data);
  }

}
