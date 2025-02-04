package ru.boris.demo.tg.bot.service;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import ru.boris.demo.tg.bot.api.message.TgMessage;
import ru.boris.demo.tg.bot.api.service.EditMessageTextService;

@Service
public class EditMessageTextServiceImpl implements EditMessageTextService {

    @Override
    public EditMessageText getEditMessageText(TgMessage tgMessage) {
        EditMessageText response = new EditMessageText();
        response.setChatId(tgMessage.getChatId());
        response.setMessageId(tgMessage.getMessageId());
        response.setText(tgMessage.getText());
        response.setReplyMarkup(tgMessage.getInlineKeyboardMarkup());
        return response;
    }
}
