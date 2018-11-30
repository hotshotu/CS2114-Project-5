package prj5;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import CS2114.*;

/**
 * Class for ProjectWindow
 * 
 * @author Ender Jaska, Kenneth Ding <dkenny>
 * @version 11.14.2018
 *
 */
public class ProjectWindow {

    private ProjectBackend backend;
    private int glyph1Num;
    private int glyph2Num;
    private Glyph[] glyphs;
    private Key key;
    private Window window;


    /**
     * Constructor for ProjectWindow
     * 
     * @param args
     *            the files we are looking for
     * @throws FileNotFoundException
     *             throws if we can not find the file we are looking for
     * @throws UnsupportedEncodingException
     */
    public ProjectWindow(String[] args) throws FileNotFoundException {
        backend = new ProjectBackend(args);
        glyph1Num = 0;
        glyph2Num = 0;
        glyphs = new Glyph[9];
        key = new Key();
        window = new Window();

        if (backend.getSongs().size() < 9) {
            glyph2Num = backend.getSongs().size() - 1;
        }
        else {
            glyph2Num = 9;
        }

        SongNode temp = backend.getSongs().getHead();
        for (int i = 0; i < glyph2Num; i++) {
            glyphs[i] = new Glyph(temp.getData());
            temp = temp.getNext();
        }

        Button prev = new Button("<-- Prev");
        Button next = new Button("Next -->");

        Button sortArtist = new Button("Sort by Artist Name");
        Button sortTitle = new Button("Sort by Title Name");
        Button sortYear = new Button("Sort by Release year");
        Button sortGenre = new Button("Sort by Genre");

        Button repHobby = new Button("Represent Hobby");
        Button repMajor = new Button("Represent Major");
        Button repRegion = new Button("Represent Region");

        Button quit = new Button("Quit");

        window.addButton(prev, WindowSide.NORTH);
        prev.onClick(this, "pressedPrev");

        window.addButton(sortArtist, WindowSide.NORTH);
        sortArtist.onClick(this, "pressedSortArtist");
        window.addButton(sortTitle, WindowSide.NORTH);
        sortTitle.onClick(this, "pressedSortTitle");
        window.addButton(sortYear, WindowSide.NORTH);
        sortYear.onClick(this, "pressedSortYear");
        window.addButton(sortGenre, WindowSide.NORTH);
        sortGenre.onClick(this, "pressedSortGenre");
        window.addButton(next, WindowSide.NORTH);
        next.onClick(this, "pressedNext");

        window.addButton(repHobby, WindowSide.SOUTH);
        repHobby.onClick(this, "pressedRepHobby");
        window.addButton(repMajor, WindowSide.SOUTH);
        repMajor.onClick(this, "pressedRepMajor");
        window.addButton(repRegion, WindowSide.SOUTH);
        repRegion.onClick(this, "pressedRepRegion");

        window.addButton(quit, WindowSide.SOUTH);
        quit.onClick(this, "pressedQuit");

        Shape tempShape = new Shape(75 - 35, 50, 35, 15, Color.PINK);
        Shape tempShape1 = new Shape(85, 50, 20, 15, Color.PINK);
        Shape tempShape2 = new Shape(25, 65, 50, 15, Color.BLUE);
        Shape tempShape3 = new Shape(85, 65, 5, 15, Color.BLUE);
        Shape tempShape4 = new Shape(65, 80, 10, 15, Color.YELLOW);
        Shape tempShape5 = new Shape(85, 80, 5, 15, Color.YELLOW);
        Shape tempShape6 = new Shape(25, 95, 50, 15, Color.GREEN);
        Shape tempShape7 = new Shape(85, 95, 23, 15, Color.GREEN);
        Shape tempShape8 = new Shape(75, 50, 10, 60, Color.BLACK);
        TextShape temptextshape = new TextShape(63, 10, "Hello");
        TextShape temptextshape2 = new TextShape(50, 30, "by Adele");
        window.addShape(tempShape8);
        window.addShape(tempShape);
        window.addShape(tempShape1);
        window.addShape(tempShape2);
        window.addShape(tempShape3);
        window.addShape(tempShape4);
        window.addShape(tempShape5);
        window.addShape(tempShape6);
        window.addShape(tempShape7);
        window.addShape(temptextshape);
        window.addShape(temptextshape2);

        TextShape keyTitle = new TextShape(620, 110, "Hobby Legend");
        TextShape keyName1 = new TextShape(620, 125, "Read", Color.PINK);
        TextShape keyName2 = new TextShape(620, 140, "Art", Color.BLUE);
        TextShape keyName3 = new TextShape(620, 155, "Sports", Color.YELLOW);
        TextShape keyName4 = new TextShape(620, 170, "Music", Color.GREEN);
        TextShape keySong = new TextShape(640, 190, "Song Title");
        TextShape keyHeard = new TextShape(620, 215, "Heard");
        TextShape keyLiked = new TextShape(685, 215, "Likes");
        Shape keyBlackBox = new Shape(610, 100, 120, 140, Color.BLACK);
        Shape keyWhiteBox = new Shape(615, 105, 110, 130, Color.WHITE);
        Shape keyBlackBar = new Shape(670, 205, 10, 25, Color.BLACK);
        window.addShape(keyTitle);
        window.addShape(keyName1);
        window.addShape(keyName2);
        window.addShape(keyName3);
        window.addShape(keyName4);
        window.addShape(keySong);
        window.addShape(keyHeard);
        window.addShape(keyLiked);
        window.addShape(keyBlackBar);
        window.addShape(keyWhiteBox);
        window.addShape(keyBlackBox);

        pressedRepHobby(repHobby);
        pressedSortGenre(sortGenre);
        output();
        // output songs list data -> the commented out code below..?
        pressedSortTitle(sortTitle);
        output();
        // same output songs data
    }


    /**
     * displays everything
     */
    public void display() {
        key.displayKey(window);
        if (glyph2Num - glyph1Num != 9) {
            for (int i = glyph1Num; i < glyph2Num; i++) {
                glyphs[8 - (i - glyph1Num)] = null;
            }
        }
        for (int i = glyph1Num; i < glyph2Num; i++) {
            glyphs[i - glyph1Num].displayGlyph(window, i * 15, i * 10);
        }
    }


    /**
     * outputs the results in words
     */
    public void output() {
        for (int i = 0; i < backend.getSongs().size(); i++) {
            System.out.println("song title " + backend.getSongs().getIndex(i)
                .getData().getTitle());
            System.out.println("song artist " + backend.getSongs().getIndex(i)
                .getData().getArtist());
            System.out.println("song genre " + backend.getSongs().getIndex(i)
                .getData().getGenre());
            System.out.println("song year " + backend.getSongs().getIndex(i)
                .getData().getYear());
            System.out.println("heard");
            System.out.println("reading" + (backend.getSongs().getIndex(i)
                .getData().getRepresentation(RepresentationEnum.HOBBY)[0]
                / backend.getSongs().getIndex(i).getData().getReps(
                    RepresentationEnum.HOBBY) * 100) + " art" + backend
                        .getSongs().getIndex(i).getData().getRepresentation(
                            RepresentationEnum.HOBBY)[2] + " sports" + 
                                                                             backend
                                                                             .getSongs
                                                                             ()
                                                                             .
                                                                             getIndex
                                                                             (i
                                                                             ).
                                                                             getData
                                                                             ()
                                                                             .getRepresentation
                                                                             (
                                                                             RepresentationEnum
                                                                             .
                                                                             HOBBY
                                                                             )[
                                                                             4]
                                                                            
                + " music" + 
                               backend.getSongs().getIndex(i).getData()
                               .getRepresentation(RepresentationEnum.HOBBY)[6]
                               );
            System.out.println("likes");
            System.out.println("reading" + backend.getSongs().getIndex(i)
                .getData().getRepresentation(RepresentationEnum.HOBBY)[1]
                + " art" + backend.getSongs().getIndex(i).getData()
                    .getRepresentation(RepresentationEnum.HOBBY)[3] + " sports"
                + 
                    backend.getSongs().getIndex(i).getData().getRepresentation(
                    RepresentationEnum.HOBBY)[5]
                     + " music" + 
                                          (backend.getSongs()
                                          .getIndex(i).getData().
                                          getRepresentation(
                                          RepresentationEnum.HOBBY)[7])
                                          );
            System.out.println();
        }
    }


    /**
     * Output method used for the tester
     * 
     * @throws FileNotFoundException
     */
    public void outputTest() throws FileNotFoundException {
        for (int x = 0; x < 3; x++) {

            PrintWriter writer = new PrintWriter(new File(
                "Output3TitleGenreHobby.txt"));
            if (x == 0) {
                writer = new PrintWriter(new File(
                    "Output2TitleGenreHobby.txt"));
            }
            if (x == 1) {
                writer = new PrintWriter(new File(
                    "Output1TitleGenreHobby.txt"));
            }
            for (int i = 0; i < backend.getNumReps(); i++) {
                writer.println("song title " + backend.getSongs().getIndex(i)
                    .getData().getTitle());
                writer.println("song artist " + backend.getSongs().getIndex(i)
                    .getData().getArtist());
                writer.println("song genre " + backend.getSongs().getIndex(i)
                    .getData().getGenre());
                writer.println("song year " + backend.getSongs().getIndex(i)
                    .getData().getYear());
                writer.println("heard");
                writer.println("reading" + backend.getSongs().getIndex(i)
                    .getData().getRepresentation(RepresentationEnum.HOBBY)[0]
                    + " art" + backend.getSongs().getIndex(i).getData()
                        .getRepresentation(RepresentationEnum.HOBBY)[2]
                    + " sports" + backend.getSongs().getIndex(i).getData()
                        .getRepresentation(RepresentationEnum.HOBBY)[4]
                    + " music" + backend.getSongs().getIndex(i).getData()
                        .getRepresentation(RepresentationEnum.HOBBY)[6]);
                writer.println("likes");
                writer.println("reading" + backend.getSongs().getIndex(i)
                    .getData().getRepresentation(RepresentationEnum.HOBBY)[1]
                    + " art" + backend.getSongs().getIndex(i).getData()
                        .getRepresentation(RepresentationEnum.HOBBY)[3]
                    + " sports" + backend.getSongs().getIndex(i).getData()
                        .getRepresentation(RepresentationEnum.HOBBY)[5]
                    + " music" + backend.getSongs().getIndex(i).getData()
                        .getRepresentation(RepresentationEnum.HOBBY)[7]);
                writer.println();
            }
            writer.close();
        }
    }


    /**
     * Displays next set of glyphs
     * 
     * @param button
     *            when pressed Next button
     */
    public void pressedNext(Button button) {
        if (glyph2Num + 9 < backend.getNumReps()) {
            glyph1Num += 9;
            glyph2Num += 9;
        }
        else if (glyph1Num + 9 < backend.getNumReps()) {
            glyph1Num += 9;
            glyph2Num = backend.getNumReps();
        }
        display();
    }


    /**
     * displays previous set of glyphs
     * 
     * @param button
     *            when pressed the Prev button
     */
    public void pressedPrev(Button button) {
        if (glyph1Num > 9) {
            glyph1Num -= 9;
            glyph2Num -= 9;
        }
        display();
    }


    /**
     * When pressed sorts by artist
     * 
     * @param button
     *            Sort by Artist Name button
     */
    public void pressedSortArtist(Button button) {
        backend.sortSongs(SortEnum.ARTIST);
        display();
    }


    /**
     * When pressed sorts by Title Name
     * 
     * @param button
     *            is the Sort by Title Name button
     */
    public void pressedSortTitle(Button button) {
        backend.sortSongs(SortEnum.TITLE);
        display();
    }


    /**
     * When pressed sorts by Year
     * 
     * @param button
     *            is the Sort by Year Button
     */
    public void pressedSortYear(Button button) {
        backend.sortSongs(SortEnum.YEAR);
        display();
    }


    /**
     * When pressed sorts by Genre Name
     * 
     * @param button
     *            is the Sort by Genre Name button
     */
    public void pressedSortGenre(Button button) {
        backend.sortSongs(SortEnum.GENRE);
        display();
    }


    /**
     * When pressed sorts by hobby
     * 
     * @param button
     *            is the Sort by Hobby button
     */
    public void pressedRepHobby(Button button) {
        for (int i = glyph1Num; i < glyph2Num; i++) {
            glyphs[i - glyph1Num].update(RepresentationEnum.HOBBY, backend
                .getSongs().getIndex(i + glyph1Num).getData(), backend
                    .getNumReps());
        }
        key.update(RepresentationEnum.HOBBY);
        display();
    }


    /**
     * When pressed sorts by major
     * 
     * @param button
     *            is the Sort by Major button
     */
    public void pressedRepMajor(Button button) {
        for (int i = glyph1Num; i < glyph2Num; i++) {
            glyphs[i - glyph1Num].update(RepresentationEnum.MAJOR, backend
                .getSongs().getIndex(i + glyph1Num).getData(), backend
                    .getNumReps());
        }
        key.update(RepresentationEnum.MAJOR);
        display();
    }


    /**
     * Represent the glyphs by region of people
     * 
     * @param button
     *            Represent Region button
     */
    public void pressedRepRegion(Button button) {
        for (int i = glyph1Num; i < glyph2Num; i++) {
            glyphs[i - glyph1Num].update(RepresentationEnum.REGION, backend
                .getSongs().getIndex(i + glyph1Num).getData(), backend
                    .getNumReps());
        }
        key.update(RepresentationEnum.REGION);
        display();
    }


    /**
     * Quits out of display
     * 
     * @param button
     *            the Quit button
     */
    public void pressedQuit(Button button) {
        System.exit(0);
    }
}
