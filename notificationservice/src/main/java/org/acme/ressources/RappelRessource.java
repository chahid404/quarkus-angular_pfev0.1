package org.acme.ressources;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.acme.requestClasses.Task;
import org.acme.requestClasses.User;
import org.acme.service.MailService;
import org.acme.service.TaskService;
import org.acme.service.userService;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import io.quarkus.scheduler.Scheduled;

@ApplicationScoped              
public class RappelRessource {
    @Inject
    @RestClient
    userService userService;

    @Inject
    @RestClient
    TaskService taskService;

    @Inject
    MailService mailService;

    @Scheduled(cron="0 15 10 * * ?") 
    void sendRappel(){
        List<Task> taskslist = taskService.getNotFinishedTasksByDueDate(LocalDate.now().plusDays(1).toString());
        for (Task task : taskslist) {
           List<String> users = Arrays.asList(task.getMembres());
           for (String userid : users) {
            User user = userService.getUserById(userid);
            mailService.sendRappelTaskHtml(task.getName(), user.email);            
           }
        }
    }

}
