import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Comment, CommentRequest } from '../models/comment.module';

@Injectable({
  providedIn: 'root'
})
export class CommentService {

  private host: string = "http://localhost:8083";
  constructor(private http:HttpClient) { }

  public addcomment(idtask:number,comment:CommentRequest):Observable<Comment>{
    return this.http.post<Comment>(this.host+"/comments/addcomment/"+idtask,comment);
  }
  public deleteTaskComment(idtask:number,comment:CommentRequest):Observable<Comment>{
    return this.http.delete<Comment>(this.host+"/comments/"+idtask);
  }
}
