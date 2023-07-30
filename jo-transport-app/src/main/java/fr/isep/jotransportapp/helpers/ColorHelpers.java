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
        if (rgbCode == null || !rgbCode.matches("#[0-9A-Fa-f]{6}")) {
            throw new IllegalArgumentException("Invalid decimal code : " + rgbCode);
        }

        int red = Integer.parseInt(rgbCode.substring(1, 3), 16);
        int green = Integer.parseInt(rgbCode.substring(3, 5), 16);
        int blue = Integer.parseInt(rgbCode.substring(5, 7), 16);

        return Color.rgb(red, green, blue);
    }
}
