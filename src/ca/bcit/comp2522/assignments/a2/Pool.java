package ca.bcit.comp2522.assignments.a2;

import java.util.ArrayList;
import java.util.Random;

public class Pool {

    /** Default pool name. */
    public static final String DEFAULT_POOL_NAME = "Unnamed";

    /** Default pool temperature. */
    public static final double DEFAULT_POOL_TEMP_CELSIUS = 40.0;

    /** Minimum pool temperature. */
    public static final double MINIMUM_POOL_TEMP_CELSIUS = 0.0;

    /** Maximum pool temperature. */
    public static final double MAXIMUM_POOL_TEMP_CELSIUS = 100.0;

    /** The neutral pH level. */
    public static final double NEUTRAL_PH = 7.0;

    /** Default amount of nutrients in the pool. */
    public static final double DEFAULT_NUTRIENT_COEFFICIENT = 0.50;

    /** Minimum amount of nutrients in the pool. */
    public static final double MINIMUM_NUTRIENT_COEFFICIENT = 0.0;

    /** Maximum amount of nutrients in the pool. */
    public static final double MAXIMUM_NUTRIENT_COEFFICIENT = 1.0;


    /** Name of the pool. */
    private final String name;

    /** Amount of water in the pool. */
    private double volumeLitres;

    /** Temperature of the pool. */
    private double temperatureCelsius;

    /** pH level of the pool. */
    private double pH;

    /** Amount of nutrients in the pool. */
    private double nutrientCoefficient;

    /** ID number of the pool. */
    private final int identificationNumber;

    /** Collection of guppies in the pool. */
    private final ArrayList<Guppy> guppiesInPool;

    /** Object for generating a random number. */
    private final Random randomNumberGenerator;


    /** The number of Pool instances. */
    private static int numberOfPools = 0;

    /**
     * Constructor for a hot spring pool that holds a collection of guppies.
     */
    public Pool() {
        numberOfPools++;
        name = DEFAULT_POOL_NAME;
        volumeLitres = 0.0;
        temperatureCelsius = DEFAULT_POOL_TEMP_CELSIUS;
        pH = NEUTRAL_PH;
        nutrientCoefficient = DEFAULT_NUTRIENT_COEFFICIENT;
        guppiesInPool = new ArrayList<>();
        randomNumberGenerator = new Random();
        identificationNumber = numberOfPools;
    }

    /**
     * Constructor for a hot spring pool that holds a collection of guppies.
     *
     * @param newName the name of this pool
     * @param newVolumeLitres the amount of water in the pool
     * @param newTemperatureCelsius the temperature of the water
     * @param newPH the pH level of the water
     * @param newNutrientCoefficient the amount of nutrients in the water
     */
    public Pool(final String newName, final double newVolumeLitres,
                final double newTemperatureCelsius, final double newPH,
                final double newNutrientCoefficient) {
        numberOfPools++;
        // Name must not be null, empty, or only whitespace
        if (newName == null || newName.trim().equals("")) {
            throw new IllegalArgumentException("Not a valid name");
        } else {
            name = capitalize(newName);
        }
        volumeLitres = (newVolumeLitres < 0) ? 0.0 : newVolumeLitres;
        temperatureCelsius = (newTemperatureCelsius
                >= MINIMUM_POOL_TEMP_CELSIUS
                && newTemperatureCelsius <= MAXIMUM_POOL_TEMP_CELSIUS)
                ? newTemperatureCelsius : DEFAULT_POOL_TEMP_CELSIUS;
        pH = (newPH >= 0 && newPH <= 14.0) ? newPH : NEUTRAL_PH;
        nutrientCoefficient = (newNutrientCoefficient
                >= MINIMUM_NUTRIENT_COEFFICIENT
                && newNutrientCoefficient <= MAXIMUM_NUTRIENT_COEFFICIENT)
                ? newNutrientCoefficient : DEFAULT_NUTRIENT_COEFFICIENT;
        guppiesInPool = new ArrayList<>();
        randomNumberGenerator = new Random();
        identificationNumber = numberOfPools;
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

    /**
     * Gets name of this pool.
     * @return the name of this pool
     */
    public String getName() {
        return name;
    }

    /**
     * Gets volume in Litres.
     * @return the volume
     */
    public double getVolumeLitres() {
        return volumeLitres;
    }

    /**
     * Gets temperature in Celsius.
     * @return the temperature
     */
    public double getTemperatureCelsius() {
        return temperatureCelsius;
    }

    /**
     * Gets pH level.
     * @return the pH level
     */
    public double getPH() {
        return pH;
    }

    /**
     * Gets nutrient coefficient.
     * @return the nutrient coefficient
     */
    public double getNutrientCoefficient() {
        return nutrientCoefficient;
    }

    /**
     * Gets ID number.
     * @return the ID number
     */
    public int getIdentificationNumber() {
        return identificationNumber;
    }

    /**
     * Sets volume in Litres.
     * @param newVolumeLitres the new volume
     */
    public void setVolumeLitres(final double newVolumeLitres) {
        if (newVolumeLitres >= 0) {
            volumeLitres = newVolumeLitres;
        }
    }

    /**
     * Sets temperature in Celsius.
     * @param newTemperatureCelsius the new temperature
     */
    public void setTemperatureCelsius(final double newTemperatureCelsius) {
        if (newTemperatureCelsius >= MINIMUM_POOL_TEMP_CELSIUS
                && newTemperatureCelsius <= MAXIMUM_POOL_TEMP_CELSIUS) {
            temperatureCelsius = newTemperatureCelsius;
        }
    }

    /**
     * Sets pH level.
     * @param newPH the new pH level
     */
    public void setPH(final double newPH) {
        if (newPH >= 0 && newPH <= 14.0) {
            pH = newPH;
        }
    }

    /**
     * Sets nutrient coefficient.
     * @param newNutrientCoefficient the new coefficient
     */
    public void setNutrientCoefficient(final double newNutrientCoefficient) {
        if (newNutrientCoefficient >= MINIMUM_NUTRIENT_COEFFICIENT
                && newNutrientCoefficient <= MAXIMUM_NUTRIENT_COEFFICIENT) {
            nutrientCoefficient = newNutrientCoefficient;
        }
    }

    /**
     * Changes nutrient coefficient.
     * @param delta added to current coefficient
     */
    public void changeNutrientCoefficient(final double delta) {
        if (nutrientCoefficient + delta < MINIMUM_NUTRIENT_COEFFICIENT) {
            nutrientCoefficient = MINIMUM_NUTRIENT_COEFFICIENT;
        } else if (nutrientCoefficient + delta
                > MAXIMUM_NUTRIENT_COEFFICIENT) {
            nutrientCoefficient = MAXIMUM_NUTRIENT_COEFFICIENT;
        } else {
            nutrientCoefficient += delta;
        }
    }

    /**
     * Changes pool temperature in Celsius.
     * @param delta added to current temperature
     */
    public void changeTemperature(final double delta) {
        if (temperatureCelsius + delta < MINIMUM_POOL_TEMP_CELSIUS) {
            temperatureCelsius = MINIMUM_POOL_TEMP_CELSIUS;
        } else if (temperatureCelsius + delta
                > MAXIMUM_POOL_TEMP_CELSIUS) {
            temperatureCelsius = MAXIMUM_POOL_TEMP_CELSIUS;
        } else {
            temperatureCelsius += delta;
        }
    }

    /**
     * Gets number of pools created.
     * @return the number of pools created
     */
    public static int getNumberCreated() {
        return numberOfPools;
    }
}
