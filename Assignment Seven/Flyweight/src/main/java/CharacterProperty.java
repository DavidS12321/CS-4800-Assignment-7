class CharacterProperty {
    private final String font;
    private final int size;
    private final String color;

    public CharacterProperty(String font, int size, String color) {
        this.font = font;
        this.size = size;
        this.color = color;
    }

    public String getFont() {
        return font;
    }

    public int getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }
}