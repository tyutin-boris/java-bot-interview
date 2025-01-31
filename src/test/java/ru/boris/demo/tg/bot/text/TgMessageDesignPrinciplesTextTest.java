package ru.boris.demo.tg.bot.text;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TgMessageDesignPrinciplesTextTest {

    @Test
    @DisplayName("Должен вернуть все элементы перечисления и вернуться в начало")
    public void should_returnNextTextForEachValue_AndReturnToBeginning() {
        // Подготовка
        TgMessageDesignPrinciplesText[] values = TgMessageDesignPrinciplesText.values();
        TgMessageDesignPrinciplesText first = values[0];

        // Действие
        TgMessageDesignPrinciplesText current = first;
        for (int i = 0; i < values.length; i++) {
            current = current.next();
        }

        // Проверка
        Assertions.assertThat(current).isEqualTo(first);
    }

    @Test
    @DisplayName("Должен перебрать элементы в обратном порядку и вернуться в начало")
    public void should_returnPreviousTextForEachValue_AndReturnToBeginning() {
        // Подготовка
        TgMessageDesignPrinciplesText[] values = TgMessageDesignPrinciplesText.values();
        TgMessageDesignPrinciplesText first = values[0];

        // Действие
        TgMessageDesignPrinciplesText current = first;
        for (int i = 0; i < values.length; i++) {
            current = current.previous();
        }

        // Проверка
        Assertions.assertThat(current).isEqualTo(first);
    }
}
