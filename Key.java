package prj5;

import java.awt.Color;
import CS2114.*;

/**
 * Key is the front-end legend that is displayed
 * 
 * @author Ender Jaska
 * @version 2018.11.10
 */
public class Key {

    private TextShape keyTitle;
    private TextShape keyName1;
    private TextShape keyName2;
    private TextShape keyName3;
    private TextShape keyName4;

    private TextShape keySong;
    private TextShape keyHeard;
    private TextShape keyLiked;

    private Shape keyBlackBar;
    private Shape keyWhiteBox;
    private Shape keyBlackBox;


    /**
     * Constructor for the Key class
     */
    public Key() {
        // These should have the same x, different y values, determine later
        keyTitle = new TextShape(620, 110, "Hobby Legend");
        keyName1 = new TextShape(620, 125, "Read", Color.PINK);
        keyName2 = new TextShape(620, 140, "Art", Color.BLUE);
        keyName3 = new TextShape(620, 155, "Sports", Color.YELLOW);
        keyName4 = new TextShape(620, 170, "Music", Color.GREEN);

        // The following need actual locations and sizes. Test and place later.
        // Program will not display correctly if they are left as default.
        keySong = new TextShape(640, 190, "Song Title");
        keyHeard = new TextShape(620, 215, "Heard");
        keyLiked = new TextShape(685, 215, "Likes");
        keyBlackBox = new Shape(610, 100, 120, 140, Color.BLACK);
        keyWhiteBox = new Shape(615, 105, 110, 130, Color.WHITE);
        keyBlackBar = new Shape(670, 205, 10, 25, Color.BLACK);
    }


    /**
     * Updates the key based on which representation is chosen
     * 
     * @param r
     *            The representation that will viewed
     */
    public void update(RepresentationEnum r) {
        switch (r) {
            case HOBBY:
                keyTitle.setText("Hobby Legend");
                keyName1.setText("Read");
                keyName2.setText("Art");
                keyName3.setText("Sports");
                keyName4.setText("Music");
                break;
            case MAJOR:
                keyTitle.setText("Major Legend");
                keyName1.setText("Comp Sci");
                keyName2.setText("Other Eng");
                keyName3.setText("Math/CDMA");
                keyName4.setText("Other");
                break;
            case REGION:
                keyTitle.setText("Region Legend");
                keyName1.setText("NE US");
                keyName2.setText("SE US");
                keyName3.setText("Other US");
                keyName4.setText("Outside US");
                break;
            default:
                throw new IllegalArgumentException(
                    "Invalid Representation pass to Key");
        }
    }


    /**
     * Displays the key in the window
     * 
     * @param win
     *            The window that needs a key displayed
     */
    public void displayKey(Window win) {
        win.removeAllShapes();
        win.addShape(keyTitle);
        win.addShape(keyName1);
        win.addShape(keyName2);
        win.addShape(keyName3);
        win.addShape(keyName4);
        win.addShape(keySong);
        win.addShape(keyHeard);
        win.addShape(keyLiked);
        win.addShape(keyBlackBar);
        win.addShape(keyWhiteBox);
        win.addShape(keyBlackBox);
    }
}
