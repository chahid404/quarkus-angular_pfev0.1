import { Users } from "./project/user.module";

export class Task {
    comments: string;
    createdBy: string;
    createdDate: Date;
    description: string;
    document: string;
    dueDate: Date;
    id: number;
    membres: Users [] =[];
    name: string;
    priority: string;
    progress: number;
    score: number;
    startDate: Date;
    status: string;
    tags: string;
    visibility: boolean;
}
export class TaskRequest {
    id: number;
    comments: string;
    createdBy: string;
    description: string;
    document: string;
    dueDate: string;
    name: string;
    priority: string;
    progress: number;
    score: number;
    startDate: string;
    status: string;
    tags: string;
    visibility: boolean;
    membres: string [] =[];
}

export class TaskDirectEditRequest {
    id: number;
    createdBy: string;
    dueDate: string;
    name: string;
    startDate: string;
    status: string;
    tags: string;
    priority: string;
    score:number;
    membres: string [] =[];
}