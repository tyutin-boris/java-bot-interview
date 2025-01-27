package ru.boris.demo.tg.bot.api.command;

import org.telegram.telegrambots.meta.api.objects.Update;

public interface CommandInvoker {

    void execute(Update update);
}
