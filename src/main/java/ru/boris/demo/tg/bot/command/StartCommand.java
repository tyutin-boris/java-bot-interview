package ru.boris.demo.tg.bot.command;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.boris.demo.tg.bot.api.command.Command;
import ru.boris.demo.tg.bot.api.service.SendMessageService;
import ru.boris.demo.tg.bot.api.service.TgBotService;
import ru.boris.demo.tg.bot.api.service.UpdateService;
import ru.boris.demo.tg.bot.dto.CommandType;

@Service
@RequiredArgsConstructor
public class StartCommand implements Command {

    private final TgBotService tgBotService;
    private final UpdateService updateService;
    private final SendMessageService sendMessageService;

    @Override
    public void execute(Update update) {
        Long chatId = updateService.getChatId(update);
        String text = "Привет мой маленький любитель паттернов";
        SendMessage message = sendMessageService.getSendMessage(chatId, text);
        tgBotService.send(message);
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.START;
    }
}
