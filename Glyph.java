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


    public void update(Representation rep, Song song, int numResponse) {
        int rep1HWidth;
        int rep1LWidth;
        int rep2HWidth;
        int rep2LWidth;
        int rep3HWidth;
        int rep3LWidth;
        int rep4HWidth;
        int rep4LWidth;
        switch (rep) {
            default:
                throw new IllegalArgumentException(
                    "Invalid Representation pass to Glyph");
            case HOBBY:
                rep1HWidth = song.getRepresentation(Representation.HOBBY)[0];
                rep1LWidth = song.getRepresentation(Representation.HOBBY)[1];
                rep2HWidth = song.getRepresentation(Representation.HOBBY)[2];
                rep2LWidth = song.getRepresentation(Representation.HOBBY)[3];
                rep3HWidth = song.getRepresentation(Representation.HOBBY)[4];
                rep3LWidth = song.getRepresentation(Representation.HOBBY)[5];
                rep4HWidth = song.getRepresentation(Representation.HOBBY)[6];
                rep4LWidth = song.getRepresentation(Representation.HOBBY)[7];
            case MAJOR:
                rep1HWidth = song.getRepresentation(Representation.MAJOR)[0];
                rep1LWidth = song.getRepresentation(Representation.MAJOR)[1];
                rep2HWidth = song.getRepresentation(Representation.MAJOR)[2];
                rep2LWidth = song.getRepresentation(Representation.MAJOR)[3];
                rep3HWidth = song.getRepresentation(Representation.MAJOR)[4];
                rep3LWidth = song.getRepresentation(Representation.MAJOR)[5];
                rep4HWidth = song.getRepresentation(Representation.MAJOR)[6];
                rep4LWidth = song.getRepresentation(Representation.MAJOR)[7];
            case REGION:
                rep1HWidth = song.getRepresentation(Representation.REGION)[0];
                rep1LWidth = song.getRepresentation(Representation.REGION)[1];
                rep2HWidth = song.getRepresentation(Representation.REGION)[2];
                rep2LWidth = song.getRepresentation(Representation.REGION)[3];
                rep3HWidth = song.getRepresentation(Representation.REGION)[4];
                rep3LWidth = song.getRepresentation(Representation.REGION)[5];
                rep4HWidth = song.getRepresentation(Representation.REGION)[6];
                rep4LWidth = song.getRepresentation(Representation.REGION)[7];
        }
        l1Shape = new Shape(rep1HWidth / numResponse, 15);
        r1Shape = new Shape(0, 0, rep1LWidth / numResponse * 65, 15);
        l2Shape = new Shape(rep2HWidth / numResponse, 15);
        r2Shape = new Shape(0, 0, rep2LWidth / numResponse * 65, 15);
        l3Shape = new Shape(rep3HWidth / numResponse, 15);
        r3Shape = new Shape(0, 0, rep3LWidth / numResponse * 65, 15);
        l4Shape = new Shape(rep4HWidth / numResponse, 15);
        r4Shape = new Shape(0, 0, rep4LWidth / numResponse * 65, 15);
        glyphBlackBar = new Shape(0, 0, 15, 60);
    }


// Need to account for variable bar lengths
    public void displayGlyph(Window win, int x, int y) {

        titleShape.setX((x - titleShape.getWidth()) / 2);
        titleShape.setY(y);
        artistShape.setX((y - artistShape.getWidth()) / 2);
        artistShape.setY(y + titleShape.getHeight());

        l1Shape.setX((x - l1Shape.getWidth()) / 2);
        l1Shape.setY(y + titleShape.getHeight() + artistShape.getHeight());

        r1Shape.setX(x + l1Shape.getWidth() + glyphBlackBar.getWidth());
        r1Shape.setY(y + titleShape.getHeight() + artistShape.getHeight());

        l2Shape.setX(x);
        l2Shape.setY(y + titleShape.getHeight() + artistShape.getHeight()
            + l1Shape.getHeight());

        r2Shape.setX(x + l2Shape.getWidth() + glyphBlackBar.getWidth());
        r2Shape.setY(y + titleShape.getHeight() + artistShape.getHeight()
            + l1Shape.getHeight());

        l3Shape.setX(x);
        l3Shape.setY(y + titleShape.getHeight() + artistShape.getHeight()
            + l1Shape.getHeight() + l2Shape.getHeight());

        r3Shape.setX(x + l3Shape.getWidth() + glyphBlackBar.getWidth());
        r3Shape.setY(y + titleShape.getHeight() + artistShape.getHeight()
            + r1Shape.getHeight() + r2Shape.getHeight());

        l4Shape.setX(x);
        l4Shape.setY(y + titleShape.getHeight() + artistShape.getHeight()
            + l1Shape.getHeight() + l2Shape.getHeight() + l3Shape.getHeight());

        r4Shape.setX(x + l4Shape.getWidth() + glyphBlackBar.getWidth());
        r4Shape.setY(y + titleShape.getHeight() + artistShape.getHeight()
            + r1Shape.getHeight() + r2Shape.getHeight() + r3Shape.getHeight());
        
        glyphBlackBar.setX(x + l1Shape.getWidth());
    }
}
