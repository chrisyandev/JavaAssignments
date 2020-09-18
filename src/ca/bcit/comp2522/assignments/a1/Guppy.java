package ca.bcit.comp2522.assignments.a1;

public class Guppy {

    public static final int YOUNG_FISH_AGE_IN_WEEKS = 10;
    public static final int MATURE_FISH_AGE_IN_WEEKS = 30;
    public static final int MAXIMUM_AGE_IN_WEEKS = 50;
    public static final double MINIMUM_WATER_VOLUME_ML = 250.0;
    public static final String DEFAULT_GENUS = "Poecilia";
    public static final String DEFAULT_SPECIES = "reticulata";
    public static final double DEFAULT_HEALTH_COEFFICIENT = 0.5;
    public static final double MINIMUM_HEALTH_COEFFICIENT = 0.0;
    public static final double MAXIMUM_HEALTH_COEFFICIENT = 1.0;

    private String genus;
    private String species;
    private int ageInWeeks;
    private boolean isFemale;
    private int generationNumber;
    private boolean isAlive;
    private double healthCoefficient;
    private int identificationNumber;

    private static int numberOfGuppiesBorn = 0;

    public Guppy() {
        numberOfGuppiesBorn++;
        identificationNumber = numberOfGuppiesBorn;
        genus = DEFAULT_GENUS;
        species = DEFAULT_SPECIES;
        isFemale = true;
        isAlive = true;
        healthCoefficient = DEFAULT_HEALTH_COEFFICIENT;
    }

    public Guppy(String newGenus, String newSpecies, int newAgeInWeeks,
                 boolean newIsFemale, int newGenerationNumber,
                 double newHealthCoefficient) {
        numberOfGuppiesBorn++;
        identificationNumber = numberOfGuppiesBorn;
        genus = capitalize(newGenus);
        species = newSpecies.toLowerCase();
        ageInWeeks = (newAgeInWeeks < 0) ? 0 : newAgeInWeeks;
        isFemale = newIsFemale;
        isAlive = true;
        generationNumber = (newGenerationNumber < 0) ? 1 : newGenerationNumber;
        if (newHealthCoefficient < MINIMUM_HEALTH_COEFFICIENT) {
            newHealthCoefficient = MINIMUM_HEALTH_COEFFICIENT;
        }
        if (newHealthCoefficient > MAXIMUM_HEALTH_COEFFICIENT) {
            newHealthCoefficient = MAXIMUM_HEALTH_COEFFICIENT;
        }
        healthCoefficient = newHealthCoefficient;
    }

    private String capitalize(String s) {
        if (s.length() == 1) {
            return s.toUpperCase();
        }
        return s.substring(0, 1).toUpperCase()
                + s.substring(1).toLowerCase();
    }
}
