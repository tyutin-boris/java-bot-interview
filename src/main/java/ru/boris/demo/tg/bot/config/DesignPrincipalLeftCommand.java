package ru.boris.demo.tg.bot.config;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.boris.demo.tg.bot.TgBot;
import ru.boris.demo.tg.bot.api.command.Command;
import ru.boris.demo.tg.bot.api.service.TgMessageService;
import ru.boris.demo.tg.bot.dto.CommandType;

public class DesignPrincipalLeftCommand implements Command {


    public DesignPrincipalLeftCommand(TgBot bot, TgMessageService messageService) {
    }

    @Override
    public void execute(Update update) {

    }

    @Override
    public CommandType getCommandType() {
        return null;
    }
}
