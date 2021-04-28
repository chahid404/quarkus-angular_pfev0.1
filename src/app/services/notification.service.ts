import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Notification } from '../models/notification.module';
import { Users } from '../models/project/user.module';
import { LocalStorageService } from './local-storage.service';

@Injectable({
  providedIn: 'root'
})
export class NotificationService {

  private host: string = "http://localhost:8083";
  constructor(private http: HttpClient, private lc: LocalStorageService) { }


  public getAllNotifs(): Observable<Notification[]> {
    return this.http.get<Notification[]>(this.host + "/notif/getall");
  }

  public getNotifByID(id: number): Observable<Notification> {
    return this.http.get<Notification>(this.host + "/notif/getbyid/" + id);
  }

  public createNotif(notif: Notification): Observable<Notification> {
    return this.http.post<Notification>(this.host + "/notif/save", notif);
  }

  public getLastThreeNotifs(idRecever: string): Observable<Notification[]> {
    return this.http.get<Notification[]>(this.host + "/notif/returnlasts/" + idRecever);
  }


  public deleteNotifsForUsers(idRecever: string) {
    return this.http.delete(this.host + "/notif/deletenotifforuser/" + idRecever);
  }

  public deleteNotifById(idnotif: number) {
    return this.http.delete(this.host + "/notif/deletenotifbyid/" + idnotif);
  }

  public markAllAsRead(iduser: string) {
    return this.http.put(this.host + "/notif/markallasread/" + iduser, null);
  }

  public markAsUnRead(idnotif: number) {
    return this.http.put(this.host + "/notif/markasunread/" + idnotif, null);
  }

  public markAsRead(idnotif: number) {
    return this.http.put(this.host + "/notif/markasread/" + idnotif, null);
  }


  public cleanAllNotifFoUser(iduser: string) {
    return this.http.put(this.host + "/notif/cleanallnotif/" + iduser, null);
  }

  public idnotif(idnotif: number) {
    return this.http.put(this.host + "/notif/dontshownotif/" + idnotif, null);
  }


  public retrunOnlySowed(idRecever: string): Observable<Notification[]> {
    return this.http.get<Notification[]>(this.host + "/notif/returnisshowbyuser/" + idRecever);
  }

  public returnUnReadNotif(idRecever: string): Observable<Notification[]> {
    return this.http.get<Notification[]>(this.host + "/notif/returnunreadnotif/" + idRecever);
  }

  public sendNotifsForMultiUsersid(membres: string[], targetProject: number, action: string,projectCreator:string) {
    let newNotif: Notification = new Notification();
    membres.forEach(user => {
      if (this.lc.getCurrentUser() != user) {
        newNotif.idRecever = user;
        newNotif.targetProjectid = targetProject;
        newNotif.action = action;
        newNotif.idCreator = this.lc.getCurrentUser();
        this.createNotif(newNotif).subscribe(res=>{
          console.log("notif send avec succé");
        },err=>{
          console.log(err);
        });
      }
    });
    if (this.lc.getCurrentUser()!=projectCreator) {
      newNotif.idRecever = projectCreator;
        newNotif.targetProjectid = targetProject;
        newNotif.action = action;
        newNotif.idCreator = this.lc.getCurrentUser();
        this.createNotif(newNotif).subscribe(res=>{
          console.log(projectCreator);
        },err=>{
          console.log(err);
        });
    }
  }
  public sendNotifsForMultiUsersidvs(membres: Users[], targetProject: number, action: string,projectCreator:string) {
    let newNotif: Notification = new Notification();
    membres.forEach(user => {
      if (this.lc.getCurrentUser() != user.id) {
        newNotif.idRecever = user.id;
        newNotif.targetProjectid = targetProject;
        newNotif.action = action;
        newNotif.idCreator = this.lc.getCurrentUser();
        this.createNotif(newNotif).subscribe(res=>{
          console.log("notif send avec succé");
        },err=>{
          console.log(err);
        });
      }
    });
    if (this.lc.getCurrentUser()!=projectCreator) {
      newNotif.idRecever = projectCreator;
        newNotif.targetProjectid = targetProject;
        newNotif.action = action;
        newNotif.idCreator = this.lc.getCurrentUser();
        this.createNotif(newNotif).subscribe(res=>{
          console.log(projectCreator);
        },err=>{
          console.log(err);
        });
    }
  }
}

