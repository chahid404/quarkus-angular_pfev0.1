import { Users } from "./project/user.module";

export class Notification {
    public id: number;
    public idRecever: string;
    public idCreator: string;
    public action: string;
    public createdAt: Date;
    public isRead: Boolean;
    public isShow: Boolean;
    public datedifference: Datedifference;
    public targetProjectid: number;
    public userRecever:Users = new Users();

}

export class Datedifference {
    public diffMins: number;
    public diffDays: number;
    public diffHrs: number;
}