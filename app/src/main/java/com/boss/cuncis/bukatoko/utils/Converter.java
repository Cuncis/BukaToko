package com.boss.cuncis.bukatoko.utils;

import java.text.NumberFormat;
import java.util.Locale;

public class Converter {
    public static String rupiah(int number) {
        NumberFormat numberFormat = NumberFormat.getInstance(Locale.GERMANY);
        return numberFormat.format(number);
    }
}
