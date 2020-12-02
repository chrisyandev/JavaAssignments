package ca.bcit.comp2522.labs.lab06;

public class Resources {

    private String levelName;
    private int levelNumber;
    private int spriteX;
    private int spriteY;
    private int health;
    private int numOfEnemies;

    public Resources(final String levelName, final int levelNumber,
                     final int spriteX, final int spriteY,
                     final int health, final int numOfEnemies) {
        this.levelName = levelName;
        this.levelNumber = levelNumber;
        this.spriteX = spriteX;
        this.spriteY = spriteY;
        this.health = health;
        this.numOfEnemies = numOfEnemies;
    }

    public String getLevelName() {
        return levelName;
    }

    public int getLevelNumber() {
        return levelNumber;
    }

    public int getSpriteX() {
        return spriteX;
    }

    public int getSpriteY() {
        return spriteY;
    }

    public int getHealth() {
        return health;
    }

    public int getNumOfEnemies() {
        return numOfEnemies;
    }

    public String toString() {
        return "Level name: " + levelName
                + "\nLevel number: " + levelNumber
                + "\nSprite position X: " + spriteX
                + "\nSprite position Y: " + spriteY
                + "\nPlayer health: " + health
                + "\nNumber of enemies: " + numOfEnemies;
    }
}
