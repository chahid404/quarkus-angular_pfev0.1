package org.advyteam.repositorys;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import org.advyteam.entites.Project;
import org.advyteam.entites.Task;
import org.advyteam.otherClasses.TaskPercentage;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProjectRepository implements PanacheRepositoryBase<Project, Long> {

    public TaskPercentage calculProjectProgressPersent(List<Task> tasks) {
        TaskPercentage projectPercentage = new TaskPercentage();
        Double numOfNotStartedTask = 0.0;
        Double numOfInProgressTask = 0.0;
        Double numOfOnHoldTask = 0.0;
        Double numOfCancelledTask = 0.0;
        Double numOfFinishedTask = 0.0;
        Integer numberOfTasks = tasks.size();
        for (Task task : tasks) {
            switch (task.status) {
            case "Not Started":
            numOfNotStartedTask++;
                break;
            case "In Progress":
            numOfInProgressTask++;
                break;
            case "On Hold":
            numOfOnHoldTask++;
                break;
            case "Cancelled":
            numOfCancelledTask++;
                break;
            case "Finished":
            numOfFinishedTask++;
                break;
            default:
                break;
            }
        }
        projectPercentage.setFinished((int)((numOfFinishedTask/numberOfTasks)*100));
        projectPercentage.setCancelled((int)((numOfCancelledTask/numberOfTasks)*100));
        projectPercentage.setInProgress((int)((numOfInProgressTask/numberOfTasks)*100));
        projectPercentage.setNotStarted((int)((numOfNotStartedTask/numberOfTasks)*100));
        projectPercentage.setOnHold((int)((numOfOnHoldTask/numberOfTasks)*100));
        return projectPercentage;
    }
    public TaskPercentage calculProjectProgressPersentForDelete(List<Task> tasks) {
        TaskPercentage projectPercentage = new TaskPercentage();
        Double numOfNotStartedTask = 0.0;
        Double numOfInProgressTask = 0.0;
        Double numOfOnHoldTask = 0.0;
        Double numOfCancelledTask = 0.0;
        Double numOfFinishedTask = 0.0;
        Integer numberOfTasks = tasks.size();
        if (numberOfTasks ==0) {
            projectPercentage.setFinished(0);
            projectPercentage.setCancelled((int)0);
            projectPercentage.setInProgress((int)0);
            projectPercentage.setNotStarted((int)0);
            projectPercentage.setOnHold((int)0);
        }else if (numberOfTasks == 1) {
            for (Task task : tasks) {
                if(task.getStatus()=="Finished"){
                    projectPercentage.setFinished(0);
                    projectPercentage.setCancelled((int)0);
                    projectPercentage.setInProgress((int)0);
                    projectPercentage.setNotStarted((int)0);
                    projectPercentage.setOnHold((int)0);
                }
            }
        }else{
            numberOfTasks =numberOfTasks-1;

            for (Task task : tasks) {
                switch (task.status) {
                case "Not Started":
                numOfNotStartedTask++;
                    break;
                case "In Progress":
                numOfInProgressTask++;
                    break;
                case "On Hold":
                numOfOnHoldTask++;
                    break;
                case "Cancelled":
                numOfCancelledTask++;
                    break;
                case "Finished":
                numOfFinishedTask++;
                    break;
                default:
                    break;
                }
            }
            projectPercentage.setFinished((int)((numOfFinishedTask/numberOfTasks)*100));
            projectPercentage.setCancelled((int)((numOfCancelledTask/numberOfTasks)*100));
            projectPercentage.setInProgress((int)((numOfInProgressTask/numberOfTasks)*100));
            projectPercentage.setNotStarted((int)((numOfNotStartedTask/numberOfTasks)*100));
            projectPercentage.setOnHold((int)((numOfOnHoldTask/numberOfTasks)*100));
        }

       
        return projectPercentage;
    }

}
