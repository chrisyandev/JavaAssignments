package ca.bcit.comp2522.assignments.a2;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

/**
 * Guppy. Represents a guppy with realistic properties.
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

    /** Minimum amount of water the Guppy needs. */
    public static final double MINIMUM_WATER_VOLUME_ML = 250.0;

    /** The default Guppy genus. */
    public static final String DEFAULT_GENUS = "Poecilia";

    /** The default Guppy species. */
    public static final String DEFAULT_SPECIES = "reticulata";

    /** The default health coefficient of the Guppy. */
    public static final double DEFAULT_HEALTH_COEFFICIENT = 0.5;

    /** The minimum health coefficient of the Guppy. */
    public static final double MINIMUM_HEALTH_COEFFICIENT = 0.0;

    /** The maximum health coefficient of the Guppy. */
    public static final double MAXIMUM_HEALTH_COEFFICIENT = 1.0;


    /** Number of Guppy instances. */
    private static int numberOfGuppiesBorn = 0;


    /** The genus of this Guppy. */
    private String genus;

    /** The species this Guppy belongs to. */
    private String species;

    /** The age of this Guppy in weeks. */
    private int ageInWeeks;

    /** The gender of this Guppy. */
    private boolean isFemale;

    /** The generation of this Guppy. */
    private int generationNumber;

    /** Whether this Guppy is alive or not. */
    private boolean isAlive;

    /** Health coefficient of this Guppy. */
    private double healthCoefficient;

    /** The unique ID of this Guppy. */
    private int identificationNumber;

    /**
     * Default constructor that sets the Guppy's properties to default values.
     */
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
     * Constructor that sets the Guppy's properties to specified values.
     *
     * @param newGenus a specific genus
     * @param newSpecies a specific species
     * @param newAgeInWeeks age in weeks
     * @param newIsFemale gender is female or not
     * @param newGenerationNumber generation of Guppy
     * @param newHealthCoefficient current health coefficient
     */
    public Guppy(final String newGenus, final String newSpecies,
                 final int newAgeInWeeks, final boolean newIsFemale,
                 final int newGenerationNumber,
                 final double newHealthCoefficient) {
        if (newGenus == null || newGenus.trim().equals("")) {
            throw new IllegalArgumentException(
                    "Genus can't be null or empty.");
        }
        if (newAgeInWeeks >= MAXIMUM_AGE_IN_WEEKS) {
            throw new IllegalArgumentException(
                    "Age in weeks must be less than maximum.");
        }
        if (newSpecies == null || newSpecies.trim().equals("")) {
            throw new IllegalArgumentException(
                    "Species can't be null or empty.");
        }
        if (newAgeInWeeks < 0) {
            throw new IllegalArgumentException("Age can't be negative.");
        }
        if (newHealthCoefficient < 0) {
            throw new IllegalArgumentException(
                    "Health coefficient can't be negative.");
        }
        if (newGenerationNumber < 0) {
            throw new IllegalArgumentException(
                    "Generation number can't be negative.");
        }
        numberOfGuppiesBorn++;
        identificationNumber = numberOfGuppiesBorn;
        genus = capitalize(newGenus);
        species = newSpecies.trim().toLowerCase();
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

    /* Capitalizes the first letter of a string. */
    private String capitalize(final String s) {
        String str = s.trim();
        if (str.length() == 1) {
            return str.toUpperCase();
        }
        return str.substring(0, 1).toUpperCase()
                + str.substring(1).toLowerCase();
    }

    /** Adds a weeks to age. */
    public void incrementAge() {
        ageInWeeks++;
        if (ageInWeeks > MAXIMUM_AGE_IN_WEEKS) {
            isAlive = false;
        }
    }

    /**
     * Creates more Guppies depending on this Guppy's state.
     * @return ArrayList of new Guppies
     */
    public ArrayList<Guppy> spawn() {
        if (!isFemale || ageInWeeks < 8) {
            return null;
        }
        Random rand = new Random();
        // 50% chance of being able to spawn
        int spawnChoice = rand.nextInt(2);
        if (spawnChoice == 0) {
            return null;
        }
        // Can spawn between 0 to 100 inclusive babies
        ArrayList<Guppy> babyGuppies = new ArrayList<>();
        int numOfSpawns = rand.nextInt(101);
        for (int i = 0; i < numOfSpawns; i++) {
            boolean femaleBaby = false;
            // 50% chance of baby being female
            int genderChoice = rand.nextInt(2);
            if (genderChoice == 0) {
                femaleBaby = true;
            }
            Guppy g = new Guppy(genus, species, 0, femaleBaby,
                    1 + generationNumber, (1.0 + healthCoefficient) / 2.0);
            babyGuppies.add(g);
        }
        return babyGuppies;
    }

    /**
     * Gets Guppy's genus.
     * @return Guppy's genus
     */
    public String getGenus() {
        return genus;
    }

    /**
     * Gets Guppy's species.
     * @return Guppy's species
     */
    public String getSpecies() {
        return species;
    }

    /**
     * Gets Guppy's age.
     * @return Guppy's age in weeks
     */
    public int getAgeInWeeks() {
        return ageInWeeks;
    }

    /**
     * Gets Guppy's gender.
     * @return true if female, false if male
     */
    public boolean getIsFemale() {
        return isFemale;
    }

    /**
     * Gets Guppy's generation number.
     * @return Guppy's generation number
     */
    public int getGenerationNumber() {
        return generationNumber;
    }

    /**
     * Gets Guppy's alive state.
     * @return true if alive, false if dead
     */
    public boolean getIsAlive() {
        return isAlive;
    }

    /**
     * Gets Guppy's health coefficient.
     * @return Guppy's health coefficient
     */
    public double getHealthCoefficient() {
        return healthCoefficient;
    }

    /**
     * Gets Guppy's ID number.
     * @return Guppy's ID number
     */
    public int getIdentificationNumber() {
        return identificationNumber;
    }

    /**
     * Gets number of Guppy instances.
     * @return number of Guppy instances
     */
    public static int getNumberOfGuppiesBorn() {
        return numberOfGuppiesBorn;
    }

    /**
     * Sets Guppy's age in weeks.
     * @param newAgeInWeeks new age in weeks
     */
    public void setAgeInWeeks(final int newAgeInWeeks) {
        if (newAgeInWeeks >= 0 && newAgeInWeeks <= MAXIMUM_AGE_IN_WEEKS) {
            ageInWeeks = newAgeInWeeks;
        }
    }

    /**
     * Sets Guppy's alive state.
     * @param newIsAlive new alive state
     */
    public void setIsAlive(final boolean newIsAlive) {
        isAlive = newIsAlive;
    }

    /**
     * Sets Guppy's health coefficient.
     * @param newHealthCoefficient new health coefficient
     */
    public void setHealthCoefficient(final double newHealthCoefficient) {
        if (newHealthCoefficient >= MINIMUM_HEALTH_COEFFICIENT
                && newHealthCoefficient <= MAXIMUM_HEALTH_COEFFICIENT) {
            healthCoefficient = newHealthCoefficient;
        }
    }

    /**
     * Determines how much water this Guppy needs based on age.
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
     * Adjusts Guppy's health coefficient while staying in bounds.
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
        return this.hashCode() == g.hashCode();
    }

    /**
     * Creates a hash code for a Guppy instance based on its
     * attributes and ID number.
     * @return a hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(genus, species, ageInWeeks, isFemale,
                isAlive, healthCoefficient, identificationNumber);
    }
}
