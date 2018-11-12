package mpvisual;

import CS2114.*;

public class ProjectWindow {

    private ProjectBackend backend;
    private int glyphNum;
    private Glyph[] glyphs;
    private Key key;
    private Window window;


    public ProjectWindow(String[] args) {
        backend = new ProjectBackend(args);
        glyphNum = 0;
        glyphs = new Glyph[9];
        key = new Key();
        window = new Window();

        SongNode temp = backend.getSongs().getHead();
        for (int i = 0; i < 9; i++) {
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
        window.addButton(next, WindowSide.NORTH);
        next.onClick(this, "pressedNext");

        window.addButton(sortArtist, WindowSide.NORTH);
        sortArtist.onClick(this, "pressedSortArtist");
        window.addButton(sortTitle, WindowSide.NORTH);
        sortTitle.onClick(this, "pressedSortTitle");
        window.addButton(sortYear, WindowSide.NORTH);
        sortYear.onClick(this, "pressedSortYear");
        window.addButton(sortGenre, WindowSide.NORTH);
        sortGenre.onClick(this, "pressedSortGenre");

        window.addButton(repHobby, WindowSide.SOUTH);
        repHobby.onClick(this, "pressedRepHobby");
        window.addButton(repMajor, WindowSide.SOUTH);
        repMajor.onClick(this, "pressedRepMajor");
        window.addButton(repRegion, WindowSide.SOUTH);
        repRegion.onClick(this, "pressedRepRegion");

        window.addButton(quit, WindowSide.SOUTH);
        quit.onClick(this, "pressedQuit");

        display();
    }


    public void display() {
        //TODO
    }


    public void pressedNext(Button button) {
        if (glyphNum + 9 < backend.getNumRep()) {
            glyphNum += 9;
        }
    }


    public void pressedPrev(Button button) {
        if (glyphNum > 9) {
            glyphNum -= 9;
        }
    }


    public void pressedSortArtist(Button button) {
        // Use sortSongs in backEnd class
        // display();
    }


    public void pressedSortTitle(Button button) {
        // Use sortSongs in backEnd class
        // display();
    }


    public void pressedSortYear(Button button) {
        // Use sortSongs in backEnd class
        // display();
    }


    public void pressedSortGenre(Button button) {
        // Use sortSongs in backEnd class
        // display();
    }


    public void pressedRepHobby(Button button) {
        // call update in glyph
        // display();
    }


    public void pressedRepMajor(Button button) {
        // call update in glyph
        // display();
    }


    public void pressedRepRegion(Button button) {
        // call update in glyph
        // display();
    }


    public void pressedQuit(Button button) {
        System.exit(0);
    }
}
