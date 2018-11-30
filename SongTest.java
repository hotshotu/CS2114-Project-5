package prj5;

import student.TestCase;

/**
 * Tester for Song class
 * 
 * @author Kenneth Ding <dkenny>
 * @version 11.15.2018
 *
 */
public class SongTest extends TestCase {

    private Song music;
    private LinkedSong songList;
    private SongNode songHolder;


    /**
     * sets up required variables
     */
    public void setUp() {
        music = new Song("Redo", "PelleK", 2016, "Pop");
        songHolder = new SongNode(music);
        songList = new LinkedSong();
    }


    /**
     * Tests the addYesHobby method
     */
    public void testAddYesHobby() {
        songList.add(songHolder);
        try {
            songList.getIndex(0).getData().addYesHobby(HobbyEnum.DEF,
                HorLEnum.HEARD);
        }
        catch (IllegalArgumentException e) {
            System.out.println("Invalid Hobby pass to Song");
            assertNotNull(e);
            assertTrue(e instanceof IllegalArgumentException);
        }
        songList.getIndex(0).getData().addYesHobby(HobbyEnum.ART,
            HorLEnum.LIKED);
        songList.getIndex(0).getData().addYesHobby(HobbyEnum.ART,
            HorLEnum.HEARD);
        songList.getIndex(0).getData().addYesHobby(HobbyEnum.READ,
            HorLEnum.LIKED);
        songList.getIndex(0).getData().addYesHobby(HobbyEnum.READ,
            HorLEnum.HEARD);
        songList.getIndex(0).getData().addYesHobby(HobbyEnum.SPORTS,
            HorLEnum.LIKED);
        songList.getIndex(0).getData().addYesHobby(HobbyEnum.SPORTS,
            HorLEnum.HEARD);
        songList.getIndex(0).getData().addYesHobby(HobbyEnum.MUSIC,
            HorLEnum.LIKED);
        songList.getIndex(0).getData().addYesHobby(HobbyEnum.MUSIC,
            HorLEnum.HEARD);
        assertEquals(8, music.getReps(RepresentationEnum.HOBBY));
    }


    /**
     * Tests the addYesMajor method
     */
    public void testAddYesMajor() {
        songList.add(songHolder);
        try {
            songList.getIndex(0).getData().addYesMajor(MajorEnum.DEF,
                HorLEnum.HEARD);
        }
        catch (IllegalArgumentException e) {
            System.out.println("Invalid Major pass to Song");
            assertNotNull(e);
            assertTrue(e instanceof IllegalArgumentException);
        }
        assertEquals(music, songHolder.getData());
        songList.getIndex(0).getData().addYesMajor(MajorEnum.COMPSCI,
            HorLEnum.LIKED);
        songList.getIndex(0).getData().addYesMajor(MajorEnum.COMPSCI,
            HorLEnum.HEARD);
        songList.getIndex(0).getData().addYesMajor(MajorEnum.MATHCDMA,
            HorLEnum.LIKED);
        songList.getIndex(0).getData().addYesMajor(MajorEnum.MATHCDMA,
            HorLEnum.HEARD);
        songList.getIndex(0).getData().addYesMajor(MajorEnum.OTHERENG,
            HorLEnum.LIKED);
        songList.getIndex(0).getData().addYesMajor(MajorEnum.OTHERENG,
            HorLEnum.HEARD);
        songList.getIndex(0).getData().addYesMajor(MajorEnum.OTHER,
            HorLEnum.LIKED);
        songList.getIndex(0).getData().addYesMajor(MajorEnum.OTHER,
            HorLEnum.HEARD);
        assertEquals(8, music.getReps(RepresentationEnum.MAJOR));
    }


    /**
     * Tests the addYesRegion method
     */
    public void testAddYesRegion() {
        songList.add(songHolder);
        try {
            songList.getIndex(0).getData().addYesRegion(RegionEnum.DEF,
                HorLEnum.HEARD);
        }
        catch (IllegalArgumentException e) {
            System.out.println("Invalid Region pass to Song");
            assertNotNull(e);
            assertTrue(e instanceof IllegalArgumentException);
        }
        assertEquals(music, songHolder.getData());
        songList.getIndex(0).getData().addYesRegion(RegionEnum.NEUS,
            HorLEnum.LIKED);
        songList.getIndex(0).getData().addYesRegion(RegionEnum.NEUS,
            HorLEnum.HEARD);
        songList.getIndex(0).getData().addYesRegion(RegionEnum.SEUS,
            HorLEnum.LIKED);
        songList.getIndex(0).getData().addYesRegion(RegionEnum.SEUS,
            HorLEnum.HEARD);
        songList.getIndex(0).getData().addYesRegion(RegionEnum.OTHERUS,
            HorLEnum.LIKED);
        songList.getIndex(0).getData().addYesRegion(RegionEnum.OTHERUS,
            HorLEnum.HEARD);
        songList.getIndex(0).getData().addYesRegion(RegionEnum.OUTSIDEUS,
            HorLEnum.LIKED);
        songList.getIndex(0).getData().addYesRegion(RegionEnum.OUTSIDEUS,
            HorLEnum.HEARD);

        assertEquals(8, music.getReps(RepresentationEnum.REGION));
    }


    /**
     * Tests the getRepresentation method
     */
    public void testGetRepresentation() {
        try {
            music.getRepresentation(RepresentationEnum.DEF);
        }
        catch (IllegalArgumentException e) {
            System.out.println("Invalid Representation pass to Song");
            assertNotNull(e);
            assertTrue(e instanceof IllegalArgumentException);
        }
        music.addYesHobby(HobbyEnum.ART, HorLEnum.HEARD);
        assertEquals(1, music.getRepresentation(RepresentationEnum.HOBBY)[2]);
        assertEquals(0, music.getRepresentation(RepresentationEnum.REGION)[2]);
        assertEquals(0, music.getRepresentation(RepresentationEnum.MAJOR)[2]);

    }


    /**
     * Tests the getTitle method
     */
    public void testGetTitle() {
        assertEquals("Redo", music.getTitle());
    }


    /**
     * Tests the getArtist method
     */
    public void testGetArtist() {
        assertEquals("PelleK", music.getArtist());
    }


    /**
     * Tests the getYear method
     */
    public void testGetYear() {
        assertEquals(2016, music.getYear());
    }


    /**
     * Tests the getGenre method
     */
    public void testGetGenre() {
        assertEquals("Pop", music.getGenre());
    }


    /**
     * Tests the getReps method
     */
    public void testGetReps() {
        try {
            music.getReps(RepresentationEnum.DEF);
        }
        catch (IllegalArgumentException e) {
            System.out.println("Illegal Representation pass to getReps");
        }
        music.addReps(RepresentationEnum.HOBBY);
        assertEquals(1, music.getReps(RepresentationEnum.HOBBY));
        assertEquals(0, music.getReps(RepresentationEnum.REGION));
        assertEquals(0, music.getReps(RepresentationEnum.MAJOR));

    }


    /**
     * Tests the addReps method
     */
    public void testAddReps() {
        try {
            music.addReps(RepresentationEnum.DEF);
        }
        catch (IllegalArgumentException e) {
            System.out.println("Illegal Representation pass to addReps");
        }
        music.addReps(RepresentationEnum.HOBBY);
        music.addReps(RepresentationEnum.MAJOR);
        music.addReps(RepresentationEnum.REGION);
        assertEquals(1, music.getReps(RepresentationEnum.HOBBY));
        assertEquals(1, music.getReps(RepresentationEnum.MAJOR));
        assertEquals(1, music.getReps(RepresentationEnum.REGION));
    }
}
