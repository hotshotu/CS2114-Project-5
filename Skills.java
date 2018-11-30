/**
 * Virginia Tech Honor Code Pledge:
 * 
 * As a Hokie, I will conduct myself with honor and integrity at all times. I
 * will not lie, cheat, or steal, nor will I accept the actions of those who do.
 * -- Ender Jaska (eljaska)
 */

package spacecolonies;

/**
 * Skills is the 3 skills that the spacecolonies package uses
 * 
 * @author Ender Jaska (eljaska)
 * @version 2018.11.28
 */
public class Skills {
    private int agriculture;
    private int medicine;
    private int technology;


    /**
     * The constructor for a Skills
     * 
     * @param ag
     *            The agriculture rank of the skill
     * @param med
     *            The medicine rank of the skill
     * @param tech
     *            The technology rank of the skill
     */
    public Skills(int ag, int med, int tech) {
        agriculture = ag;
        medicine = med;
        technology = tech;
    }


    /**
     * Gets the agriculture rank
     * 
     * @return Returns the agriculture skill
     */
    public int getAgriculture() {
        return agriculture;
    }


    /**
     * Gets the medicine rank
     * 
     * @return Returns the medicine skill
     */
    public int getMedicine() {
        return medicine;
    }


    /**
     * Gets the technology rank
     * 
     * @return Returns the technology skill
     */
    public int getTechnology() {
        return technology;
    }


    /**
     * Checks if this set of skills is less than another
     * 
     * @param other
     *            The set of skills that this is being compared to
     * @return Returns if each of this's skills is less than other's skills
     */
    public boolean isBelow(Skills other) {
        if (other == null) {
            throw new IllegalArgumentException("Skills: Comparing to null");
        }
        return (agriculture <= other.getAgriculture() && medicine <= other
            .getMedicine() && technology <= other.getTechnology());
    }


    /**
     * Converts the Skills to a string
     * 
     * @return Returns the converted string
     */
    public String toString() {
        return "A:" + agriculture + " M:" + medicine + " T:" + technology;
    }


    /**
     * Compares two Skills objects to see if they are equal
     * 
     * @param obj
     *            The object to be compared to
     * @return Returns whether or not the values are the same
     */
    public boolean equals(Object obj) {
        if (obj != null && this.getClass() == obj.getClass()) {
            Skills other = (Skills)obj;
            if (agriculture == other.getAgriculture() && medicine == other
                .getMedicine() && technology == other.getTechnology()) {
                return true;
            }
        }
        return false;
    }
}
