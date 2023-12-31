package fr.isep.jotransportapp.helpers;

import javafx.scene.paint.Color;

public class ColorHelpers {
    public static String toRGBCode(Color color) {
        return String.format("#%02X%02X%02X",
                (int) (color.getRed() * 255),
                (int) (color.getGreen() * 255),
                (int) (color.getBlue() * 255));
    }

    public static Color fromRGBCode(String rgbCode) {
        rgbCode = rgbCode.replace("0x", "#");
        rgbCode = rgbCode.replace(";", "");
        if (!(rgbCode.matches("#[0-9A-Fa-f]{6}") || rgbCode.matches("#[0-9A-Fa-f]{8}"))) {
            throw new IllegalArgumentException("Invalid decimal code : " + rgbCode);
        }

        int red = Integer.parseInt(rgbCode.substring(1, 3), 16);
        int green = Integer.parseInt(rgbCode.substring(3, 5), 16);
        int blue = Integer.parseInt(rgbCode.substring(5, 7), 16);

        double alpha = rgbCode.length() == 9 ? Integer.parseInt(rgbCode.substring(7, 9), 16) / 255.0 : 1.0;

        return Color.rgb(red, green, blue, alpha);
    }
}
