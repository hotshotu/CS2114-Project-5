package prj5;

/**
 * Song is the backend data that is stored for a single song
 * 
 * @author Ender Jaska
 * @version 2018.11.10
 */
public class Song {

    private String title;
    private String artist;
    private int year;
    private String genre;

    private int[] hobby;
    private int[] major;
    private int[] region;
    private int[] numReps;


    /**
     * Constructor for Song
     * 
     * @param title
     *            The title of the song
     * @param artist
     *            The artist of the song
     * @param year
     *            The release year of the song
     * @param genre
     *            The genre of the song
     */
    public Song(String title, String artist, int year, String genre) {
        this.title = title;
        this.artist = artist;
        this.year = year;
        this.genre = genre;

        hobby = new int[8];
        major = new int[8];
        region = new int[8];
        numReps = new int[3];

        for (int i = 0; i < 8; i++) {
            hobby[i] = 0;
            major[i] = 0;
            region[i] = 0;
            if (i < 3) {
                numReps[i] = 0;
            }
        }
    }


    /**
     * Increases the count for the respective Heard or Liked given a student's
     * hobby. It adds all three at once so it only needs to
     * be called once per song per student. It is called a second time if they
     * heard and liked, 0 times if neither.
     * 
     * @param h
     *            The student's hobby
     * @param pick
     *            Whether the student heard or liked the song
     */
    public void addYesHobby(HobbyEnum h, HorLEnum pick) {
        switch (h) {
            case READ:
                switch (pick) {
                    case HEARD:
                        hobby[0]++;
                        numReps[0]++;
                        break;
                    case LIKED:
                        hobby[1]++;
                        numReps[0]++;
                        break;
                    default:
                        throw new IllegalArgumentException(
                            "Invalid Hobby pass to Song");
                }
                break;
            case ART:
                switch (pick) {
                    case HEARD:
                        hobby[2]++;
                        numReps[0]++;
                        break;
                    case LIKED:
                        hobby[3]++;
                        numReps[0]++;
                        break;
                    default:
                        throw new IllegalArgumentException(
                            "Invalid Hobby pass to Song");
                }
                break;
            case SPORTS:
                switch (pick) {
                    case HEARD:
                        hobby[4]++;
                        numReps[0]++;
                        break;
                    case LIKED:
                        hobby[5]++;
                        numReps[0]++;
                        break;
                    default:
                        throw new IllegalArgumentException(
                            "Invalid Hobby pass to Song");
                }
                break;
            case MUSIC:
                switch (pick) {
                    case HEARD:
                        hobby[6]++;
                        numReps[0]++;
                        break;
                    case LIKED:
                        hobby[7]++;
                        numReps[0]++;
                        break;
                    default:
                        throw new IllegalArgumentException(
                            "Invalid Hobby pass to Song");
                }
                break;
            default:
                throw new IllegalArgumentException("Invalid HorL pass to Song");
        }
    }


    /**
     * Increases the count for the respective Heard or Liked given a student's
     * major. It adds all three at once so it only needs to
     * be called once per song per student. It is called a second time if they
     * heard and liked, 0 times if neither.
     * 
     * @param m
     *            the respective student's major
     * @param pick
     *            whether the student heard or liked the song
     */
    public void addYesMajor(MajorEnum m, HorLEnum pick) {
        switch (m) {
            case COMPSCI:
                switch (pick) {
                    case HEARD:
                        major[0]++;
                        numReps[1]++;
                        break;
                    case LIKED:
                        major[1]++;
                        numReps[1]++;
                        break;
                    default:
                        throw new IllegalArgumentException(
                            "Invalid Major pass to Song");
                }
                break;
            case OTHERENG:
                switch (pick) {
                    case HEARD:
                        major[2]++;
                        numReps[1]++;
                        break;
                    case LIKED:
                        major[3]++;
                        numReps[1]++;
                        break;
                    default:
                        throw new IllegalArgumentException(
                            "Invalid Major pass to Song");
                }
                break;
            case MATHCDMA:
                switch (pick) {
                    case HEARD:
                        major[4]++;
                        numReps[1]++;
                        break;
                    case LIKED:
                        major[5]++;
                        numReps[1]++;
                        break;
                    default:
                        throw new IllegalArgumentException(
                            "Invalid Major pass to Song");
                }
                break;
            case OTHER:
                switch (pick) {
                    case HEARD:
                        major[6]++;
                        numReps[1]++;
                        break;
                    case LIKED:
                        major[7]++;
                        numReps[1]++;
                        break;
                    default:
                        throw new IllegalArgumentException(
                            "Invalid Major pass to Song");
                }
                break;
            default:
                throw new IllegalArgumentException("Invalid HorL pass to Song");
        }
    }


    /**
     * Increases the count for the respective Heard or Liked given a student's
     * region. It adds all three at once so it only needs to
     * be called once per song per student. It is called a second time if they
     * heard and liked, 0 times if neither.
     * 
     * @param r
     *            The student's region
     * @param pick
     *            Whether the student heard or liked the song
     */
    public void addYesRegion(RegionEnum r, HorLEnum pick) {
        switch (r) {
            case NEUS:
                switch (pick) {
                    case HEARD:
                        region[0]++;
                        numReps[2]++;
                        break;
                    case LIKED:
                        region[1]++;
                        numReps[2]++;
                        break;
                    default:
                        throw new IllegalArgumentException(
                            "Invalid Region pass to Song");
                }
                break;
            case SEUS:
                switch (pick) {
                    case HEARD:
                        region[2]++;
                        numReps[2]++;
                        break;
                    case LIKED:
                        region[3]++;
                        numReps[2]++;
                        break;
                    default:
                        throw new IllegalArgumentException(
                            "Invalid Region pass to Song");
                }
                break;
            case OTHERUS:
                switch (pick) {
                    case HEARD:
                        region[4]++;
                        numReps[2]++;
                        break;
                    case LIKED:
                        region[5]++;
                        numReps[2]++;
                        break;
                    default:
                        throw new IllegalArgumentException(
                            "Invalid Region pass to Song");
                }
                break;
            case OUTSIDEUS:
                switch (pick) {
                    case HEARD:
                        region[6]++;
                        numReps[2]++;
                        break;
                    case LIKED:
                        region[7]++;
                        numReps[2]++;
                        break;
                    default:
                        throw new IllegalArgumentException(
                            "Invalid Region pass to Song");
                }
                break;
            default:
                throw new IllegalArgumentException("Invalid HorL pass to Song");
        }
    }


    /**
     * Getter method for the heard and liked numbers of a given representation
     * 
     * @param r
     *            The representation to be returned
     * @return Returns the corresponding array
     */
    public int[] getRepresentation(RepresentationEnum r) {
        switch (r) {
            case HOBBY:
                return hobby;
            case MAJOR:
                return major;
            case REGION:
                return region;
            default:
                throw new IllegalArgumentException(
                    "Invalid Representation pass to Song");
        }
    }


    // The reason why the following getter methods do not use the enum Sort and
    // a switch statement in a single method is because the getYear method needs
    // to return a int value, so we would have to change the int to a string at
    // the location where we call getYear

    /**
     * Getter method for title
     * 
     * @return Returns title
     */
    public String getTitle() {
        return title;
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


    /**
     * Getter for the number of students in each representation
     * 
     * @param rep
     *            The representation
     * @return Returns the number of students in each representation
     */
    public int getReps(RepresentationEnum rep) {
        switch (rep) {
            case HOBBY:
                return numReps[0];
            case MAJOR:
                return numReps[1];
            case REGION:
                return numReps[2];
            default:
                throw new IllegalArgumentException();
        }
    }


    /**
     * Increments a hobby based on the parameter
     * 
     * @param rep
     *            The representation
     */
    public void addReps(RepresentationEnum rep) {
        switch (rep) {
            case HOBBY:
                numReps[0]++;
                break;
            case MAJOR:
                numReps[1]++;
                break;
            case REGION:
                numReps[2]++;
                break;
            default:
                throw new IllegalArgumentException();
        }
    }
}
