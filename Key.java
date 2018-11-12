package mpvisual;

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


    public Key() {
        // These should have the same x, different y values, determine later
        keyTitle = new TextShape(0, 0, "");
        keyName1 = new TextShape(0, 0, "", Color.PINK);
        keyName2 = new TextShape(0, 0, "", Color.BLUE);
        keyName3 = new TextShape(0, 0, "", Color.YELLOW);
        keyName4 = new TextShape(0, 0, "", Color.GREEN);

        // The following need actual locations and sizes. Test and place later.
        // Program will not display correctly if they are left as default.
        keySong = new TextShape(0, 0, "Song Title");
        keyHeard = new TextShape(0, 0, "Heard");
        keyLiked = new TextShape(0, 0, "Likes");
        keyBlackBox = new Shape(0, 0, 0, 0, Color.BLACK);
        keyWhiteBox = new Shape(0, 0, 0, 0, Color.WHITE);
        keyBlackBar = new Shape(0, 0, 0, 0, Color.BLACK);
    }


    public void update(Representation r) {
        switch (r) {
            default:
                throw new IllegalArgumentException(
                    "Invalid Representation pass to Key");
            case HOBBY:
                keyTitle.setText("Hobby Legend");
                keyName1.setText("Read");
                keyName2.setText("Art");
                keyName3.setText("Sports");
                keyName4.setText("Music");
            case MAJOR:
                keyTitle.setText("Major Legend");
                keyName1.setText("Comp Sci");
                keyName2.setText("Other Eng");
                keyName3.setText("Math/CDMA");
                keyName4.setText("Other");
            case REGION:
                keyTitle.setText("Region Legend");
                keyName1.setText("NE US");
                keyName2.setText("SE US");
                keyName3.setText("Other US");
                keyName4.setText("Outside US");
        }
    }


    // The two ints used to be x and y values, but were deleted as we don't need
    // to base the key off of a passed x and y, but instead hardcode values
    public void displayKey(Window win) {
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
