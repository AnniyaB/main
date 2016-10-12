# User Guide

1. [About the Task Manager](#about-the-task-manager)
2. [Ouick Start Guide](#quick-start-guide)
3. [Command Summary](#command-summary)
4. [Features](#features)
5. [FAQ](#faq)


## About the Task Manager

This product is meant to address the concerns of users who wish to schedule their tasks using a simple and 	easy command-line interface.

## Quick Start Guide 

0. Make sure you have Java version `1.8.0_60` or later installed in your computer.<br>
   > This app will not work with previous versions of Java 8.
   
1. Download the latest 'The Practical Task Manager' file (tptm.jar) from the [releases](../../../releases) tab.
2. Copy the file to a suitable location on your computer. This location will serve as the home folder for the Task Manager.
3. Double-click the file to start the application. The GUI should appear in a few seconds (Figure 1). 
4. Type a command in the command box and press <kbd>enter</kbd> to execute it. Depending on the command, the Task Manager will respond by displaying a message in the console window.
5. Some example commands you can try:
   * **'list'** : lists all tasks
   * **'add task'**` Project due for CS2103 d/121116 p/3` : adds a Task named 'Project due for CS2103' on the 12/11/2016 at a priority of level 3 to the Task Manager.
   * **'delete'**` 1` : deletes the first task shown in the current list
   * **'exit'** : exits the application
6. Refer to the [Features](#features) section below for details of each command.<br>

![Image of UI](https://github.com/AnniyaB/main/blob/master/Ui.png)
                                                              Figure 1

## Command Summary

Command | Format  
-------- | :-------- 
Add | `add <TASKNAME> d/<DEADLINE> p/<PRIORITY>`
Clear | `clear`
Edit | `edit <INDEX> <TASKNAME> d/<DEADLINE> p/<PRIORITY>`
Delete | `delete <INDEX>`
Find | `find KEYWORD [MORE_KEYWORDS]`
List | `list`
Help | `help`
Select | `select <INDEX>`
View | `view <TASKNAME>`

## Features

> **Command Format**
> * Words in `UPPER_CASE` are the parameters.
> * Items in `SQUARE_BRACKETS` are optional.
> * Items with `...` after them can have multiple instances.
> * The order of parameters is fixed.

#### Viewing help : `help`
Description: displays all commands
Format: `help`

> Help is also shown if you enter an incorrect command e.g. `abcd`
 
#### Adding a task: `add`
Description: Adds a task to the task manager<br>
Format: `add TASK_DESCRIPTION [d/DEADLINE] [p/PRIORITY] [t/TAG]...` 

> Tasks can have no deadline. In which case, leave the DEADLINE field blank.
> Tasks can have different priority levels or none at all (From 1 to 5, where 1 is the lowest priority and 5 is the highest priority).
> Tasks can have any amount of tags (even 0).

Examples: 
* `add CS2103 project d/231016 p/5 t/Group`
* `add make sandwich d/111016 p/1 t/hungry`
* `add complete report`

#### Listing all tasks : `list`
Description: Shows a list of all tasks in the task manager.<br>
Format: `list`

> `list` will show in order of tasks added.

#### Finding all tasks containing any keyword in their name: `find`
Description: Finds task whose names contain any of the given keywords.<br>
Format: `find KEYWORD [MORE_KEYWORDS]`

> * The search is case sensitive. e.g `cs2103t` will not match `CS2103T`
> * The order of the keywords does not matter. e.g. `Software Engineering` will match `Engineering Software`
> * Only the name is searched.
> * Only full words will be matched e.g. `CS2103` will not match `CS2103T`
> * Tasks matching at least one keyword will be returned (i.e. `OR` search).
    e.g. `Software` will match `Software Engineering`

Examples: 
* `find Software`<br>
  Returns `Software Engineering` but not `software`
* `find CS2103T Software Engineering`<br>
  Returns Any task having names `CS2103T`, `Software`, or `Engineering`

#### Deleting a task : `delete`
Description: Deletes the specified task from the task manager. 
*Note: This process is irreversible.<br>
Format: `delete INDEX`

> Deletes the task at the specified `INDEX`. 
  The index refers to the index number shown in the most recent listing.<br>
  The index **must be a positive integer** 1, 2, 3, ...

Examples: 
* `list`<br>
  `delete 2`<br>
  Deletes the 2nd task in the task manager.
* `find CS2101`<br> 
  `delete 1`<br>
  Deletes the 1st task in the results of the `find` command.

#### Selecting a task : `select`
Description: Selects the task identified by the index number used in the last task listing.<br>
Format: `select INDEX`

> Selects the task and loads the Google search page the task at the specified `INDEX`. 
  The index refers to the index number shown in the most recent listing.<br>
  The index **must be a positive integer** 1, 2, 3, ...

Examples: 
* `list`<br>
  `select 2`<br>
  Selects the 2nd task in the address book.
* `find CS2103T` <br> 
  `select 1`<br>
  Selects the 1st person in the results of the `find` command.
  
#### View details of a task: `view`
Description: Displays all details of a specified task or all tasks due on a certain day.
Format: `view TASKNAME` or `view DEADLINE`

Examples:
* `view CS2103T`
* `view d/121116`

#### Clearing all entries : `clear`
Description: Clears all entries from the task manager.<br>
Format: `clear`

> If user enters `clear` the program will prompt `Program will wipe ALL entries do you still want to proceed? y/n`
  If the User confirms `y` then `clear` will execute, if `n` it will not.

#### Exiting the program : `exit`
Description: Exits the program.<br>
Format: `exit` 

#### Editing a task: `edit`
Description: Edits the last task selected.<br>
Format: `edit INDEX INPUT [INPUT] [INPUT]`

> * Edits the task by replacing the information stored with the input entered.
> * Inputs are the same as specified in the `add` command function.

Examples:
* `list`<br>
  `edit 3 Finish studying for EE2021 d/121116 p/4`<br>
  Edits the third task in the list of the task manager by replacing the description, changing the date nd the priority.
* `find CS2101 meeting`<br>
  `edit 1 CS2101 meeting d/131016 p/5 t/John will be late`<br>
  Added in the tag `John will be late` and changed the priority.
  
#### Saving the data 
Task Manager data is saved in the hard disk automatically after any command that changes the data.<br>
There is no need to save manually.

## FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with 
       the file that contains the data of your previous Task Manager folder.          
       
