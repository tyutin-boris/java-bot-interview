package ru.boris.demo.tg.bot.service;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.MaybeInaccessibleMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.boris.demo.tg.bot.api.service.UpdateService;

import java.util.Optional;

@Service
public class UpdateServiceImpl implements UpdateService {

    @Override
    public Long getChatId(Update update) {
        Optional<Long> chatIdFromMessage = Optional.ofNullable(update)
                .map(Update::getMessage)
                .map(Message::getChatId);

        if (chatIdFromMessage.isPresent()) {
            return chatIdFromMessage.get();
        }

        Optional<Long> chatIdFormCallback = Optional.ofNullable(update)
                .map(Update::getCallbackQuery)
                .map(CallbackQuery::getMessage)
                .map(MaybeInaccessibleMessage::getChatId);
        if (chatIdFormCallback.isPresent()) {
            return chatIdFormCallback.get();
        }

        throw new RuntimeException("Не удалось найти идентификатор чата");
    }

    @Override
    public Integer getMessageId(Update update) {
        Optional<Integer> messageIdFromMessage = Optional.ofNullable(update)
                .map(Update::getMessage)
                .map(Message::getMessageId);

        if (messageIdFromMessage.isPresent()) {
            return messageIdFromMessage.get();
        }

        Optional<Integer> messageIdFormCallback = Optional.ofNullable(update)
                .map(Update::getCallbackQuery)
                .map(CallbackQuery::getMessage)
                .map(MaybeInaccessibleMessage::getMessageId);

        if (messageIdFormCallback.isPresent()) {
            return messageIdFormCallback.get();
        }

        throw new RuntimeException("Не удалось найти идентификатор сообщения");
    }
}
