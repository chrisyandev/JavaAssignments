package ca.bcit.comp2522.assignments.a1;

/**
 * Guppy. Represents a distinct Guppy with realistic properties.
 *
 * @author Chris Yan
 * @version 1.0
 */
public class Guppy {

    /** Determined age of young fish. In weeks. */
    public static final int YOUNG_FISH_AGE_IN_WEEKS = 10;

    /** Determined age of mature fish. In weeks. */
    public static final int MATURE_FISH_AGE_IN_WEEKS = 30;

    /** Fish dies past this age. */
    public static final int MAXIMUM_AGE_IN_WEEKS = 50;

    /** Minimum amount of water the guppy needs. */
    public static final double MINIMUM_WATER_VOLUME_ML = 250.0;

    /** The default guppy genus. */
    public static final String DEFAULT_GENUS = "Poecilia";

    /** The default guppy species. */
    public static final String DEFAULT_SPECIES = "reticulata";

    /** The default health coefficient of the guppy. */
    public static final double DEFAULT_HEALTH_COEFFICIENT = 0.5;

    /** The minimum health coefficient of the guppy. */
    public static final double MINIMUM_HEALTH_COEFFICIENT = 0.0;

    /** The maximum health coefficient of the guppy. */
    public static final double MAXIMUM_HEALTH_COEFFICIENT = 1.0;


    /** Number of Guppy instances. */
    private static int numberOfGuppiesBorn = 0;


    /** The genus of this guppy. */
    private String genus;

    /** The species this guppy belongs to. */
    private String species;

    /** The age of this guppy in weeks. */
    private int ageInWeeks;

    /** The gender of this guppy. */
    private boolean isFemale;

    /** The generation of this guppy. */
    private int generationNumber;

    /** Whether this guppy is alive or not. */
    private boolean isAlive;

    /** Health coefficient of this guppy. */
    private double healthCoefficient;

    /** The unique ID of this guppy. */
    private int identificationNumber;

    /** Constructor that sets the guppy's properties to default values. */
    public Guppy() {
        numberOfGuppiesBorn++;
        identificationNumber = numberOfGuppiesBorn;
        genus = DEFAULT_GENUS;
        species = DEFAULT_SPECIES;
        isFemale = true;
        isAlive = true;
        healthCoefficient = DEFAULT_HEALTH_COEFFICIENT;
    }

    /**
     * Constructor that sets the guppy's properties to specified values.
     *
     * @param newGenus a specific genus
     * @param newSpecies a specific species
     * @param newAgeInWeeks age in weeks
     * @param newIsFemale gender is female or not
     * @param newGenerationNumber generation of guppy
     * @param newHealthCoefficient current health coefficient
     */
    public Guppy(final String newGenus, final String newSpecies,
                 final int newAgeInWeeks, final boolean newIsFemale,
                 final int newGenerationNumber,
                 final double newHealthCoefficient) {
        numberOfGuppiesBorn++;
        identificationNumber = numberOfGuppiesBorn;
        genus = capitalize(newGenus);
        species = newSpecies.toLowerCase();
        ageInWeeks = (newAgeInWeeks < 0) ? 0 : newAgeInWeeks;
        isFemale = newIsFemale;
        isAlive = true;
        generationNumber = (newGenerationNumber < 0) ? 1 : newGenerationNumber;
        if (newHealthCoefficient < MINIMUM_HEALTH_COEFFICIENT) {
            healthCoefficient = MINIMUM_HEALTH_COEFFICIENT;
        } else if (newHealthCoefficient > MAXIMUM_HEALTH_COEFFICIENT) {
            healthCoefficient = MAXIMUM_HEALTH_COEFFICIENT;
        } else {
            healthCoefficient = newHealthCoefficient;
        }
    }

    private String capitalize(final String s) {
        if (s.length() == 1) {
            return s.toUpperCase();
        }
        return s.substring(0, 1).toUpperCase()
                + s.substring(1).toLowerCase();
    }

    /** Adds a weeks to age. */
    public void incrementAge() {
        ageInWeeks++;
        if (ageInWeeks > MAXIMUM_AGE_IN_WEEKS) {
            isAlive = false;
        }
    }

    /**
     * Gets guppy's genus.
     * @return guppy's genus
     */
    public String getGenus() {
        return genus;
    }

    /**
     * Gets guppy's species.
     * @return guppy's species
     */
    public String getSpecies() {
        return species;
    }

    /**
     * Gets guppy's age.
     * @return guppy's age in weeks
     */
    public int getAgeInWeeks() {
        return ageInWeeks;
    }

    /**
     * Gets guppy's gender.
     * @return true if female, false if male
     */
    public boolean isFemale() {
        return isFemale;
    }

    /**
     * Gets guppy's generation number.
     * @return guppy's generation number
     */
    public int getGenerationNumber() {
        return generationNumber;
    }

    /**
     * Gets guppy's alive state.
     * @return true if alive, false if dead
     */
    public boolean isAlive() {
        return isAlive;
    }

    /**
     * Gets guppy's health coefficient.
     * @return guppy's health coefficient
     */
    public double getHealthCoefficient() {
        return healthCoefficient;
    }

    /**
     * Gets guppy's ID number.
     * @return guppy's ID number
     */
    public int getIdentificationNumber() {
        return identificationNumber;
    }

    /**
     * Gets number of guppy instances.
     * @return number of guppy instances
     */
    public static int getNumberOfGuppiesBorn() {
        return numberOfGuppiesBorn;
    }

    /**
     * Sets guppy's age in weeks.
     * @param newAgeInWeeks new age in weeks
     */
    public void setAgeInWeeks(final int newAgeInWeeks) {
        if (newAgeInWeeks >= 0 && newAgeInWeeks <= MAXIMUM_AGE_IN_WEEKS) {
            ageInWeeks = newAgeInWeeks;
        }
    }

    /**
     * Sets guppy's alive state.
     * @param newIsAlive new alive state
     */
    public void setIsAlive(final boolean newIsAlive) {
        isAlive = newIsAlive;
    }

    /**
     * Sets guppy's health coefficient.
     * @param newHealthCoefficient new health coefficient
     */
    public void setHealthCoefficient(final double newHealthCoefficient) {
        if (newHealthCoefficient >= MINIMUM_HEALTH_COEFFICIENT
                && newHealthCoefficient <= MAXIMUM_HEALTH_COEFFICIENT) {
            healthCoefficient = newHealthCoefficient;
        }
    }

    /**
     * Determines how much water this guppy needs based on age.
     * Age ranges are as follows:
     *      Less than 10 weeks
     *      10 weeks to 30 weeks
     *      31 weeks to 50 weeks
     *      Greater than 50 weeks
     * @return amount of water in ML
     */
    public double getVolumeNeeded() {
        final int ageRange1 = 10;
        final int ageRange2 = 31;
        final int ageRange3 = 51;
        final double ageFactor = 1.5;
        if (ageInWeeks < ageRange1) {
            return MINIMUM_WATER_VOLUME_ML;
        }
        if (ageInWeeks < ageRange2) {
            return MINIMUM_WATER_VOLUME_ML
                    * ageInWeeks / YOUNG_FISH_AGE_IN_WEEKS;
        }
        if (ageInWeeks < ageRange3) {
            return MINIMUM_WATER_VOLUME_ML * ageFactor;
        }
        return 0.0;
    }

    /**
     * Adjusts guppy's health coefficient while staying in bounds.
     * @param delta positive or negative number added to health coefficient
     */
    public void changeHealthCoefficient(final double delta) {
        if (healthCoefficient + delta <= MINIMUM_HEALTH_COEFFICIENT) {
            healthCoefficient = 0.0;
            isAlive = false;
        } else if (healthCoefficient + delta > MAXIMUM_HEALTH_COEFFICIENT) {
            healthCoefficient = MAXIMUM_HEALTH_COEFFICIENT;
        } else {
            healthCoefficient += delta;
        }
    }

    /**
     * Outputs all instance fields.
     * @return a formatted string
     */
    @Override
    public String toString() {
        return "Guppy{"
                + "genus='" + genus + '\''
                + ", species='" + species + '\''
                + ", ageInWeeks=" + ageInWeeks
                + ", isFemale=" + isFemale
                + ", generationNumber=" + generationNumber
                + ", isAlive=" + isAlive
                + ", healthCoefficient=" + healthCoefficient
                + ", identificationNumber=" + identificationNumber
                + '}';
    }

    /**
     * Checks if two objects are aliases of each other.
     * @param o the other object to be compared
     * @return true if objects are aliases
     */
    @Override
    public boolean equals(final Object o) {
        if (!(o instanceof Guppy)) {
            return false;
        }
        Guppy g = (Guppy) o;
        if (!(identificationNumber == g.getIdentificationNumber())) {
            return false;
        }
        return this.hashCode() == g.hashCode();
    }
}
