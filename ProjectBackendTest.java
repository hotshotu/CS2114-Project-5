package prj5;

import java.io.FileNotFoundException;
import student.TestCase;

/**
 * Tester for ProjectBackend
 * 
 * @author Kenneth Ding <dkenny>
 * @version 11.15.2018
 *
 */
public class ProjectBackendTest extends TestCase {
    private ProjectWindow window;
    private ProjectBackend backend;


    /**
     * setup method for the two
     */
    public void setUp() throws FileNotFoundException {
        window = new ProjectWindow(new String[] { "MusicSurveyData.csv",
            "SongList.csv" });
        backend = new ProjectBackend(new String[] { "MusicSurveyData.csv",
            "SongList.csv" });
    }


    /**
     * Tester for both window and backend
     */
    public void testEverything() {
        assertEquals(209, backend.getNumReps());
        assertEquals(59, backend.getSongs().size());
        window.pressedNext(null);
        window.pressedPrev(null);
        window.pressedRepHobby(null);
        window.pressedRepMajor(null);
        window.pressedRepRegion(null);
        window.pressedSortArtist(null);
        window.pressedSortGenre(null);
        window.pressedSortTitle(null);
        window.pressedSortYear(null);
    }
}
