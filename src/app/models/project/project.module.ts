import { ProjectSetting } from "src/app/models/project/projectSettings.module";

export class Project {
  public name: String;
  public designation: String;
  public creator: String;
  public startDate: String;
  public deadline: String;
  public tasks: String;
  public createdDate: String;
  public documents: String;
  public membres: String;
  public progress: number;
  public projectSettings: ProjectSetting;
  public status: String;
  public subProject: String;
  public tags: String;


}