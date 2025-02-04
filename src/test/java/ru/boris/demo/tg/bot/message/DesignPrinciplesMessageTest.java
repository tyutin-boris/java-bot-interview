package ru.boris.demo.tg.bot.message;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.boris.demo.tg.bot.text.TgMessageDesignPrinciplesText;

public class DesignPrinciplesMessageTest {

    private final DesignPrinciplesMessage sut = new DesignPrinciplesMessage(1L, 2);

    @Test
    @DisplayName("Должен вернуть текст для всех принципов и вернуться к первому")
    public void shout_returnAllPrinciples_and_returnToBeginning() {
        // Подготовка
        TgMessageDesignPrinciplesText[] values = TgMessageDesignPrinciplesText.values();
        TgMessageDesignPrinciplesText first = sut.getCurrent();

        // Действие
        TgMessageDesignPrinciplesText current = first;
        for (int i = 0; i < values.length; i++) {
            current = current.next();
        }

        // Проверка
        Assertions.assertThat(current).isEqualTo(first);
    }

    @Test
    @DisplayName("Должен вернуть текст в обратном порядке для всех принципов и вернуться к первому")
    public void shout_returnAllPreviousPrinciples_and_returnToBeginning() {
        // Подготовка
        TgMessageDesignPrinciplesText[] values = TgMessageDesignPrinciplesText.values();
        TgMessageDesignPrinciplesText first = sut.getCurrent();

        // Действие
        TgMessageDesignPrinciplesText current = first;
        for (int i = 0; i < values.length; i++) {
            current = current.previous();
        }

        // Проверка
        Assertions.assertThat(current).isEqualTo(first);
    }
}
