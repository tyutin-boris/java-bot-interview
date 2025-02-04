package ru.boris.demo.tg.bot.service;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import ru.boris.demo.tg.bot.api.message.TgMessage;
import ru.boris.demo.tg.bot.api.service.SendMessageService;

@Service
public class SendMessageServiceImpl implements SendMessageService {

    @Override
    public SendMessage getSendMessage(TgMessage tgMessage) {
        SendMessage message = new SendMessage();
        message.setChatId(tgMessage.getChatId());
        message.setText(tgMessage.getText());
        message.setReplyMarkup(tgMessage.getInlineKeyboardMarkup());

        return message;
    }

    @Override
    public SendMessage getSendMessage(Long chatId, String text) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText(text);
        return message;
    }
}
