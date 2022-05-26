package com.app.spidermanager.mocks;

import com.app.models.Spider;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class SpidersMocks {
    private final ArrayList<Spider> spiders;

    public ArrayList<Spider> getSpiders() {
        return spiders;
    }

    public SpidersMocks() throws ParseException {
        spiders = new ArrayList<>();
        SimpleDateFormat formatter = new SimpleDateFormat("MM.dd.yyyy");

        spiders.add(new Spider(1, "Егор", 10, "Brachypelma vagans", new byte[0], false, formatter.parse("26.05.2022"), formatter.parse("20.01.2022")));
        spiders.add(new Spider(2, "Пиксель", 6, "Phormictopus auratus", new byte[0], true, formatter.parse("26.05.2022"), formatter.parse("25.03.2022")));
        spiders.add(new Spider(3, "Тесла", 5, "Pterinopelma sazimai", new byte[0], null, formatter.parse("01.04.2022"), formatter.parse("18.03.2022")));
        spiders.add(new Spider(4, "Хельга", 12, "Grammostola pulchra", new byte[0], true, formatter.parse("19.04.2022"), formatter.parse("12.04.2022")));
        spiders.add(new Spider(5, "Чубайс", 13, "Pterinochilus murinus", new byte[0], true, formatter.parse("13.03.2022"), formatter.parse("21.05.2022")));
    }
}
