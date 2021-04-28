import { ProjectSetting } from "src/app/models/project/projectSettings.module";
import { Document } from "../document.module";
import { Task } from "../task.module";
import { Users } from "./user.module";

export class Projects {
    public id: number;
    public name: string;
    public designation: string;
    public creator: string;
    public startDate: string;
    public deadline: string;
    public tasks: Task [];
    public createdDate: string;
    public documents: Document;
    public membres: Users[];
    public progress: number;
    public projectSettings: ProjectSetting;
    public status: string;
    public subProject: string;
    public tags: string[];
}