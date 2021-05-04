import { Users } from "./project/user.module";

export class Comment {
    id:number
    comment:string;
    commentDate:string;
    createdBy:string;
}

export class CommentRequest{
    createdBy:string;
    comment:string;
}
export class CommentEntiy {
    id:number
    comment:string;
    commentDate:Date;
    createdBy:string;
    displayTime: string;
}