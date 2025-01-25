package ru.boris.demo.tg.bot.api.command;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.boris.demo.tg.bot.dto.CommandType;

public interface Command {

    void execute(Update update);

    CommandType getCommandType();
}
