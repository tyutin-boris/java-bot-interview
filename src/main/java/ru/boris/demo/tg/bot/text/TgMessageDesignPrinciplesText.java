package ru.boris.demo.tg.bot.text;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ru.boris.demo.tg.bot.api.text.CyclicText;
import ru.boris.demo.tg.bot.api.text.TgMessageText;

@Getter
@RequiredArgsConstructor
public enum TgMessageDesignPrinciplesText implements TgMessageText, CyclicText<TgMessageDesignPrinciplesText> {

    ONE("one") {
        @Override
        public TgMessageDesignPrinciplesText previous() {
            return FOUR;
        }

        @Override
        public TgMessageDesignPrinciplesText next() {
            return TWO;
        }
    },
    TWO("two") {
        @Override
        public TgMessageDesignPrinciplesText previous() {
            return ONE;
        }

        @Override
        public TgMessageDesignPrinciplesText next() {
            return THREE;
        }
    },
    THREE("three") {
        @Override
        public TgMessageDesignPrinciplesText previous() {
            return TWO;
        }

        @Override
        public TgMessageDesignPrinciplesText next() {
            return FOUR;
        }
    },

    FOUR("four") {
        @Override
        public TgMessageDesignPrinciplesText previous() {
            return THREE;
        }

        @Override
        public TgMessageDesignPrinciplesText next() {
            return ONE;
        }
    };

    private final String text;
}
