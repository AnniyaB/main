- click on the icon and access the application
--the application will be opend 

- load ./data/ManualTesing/SampleData.xml
-- the application will be closed

- restarts the application

- listtag lesson
-- all tasks that contain lesson in [] will be shown

- find ger
-- all tasks what has name ger regardless spacing or case will be shown

- delete 3
-- the third task will be deleted 

- undo
-- the third task deleted just now will be back to the list

- rev
-- undo the undo, the third task will be deleted

- edit 1 n/CS2111 s/010716 p/5
-- edit the first task with new name, startline and priority

- complete 3
-- the third task will be marked as completed, and all startline and deadline will be set as blank

- list
-- only incompete tasks will be shown

- listall
-- show all the tasks regardless it is completed or not

- repeat 1 weekly
-- a new tag [weekly] will be added to the first task

- complete 49
-- the repeated (weekly) task is completed, the deadline will be set to the next deadline and the color of the task now is changed to b    black

- undo
-- repeated task can be undo and the deadline is changed back 

- unpdate 
-- the list will be updated, color coding will be reflected. The task manager is updated automatically every minute

- repeat 49 off
-- the tag [weekly] is deleted

- help
-- user guide will pop out

- save ./src/test/data/ManualTesting/SampleData2.xml 
-- save all the changed to SampleData2.xml 

- clear
-- a confirmation window will pop out, and click confirm

- exit
-- exit the application
