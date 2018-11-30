/**
 * Virginia Tech Honor Code Pledge:
 * 
 * As a Hokie, I will conduct myself with honor and integrity at all times. I
 * will not lie, cheat, or steal, nor will I accept the actions of those who do.
 * -- Ender Jaska (eljaska)
 */

package spacecolonies;

import java.awt.Color;
import CS2114.*;
import list.AList;

/**
 * SpaceWindow is the front end of space colonies
 * 
 * @author Ender Jaska (eljaska)
 * @version 2018.11.28
 */
public class SpaceWindow {
    private Window window;
    private ColonyCalculator colonyCalculator;
    private Button accept;
    private Button reject;
    private AList<CircleShape> personCircles;
    private TextShape currentPerson;
    private Shape p1;
    private Shape bp1;
    private Shape p2;
    private Shape bp2;
    private Shape p3;
    private Shape bp3;
    private TextShape t1;
    private TextShape t2;
    private TextShape t3;


    public SpaceWindow(ColonyCalculator calc) {
        if (calc == null) {
            throw new IllegalArgumentException("Null ColonyCalculator");
        }
        window = new Window("Space Colony Placement");
        colonyCalculator = calc;

        accept = new Button("ACCEPT");
        accept.onClick(this, "clickedAccept");
        window.addButton(accept, WindowSide.SOUTH);

        reject = new Button("REJECT");
        reject.onClick(this, "clickedReject");
        window.addButton(reject, WindowSide.SOUTH);

        ArrayQueue<Person> ptemp = colonyCalculator.getQueue();
        Object[] people = ptemp.toArray();

        personCircles = new AList<CircleShape>();
        for (int i = 0; i < colonyCalculator.getQueue().getSize(); i++) {
            personCircles.add(new CircleShape(i * 55 + 20, 50, 50, getColor(
                (Person)people[i])));
            window.addShape(personCircles.getEntry(i));
        }

        currentPerson = new TextShape(20, 20, "");
        currentPerson.setBackgroundColor(Color.WHITE);
        window.addShape(currentPerson);

        p1 = new Shape(80, 230, 80, 0, Color.PINK);
        p2 = new Shape(220, 230, 80, 0, Color.CYAN);
        p3 = new Shape(360, 230, 80, 0, Color.LIGHT_GRAY);
        window.addShape(p1);
        window.addShape(p2);
        window.addShape(p3);

        bp1 = new SquareShape(80, 150, 80, Color.RED);
        bp2 = new SquareShape(220, 150, 80, Color.BLUE);
        bp3 = new SquareShape(360, 150, 80, Color.GRAY);
        window.addShape(bp1);
        window.addShape(bp2);
        window.addShape(bp3);

        t1 = new TextShape(80, 240, "");
        t1.setBackgroundColor(Color.WHITE);
        t2 = new TextShape(220, 240, "");
        t2.setBackgroundColor(Color.WHITE);
        t3 = new TextShape(360, 240, "");
        t3.setBackgroundColor(Color.WHITE);
        window.addShape(t1);
        window.addShape(t2);
        window.addShape(t3);

        Planet[] temp = ColonyCalculator.getPlanets();
        updatePText(t1, temp[1]);
        updatePText(t2, temp[2]);
        updatePText(t3, temp[3]);
        window.repaint();

        TextShape t21 = new TextShape(80, 260, temp[1].getSkills().toString());
        t21.setBackgroundColor(Color.WHITE);
        TextShape t22 = new TextShape(220, 260, temp[2].getSkills().toString());
        t22.setBackgroundColor(Color.WHITE);
        TextShape t23 = new TextShape(360, 260, temp[3].getSkills().toString());
        t23.setBackgroundColor(Color.WHITE);
        window.addShape(t21);
        window.addShape(t22);
        window.addShape(t23);

        nextPerson();
    }


    public void clickedAccept(Button button) {
        Person acceptee = colonyCalculator.getQueue().getFront();
        Planet sent = colonyCalculator.getPlanetForPerson(acceptee);
        int temp = colonyCalculator.getPlanetIndex(sent.getName());
        colonyCalculator.accept();

        int calc = (int)((double)sent.getPopulationSize() / sent.getCapacity()
            * 80);
        if (temp == 1) {
            window.removeShape(p1);
            p1 = new Shape(80, 230 - calc, 80, calc, Color.PINK);
            window.addShape(p1);
            window.removeShape(bp1);
            window.addShape(bp1);
            updatePText(t1, sent);
        }
        else if (temp == 2) {
            window.removeShape(p2);
            p2 = new Shape(220, 230 - calc, 80, calc, Color.CYAN);
            window.addShape(p2);
            window.removeShape(bp2);
            window.addShape(bp2);
            updatePText(t2, sent);
        }
        else if (temp == 3) {
            window.removeShape(p3);
            p3 = new Shape(360, 230 - calc, 80, calc, Color.LIGHT_GRAY);
            window.addShape(p3);
            window.removeShape(bp3);
            window.addShape(bp3);
            updatePText(t3, sent);
        }

        window.removeShape(personCircles.remove(0));
        for (int i = 0; i < colonyCalculator.getQueue().getSize(); i++) {
            personCircles.getEntry(i).setX(i * 55 + 20);
        }
        window.repaint();

        nextPerson();
    }


    public void clickedReject(Button button) {
        colonyCalculator.reject();
        window.removeShape(personCircles.remove(0));
        for (int i = 0; i < colonyCalculator.getQueue().getSize(); i++) {
            personCircles.getEntry(i).setX(i * 55 + 20);
        }
        window.repaint();
        nextPerson();
    }


    private void nextPerson() {
        if (!colonyCalculator.getQueue().isEmpty()) {
            Person cadet = colonyCalculator.getQueue().getFront();
            currentPerson.setText(cadet.toString());
            if (colonyCalculator.getPlanetForPerson(cadet) == null) {
                accept.disable();
            }
            else {
                accept.enable();
            }
        }
        else {
            accept.disable();
            reject.disable();
            currentPerson.setText("");
        }
    }


    private Color getColor(Person person) {
        int temp = colonyCalculator.getPlanetIndex(person.getPlanetName());
        if (temp == 1) {
            return Color.PINK;
        }
        else if (temp == 2) {
            return Color.CYAN;
        }
        else if (temp == 3) {
            return Color.LIGHT_GRAY;
        }
        else {
            return Color.BLACK;
        }
    }


    private void updatePText(TextShape text, Planet planet) {
        StringBuilder builder = new StringBuilder();
        builder.append(planet.getName());
        builder.append(", ");
        builder.append(planet.getPopulationSize());
        builder.append("/");
        builder.append(planet.getCapacity());
        text.setText(builder.toString());
    }
}
