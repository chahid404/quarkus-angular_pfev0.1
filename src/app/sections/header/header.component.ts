import { Component, OnInit } from '@angular/core';
import { Notification, Datedifference } from 'src/app/models/notification.module';
import { KeycloakSecurityService } from 'src/app/services/keycloak-security.service';
import { LocalStorageService } from 'src/app/services/local-storage.service';
import { NotificationService } from 'src/app/services/notification.service';
import { interval, Subscription } from 'rxjs';
import { MatSnackBar, MatSnackBarHorizontalPosition, MatSnackBarVerticalPosition } from '@angular/material/snack-bar';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  horizontalPosition: MatSnackBarHorizontalPosition = 'end';
  verticalPosition: MatSnackBarVerticalPosition = 'bottom';
  notifList: Notification[] = [];
  currentUserId: string
  myDate = new Date();
  notifList2: Notification[];
  notifnumber: number = 0;
  newNotifnumber: number = 0;
  mySubscription: Subscription;


  constructor(private _snackBar: MatSnackBar,public kcService: KeycloakSecurityService, private notifService: NotificationService, private lc: LocalStorageService) {
    this.mySubscription = interval(5000).subscribe((x => {
      this.doStuff();
    }));
  }
  doStuff() {
    // this.countNotifUnReadSync(this.lc.getCurrentUser());
    // if (this.newNotifnumber > this.notifnumber) {
    //   this.notifnumber=this.newNotifnumber;
    //   this._snackBar.open("New Notification", "close", {
    //     duration: 5000,
    //     horizontalPosition: this.horizontalPosition,
    //     verticalPosition: this.verticalPosition,
    //   });
    // }
    //doing stuff with unsubscribe at end to only run once
    //this.mySubscription.unsubscribe();
  }

  ngOnInit(): void {
    this.currentUserId = this.lc.getCurrentUser();
    this.getNotifs(this.lc.getCurrentUser());
    this.countNotifUnRead(this.lc.getCurrentUser());
  }
  onLogout() {
    this.kcService.kc.logout();
  }
  onLogin() {
    this.kcService.kc.login();
  }
  onMarkAllAsRead() {
    this.notifService.markAllAsRead(this.currentUserId).subscribe();
    //this.countNotifUnRead(this.lc.getCurrentUser());
    this.getNotifs(this.lc.getCurrentUser());
    this.notifnumber = 0;
    this.notifList = [];
  }
  onClearAllNotification() {
    this.notifService.cleanAllNotifFoUser(this.currentUserId).subscribe();
    //this.countNotifUnRead(this.lc.getCurrentUser());
    this.getNotifs(this.lc.getCurrentUser());
    this.notifnumber = 0;
    this.notifList = [];
  }

  deletenotif(idnotif) {
    this.notifService.deleteNotifById(idnotif).subscribe();
    //this.countNotifUnRead(this.lc.getCurrentUser());
    this.getNotifs(this.lc.getCurrentUser());
    this.notifnumber = this.notifnumber - 1;
  }

  getNotifs(iduser) {
    this.notifList = [];
    this.notifService.retrunOnlySowed(this.currentUserId).subscribe(notif => {
      this.notifList2 = notif;
      this.notifList2.forEach(notif => {
        notif.datedifference = this.calculDiffDate(notif.createdAt);
        this.notifList.push(notif);
      });
    });
  }

  countNotifUnRead(iduser) {
    this.notifService.returnUnReadNotif(iduser).subscribe(notif => {
      this.notifnumber = notif.length;
    });
    
  }
  countNotifUnReadSync(iduser){
    this.notifService.returnUnReadNotif(iduser).subscribe(notif => {
      this.newNotifnumber=notif.length;
      this.notifList=notif;
    });

  }
  calculDiffDate(dateSent): Datedifference {
    let currentDate = new Date(this.myDate);
    let datedifference: Datedifference = new Datedifference();
    let dateSente = new Date(dateSent);
    let diffMs = (currentDate.getTime() - dateSente.getTime()); // milliseconds
    datedifference.diffDays = Math.floor(diffMs / 86400000); // days
    datedifference.diffHrs = Math.floor((diffMs % 86400000) / 3600000); // hours
    datedifference.diffMins = Math.round(((diffMs % 86400000) % 3600000) / 60000); // minutes
    return datedifference;
  }
}
