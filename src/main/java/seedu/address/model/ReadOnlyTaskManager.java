package seedu.address.model;

import seedu.address.model.deadline.Deadline;
import seedu.address.model.deadline.UniqueDeadlineList;
import seedu.address.model.tag.Tag;
import seedu.address.model.tag.UniqueTagList;
import seedu.address.model.task.ReadOnlyTask;
import seedu.address.model.task.UniqueTaskList;

import java.util.List;

/**
 * Unmodifiable view of an task manager
 */
public interface ReadOnlyTaskManager {

    UniqueTagList getUniqueTagList();

    UniqueTaskList getUniqueTaskList();
    
    UniqueDeadlineList getUniqueDeadlineList();

    /**
     * Returns an unmodifiable view of tasks list
     */
    List<ReadOnlyTask> getTaskList();

    /**
     * Returns an unmodifiable view of tags list
     */
    List<Tag> getTagList();
    
    /**
     * Returns an unmodifiable view of deadlines list
     */
    List<Deadline> getDeadlineList();

}
