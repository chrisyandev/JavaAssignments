package ca.bcit.comp2522.assignments.a2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

/**
 * Pool. Represents a small body of water.
 *
 * @author Chris Yan
 * @version 1.0
 */
public final class Pool {

    /** Default Pool name. */
    public static final String DEFAULT_POOL_NAME = "Unnamed";

    /** Default Pool temperature. */
    public static final double DEFAULT_POOL_TEMP_CELSIUS = 40.0;

    /** Minimum Pool temperature. */
    public static final double MINIMUM_POOL_TEMP_CELSIUS = 0.0;

    /** Maximum Pool temperature. */
    public static final double MAXIMUM_POOL_TEMP_CELSIUS = 100.0;

    /** The neutral pH level. */
    public static final double NEUTRAL_PH = 7.0;

    /** Default amount of nutrients in the Pool. */
    public static final double DEFAULT_NUTRIENT_COEFFICIENT = 0.50;

    /** Minimum amount of nutrients in the Pool. */
    public static final double MINIMUM_NUTRIENT_COEFFICIENT = 0.0;

    /** Maximum amount of nutrients in the Pool. */
    public static final double MAXIMUM_NUTRIENT_COEFFICIENT = 1.0;


    /** Name of the Pool. */
    private final String name;

    /** Amount of water in the Pool. */
    private double volumeLitres;

    /** Temperature of the Pool. */
    private double temperatureCelsius;

    /** pH level of the Pool. */
    private double pH;

    /** Amount of nutrients in the Pool. */
    private double nutrientCoefficient;

    /** ID number of the Pool. */
    private final int identificationNumber;

    /** Collection of Guppies in the Pool. */
    private final ArrayList<Guppy> guppiesInPool;

    /** Object for generating a random number. */
    private final Random randomNumberGenerator;


    /** The number of Pool instances. */
    private static int numberOfPools = 0;

    /**
     * Default constructor for a hot spring Pool that holds a
     * collection of Guppies.
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
     * Constructor for a hot spring Pool that holds a collection of Guppies.
     *
     * @param newName the name of this Pool
     * @param newVolumeLitres the amount of water in the Pool
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
     * Gets name of this Pool.
     * @return the name of this Pool
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
     * Changes Pool temperature in Celsius.
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

    /**
     * Adds Guppies to the collection.
     * @param guppy a Guppy instance
     * @return true if the Guppy was added
     */
    public boolean addGuppy(final Guppy guppy) {
        if (guppy == null) {
            return false;
        }
        return guppiesInPool.add(guppy);
    }

    /**
     * Gets number of living Guppies in the Pool.
     * @return the number of living Guppies
     */
    public int getPopulation() {
        Iterator<Guppy> guppyIterator = guppiesInPool.iterator();
        int aliveGuppies = 0;
        while (guppyIterator.hasNext()) {
            if (guppyIterator.next().getIsAlive()) {
                aliveGuppies++;
            }
        }
        return aliveGuppies;
    }

    /**
     * Calculates which Guppies have died.
     * @return number of dead Guppies
     */
    public int applyNutrientCoefficient() {
        Iterator<Guppy> guppyIterator = guppiesInPool.iterator();
        int numOfDeadGuppies = 0;
        while (guppyIterator.hasNext()) {
            Guppy guppy = guppyIterator.next();
            if (randomNumberGenerator.nextDouble() > nutrientCoefficient) {
                guppy.setIsAlive(false);
                numOfDeadGuppies++;
            }
        }
        return numOfDeadGuppies;
    }

    /**
     * Removes the dead Guppies from the Pool.
     * @return number of removed guppies
     */
    public int removeDeadGuppies() {
        Iterator<Guppy> guppyIterator = guppiesInPool.iterator();
        int numOfRemovedGuppies = 0;
        while (guppyIterator.hasNext()) {
            Guppy guppy = guppyIterator.next();
            if (!(guppy.getIsAlive())) {
                guppyIterator.remove();
                numOfRemovedGuppies++;
            }
        }
        return numOfRemovedGuppies;
    }

    /**
     * Calculates the total amount of water needed by all Guppies in litres.
     * @return total number of litres required
     */
    public double getGuppyVolumeRequirementInLitres() {
        Iterator<Guppy> guppyIterator = guppiesInPool.iterator();
        double totalMillilitres = 0.0;
        while (guppyIterator.hasNext()) {
            Guppy guppy = guppyIterator.next();
            if (guppy.getIsAlive()) {
                totalMillilitres += guppy.getVolumeNeeded();
            }
        }
        return totalMillilitres / 1000.0;
    }

    /**
     * Calculates the average age of alive Guppies.
     * @return the average age
     */
    public double getAverageAgeInWeeks() {
        Iterator<Guppy> guppyIterator = guppiesInPool.iterator();
        double totalAgeInWeeks = 0.0;
        double numOfAliveGuppies = 0.0;
        while (guppyIterator.hasNext()) {
            Guppy guppy = guppyIterator.next();
            if (guppy.getIsAlive()) {
                totalAgeInWeeks += guppy.getAgeInWeeks();
                numOfAliveGuppies++;
            }
        }
        if (numOfAliveGuppies <= 0) {
            return 0.0;
        }
        return totalAgeInWeeks / numOfAliveGuppies;
    }

    /**
     * Calculates the average health coefficient of alive Guppies.
     * @return the average health coefficient
     */
    public double getAverageHealthCoefficient() {
        Iterator<Guppy> guppyIterator = guppiesInPool.iterator();
        double totalHealthCoefficient = 0.0;
        double numOfAliveGuppies = 0.0;
        while (guppyIterator.hasNext()) {
            Guppy guppy = guppyIterator.next();
            if (guppy.getIsAlive()) {
                totalHealthCoefficient += guppy.getHealthCoefficient();
                numOfAliveGuppies++;
            }
        }
        if (numOfAliveGuppies <= 0) {
            return 0.0;
        }
        return totalHealthCoefficient / numOfAliveGuppies;
    }

    /**
     * Calculates the percentage of female Guppies.
     * @return the percentage of female Guppies
     */
    public double getFemalePercentage() {
        Iterator<Guppy> guppyIterator = guppiesInPool.iterator();
        double numOfFemaleGuppies = 0.0;
        double numOfAliveGuppies = 0.0;
        while (guppyIterator.hasNext()) {
            Guppy guppy = guppyIterator.next();
            if (guppy.getIsAlive()) {
                numOfAliveGuppies++;
                if (guppy.getIsFemale()) {
                    numOfFemaleGuppies++;
                }
            }
        }
        if (numOfAliveGuppies <= 0) {
            return 0.0;
        }
        return numOfFemaleGuppies / numOfAliveGuppies;
    }

    /**
     * Calculates the median age of alive Guppies. If there is an even
     * number of ages, gets the average of the two ages in the middle.
     * @return the median age
     */
    public double getMedianAge() {
        ArrayList<Integer> agesInWeeks = new ArrayList<>();
        Iterator<Guppy> guppyIterator = guppiesInPool.iterator();
        while (guppyIterator.hasNext()) {
            Guppy guppy = guppyIterator.next();
            if (guppy.getIsAlive()) {
                agesInWeeks.add(guppy.getAgeInWeeks());
            }
        }
        Collections.sort(agesInWeeks);
        int numOfElements = agesInWeeks.size();
        if (numOfElements == 0) {
            return 0.0;
        }
        if (numOfElements == 1) {
            return agesInWeeks.get(0);
        }
        // Averages the two ages in the middle if even number of elements
        if (numOfElements % 2 == 0) {
            double age1 = agesInWeeks.get((numOfElements / 2) - 1);
            double age2 = agesInWeeks.get(numOfElements / 2);
            return (age1 + age2) / 2.0;
        } else {
            return agesInWeeks.get(numOfElements / 2);
        }
    }

    /**
     * Spawns new Guppies for every Guppy in the pool.
     * @return number of new Guppy babies
     */
    public int spawn() {
        Iterator<Guppy> guppyIterator = guppiesInPool.iterator();
        ArrayList<Guppy> newBabies = new ArrayList<>();
        while (guppyIterator.hasNext()) {
            Guppy guppy = guppyIterator.next();
            if (guppy.getIsAlive()) {
                ArrayList<Guppy> spawnResult = guppy.spawn();
                if (spawnResult != null) {
                    newBabies.addAll(spawnResult);
                }
            }
        }
        guppiesInPool.addAll(newBabies);
        return newBabies.size();
    }

    /**
     * Increments age of all Guppies in the Pool and checks if
     * they're still alive.
     * @return number of Guppies that died of old age
     */
    public int incrementAges() {
        Iterator<Guppy> guppyIterator = guppiesInPool.iterator();
        int numDiedOfOldAge = 0;
        while (guppyIterator.hasNext()) {
            Guppy guppy = guppyIterator.next();
            if (guppy.getIsAlive()) {
                guppy.incrementAge();
                if (!(guppy.getIsAlive())) {
                    numDiedOfOldAge++;
                }
            }
        }
        return numDiedOfOldAge;
    }

    /**
     * If Pool is overcrowded, terminates Guppies with the lowest health
     * coefficient until the total volume requirement is less than
     * or equal to the volume of the Pool.
     * @return number of Guppies terminated
     */
    public int adjustForCrowding() {
        Iterator<Guppy> guppyIterator = guppiesInPool.iterator();
        int numOfTerminated = 0;
        double requiredVolumeLitres = getGuppyVolumeRequirementInLitres();
        while (requiredVolumeLitres > volumeLitres) {
            double coefOfWeakest = 1.0;
            int indexOfWeakest = 0;
            int indexOfIterator = -1;
            while (guppyIterator.hasNext()) {
                Guppy guppy = guppyIterator.next();
                indexOfIterator++;
                if (guppy.getIsAlive()) {
                    double currentGuppyCoef = guppy.getHealthCoefficient();
                    if (currentGuppyCoef < coefOfWeakest) {
                        coefOfWeakest = currentGuppyCoef;
                        indexOfWeakest = indexOfIterator;
                    }
                }
            }
            Guppy weakestGuppy = guppiesInPool.get(indexOfWeakest);
            weakestGuppy.setIsAlive(false);
            numOfTerminated++;
            requiredVolumeLitres -= (weakestGuppy.getVolumeNeeded() / 1000);
        }
        return numOfTerminated;
    }

    @Override
    public String toString() {
        return "Pool{"
                + "name='" + name + '\''
                + ", volumeLitres=" + volumeLitres
                + ", temperatureCelsius=" + temperatureCelsius
                + ", pH=" + pH
                + ", nutrientCoefficient=" + nutrientCoefficient
                + ", identificationNumber=" + identificationNumber
                + '}';
    }
}
