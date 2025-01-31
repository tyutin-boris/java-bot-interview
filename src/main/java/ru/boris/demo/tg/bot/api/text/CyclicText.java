package ru.boris.demo.tg.bot.api.text;

import ru.boris.demo.tg.bot.text.TgMessageDesignPrinciplesText;

public interface CyclicText<T> {

    TgMessageDesignPrinciplesText previous();

    TgMessageDesignPrinciplesText next();
}
