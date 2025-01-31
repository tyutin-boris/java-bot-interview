package ru.boris.demo.tg.bot.api.message;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

@Getter
@Setter
@RequiredArgsConstructor
public abstract class TgMessage {
    protected final Long chatId;
    protected final Integer messageId;
    protected String text;
    protected InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
}
