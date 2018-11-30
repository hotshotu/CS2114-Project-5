package prj5;

import java.io.*;
import java.util.*;

/**
 * Constructor of Project Backend
 * 
 * @author eljaska, kenny, Jeffrey Peng(jeffp123)
 * @version 11.14.2018
 * 
 */
public class ProjectBackend {

    private LinkedSong songs;
    private int numResponse;


    /**
     * Constructor with parameters for ProjectBackend
     * 
     * @param args
     *            are the files we will be looking through
     * @throws FileNotFoundException
     *             throws exception if the files that we take in are not the
     *             ones we are looking for
     */
    public ProjectBackend(String[] args) throws FileNotFoundException {
        songs = new LinkedSong();
        numResponse = 0;
        loadSongs(args[1]);
        loadSurvey(args[0]);
    }


    /**
     * gets the songs from Nodes
     * 
     * @return songs returns the songs
     */
    public LinkedSong getSongs() {
        return songs;
    }


    /**
     * loads the songs and adds them into a chain of nodes
     * 
     * @param arg
     *            String from the file we are looking for
     * @throws FileNotFoundException
     *             throws if file we are looking for is not found
     * 
     */
    public void loadSongs(String arg) throws FileNotFoundException {
        Scanner scan = new Scanner(new File(arg));
        scan.nextLine();
        while (scan.hasNextLine()) {
            String delims = ",";
            StringTokenizer s = new StringTokenizer(scan.nextLine(), delims);
            String name = s.nextToken();
            String artist = s.nextToken();
            String year = s.nextToken();
            String genre = s.nextToken();
            Song song = new Song(name, artist, Integer.parseInt(year), genre);
            SongNode node = new SongNode(song);
            songs.add(node);
        }
    }


    /**
     * gets the number of yes or no responses
     * 
     * @return numResponse number of responses
     */
    public int getNumReps() {
        return numResponse;
    }


    /**
     * loads the survey responses for songs
     * 
     * @param arg
     *            the file we need
     * @throws FileNotFoundException
     *             throws exception if we can't find the file we are looking for
     */
    public void loadSurvey(String arg) throws FileNotFoundException {
        Scanner scan = new Scanner(new File(arg));
        scan.nextLine();
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] splitLine = line.split(",", -1);
            HobbyEnum hobby = null;
            MajorEnum major = null;
            RegionEnum region = null;
            numResponse++;

            String temp = splitLine[2];
            if (temp.equals("Math or CMDA")) {
                major = MajorEnum.MATHCDMA;
            }
            else if (temp.equals("Computer Science")) {
                major = MajorEnum.COMPSCI;
            }
            else if (temp.equals("Other Engineering")) {
                major = MajorEnum.OTHERENG;
            }
            else if (temp.equals("Other")) {
                major = MajorEnum.OTHER;
            }

            temp = splitLine[3];
            if (temp.equals(
                "United States (other than Southeast or Northwest)")) {
                region = RegionEnum.OTHERUS;
            }
            else if (temp.equals("Northeast")) {
                region = RegionEnum.NEUS;
            }
            else if (temp.equals("Outside of United States")) {
                region = RegionEnum.OUTSIDEUS;
            }
            else if (temp.equals("Southeast")) {
                region = RegionEnum.SEUS;
            }

            temp = splitLine[4];
            if (temp.equals("sports")) {
                hobby = HobbyEnum.SPORTS;
            }
            else if (temp.equals("art")) {
                hobby = HobbyEnum.ART;
            }
            else if (temp.equals("music")) {
                hobby = HobbyEnum.MUSIC;
            }
            else if (temp.equals("reading")) {
                hobby = HobbyEnum.READ;
            }
            for (int x = 5; x < splitLine.length; x++) {
                if (splitLine[x].equals("Yes")) {
                    if (x % 2 == 1) {
                        if (hobby != null) {
                            songs.getIndex((x - 5) / 2).getData().addYesHobby(
                                hobby, HorLEnum.HEARD);
                            songs.getIndex((x - 5) / 2).getData().addReps(
                                RepresentationEnum.HOBBY);
                        }
                        if (major != null) {
                            songs.getIndex((x - 5) / 2).getData().addYesMajor(
                                major, HorLEnum.HEARD);
                            songs.getIndex((x - 5) / 2).getData().addReps(
                                RepresentationEnum.MAJOR);
                        }
                        if (region != null) {
                            songs.getIndex((x - 5) / 2).getData().addYesRegion(
                                region, HorLEnum.HEARD);
                            songs.getIndex((x - 5) / 2).getData().addReps(
                                RepresentationEnum.REGION);
                        }
                    }
                    else {
                        if (hobby != null) {
                            songs.getIndex((x - 5) / 2).getData().addYesHobby(
                                hobby, HorLEnum.LIKED);
                            songs.getIndex((x - 5) / 2).getData().addReps(
                                RepresentationEnum.HOBBY);
                        }
                        if (major != null) {
                            songs.getIndex((x - 5) / 2).getData().addYesMajor(
                                major, HorLEnum.LIKED);
                            songs.getIndex((x - 5) / 2).getData().addReps(
                                RepresentationEnum.MAJOR);
                        }
                        if (region != null) {
                            songs.getIndex((x - 5) / 2).getData().addYesRegion(
                                region, HorLEnum.LIKED);
                            songs.getIndex((x - 5) / 2).getData().addReps(
                                RepresentationEnum.REGION);
                        }
                    }
                }
            }
        }
    }


    /**
     * sorts the songs
     * 
     * @param sort
     *            the way we want the songs to be sorted
     */
    public void sortSongs(SortEnum sort) {
        int tempInt = 0;
        switch (sort) {

            case TITLE:
                for (int i = 0; i < songs.size(); i++) {
                    String ori = songs.getIndex(i).getData().getTitle();
                    for (int k = i + 1; k < songs.size(); k++) {
                        String comp = songs.getIndex(k).getData().getTitle();
                        if (compareTo(ori, comp) > 0) {
                            ori = comp;
                            tempInt = k;
                        }
                    }
                    Song temp = songs.getIndex(i).getData();
                    songs.getIndex(i).setData(songs.getIndex(tempInt)
                        .getData());
                    songs.getIndex(tempInt).setData(temp);
                }
                break;
            case ARTIST:
                for (int i = 0; i < songs.size(); i++) {
                    String ori = songs.getIndex(i).getData().getArtist();
                    for (int k = i + 1; k < songs.size(); k++) {
                        String comp = songs.getIndex(k).getData().getArtist();
                        if (compareTo(ori, comp) > 0) {
                            ori = comp;
                            tempInt = k;
                        }
                    }
                    Song temp = songs.getIndex(i).getData();
                    songs.getIndex(i).setData(songs.getIndex(tempInt)
                        .getData());
                    songs.getIndex(tempInt).setData(temp);
                }
                break;
            case YEAR:
                for (int i = 0; i < songs.size(); i++) {
                    int ori = songs.getIndex(i).getData().getYear();
                    for (int k = i + 1; k < songs.size(); k++) {
                        int comp = songs.getIndex(k).getData().getYear();
                        if (ori > comp) {
                            ori = comp;
                            tempInt = k;
                        }
                    }
                    Song temp = songs.getIndex(i).getData();
                    songs.getIndex(i).setData(songs.getIndex(tempInt)
                        .getData());
                    songs.getIndex(tempInt).setData(temp);
                }
                break;
            case GENRE:
                for (int i = 0; i < songs.size(); i++) {
                    String ori = songs.getIndex(i).getData().getGenre();
                    for (int k = i + 1; k < songs.size(); k++) {
                        String comp = songs.getIndex(k).getData().getGenre();

                        if (compareTo(ori, comp) > 0) {
                            ori = comp;
                            tempInt = k;
                        }
                    }
                    Song temp = songs.getIndex(i).getData();
                    songs.getIndex(i).setData(songs.getIndex(tempInt)
                        .getData());
                    songs.getIndex(tempInt).setData(temp);
                }
                break;
            default:
                throw new IllegalArgumentException(
                    "Invalid sort pass to sortSongs");
        }
    }


    /**
     * Compares 2 strings to see which one comes first
     * 
     * @param ori
     *            The original string
     * @param comp
     *            The string to be compared to
     * @return 1 if ori comes first, 0 if they are the same, and -1 if comp
     *         comes first
     */
    private int compareTo(String ori, String comp) {
        return ori.compareTo(comp);
    }
}
