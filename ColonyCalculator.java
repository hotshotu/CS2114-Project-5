/**
 * Virginia Tech Honor Code Pledge:
 * 
 * As a Hokie, I will conduct myself with honor and integrity at all times. I
 * will not lie, cheat, or steal, nor will I accept the actions of those who do.
 * -- Ender Jaska (eljaska)
 */

package spacecolonies;

import java.util.Arrays;
import list.AList;

/**
 * ColonyCalculator is the back end for the space colony program
 * 
 * @author Ender Jaska (eljaska)
 * @version 2018.11.28
 */
public class ColonyCalculator {

    /**
     * Maximum number of planets
     */
    public static final int NUM_PLANETS = 3;

    /**
     * Minimum skill level
     */
    public static final int MIN_SKILL_LEVEL = 1;

    /**
     * Maximum skill level
     */
    public static final int MAX_SKILL_LEVEL = 5;
    private ArrayQueue<Person> applicantQueue;
    private AList<Person> rejectBus;
    private static Planet[] planets = new Planet[NUM_PLANETS + 1];


    /**
     * Constructor for the calculator
     * 
     * @param people
     *            The people queue
     * @param planetList
     *            The planet array
     */
    public ColonyCalculator(ArrayQueue<Person> people, Planet[] planetList) {
        if (people == null || planetList == null) {
            throw new IllegalArgumentException("People/planetList Is Null");
        }
        applicantQueue = people;
        rejectBus = new AList<Person>();
        if (planetList.length != 3) {
            throw new IllegalArgumentException("Not 3 Planets");
        }
        for (int i = 0; i < 3; i++) {
            planets[i + 1] = planetList[i];
            if (planets[i + 1] == null) {
                throw new IllegalArgumentException(
                    "One of the planets is null");
            }
        }
    }


    /**
     * Getter method for the queue
     * 
     * @return Returns the person queue
     */
    public ArrayQueue<Person> getQueue() {
        return applicantQueue;
    }


    /**
     * Getter method for the planet array
     * 
     * @return Returns the planet array
     */
    public static Planet[] getPlanets() {
        return planets;
    }


    /**
     * Gets the planet a person should go to
     * 
     * @param nextPerson
     *            The person we are looking at
     * @return Returns the planet they should go to
     */
    public Planet getPlanetForPerson(Person nextPerson) {
        if (nextPerson == null) {
            throw new IllegalArgumentException("Null person");
        }
        Planet sendTo = getPreferredPlanet(nextPerson);
        if (sendTo != null && sendTo.isQualified(nextPerson) && sendTo
            .getAvailability() > 0) {
            return sendTo;
        }
        sendTo = getMostAvailablePlanet(nextPerson);
        return sendTo;
    }


    /**
     * Helper method if the person has a preferred planet
     * 
     * @param person
     *            The person we are looking at
     * @return Returns the preferred planet for the person
     */
    private Planet getPreferredPlanet(Person person) {
        for (int i = 1; i < NUM_PLANETS + 1; i++) {
            if (person.getPlanetName().equals(planets[i].getName())) {
                return planets[i];
            }
        }
        return null;
    }


    /**
     * Helper method if the person doesn't have a pref. planet
     * 
     * @param person
     *            The person we are looking at
     * @return Returns the most available planet
     */
    private Planet getMostAvailablePlanet(Person person) {
        Planet[] temp = new Planet[3];
        for (int i = 1; i < NUM_PLANETS + 1; i++) {
            temp[i - 1] = planets[i];
        }
        Arrays.sort(temp);
        Planet tempP = null;
        for (int i = 2; i >= 0; i--) {
            if (temp[i].getAvailability() > 0 && temp[i].isQualified(person)) {
                tempP = temp[i];
                return tempP;
            }
        }
        return tempP;
    }


    /**
     * Accepts a person to their planet
     * 
     * @return Returns whether the acceptance was successful
     */
    public boolean accept() {
        Person temp = applicantQueue.getFront();
        Planet tP = getPlanetForPerson(temp);
        if (tP != null) {
            return tP.addPerson(applicantQueue.dequeue());
        }
        reject();
        return false;
    }


    /**
     * Rejects a person
     */
    public void reject() {
        rejectBus.add(applicantQueue.dequeue());
    }


    /**
     * Returns the planet of a given order number
     * 
     * @param planet
     *            The number of the planet
     * @return Returns the order number's planet
     */
    public Planet planetByNumber(int planet) {
        if (1 <= planet && planet <= 3) {
            return planets[planet];
        }
        else {
            return null;
        }
    }


    /**
     * Returns the number order of a given planet
     * 
     * @param planet
     *            the planet's name
     * @return Returns the order number of the planet
     */
    public int getPlanetIndex(String planet) {
        if (planet.equals(planets[1].getName())) {
            return 1;
        }
        else if (planet.equals(planets[2].getName())) {
            return 2;
        }
        else if (planet.equals(planets[3].getName())) {
            return 3;
        }
        else {
            return 0;
        }
    }
}
