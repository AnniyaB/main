package seedu.address.logic.commands;

import seedu.address.commons.exceptions.FinishStateException;

/**
 * Reverts back to the initial state in the task manager before undo occurs.
 */
public class RevertCommand extends Command {
	
	public static final String COMMAND_WORD = "rev";
	
	public static final String MESSAGE_USAGE = COMMAND_WORD + ": Reverts the previously done undo command.\n"
			+ "Example: " + COMMAND_WORD;
	
	public static final String MESSAGE_SUCCESS = "Reverted back to the most recent command";
	public static final String MESSAGE_FAILED = "Unable to revert commands";
	
	public RevertCommand() {
		
	}
	
	@Override
	public CommandResult execute() {
		try {
			String point = model.getInitialState();
			return new CommandResult(MESSAGE_SUCCESS);
		} catch (FinishStateException e) {
			return new CommandResult(MESSAGE_FAILED);
		}
		
	}
		
}