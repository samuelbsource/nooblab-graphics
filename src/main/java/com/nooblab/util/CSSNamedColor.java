package com.nooblab.util;

/**
 * Represents standardized color keywords as defined in the
 * <a href="https://www.w3.org/TR/css-color-4/#color-keywords">CSS Color Module Level 4</a>.
 * <p>
 * Each color is associated with a predefined name and its corresponding 32-bit ARGB integer value.
 * This enum allows lookup and validation of named colors based on the CSS standard.
 * </p>
 *
 * @see <a href="https://www.w3.org/TR/css-color-4/#color-keywords">CSS Color Module Level 4: Color Keywords</a>
 * @author Samuel Jonatan Boczek <samuelboczek@gmail.com>
 */
public enum CSSNamedColor {
    // Transparent color
    TRANSPARENT("transparent", 0x00000000),

    // Opaque colors
    ALICEBLUE("aliceblue", 0xFFF0F8FF),
    ANTIQUEWHITE("antiquewhite", 0xFFFAEBD7),
    AQUA("aqua", 0xFF00FFFF),
    AQUAMARINE("aquamarine", 0xFF7FFFD4),
    AZURE("azure", 0xFFF0FFFF),
    BEIGE("beige", 0xFFF5F5DC),
    BISQUE("bisque", 0xFFFFE4C4),
    BLACK("black", 0xFF000000),
    BLANCHEDALMOND("blanchedalmond", 0xFFFFEBCD),
    BLUE("blue", 0xFF0000FF),
    BLUEVIOLET("blueviolet", 0xFF8A2BE2),
    BROWN("brown", 0xFFA52A2A),
    BURLYWOOD("burlywood", 0xFFDEB887),
    CADETBLUE("cadetblue", 0xFF5F9EA0),
    CHARTREUSE("chartreuse", 0xFF7FFF00),
    CHOCOLATE("chocolate", 0xFFD2691E),
    CORAL("coral", 0xFFFF7F50),
    CORNFLOWERBLUE("cornflowerblue", 0xFF6495ED),
    CORNSILK("cornsilk", 0xFFFFF8DC),
    CRIMSON("crimson", 0xFFDC143C),
    CYAN("cyan", 0xFF00FFFF),
    DARKBLUE("darkblue", 0xFF00008B),
    DARKCYAN("darkcyan", 0xFF008B8B),
    DARKGOLDENROD("darkgoldenrod", 0xFFB8860B),
    DARKGRAY("darkgray", 0xFFA9A9A9),
    DARKGREEN("darkgreen", 0xFF006400),
    DARKGREY("darkgrey", 0xFFA9A9A9),
    DARKKHAKI("darkkhaki", 0xFFBDB76B),
    DARKMAGENTA("darkmagenta", 0xFF8B008B),
    DARKOLIVEGREEN("darkolivegreen", 0xFF556B2F),
    DARKORANGE("darkorange", 0xFFFF8C00),
    DARKORCHID("darkorchid", 0xFF9932CC),
    DARKRED("darkred", 0xFF8B0000),
    DARKSALMON("darksalmon", 0xFFE9967A),
    DARKSEAGREEN("darkseagreen", 0xFF8FBC8F),
    DARKSLATEBLUE("darkslateblue", 0xFF483D8B),
    DARKSLATEGRAY("darkslategray", 0xFF2F4F4F),
    DARKSLATEGREY("darkslategrey", 0xFF2F4F4F),
    DARKTURQUOISE("darkturquoise", 0xFF00CED1),
    DARKVIOLET("darkviolet", 0xFF9400D3),
    DEEPPINK("deeppink", 0xFFFF1493),
    DEEPSKYBLUE("deepskyblue", 0xFF00BFFF),
    DIMGRAY("dimgray", 0xFF696969),
    DIMGREY("dimgrey", 0xFF696969),
    DODGERBLUE("dodgerblue", 0xFF1E90FF),
    FIREBRICK("firebrick", 0xFFB22222),
    FLORALWHITE("floralwhite", 0xFFFFFAF0),
    FORESTGREEN("forestgreen", 0xFF228B22),
    FUCHSIA("fuchsia", 0xFFFF00FF),
    GAINSBORO("gainsboro", 0xFFDCDCDC),
    GHOSTWHITE("ghostwhite", 0xFFF8F8FF),
    GOLD("gold", 0xFFFFD700),
    GOLDENROD("goldenrod", 0xFFDAA520),
    GRAY("gray", 0xFF808080),
    GREEN("green", 0xFF008000),
    GREENYELLOW("greenyellow", 0xFFADFF2F),
    GREY("grey", 0xFF808080),
    HONEYDEW("honeydew", 0xFFF0FFF0),
    HOTPINK("hotpink", 0xFFFF69B4),
    INDIANRED("indianred", 0xFFCD5C5C),
    INDIGO("indigo", 0xFF4B0082),
    IVORY("ivory", 0xFFFFFFF0),
    KHAKI("khaki", 0xFFF0E68C),
    LAVENDER("lavender", 0xFFE6E6FA),
    LAVENDERBLUSH("lavenderblush", 0xFFFFF0F5),
    LAWNGREEN("lawngreen", 0xFF7CFC00),
    LEMONCHIFFON("lemonchiffon", 0xFFFFFACD),
    LIGHTBLUE("lightblue", 0xFFADD8E6),
    LIGHTCORAL("lightcoral", 0xFFF08080),
    LIGHTCYAN("lightcyan", 0xFFE0FFFF),
    LIGHTGOLDENRODYELLOW("lightgoldenrodyellow", 0xFFFAFAD2),
    LIGHTGRAY("lightgray", 0xFFD3D3D3),
    LIGHTGREEN("lightgreen", 0xFF90EE90),
    LIGHTGREY("lightgrey", 0xFFD3D3D3),
    LIGHTPINK("lightpink", 0xFFFFB6C1),
    LIGHTSALMON("lightsalmon", 0xFFFFA07A),
    LIGHTSEAGREEN("lightseagreen", 0xFF20B2AA),
    LIGHTSKYBLUE("lightskyblue", 0xFF87CEFA),
    LIGHTSLATEGRAY("lightslategray", 0xFF778899),
    LIGHTSLATEGREY("lightslategrey", 0xFF778899),
    LIGHTSTEELBLUE("lightsteelblue", 0xFFB0C4DE),
    LIGHTYELLOW("lightyellow", 0xFFFFFFE0),
    LIME("lime", 0xFF00FF00),
    LIMEGREEN("limegreen", 0xFF32CD32),
    LINEN("linen", 0xFFFAF0E6),
    MAGENTA("magenta", 0xFFFF00FF),
    MAROON("maroon", 0xFF800000),
    MEDIUMAQUAMARINE("mediumaquamarine", 0xFF66CDAA),
    MEDIUMBLUE("mediumblue", 0xFF0000CD),
    MEDIUMORCHID("mediumorchid", 0xFFBA55D3),
    MEDIUMPURPLE("mediumpurple", 0xFF9370DB),
    MEDIUMSEAGREEN("mediumseagreen", 0xFF3CB371),
    MEDIUMSLATEBLUE("mediumslateblue", 0xFF7B68EE),
    MEDIUMSPRINGGREEN("mediumspringgreen", 0xFF00FA9A),
    MEDIUMTURQUOISE("mediumturquoise", 0xFF48D1CC),
    MEDIUMVIOLETRED("mediumvioletred", 0xFFC71585),
    MIDNIGHTBLUE("midnightblue", 0xFF191970),
    MINTCREAM("mintcream", 0xFFF5FFFA),
    MISTYROSE("mistyrose", 0xFFFFE4E1),
    MOCCASIN("moccasin", 0xFFFFE4B5),
    NAVAJOWHITE("navajowhite", 0xFFFFDEAD),
    NAVY("navy", 0xFF000080),
    OLDLACE("oldlace", 0xFFFDF5E6),
    OLIVE("olive", 0xFF808000),
    OLIVEDRAB("olivedrab", 0xFF6B8E23),
    ORANGE("orange", 0xFFFFA500),
    ORANGERED("orangered", 0xFFFF4500),
    ORCHID("orchid", 0xFFDA70D6),
    PALEGOLDENROD("palegoldenrod", 0xFFEEE8AA),
    PALEGREEN("palegreen", 0xFF98FB98),
    PALETURQUOISE("paleturquoise", 0xFFAFEEEE),
    PALEVIOLETRED("palevioletred", 0xFFDB7093),
    PAPAYAWHIP("papayawhip", 0xFFFFEFD5),
    PEACHPUFF("peachpuff", 0xFFFFDAB9),
    PERU("peru", 0xFFCD853F),
    PINK("pink", 0xFFFFC0CB),
    PLUM("plum", 0xFFDDA0DD),
    POWDERBLUE("powderblue", 0xFFB0E0E6),
    PURPLE("purple", 0xFF800080),
    REBECCAPURPLE("rebeccapurple", 0xFF663399),
    RED("red", 0xFFFF0000),
    ROSYBROWN("rosybrown", 0xFFBC8F8F),
    ROYALBLUE("royalblue", 0xFF4169E1),
    SADDLEBROWN("saddlebrown", 0xFF8B4513),
    SALMON("salmon", 0xFFFA8072),
    SANDYBROWN("sandybrown", 0xFFF4A460),
    SEAGREEN("seagreen", 0xFF2E8B57),
    SEASHELL("seashell", 0xFFFFF5EE),
    SIENNA("sienna", 0xFFA0522D),
    SILVER("silver", 0xFFC0C0C0),
    SKYBLUE("skyblue", 0xFF87CEEB),
    SLATEBLUE("slateblue", 0xFF6A5ACD),
    SLATEGRAY("slategray", 0xFF708090),
    SLATEGREY("slategrey", 0xFF708090),
    SNOW("snow", 0xFFFFFAFA),
    SPRINGGREEN("springgreen", 0xFF00FF7F),
    STEELBLUE("steelblue", 0xFF4682B4),
    TAN("tan", 0xFFD2B48C),
    TEAL("teal", 0xFF008080),
    THISTLE("thistle", 0xFFD8BFD8),
    TOMATO("tomato", 0xFFFF6347),
    TURQUOISE("turquoise", 0xFF40E0D0),
    VIOLET("violet", 0xFFEE82EE),
    WHEAT("wheat", 0xFFF5DEB3),
    WHITE("white", 0xFFFFFFFF),
    WHITESMOKE("whitesmoke", 0xFFF5F5F5),
    YELLOW("yellow", 0xFFFFFF00),
    YELLOWGREEN("yellowgreen", 0xFF9ACD32);

    private final String name;
    private final int value;

    /**
     * Constructs a {@code CSSNamedColor} entry with a specified name and ARGB value.
     *
     * @param name  The CSS color name.
     * @param value The 32-bit ARGB integer representation of the color.
     */
    CSSNamedColor(String name, int value) {
        this.name = name;
        this.value = value;
    }

    /**
     * Returns the CSS name of the color.
     *
     * @return The name of the color as a string.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the 32-bit ARGB integer representation of the color.
     *
     * @return The ARGB value of the color.
     */
    public int getValue() {
        return value;
    }

    /**
     * Finds a {@code CSSNamedColor} entry by its name.
     * <p>
     * Performs a case-insensitive match against defined color names as per CSS specification.
     * If no match is found, {@code null} is returned.
     * </p>
     *
     * @param name The name of the color to look up.
     * @return The corresponding {@code CSSNamedColor} entry, or {@code null} if not found.
     */
    public static CSSNamedColor fromName(String name) {
        for (CSSNamedColor color : values()) {
            if (color.getName().equalsIgnoreCase(name)) {
                return color;
            }
        }
        return null;
    }
}
