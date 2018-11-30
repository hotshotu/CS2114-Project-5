/**
 * Virginia Tech Honor Code Pledge:
 * 
 * As a Hokie, I will conduct myself with honor and integrity at all times. I
 * will not lie, cheat, or steal, nor will I accept the actions of those who do.
 * -- Ender Jaska (eljaska)
 */
package spacecolonies;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import bsh.ParseException;

/**
 * ColonyReader reads the information from the files and sets up the data to be
 * displayed
 * 
 * @author Ender Jaska (eljaska)
 * @version 2018.11.28
 */
public class ColonyReader {
    private Planet[] planets;
    private ArrayQueue<Person> queue;


    /**
     * Constructor for the reader
     * 
     * @param applicantFileName
     *            The name of the person file
     * @param planetFileName
     *            The name of the planet file
     * @throws FileNotFoundException
     * @throws ParseException
     * @throws SpaceColonyDataException
     */
    public ColonyReader(String applicantFileName, String planetFileName)
        throws FileNotFoundException,
        ParseException,
        SpaceColonyDataException {
        planets = readPlanetFile(planetFileName);
        queue = readQueueFile(applicantFileName);
        new SpaceWindow(new ColonyCalculator(queue, planets));
    }


    /**
     * Reader for the planet file
     * 
     * @param fileName
     *            The name of the planet file
     * @return Returns the converted planets array
     * @throws FileNotFoundException
     * @throws ParseException
     * @throws SpaceColonyDataException
     */
    private Planet[] readPlanetFile(String fileName)
        throws FileNotFoundException,
        ParseException,
        SpaceColonyDataException {
        Planet[] temp = new Planet[3];
        @SuppressWarnings("resource")
        Scanner file = new Scanner(new File(fileName));
        int counter = 0;
        while (file.hasNextLine() && counter < 3) {
            String line = file.nextLine();
            String[] params = line.split(", *");
            if (params.length != 5) {
                throw new ParseException("Planet File Incorrect");
            }
            else if (params[1] == "" || params[2] == "" || params[3] == "") {
                throw new SpaceColonyDataException("No Planet Skills Error");
            }
            int num1 = Integer.valueOf(params[1]);
            int num2 = Integer.valueOf(params[2]);
            int num3 = Integer.valueOf(params[3]);
            if (!isInSkillRange(num1, num2, num3)) {
                throw new SpaceColonyDataException("Planet Skills Error");
            }
            temp[counter] = new Planet(params[0], num1, num2, num3, Integer
                .valueOf(params[4]));
            counter++;
        }
        file.close();
        if (temp[0] == null || temp[1] == null || temp[2] == null) {
            throw new SpaceColonyDataException("Not 3 Planets");
        }
        return temp;
    }


    /**
     * Reader for the person file
     * 
     * @param fileName
     *            The name of the person file
     * @return Returns the converted person queue
     * @throws FileNotFoundException
     * @throws SpaceColonyDataException
     */
    private ArrayQueue<Person> readQueueFile(String fileName)
        throws FileNotFoundException,
        SpaceColonyDataException {
        ArrayQueue<Person> temp = new ArrayQueue<Person>();
        @SuppressWarnings("resource")
        Scanner file = new Scanner(new File(fileName));
        while (file.hasNextLine()) {
            String line = file.nextLine();
            String[] params = line.split(", *");
            if (params.length < 4 || 5 < params.length) {
                throw new SpaceColonyDataException("Person Data Error");
            }
            else if (params[1] == "" || params[2] == "" || params[3] == "") {
                throw new SpaceColonyDataException("No Person Skills Error");
            }
            int num1 = Integer.valueOf(params[1]);
            int num2 = Integer.valueOf(params[2]);
            int num3 = Integer.valueOf(params[3]);
            if (!isInSkillRange(num1, num2, num3)) {
                throw new SpaceColonyDataException("Person's Skills Error");
            }
            if (params.length == 5 && (params[4].equals(planets[0].getName())
                || params[4].equals(planets[1].getName()) || params[4].equals(
                    planets[2].getName()))) {
                temp.enqueue(new Person(params[0], num1, num2, num3,
                    params[4]));
            }
            else {
                temp.enqueue(new Person(params[0], num1, num2, num3, ""));
            }
        }
        file.close();
        return temp;
    }


    private boolean isInSkillRange(int num1, int num2, int num3) {
        return (0 < num1 && num1 < 6 && 0 < num2 && num2 < 6 && 0 < num3
            && num3 < 6);
    }
}
