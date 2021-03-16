INSERT INTO setting(EditTasks,commentOnTasks,viewTaskAttachements,uploadAttachementsOnTask,viewActivityLog,viewTeamMembers,hideProjectTasksOnMainTasksTable) VALUES (FALSE,TRUE,TRUE,TRUE,FALSE,FALSE,FALSE);
INSERT INTO setting(EditTasks,commentOnTasks,viewTaskAttachements,uploadAttachementsOnTask,viewActivityLog,viewTeamMembers,hideProjectTasksOnMainTasksTable) VALUES (TRUE,FALSE,TRUE,TRUE,FALSE,FALSE,FALSE);
INSERT INTO setting(EditTasks,commentOnTasks,viewTaskAttachements,uploadAttachementsOnTask,viewActivityLog,viewTeamMembers,hideProjectTasksOnMainTasksTable) VALUES (TRUE,TRUE,FALSE,TRUE,FALSE,FALSE,FALSE);
INSERT INTO setting(EditTasks,commentOnTasks,viewTaskAttachements,uploadAttachementsOnTask,viewActivityLog,viewTeamMembers,hideProjectTasksOnMainTasksTable) VALUES (TRUE,TRUE,TRUE,FALSE,FALSE,FALSE,FALSE);

--
--
--
INSERT INTO project(createdDate,creator,deadline,description,documents,membres, name,progress,setting_id,startDate,status,subProject,tags,tasks) VALUES ( '2021-03-06', 'chahid','2021-03-06','first Project 1','file1.txt','chahid sami mah','Projet 1',55,1,'2021-03-06','active','Projet 1.1','dev , mobile','task 1');
INSERT INTO project(createdDate,creator,deadline,description,documents,membres, name,progress,setting_id,startDate,status,subProject,tags,tasks) VALUES ('2021-03-06', 'sami','2021-03-06','first Project 2','file1.txt','sami chahid mah','Projet 3',15,2,'2021-03-06','blocked','Projet 2.1','java ,.net','task 6');
INSERT INTO project(createdDate,creator,deadline,description,documents,membres, name,progress,setting_id,startDate,status,subProject,tags,tasks) VALUES ('2021-03-06', 'mah','2021-03-06','first Project 3','file1.txt','mah sami chahid','Projet 4',23,3,'2021-03-06','blocked','Projet 3.1','java ,.net','task 92');
INSERT INTO project(createdDate,creator,deadline,description,documents,membres, name,progress,setting_id,startDate,status,subProject,tags,tasks) VALUES ('2021-03-06', 'yasmine','2021-03-06','first Project 4','file1.txt','sami yasmine','Projet 2',99,4,'2021-03-06','active','Projet 4.1','java ,.net','task 12');

--
INSERT INTO comment(comment,commentDate,createdBy,task) VALUES ('comment num 1','2021-03-06', 'chaihd','tast num 1');
INSERT INTO comment(comment,commentDate,createdBy,task) VALUES ('comment num 2','2021-03-06', 'sami','tast num 2');
INSERT INTO comment(comment,commentDate,createdBy,task) VALUES ('comment num 3','2021-03-06', 'mah','tast num 3');
INSERT INTO comment(comment,commentDate,createdBy,task) VALUES ('comment num 4','2021-03-06', 'yasmine','tast num 4');


INSERT INTO task(name,description,membres,tags,comments,document,visibility,priority,status,progress,score,startDate,dueDate,createdDate,createdBy) VALUES ('taske 1','this is task num 1','chahid sami','dev,mobile','comment1','vide1.mp4','public','high','in progress',20,1,'2021-03-06','2021-03-06','2021-03-06','chaid');
INSERT INTO task(name,description,membres,tags,comments,document,visibility,priority,status,progress,score,startDate,dueDate,createdDate,createdBy) VALUES ('taske 2','this is task num 2','mah sami','makeup','comment2','vide2.mp4','private','low','blocked',33,1,'2021-03-06','2021-03-06','2021-03-06','sami');
INSERT INTO task(name,description,membres,tags,comments,document,visibility,priority,status,progress,score,startDate,dueDate,createdDate,createdBy) VALUES ('taske 3','this is task num 3','chahid yasmine','pfe','comment3','vide3.mp4','public','high','done',50,1,'2021-03-06','2021-03-06','2021-03-06','mah');
INSERT INTO task(name,description,membres,tags,comments,document,visibility,priority,status,progress,score,startDate,dueDate,createdDate,createdBy) VALUES ('taske 4','this is task num 4','mah sami','webdesign','comment4','vide4.mp4','public','medium','in progress',21,1,'2021-03-06','2021-03-06','2021-03-06','yasmine');
