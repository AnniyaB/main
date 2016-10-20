package seedu.address.model;

import javafx.collections.ObservableList;
import seedu.address.model.deadline.Deadline;
import seedu.address.model.deadline.UniqueDeadlineList;
import seedu.address.model.tag.Tag;
import seedu.address.model.tag.UniqueTagList;
import seedu.address.model.task.ReadOnlyTask;
import seedu.address.model.task.Task;
import seedu.address.model.task.UniqueTaskList;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Wraps all data at the task manager level
 * Duplicates are not allowed (by .equals comparison)
 */
public class TaskManager implements ReadOnlyTaskManager {

    private final UniqueTaskList tasks;
    private final UniqueTagList tags;
    private final UniqueDeadlineList deadlines;

    {
        tasks = new UniqueTaskList();
        tags = new UniqueTagList();
        deadlines = new UniqueDeadlineList();
    }

    public TaskManager() {}

    /**
     * Tasks and Tags are copied into this task manager
     */
    public TaskManager(ReadOnlyTaskManager toBeCopied) {
        this(toBeCopied.getUniqueTaskList(), toBeCopied.getUniqueDeadlineList(), toBeCopied.getUniqueTagList());
    }

    /**
     * Persons and Tags are copied into this task manager
     */
    public TaskManager(UniqueTaskList persons, UniqueDeadlineList deadlines, UniqueTagList tags) {
        resetData(persons.getInternalList(), deadlines.getInternalList(), tags.getInternalList());
    }

    public static ReadOnlyTaskManager getEmptyTaskManager() {
        return new TaskManager();
    }

//// list overwrite operations

    public ObservableList<Task> getTasks() {
        return tasks.getInternalList();
    }

    public void setTasks(List<Task> tasks) {
        this.tasks.getInternalList().setAll(tasks);
    }

    public void setDeadlines(Collection<Deadline> deadlines) {
        this.deadlines.getInternalList().setAll(deadlines);
    }
    
    public void setTags(Collection<Tag> tags) {
        this.tags.getInternalList().setAll(tags);
    }
    
    public void resetData(Collection<? extends ReadOnlyTask> newTasks, Collection<Deadline> newDeadlines, Collection<Tag> newTags) {
        setTasks(newTasks.stream().map(Task::new).collect(Collectors.toList()));
        setDeadlines(newDeadlines);
        setTags(newTags);
    }

    public void resetData(ReadOnlyTaskManager newData) {
        resetData(newData.getTaskList(), newData.getDeadlineList(), newData.getTagList());
    }

//// task-level operations

    /**
     * Adds a task to the address book.
     * Also checks the new task's tags and updates {@link #tags} with any new tags found,
     * and updates the Tag objects in the task to point to those in {@link #tags}.
     *
     * @throws UniqueTaskList.DuplicateTaskException if an equivalent task already exists.
     */
    public void addTask(Task p) throws UniqueTaskList.DuplicateTaskException {
        syncTagsWithMasterList(p);
        tasks.add(p);
    }

    /**
     * Ensures that every tag in this task:
     *  - exists in the master list {@link #tags}
     *  - points to a Tag object in the master list
     */
    private void syncTagsWithMasterList(Task task) {
        final UniqueTagList taskTags = task.getTags();
        tags.mergeFrom(taskTags);

        // Create map with values = tag object references in the master list
        final Map<Tag, Tag> masterTagObjects = new HashMap<>();
        for (Tag tag : tags) {
            masterTagObjects.put(tag, tag);
        }

        // Rebuild the list of person tags using references from the master list
        final Set<Tag> commonTagReferences = new HashSet<>();
        for (Tag tag : taskTags) {
            commonTagReferences.add(masterTagObjects.get(tag));
        }
        task.setTags(new UniqueTagList(commonTagReferences));
    }
    
    private void syncDeadlinesWithMasterList(Task task) {
        final UniqueDeadlineList taskDeadlines = task.getDeadlines();
        deadlines.mergeFrom(taskDeadlines);

        // Create map with values = tag object references in the master list
        final Map<Deadline, Deadline> masterDeadlineObjects = new HashMap<>();
        for (Deadline deadline : deadlines) {
            masterDeadlineObjects.put(deadline, deadline);
        }

        // Rebuild the list of person tags using references from the master list
        final Set<Deadline> commonDeadlineReferences = new HashSet<>();
        for (Deadline deadline : taskDeadlines) {
            commonDeadlineReferences.add(masterDeadlineObjects.get(deadline));
        }
        task.setDeadlines(new UniqueDeadlineList(commonDeadlineReferences));
    }

    public boolean removeTask(ReadOnlyTask key) throws UniqueTaskList.TaskNotFoundException {
        if (tasks.remove(key)) {
            return true;
        } else {
            throw new UniqueTaskList.TaskNotFoundException();
        }
    }

////deadline-level operations

   public void addDeadline(Deadline d) throws UniqueDeadlineList.DuplicateDeadlineException {
       deadlines.add(d);
   }
   
//// tag-level operations

    public void addTag(Tag t) throws UniqueTagList.DuplicateTagException {
        tags.add(t);
    }
    

//// util methods

    @Override
    public String toString() {
        return tasks.getInternalList().size() + " tasks, " + deadlines.getInternalList().size() + " deadlines, " + tags.getInternalList().size() +  " tags";
        // TODO: refine later
    }

    @Override
    public List<ReadOnlyTask> getTaskList() {
        return Collections.unmodifiableList(tasks.getInternalList());
    }

    @Override
    public List<Deadline> getDeadlineList() {
        return Collections.unmodifiableList(deadlines.getInternalList());
    }
    
    @Override
    public List<Tag> getTagList() {
        return Collections.unmodifiableList(tags.getInternalList());
    }

    @Override
    public UniqueTaskList getUniqueTaskList() {
        return this.tasks;
    }

    @Override
    public UniqueDeadlineList getUniqueDeadlineList() {
        return this.deadlines;
    }

    @Override
    public UniqueTagList getUniqueTagList() {
        return this.tags;
    }


    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof TaskManager // instanceof handles nulls
                && this.tasks.equals(((TaskManager) other).tasks)
                && this.deadlines.equals(((TaskManager)other).deadlines)
                && this.tags.equals(((TaskManager) other).tags));
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(tasks, deadlines, tags);
    }
    
    public boolean contains(Task task){
    	return tasks.contains(task);
    }
}
