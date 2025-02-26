import org.code.theater.*;
import org.code.media.*;

public class TheaterRunner {
  public static void main(String[] args) {
    /* 2D Array storing nba teams information
     * Contains city/team abbreviation and team name
     */
    String[][] nbaTeams = {
      {"BOS-Celtics", "NYK-Knicks", "PHI-76ers", "BKN-Nets", "TOR-Raptors"},
      {"CLE-Cavaliers", "IND-Pacers", "MIL-Bucks", "DET-Pistons", "CHI-Bulls"},
      {"MIA-Heat", "ATL-Hawks", "ORL-Magic", "CHA-Hornets", "WAS-Wizards"},
      {"OKC-Thunder", "DEN-Nuggets", "POR-Trail Blazers", "UTA-Jazz", "MIN-Timberwolves"},
      {"LAL-Lakers", "LAC-Clippers", "SAC-Kings", "GSW-Warriors", "PHO-Suns"},
      {"MEM-Grizzlies", "HOU-Rockets", "DAL-Mavericks", "SAS-Spurs", "NOP-Pelicans"}
    };
    
     /* 2D Array storing images relating to the division of the corresponding row of nba teams
     * 2 images per row
     */
    ImageFilter[][] images = {
      { new ImageFilter("atlanticdivision.jpg"), new ImageFilter("nbadivsionmapatlantic.jpg") },
      { new ImageFilter("centralNBA.png"), new ImageFilter("central-divsion-map.jpeg") },
      { new ImageFilter ("southeastlogos.jpg"), new ImageFilter("southeastmap.jpg")},
      { new ImageFilter ("northwestNBA.png"), new ImageFilter("northwestmap.jpg")},
      { new ImageFilter ("pacificNBA.png"), new ImageFilter("pacificmap.jpg")},
      { new ImageFilter("nbaSouthwest.png"), new ImageFilter("southwestjpg.jpg") },
      
    };

    
    MyStory scene = new MyStory(nbaTeams, images);

    scene.drawScene();
    Theater.playScenes(scene);
  }
}