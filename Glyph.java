package mpvisual;

import java.awt.Color;
import CS2114.*;

/**
 * Glyph is the front-end representation of a song
 * 
 * @author Ender Jaska
 * @version 2018.11.10
 */
public class Glyph {

    private TextShape titleShape;
    private TextShape artistShape;
    private Shape l1Shape;
    private Shape r1Shape;
    private Shape l2Shape;
    private Shape r2Shape;
    private Shape l3Shape;
    private Shape r3Shape;
    private Shape l4Shape;
    private Shape r4Shape;
    private Shape glyphBlackBar;


    // the heights of the bars, the x of the r bars, and glyphBlackBar should be
    // hard-coded
    public Glyph(Song song) {
        titleShape = new TextShape(0, 0, song.getName());
        artistShape = new TextShape(0, 0, song.getArtist());
        l1Shape = new Shape(0, 0, 0, 0, Color.PINK);
        r1Shape = new Shape(0, 0, 0, 0, Color.PINK);
        l2Shape = new Shape(0, 0, 0, 0, Color.BLUE);
        r2Shape = new Shape(0, 0, 0, 0, Color.BLUE);
        l3Shape = new Shape(0, 0, 0, 0, Color.YELLOW);
        r3Shape = new Shape(0, 0, 0, 0, Color.YELLOW);
        l4Shape = new Shape(0, 0, 0, 0, Color.GREEN);
        r4Shape = new Shape(0, 0, 0, 0, Color.GREEN);
        glyphBlackBar = new Shape(0, 0, 0, 0);
    }
    
    public void update(Representation rep, Song song, int glyphNum) {
        switch(rep) {
            default:
                throw new IllegalArgumentException(
                    "Invalid Representation pass to Glyph");
            case HOBBY:
                
        }
    }
}
