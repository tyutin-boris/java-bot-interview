package ru.boris.demo.tg.bot.command;

import lombok.RequiredArgsConstructor;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.boris.demo.tg.bot.TgBot;
import ru.boris.demo.tg.bot.api.command.Command;
import ru.boris.demo.tg.bot.dto.BotCommands;
import ru.boris.demo.tg.bot.dto.CommandType;

import java.util.Optional;

@RequiredArgsConstructor
public class StartCommand implements Command {

    private final TgBot bot;

    @Override
    public void execute(Update update) {
        Long chatId = Optional.ofNullable(update)
                .map(Update::getMessage)
                .map(Message::getChat)
                .map(Chat::getId)
                .orElseThrow(() -> new RuntimeException("Не удалось определить идентификатор чата"));

        Optional<String> text = Optional.ofNullable(update)
                .map(Update::getMessage)
                .map(Message::getText);

        text.ifPresent(message -> {
            if (BotCommands.START.getName().equals(message)) {
                SendMessage method = new SendMessage();
                method.setChatId(chatId);
                method.setText("Привет мой маленький любитель паттернов");
                try {
                    bot.execute(method);
                } catch (TelegramApiException e) {
                    throw new RuntimeException("Ошибка при отправке сообщения", e);
                }
            }
        });
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.START;
    }
}
