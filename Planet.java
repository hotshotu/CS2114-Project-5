/**
 * Virginia Tech Honor Code Pledge:
 * 
 * As a Hokie, I will conduct myself with honor and integrity at all times. I
 * will not lie, cheat, or steal, nor will I accept the actions of those who do.
 * -- Ender Jaska (eljaska)
 */

package spacecolonies;

/**
 * Planet represents a potential habitable planet
 * 
 * @author Ender Jaska (eljaska)
 * @version 2018.11.28
 */
public class Planet implements Comparable<Planet> {
    private String name;
    private Skills minSkills;
    private Person[] population;
    private int populationSize;
    private int capacity;


    /**
     * Constructor for Planet
     * 
     * @param planetName
     *            The Planet's name
     * @param planetAgri
     *            The Planet's minimum agriculture skill
     * @param planetMedi
     *            The Planet's minimum medicine skill
     * @param planetTech
     *            The Planet's minimum technology skill
     * @param planetCap
     *            The Planet's maximum capacity for people
     */
    public Planet(
        String planetName,
        int planetAgri,
        int planetMedi,
        int planetTech,
        int planetCap) {
        name = planetName;
        minSkills = new Skills(planetAgri, planetMedi, planetTech);
        capacity = planetCap;
        population = new Person[capacity];
        populationSize = 0;
    }


    /**
     * Sets the Planet's name
     * 
     * @param planetName
     *            The new Planet name
     */
    public void setName(String planetName) {
        name = planetName;
    }


    /**
     * Gets the Planet's name
     * 
     * @return Returns the Planet's name
     */
    public String getName() {
        return name;
    }


    /**
     * Gets the Planet's minimum skills
     * 
     * @return Returns the Planet's minimum skills
     */
    public Skills getSkills() {
        return minSkills;
    }


    /**
     * Gets the current population on the Planet
     * 
     * @return Returns the population of the Planet
     */
    public Person[] getPopulation() {
        return population;
    }


    /**
     * Gets the size of the current population on the Planet
     * 
     * @return Returns the population's size
     */
    public int getPopulationSize() {
        return populationSize;
    }


    /**
     * Gets the Planet's maximum capacity
     * 
     * @return Returns the Planet's capacity
     */
    public int getCapacity() {
        return capacity;
    }


    /**
     * Gets the number of slots left on the Planet
     * 
     * @return Returns the remaining slots on the Planet
     */
    public int getAvailability() {
        return capacity - populationSize;
    }


    /**
     * Checks if the Planet is full
     * 
     * @return Returns whether the Planet is a full capacity
     */
    public boolean isFull() {
        return populationSize >= capacity;
    }


    /**
     * Adds a person to the Planet
     * 
     * @param newbie
     *            The person to be added
     * @return Returns whether the add was successful or not
     */
    public boolean addPerson(Person newbie) {
        if (newbie != null && !isFull() && isQualified(newbie)) {
            population[populationSize] = newbie;
            populationSize++;
            return true;
        }
        return false;
    }


    /**
     * Checks if a person is qualified to be on the Planet
     * 
     * @param newbie
     *            The person being compared
     * @return Returns whether they meet the planet skill minimums
     */
    public boolean isQualified(Person newbie) {
        if (newbie == null) {
            return false;
        }
        Skills s = newbie.getSkills();
        return (s.getAgriculture() >= minSkills.getAgriculture() && s
            .getMedicine() >= minSkills.getMedicine() && s
                .getTechnology() >= minSkills.getTechnology());
    }


    /**
     * Converts the Planet to a string
     * 
     * @return Returns the converted string
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(name);
        builder.append(", population ");
        builder.append(populationSize);
        builder.append(" (cap: ");
        builder.append(capacity);
        builder.append("), Requires: A >= ");
        builder.append(minSkills.getAgriculture());
        builder.append(", M >= ");
        builder.append(minSkills.getMedicine());
        builder.append(", T >= ");
        builder.append(minSkills.getTechnology());
        return builder.toString();
    }


    /**
     * Compares two Planet objects to see if they are equal
     * 
     * @param obj
     *            The object being compared
     * @return Returns whether or not the values are the same
     */
    public boolean equals(Object obj) {
        if (obj != null && this.getClass() == obj.getClass()) {
            Planet other = (Planet)obj;
            return name.equals(other.getName()) && minSkills.equals(other
                .getSkills()) && populationSize == other.getPopulationSize();
        }
        return false;
    }


    /**
     * Compares two Planet objects
     * 
     * @param other
     *            The Planet this is being compared to
     * @return Returns 1 if this is more available, -1 if less available, 0 if
     *         equally available
     */
    public int compareTo(Planet other) {
        if (getAvailability() > other.getAvailability()) {
            return 1;
        }
        else if (getAvailability() < other.getAvailability()) {
            return -1;
        }
        else {
            return 0;
        }
    }
}
