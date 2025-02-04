package ru.boris.demo.tg.bot.api.service;

import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import ru.boris.demo.tg.bot.api.message.TgMessage;

public interface EditMessageTextService {

    EditMessageText getEditMessageText(TgMessage tgMessage);
}
