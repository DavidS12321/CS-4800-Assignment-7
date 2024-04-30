class Character {
    private char character;
    private CharacterProperty property;

    public Character(char c, CharacterProperty property) {
        this.character = c;
        this.property = property;
    }

    public char getCharacter() {
        return character;
    }

    public CharacterProperty getProperty() {
        return property;
    }
}