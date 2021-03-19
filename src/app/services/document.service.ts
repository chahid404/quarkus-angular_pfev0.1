import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DocumentService {

  constructor(private httpClient: HttpClient) { }
  SERVER_URL = "http://localhost:8080/documents/uploadfile";

  public uploadFile(formdata): Observable<any> {
    return this.httpClient.post<any>(this.SERVER_URL, formdata);
  }
}
