/**
 * Virginia Tech Honor Code Pledge:
 * 
 * As a Hokie, I will conduct myself with honor and integrity at all times. I
 * will not lie, cheat, or steal, nor will I accept the actions of those who do.
 * -- Ender Jaska (eljaska)
 */

package spacecolonies;

/**
 * Person represents a person and their skills
 * 
 * @author Ender Jaska (eljaska)
 * @version 2018.11.28
 */
public class Person {
    private String name;
    private Skills skills;
    private String planetPreference;


    /**
     * Constructor for a Person
     * 
     * @param pname
     *            The name for the person
     * @param agri
     *            The person's agriculture skill
     * @param medi
     *            The person's medicine skill
     * @param tech
     *            The person's technology skill
     * @param planet
     *            The preferred planet for the person
     */
    public Person(String pname, int agri, int medi, int tech, String planet) {
        name = pname;
        skills = new Skills(agri, medi, tech);
        planetPreference = planet;
    }


    /**
     * Gets the person's name
     * 
     * @return Returns the name
     */
    public String getName() {
        return name;
    }


    /**
     * Gets the person's skills
     * 
     * @return Returns the skills
     */
    public Skills getSkills() {
        return skills;
    }


    /**
     * Gets the person's preferred planet
     * 
     * @return Returns the person's planet preference
     */
    public String getPlanetName() {
        return planetPreference;
    }


    /**
     * Converts the Person to a string
     * 
     * @return Returns the converted string
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (planetPreference.length() == 0) {
            builder.append("No-Planet ");
        }
        builder.append(name);
        builder.append(" ");
        builder.append(skills.toString());
        if (planetPreference.length() > 0) {
            builder.append(" Wants: ");
            builder.append(planetPreference);
        }
        return builder.toString();
    }


    /**
     * Compares two Person objects to see if they are equal
     * 
     * @param obj
     *            The object to be compared to
     * @return Returns whether or not the values are the same
     */
    public boolean equals(Object obj) {
        if (obj != null && this.getClass() == obj.getClass()) {
            Person other = (Person)obj;
            return (name.equals(other.getName()) && skills.equals(other
                .getSkills()) && planetPreference.equals(other
                    .getPlanetName()));

        }
        return false;
    }
}
