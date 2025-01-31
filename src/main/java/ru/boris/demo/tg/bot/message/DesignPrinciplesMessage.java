package ru.boris.demo.tg.bot.message;

import lombok.Getter;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import ru.boris.demo.tg.bot.api.message.TgMessage;
import ru.boris.demo.tg.bot.text.TgMessageDesignPrinciplesText;

import java.util.List;

import static ru.boris.demo.tg.bot.dto.CallbackQueryType.DESIGN_PRINCIPAL_LEFT;
import static ru.boris.demo.tg.bot.dto.CallbackQueryType.DESIGN_PRINCIPAL_RIGHT;

@Getter
public class DesignPrinciplesMessage extends TgMessage {

    private TgMessageDesignPrinciplesText current;

    public DesignPrinciplesMessage(Long chatId, Integer messageId) {
        super(chatId, messageId);
        this.inlineKeyboardMarkup.setKeyboard(getButtons());
        this.text = TgMessageDesignPrinciplesText.ONE.getText();
        this.current = TgMessageDesignPrinciplesText.ONE;
    }

    public String next() {
        TgMessageDesignPrinciplesText currentText = current;
        this.current = currentText.next();
        return current.getText();
    }

    public String previous() {
        TgMessageDesignPrinciplesText currentText = current;
        this.current = currentText.previous();
        return current.getText();
    }

    private List<List<InlineKeyboardButton>> getButtons() {
        InlineKeyboardButton left = new InlineKeyboardButton();
        left.setText(DESIGN_PRINCIPAL_LEFT.getText());
        left.setCallbackData(DESIGN_PRINCIPAL_LEFT.getName());

        InlineKeyboardButton right = new InlineKeyboardButton();
        right.setText(DESIGN_PRINCIPAL_RIGHT.getText());
        right.setCallbackData(DESIGN_PRINCIPAL_RIGHT.getName());

        return List.of(List.of(left, right));
    }
}
