import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ProjectSetting } from '../models/project/projectSettings.module';
@Injectable({
  providedIn: 'root'
})
export class ProjectSettingsService {

  constructor(private httpClient: HttpClient) { }
  public host: string = "http://localhost:8083";



  public newProjectSettings(data): Observable<ProjectSetting> {
    return this.httpClient.post<ProjectSetting>(this.host + "/settings", data);
  }
}
