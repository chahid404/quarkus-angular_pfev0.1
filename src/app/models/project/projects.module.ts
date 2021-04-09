import { ProjectSetting } from "src/app/models/project/projectSettings.module";
import { Document } from "../document.module";
import { Users } from "./user.module";

export class Projects {
    public id: String;
    public name: String;
    public designation: String;
    public creator: String;
    public startDate: String;
    public deadline: String;
    public tasks: String;
    public createdDate: String;
    public documents: Document;
    public membres: Users[];
    public progress: number;
    public projectSettings: ProjectSetting;
    public status: String;
    public subProject: String;
    public tags: String[];
}