export class Task {
    comments: string;
    createdBy: string;
    createdDate: Date;
    description: string;
    document: string;
    dueDate: Date;
    id: number;
    membres: string;
    name: string;
    priority: string;
    progress: number;
    score: number;
    startDate: Date;
    status: string;
    tags: string;
    visibility: boolean
}
export class TaskRequest {
    id: number;
    comments: string;
    createdBy: string;
    description: string;
    document: string;
    dueDate: string;
    membres: string;
    name: string;
    priority: string;
    progress: number;
    score: number;
    startDate: string;
    status: string;
    tags: string;
    visibility: boolean
}

export class TaskDirectEditRequest {
    id: number;
    createdBy: string;
    dueDate: string;
    name: string;
    startDate: string;
    status: string;
    tags: string;
}