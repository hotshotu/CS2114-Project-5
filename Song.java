package mpvisual;

/**
 * Song is the backend data that is stored for a single song
 * 
 * @author Ender Jaska
 * @version 2018.11.10
 */
public class Song {

    private String name;
    private String artist;
    private int year;
    private String genre;

    private int[] hobby;
    private int[] major;
    private int[] region;


    /**
     * Constructor for Song
     * 
     * @param Name
     *            The name of the song
     * @param Artist
     *            The artist of the song
     * @param Year
     *            The release year of the song
     * @param Genre
     *            The genre of the song
     */
    public Song(String Name, String Artist, int Year, String Genre) {
        name = Name;
        artist = Artist;
        year = Year;
        genre = Genre;

        hobby = new int[8];
        major = new int[8];
        region = new int[8];

        for (int i = 0; i < 8; i++) {
            hobby[i] = 0;
            major[i] = 0;
            region[i] = 0;
        }
    }


    /**
     * Increases the count for the respective Heard or Liked given a student's
     * hobby, major, and region. It adds all three at once so it only needs to
     * be called once per song per student. It is called a second time if they
     * heard and liked, 0 times if neither.
     * 
     * @param h
     *            The student's hobby
     * @param m
     *            The student's major
     * @param r
     *            The student's region
     * @param pick
     *            Whether the student heard or liked the song
     */
    public void addYes(Hobby h, Major m, Region r, HorL pick) {
        switch (pick) {
            default:
                throw new IllegalArgumentException("Invalid HorL pass to Song");
            case HEARD:
                switch (h) {
                    default:
                        throw new IllegalArgumentException(
                            "Invalid Hobby pass to Song");
                    case READ:
                        hobby[0]++;
                    case ART:
                        hobby[1]++;
                    case SPORTS:
                        hobby[2]++;
                    case MUSIC:
                        hobby[3]++;
                }
                switch (m) {
                    default:
                        throw new IllegalArgumentException(
                            "Invalid Major pass to Song");
                    case COMPSCI:
                        major[0]++;
                    case OTHERENG:
                        major[1]++;
                    case MATHCDMA:
                        major[2]++;
                    case OTHER:
                        major[3]++;
                }
                switch (r) {
                    default:
                        throw new IllegalArgumentException(
                            "Invalid Region pass to Song");
                    case NEUS:
                        region[0]++;
                    case SEUS:
                        region[1]++;
                    case OTHERUS:
                        region[2]++;
                    case OUTSIDEUS:
                        region[3]++;
                }
            case LIKED:
                switch (h) {
                    default:
                        throw new IllegalArgumentException(
                            "Invalid Hobby pass to Song");
                    case READ:
                        hobby[4]++;
                    case ART:
                        hobby[5]++;
                    case SPORTS:
                        hobby[6]++;
                    case MUSIC:
                        hobby[7]++;
                }
                switch (m) {
                    default:
                        throw new IllegalArgumentException(
                            "Invalid Major pass to Song");
                    case COMPSCI:
                        major[4]++;
                    case OTHERENG:
                        major[5]++;
                    case MATHCDMA:
                        major[6]++;
                    case OTHER:
                        major[7]++;
                }
                switch (r) {
                    default:
                        throw new IllegalArgumentException(
                            "Invalid Region pass to Song");
                    case NEUS:
                        region[4]++;
                    case SEUS:
                        region[5]++;
                    case OTHERUS:
                        region[6]++;
                    case OUTSIDEUS:
                        region[7]++;
                }
        }
    }


    /**
     * Getter method for the heard and liked numbers of a given representation
     * 
     * @param r
     *            The representation to be returned
     * @return Returns the corresponding array
     */
    public int[] getRepresentation(Representation r) {
        switch (r) {
            default:
                throw new IllegalArgumentException(
                    "Invalid Representation pass to Song");
            case HOBBY:
                return hobby;
            case MAJOR:
                return major;
            case REGION:
                return region;
        }
    }


    // The reason why the following getter methods do not use the enum Sort and
    // a switch statement in a single method is because the getYear method needs
    // to return a int value, so we would have to change the int to a string at
    // the location where we call getYear

    /**
     * Getter method for name
     * 
     * @return Returns name
     */
    public String getName() {
        return name;
    }


    /**
     * Getter method for artist
     * 
     * @return Returns artist
     */
    public String getArtist() {
        return artist;
    }


    /**
     * Getter method for year
     * 
     * @return Returns year
     */
    public int getYear() {
        return year;
    }


    /**
     * Getter method for genre
     * 
     * @return Returns genre
     */
    public String getGenre() {
        return genre;
    }
}
