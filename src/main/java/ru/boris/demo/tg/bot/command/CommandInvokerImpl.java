package ru.boris.demo.tg.bot.command;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.boris.demo.tg.bot.api.command.Command;
import ru.boris.demo.tg.bot.api.command.CommandInvoker;
import ru.boris.demo.tg.bot.dto.BotCommands;
import ru.boris.demo.tg.bot.dto.CallbackQueryType;
import ru.boris.demo.tg.bot.dto.CommandType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CommandInvokerImpl implements CommandInvoker {

    private final Map<CommandType, Command> commands = new HashMap<>();

    public CommandInvokerImpl(List<Command> commands) {
        commands.forEach(command -> this.commands.put(command.getCommandType(), command));
    }

    @Override
    public void execute(Update update) {
        getCommandType(update)
                .map(commands::get)
                .ifPresent(command -> command.execute(update));
    }

    private Optional<CommandType> getCommandType(Update update) {
        Optional<BotCommands> botCommands = Optional.ofNullable(update)
                .map(Update::getMessage)
                .map(Message::getText)
                .flatMap(BotCommands::getCommandsByName);

        if (botCommands.isPresent()) {
            return getCommandType(botCommands.get());
        }

        Optional<CallbackQueryType> callbackQueryType = Optional.ofNullable(update)
                .map(Update::getCallbackQuery)
                .map(CallbackQuery::getData)
                .flatMap(CallbackQueryType::getByName);

        return callbackQueryType.flatMap(this::getCommandType);
    }

    private Optional<CommandType> getCommandType(CallbackQueryType callbackQueryType) {
        CommandType commandType = switch (callbackQueryType) {
            case DESIGN_PRINCIPAL_LEFT -> CommandType.DESIGN_PRINCIPAL_LEFT;
            case DESIGN_PRINCIPAL_RIGHT -> CommandType.DESIGN_PRINCIPAL_RIGHT;
        };
        return Optional.of(commandType);
    }

    private Optional<CommandType> getCommandType(BotCommands botCommand) {
        CommandType commandType = switch (botCommand) {
            case START -> CommandType.START;
            case DESIGN_PRINCIPLES -> CommandType.DESIGN_PRINCIPLE;
        };
        return Optional.of(commandType);
    }
}
