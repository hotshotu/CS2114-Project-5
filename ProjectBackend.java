package mpvisual;

import java.io.*;
import java.util.*;

public class ProjectBackend {
    // leave blank for now
    private LinkedSong songs;
    private int numResponse;


    public ProjectBackend(String[] args) throws FileNotFoundException {
        songs = new LinkedSong();
        numResponse = 0;
        loadSongs(args[0]);
        loadSurvey(args[1]);
    }


    public LinkedSong getSongs() {
        return songs;
    }


    public int getNumRep() {
        return numResponse;
    }


    public void loadSongs(String arg) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("SongList2018S.csv"));
        while (scan.hasNextLine()) {
            StringTokenizer s = new StringTokenizer(scan.nextLine());
            String name = s.nextToken();
            String artist = s.nextToken();
            String year = s.nextToken();
            String genre = s.nextToken();
            Song song = new Song(name, artist, Integer.parseInt(year), genre);
            SongNode node = new SongNode(song);
            songs.add(node);
        }
    }


    public void loadSurvey(String arg) throws FileNotFoundException
    {
        Scanner scan = new Scanner(new File("MusicSurvey2018S.csv"));
        while(scan.hasNextLine())
        {
            StringTokenizer s = new StringTokenizer(scan.nextLine());
            Hobby hobby = null;
            Major major = null;
            Region region = null;
            if(s.nextToken().equals("sports")) {
                hobby = Hobby.SPORTS;
            }
            if(s.nextToken().equals("art")) {
                hobby = Hobby.ART;
            }
            if(s.nextToken().equals("music")) {
                hobby = Hobby.MUSIC;
            }
            if(s.nextToken().equals("reading")) {
                hobby = Hobby.READ;
            }
            if(s.nextToken().equals("Math or CMDA"))
            {
                major = Major.MATHCDMA;
            }
            if(s.nextToken().equals("Computer Science"))
            {
                major = Major.COMPSCI;
            }
            if(s.nextToken().equals("Other Engineering"))
            {
                major = Major.OTHERENG;
            }
            if(s.nextToken().equals("Other"))
            {
                major = Major.OTHER;
            }
            if(s.nextToken().equals("United States (other than Southeast or Northwest)"))
            {
                region = Region.OTHERUS;
            }
            if(s.nextToken().equals("Northeast"))
            {
                region = Region.NEUS;
            }
            if(s.nextToken().equals("Outside of United States"))
            {
                region = Region.OUTSIDEUS;
            }
            if(s.nextToken().equals("Southeast"))
            {
                region = Region.SEUS;
            }
            for(int x = 0; x< songs.size(); x++)
            {
                if(s.nextToken().equals("Yes"))
                {
                   if(x%2 == 0)
                   {
                       songs.getIndex(x).getData().addYes(hobby, major, region, HorL.HEARD);
                   }
                   else {
                       songs.getIndex(x).getData().addYes(hobby, major, region, HorL.LIKED);
                   }
                }
                numResponse++;
            }
        }
    }
}
