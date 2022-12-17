package com.periodicallyprogramming.notifi;

public final class Commands
{

    // Command List
    public static final String NOTIFI = "notifi";
    public static final String NOTIFI_DESCRIPTION = "Receive a DM when reminder is sent in mutual servers";

    // Subcommands
    public static final String NOTIFI_HELP = "help";
    public static final String NOTIFI_HELP_DESCRIPTION = "Lists all notifi commands";

    public static final String NOTIFI_RESET = "reset";
    public static final String NOTIFI_RESET_DESCRIPTION = "Resets all stored reminders";

    public static final String NOTIFI_LIST = "list";
    public static final String NOTIFI_LIST_DESCRIPTION = "Lists all stored reminders";

    public static final String NOTIFI_NEW = "new";
    public static final String NOTIFI_NEW_DESCRIPTION = "Add a new reminder";
    public static final String NOTIFI_NEW_OPTION_NAME = "word";
    public static final String NOTIFI_NEW_OPTION_DESCRIPTION = "Reminder word";

    public static final String NOTIFI_DELETE = "delete";
    public static final String NOTIFI_DELETE_DESCRIPTION = "Delete a stored reminder";
    public static final String NOTIFI_DELETE_OPTION_NAME = "word";
    public static final String NOTIFI_DELETE_OPTION_DESCRIPTION = "Reminder word";

    public static final String NOTIFI_TOGGLE = "toggle";
    public static final String NOTIFI_TOGGLE_OPTION_NAME = "switch";
    public static final String NOTIFI_TOGGLE_OPTION_DESCRIPTION = "Toggles notifications";
    public static final String NOTIFI_TOGGLE_DESCRIPTION = "Toggles notifications";

    private Commands()
    {

    }

}