package com.periodicallyprogramming.notifi;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.guild.GuildJoinEvent;
import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.SubcommandData;
import org.jetbrains.annotations.NotNull;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Register extends ListenerAdapter
{

    @Override
    public void onGenericEvent( @NotNull GenericEvent event )
    {

        // Register commands (#updateCommands will CLEAR all commands, don't do this more than once per startup)
        updateCommands( event );
    }

    /**
     * Updates bot commands in guild
     *
     * @param event GuildReadyEvent or GuildJoinEvent
     */
    private void updateCommands( GenericEvent event )
    {

        Guild guild;

        if ( event instanceof GuildReadyEvent guildReadyEvent )
        {
            guild = guildReadyEvent.getGuild();
        }
        else if ( event instanceof GuildJoinEvent guildJoinEvent )
        {
            guild = guildJoinEvent.getGuild();
        }
        else
        {
            return;
        }

        // Registers guild commands
        guild.updateCommands().addCommands( guildCommands() )
                .queue( ( null ), ( ( error ) -> LoggerFactory.getLogger( Main.class )
                        .info( "Failed to update commands for " + guild.getName() + " (" + guild.getId()
                                + ")" ) ) );
    }

    /**
     * Guild Commands List
     * <p>
     * All commands intended ONLY for guild usage are returned in a List
     * </p>
     *
     * @return List containing bot commands
     */
    private List<CommandData> guildCommands()
    {

        // List holding all guild commands
        List<CommandData> guildCommandData = new ArrayList<>();

        // Notifi command + subcommands
        SubcommandData help = new SubcommandData( com.periodicallyprogramming.notifi.Commands.NOTIFI_HELP,
                com.periodicallyprogramming.notifi.Commands.NOTIFI_HELP_DESCRIPTION );
        SubcommandData reset = new SubcommandData( com.periodicallyprogramming.notifi.Commands.NOTIFI_RESET,
                com.periodicallyprogramming.notifi.Commands.NOTIFI_RESET_DESCRIPTION );
        SubcommandData list = new SubcommandData( com.periodicallyprogramming.notifi.Commands.NOTIFI_LIST,
                com.periodicallyprogramming.notifi.Commands.NOTIFI_LIST_DESCRIPTION );
        SubcommandData toggle =
                new SubcommandData( com.periodicallyprogramming.notifi.Commands.NOTIFI_TOGGLE,
                        com.periodicallyprogramming.notifi.Commands.NOTIFI_TOGGLE_DESCRIPTION )
                        .addOption( OptionType.BOOLEAN, com.periodicallyprogramming.notifi.Commands.NOTIFI_TOGGLE_OPTION_NAME,
                                com.periodicallyprogramming.notifi.Commands.NOTIFI_TOGGLE_OPTION_DESCRIPTION, true );
        SubcommandData newReminder =
                new SubcommandData( com.periodicallyprogramming.notifi.Commands.NOTIFI_NEW,
                        com.periodicallyprogramming.notifi.Commands.NOTIFI_NEW_DESCRIPTION )
                        .addOption( OptionType.STRING, com.periodicallyprogramming.notifi.Commands.NOTIFI_NEW_OPTION_NAME,
                                com.periodicallyprogramming.notifi.Commands.NOTIFI_NEW_OPTION_DESCRIPTION, true );
        SubcommandData delete =
                new SubcommandData( com.periodicallyprogramming.notifi.Commands.NOTIFI_DELETE,
                        com.periodicallyprogramming.notifi.Commands.NOTIFI_DELETE_DESCRIPTION )
                        .addOption( OptionType.STRING, com.periodicallyprogramming.notifi.Commands.NOTIFI_DELETE_OPTION_NAME,
                                com.periodicallyprogramming.notifi.Commands.NOTIFI_DELETE_OPTION_DESCRIPTION, true, true );

        guildCommandData.add(
                Commands.slash( com.periodicallyprogramming.notifi.Commands.NOTIFI,
                                com.periodicallyprogramming.notifi.Commands.NOTIFI_DESCRIPTION )
                        .addSubcommands( help, reset, list, toggle, newReminder, delete ) );

        return guildCommandData;
    }
}