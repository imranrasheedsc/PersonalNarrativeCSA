import org.code.theater.*;
import org.code.media.*;

public class MyStory extends Scene {

  private String[][] nbaTeams;
  private ImageFilter[][] images;
   
  public MyStory(String[][] nbaTeams, ImageFilter[][] images) {
     this.nbaTeams = nbaTeams;
     this.images = images;
  }

  /* Draws/initalizes the entire scene
   * It calls all the draw methods
   */
  public void drawScene() {
    drawFirstScene();
    drawSecondScene();
    drawThirdScene();
    drawFourthScene();
    drawFifthScene();
    drawSixthScene();
  }

  /* Loads info about the current nba teams found in a division
   * {param} sceneNumber - determines the row loaded
   */

  public void loadTeamInfo(int sceneNumber) {
    String teamNames = "";
    String cityAbbrevations = "";
    for (int i = 0; i < nbaTeams[sceneNumber].length; i++) {
      String currentNbaTeam = nbaTeams[sceneNumber][i];
      cityAbbrevations += currentNbaTeam.substring(0,currentNbaTeam.indexOf("-")) + "      ";
      teamNames += currentNbaTeam.substring(currentNbaTeam.indexOf("-")+1);
      if (i != nbaTeams[sceneNumber].length - 1) {
       teamNames += ", "; 
      }
    }

    for (int index = 0; index < images[sceneNumber].length; index++) {
      drawVisuals(teamNames, cityAbbrevations, index, sceneNumber);
      
      pause(1);
    }

    for (int index = 0; index < images[sceneNumber].length; index++) {
      if (sceneNumber == 0) {
        images[sceneNumber][index].makeNegative(); 
      } else if (sceneNumber == 1) {
        images[sceneNumber][index].colorShift(60);
      } else if (sceneNumber == 2) {
        images[sceneNumber][index].saturate(2);
      } else if (sceneNumber == 3) {
        images[sceneNumber][index].grayOutImage();
      } else if (sceneNumber == 4) {
        images[sceneNumber][index].colorShift(100);
      } else if (sceneNumber == 5) {
        images[sceneNumber][index].makeNegative(); 
      }
      drawVisuals(teamNames, cityAbbrevations, index, sceneNumber);
      
      pause(1);
    }
  }

  /* Draws the visuals on the screen based on the teamNames and cityAbbrevations
   * It then accesses the specific image using the index parameter to get the column,
   * and uses the sceneNumber parameter to access the row.
   */

  public void drawVisuals(String teamNames, String cityAbbrevations, int index, int sceneNumber) {
    clear("white");
    drawImage(images[sceneNumber][index], 10,images[sceneNumber][index].getHeight()-90,images[sceneNumber][index].getWidth());
    setTextStyle(Font.SANS, FontStyle.BOLD);
    setTextHeight(20);
    setTextColor(new Color(165, 1, 4));
    drawText(teamNames, 0,100);
    setTextColor(new Color(0, 255, 0));
    drawText(cityAbbrevations, 0,50);
  }

  /* Draws scenes based on the sceneNumber specified.
   * Depending on the sceneNumber specified, it will provide information about a different row
   * As well as displaying different images that correspond to that row index.
   */
  public void drawFirstScene() {
    int sceneNumber = 0;
    loadTeamInfo(sceneNumber);
    pause(0.5);
    clear("white");
  }

  public void drawSecondScene() {
    int sceneNumber = 1;
    loadTeamInfo(sceneNumber);
    pause(0.5);
    clear("white");
  }

  public void drawThirdScene() {
    int sceneNumber = 2;
    loadTeamInfo(sceneNumber);
    pause(0.5);
    clear("white");
  }
  public void drawFourthScene() {
    int sceneNumber = 3;
    loadTeamInfo(sceneNumber);
    pause(0.5);
    clear("white");
  }
  public void drawFifthScene() {
    int sceneNumber = 4;
    loadTeamInfo(sceneNumber);
    pause(0.5);
    clear("white");
  }
  public void drawSixthScene() {
    int sceneNumber = 5;
    loadTeamInfo(sceneNumber);
    pause(0.5);
    clear("white");
  }
}