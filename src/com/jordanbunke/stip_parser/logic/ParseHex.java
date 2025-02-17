package com.jordanbunke.stip_parser.logic;

import com.jordanbunke.delta_time.error.GameError;

public final class ParseHex {
    public static int hexToInt(final String hexSequence) {
        if (hexSequence.isEmpty() || !validHexSequence(hexSequence)) {
            GameError.send("String \"" + hexSequence +
                    "\" is not a valid hex sequence.");
            return 0;
        }

        final int BASE = 16;
        int accumulator = 0, power = 0;

        for (int i = hexSequence.length() - 1; i >= 0; i--) {
            final char c = hexSequence.toLowerCase().charAt(i);
            final int placeValue = isNumeric(c)
                    ? c - '0' : 10 + (c - 'a');

            accumulator += placeValue * Math.pow(BASE, power);
            power++;
        }

        return accumulator;
    }

    private static boolean validHexSequence(final String hexSequence) {
        for (char c : hexSequence.toCharArray())
            if (!(isNumeric(c) || isAlpha(c)))
                return false;

        return true;
    }

    private static boolean isNumeric(final char c) {
        return c >= '0' && c <= '9';
    }

    private static boolean isAlpha(final char c) {
        return (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F');
    }
}
