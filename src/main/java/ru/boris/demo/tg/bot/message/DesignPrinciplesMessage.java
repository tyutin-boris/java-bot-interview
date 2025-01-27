package ru.boris.demo.tg.bot.message;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import ru.boris.demo.tg.bot.api.message.TgMessage;

import java.util.ArrayList;
import java.util.List;

import static ru.boris.demo.tg.bot.dto.CallbackQueryType.DESIGN_PRINCIPAL_LEFT;
import static ru.boris.demo.tg.bot.dto.CallbackQueryType.DESIGN_PRINCIPAL_RIGHT;

public class DesignPrinciplesMessage extends TgMessage {

    private final List<String> designPrinciples = new ArrayList<>();
    private int current;

    public DesignPrinciplesMessage(Long chatId, Integer messageId) {
        super(chatId, messageId);
        this.inlineKeyboardMarkup.setKeyboard(getButtons());
        this.text = """
                 Выделите аспекты приложения, которые могут изменятся,\s
                 и отделите их от тех, которые всегда остаются постоянными.
                """;

        designPrinciples.add(0, text);
        designPrinciples.add(1, "two");
        designPrinciples.add(2, "three");
        designPrinciples.add(3, "four");
        designPrinciples.add(4, "fife");
        designPrinciples.add(5, "six");
        designPrinciples.add(6, "seven");
        this.current = 0;

    }

    public String next() {
        if (current < designPrinciples.size() - 1) {
            return designPrinciples.get(++current);
        }

        current = 0;
        return designPrinciples.get(current);
    }

    public String prev() {
        if (current <= 0) {
            current = designPrinciples.size() - 1;
            return designPrinciples.get(current);
        }

        return designPrinciples.get(--current);
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
