package seng201.team131.gui;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import seng201.team131.Difficulty;
import seng201.team131.Player;
import seng201.team131.Round;
public class GameChangersScreenController extends Controller {
    private Player player;
    public GameChangersScreenController(Player newPlayer) {
        player = newPlayer;
    }
    @FXML
    private Button BtnDiffEasy;
    @FXML
    private Button BtnDiffMed;
    @FXML
    private Button BtnDiffHard;
    @FXML
    private Button BtnTradeOff1;
    @FXML
    private Button BtnTradeOff2;
    @FXML
    private Button BtnTradeOff3;
    @FXML
    private Button BtnPwrUp1;
    @FXML
    private Button BtnPwrUp2;
    @FXML
    private Button BtnPwrUp3;
    public GameChangersScreenController() {
        //go FX yourself
    }

    @Override
    public void setPlayer(Player player) {
        this.player = player;
        initialize();
    }
    @FXML
    public void initialize() {
        if (player != null) {

        }
    }

    public void onBtnDiffEasy(){


        //Round round = new Round();
        //player.applyDifficulty(Difficulty.EASY);
    }

    public void onBtnDiffMed(){

        Round round = new Round();
        round.applyDifficulty(EnumDifficulty.MEDIUM, player.getRound());
    }

    public void onBtnDiffHard(){
        Round round = new Round();
        round.applyDifficulty(Difficulty.HARD, player.getRound());
    }

}
