insert into teacher (username, password, name) values ('teacher', '$2a$12$y32WiiXJxQH1bjDL21cKIOCqdRx3UGwsRmzYRJ1xFvEzr0J7n2gf6', 'John Doe');
insert into teacher (username, password, name) values ('teacher2', '$2a$12$y32WiiXJxQH1bjDL21cKIOCqdRx3UGwsRmzYRJ1xFvEzr0J7n2gf6', 'Kal Drogo');

insert into task (taskDesc, taskName, teacher_teacherId) values ('this is first description and it is just a long text', 'first task', 1);
insert into task (taskDesc, taskName, teacher_teacherId) values ('task number 2 has a different description', 'to do', 1);
insert into task (taskDesc, taskName, teacher_teacherId) values ('2 databases should be merged', 'db merge', 1);
insert into task (taskDesc, taskName, teacher_teacherId) values ('create an application that tracks gps', 'gps tracker', 1);
insert into task (taskDesc, taskName, teacher_teacherId) values ('find a full stack developer', 'developer search', 1);
insert into task (taskDesc, taskName, teacher_teacherId) values ('the only task for teacher 2', 'sample', 2);

insert into submission (sDesc, submissionDate, submitterName, task_taskId, point) values ('submission number one', CURRENT_TIMESTAMP(), 'mesud', 1, 3);
insert into submission (sDesc, submissionDate, submitterName, task_taskId, point) values ('submission number two', CURRENT_TIMESTAMP(), 'valeh', 1, 2);
insert into submission (sDesc, submissionDate, submitterName, task_taskId, point) values ('submission description sample', CURRENT_TIMESTAMP(), 'latif', 1, 4);
insert into submission (sDesc, submissionDate, submitterName, task_taskId, point) values ('aaaabbbbbccccddddddd abcd', CURRENT_TIMESTAMP(), 'seymur', 2, 4);
insert into submission (sDesc, submissionDate, submitterName, task_taskId, point) values ('lorem ipsum dolar amen and so on...', CURRENT_TIMESTAMP(), 'seymur', 1, 5);
insert into submission (sDesc, submissionDate, submitterName, task_taskId) values ('lsubmission with no points', CURRENT_TIMESTAMP(), 'seymur', 1);