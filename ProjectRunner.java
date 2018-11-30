/**
 * Virginia Tech Honor Code Pledge:
 * 
 * As a Hokie, I will conduct myself with honor and integrity at all times. I
 * will not lie, cheat, or steal, nor will I accept the actions of those who do.
 * -- Ender Jaska (eljaska)
 */

package spacecolonies;

import java.io.FileNotFoundException;
import bsh.ParseException;

public class ProjectRunner {
    public static void main(String[] args) throws FileNotFoundException, ParseException, SpaceColonyDataException {
        String[] temp = new String[2];
        if(args == null || args.length != 2) {
            temp[0] = "input.txt";
            temp[1] = "planets.txt";
        }
        else {
            temp = args;
        }
        new ColonyReader(temp[0], temp[1]);
    }
}
