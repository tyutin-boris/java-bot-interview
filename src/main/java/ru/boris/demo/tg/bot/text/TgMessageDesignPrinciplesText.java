package ru.boris.demo.tg.bot.text;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ru.boris.demo.tg.bot.api.text.CyclicText;
import ru.boris.demo.tg.bot.api.text.TgMessageText;

@Getter
@RequiredArgsConstructor
public enum TgMessageDesignPrinciplesText implements TgMessageText, CyclicText<TgMessageDesignPrinciplesText> {

    ONE("Выделите аспекты приложения, которые " +
        "могут изменяться, и отделите их от тех, " +
        "которые всегда остаются постоянными.") {
        @Override
        public TgMessageDesignPrinciplesText previous() {
            return NINE;
        }

        @Override
        public TgMessageDesignPrinciplesText next() {
            return TWO;
        }
    },
    TWO("Программируйте на уровне интерфейса, а не на уровне реализации.") {
        @Override
        public TgMessageDesignPrinciplesText previous() {
            return ONE;
        }

        @Override
        public TgMessageDesignPrinciplesText next() {
            return THREE;
        }
    },
    THREE("Отдавайте предпочтение композиции перед наследованием.") {
        @Override
        public TgMessageDesignPrinciplesText previous() {
            return TWO;
        }

        @Override
        public TgMessageDesignPrinciplesText next() {
            return FOUR;
        }
    },

    FOUR("Стремитесь к слабой связанности взаимодействующих объектов.") {
        @Override
        public TgMessageDesignPrinciplesText previous() {
            return THREE;
        }

        @Override
        public TgMessageDesignPrinciplesText next() {
            return FIFE;
        }
    },

    FIFE("Классы должны быть открыты для расширения, но закрыты для изменения.") {
        @Override
        public TgMessageDesignPrinciplesText previous() {
            return FOUR;
        }

        @Override
        public TgMessageDesignPrinciplesText next() {
            return SIX;
        }
    },

    SIX("Код должен зависеть от абстракции, а не от конкретных классов.") {
        @Override
        public TgMessageDesignPrinciplesText previous() {
            return FIFE;
        }

        @Override
        public TgMessageDesignPrinciplesText next() {
            return SEVEN;
        }
    },

    SEVEN("Принцип минимальной информированности: общайтесь только с близкими друзьями.") {
        @Override
        public TgMessageDesignPrinciplesText previous() {
            return SIX;
        }

        @Override
        public TgMessageDesignPrinciplesText next() {
            return EIGHT;
        }
    },

    EIGHT("Не вызывайте нас - мы вас сами вызовем.") {
        @Override
        public TgMessageDesignPrinciplesText previous() {
            return SEVEN;
        }

        @Override
        public TgMessageDesignPrinciplesText next() {
            return NINE;
        }
    },

    NINE("Класс должен иметь только одну причину для изменения.") {
        @Override
        public TgMessageDesignPrinciplesText previous() {
            return EIGHT;
        }

        @Override
        public TgMessageDesignPrinciplesText next() {
            return ONE;
        }
    };

    private final String text;
}
