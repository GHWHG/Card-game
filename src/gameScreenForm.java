import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class gameScreenForm extends JFrame{
    private JPanel mainPanel;
    private JTextArea gameTextArea;
    private JButton lowerButton;
    private JButton higherButton;
    private JButton playButton;
    private JButton backButton;
    private JLabel nameLabel;
    private JLabel scoreLabel;
    private JLabel highScoreLabel;
    private Player currentPlayer;
    private Card currentCard;
    private Deck cardDeck;
    private Card previousCard;
    private Boolean playing;
    private int roundScore;
    private Boolean savingData;
    private ArrayList<Player> playerData;



    public gameScreenForm(ArrayList<Player> playerData, Player newPlayer){
        this.playerData = playerData;
        this.currentPlayer = newPlayer;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();

        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                savingData=false;
                playing = true;
                roundScore=0;
                cardDeck = new Deck();
                gameTextArea.setText(null);
                setPlayerName(currentPlayer.getUserName());
                setScoreLabel(Integer.toString(roundScore));
                setHighScoreLabel(Integer.toString(currentPlayer.getHighScore()));
                playGame();
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeForm();
            }
        });


        lowerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(playing){
                    if(currentCard.getRank()< previousCard.getRank()){
                        gameTextArea.append("Correct"+"\n");
                        setScore();
                        gameTextArea.append("Current score:"+roundScore+".Cards left in deck "+ cardDeck.currentDeck.size()+"\n");
                        gameTextArea.update(gameTextArea.getGraphics());
                        nextRound();
                    }
                    else{
                        playing=false;
                        gameTextArea.append("Next card is "+ currentCard+" you are wrong");
                        gameTextArea.update(gameTextArea.getGraphics());
                        JOptionPane.showMessageDialog(null, "Game over");
                        if(savingData){
                            savePlayerData();
                        }
                    }
                }
            }
        });

        higherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(playing){
                    if(currentCard.getRank()> previousCard.getRank()){
                        gameTextArea.append("Correct"+"\n");
                        setScore();
                        gameTextArea.append("Current score:"+roundScore+".Cards left in deck "+ cardDeck.currentDeck.size()+"\n");
                        gameTextArea.update(gameTextArea.getGraphics());
                        nextRound();
                    }
                    else{
                        playing=false;
                        gameTextArea.append("Next card is "+ currentCard+" you are wrong");
                        gameTextArea.update(gameTextArea.getGraphics());
                        JOptionPane.showMessageDialog(null, "Game over");
                        if(savingData){
                            savePlayerData();
                        }
                    }
                }
            }
        });
    }

    public void setPlayerName(String name){
        nameLabel.setText(name);
    }

    public void setScoreLabel(String score){
        scoreLabel.setText(score);
    }

    public void setHighScoreLabel(String highScore){
        highScoreLabel.setText(highScore);
    }


    private void closeForm(){
        this.setVisible(false);
    }

    private void playGame() {
        gameTextArea.append("Hello - Welcome to the Card Game!"+"\n");
        gameTextArea.append(currentPlayer.getUserName()+" added to game"+"\n");
        gameTextArea.update(gameTextArea.getGraphics());
        cardDeck.makeNewDeck();
        cardDeck.shuffleDeck();
        currentCard = cardDeck.dealCard();

        gameTextArea.append(currentPlayer.getUserName()+" your first card is "+currentCard+"\n");
        gameTextArea.update(gameTextArea.getGraphics());
        nextRound();
    }


    private Boolean equalCard(){
        if(currentCard.getRank() == previousCard.getRank()){
            return true;
        }
        else{
            return false;
        }
    }

    private void nextRound(){
        if (cardDeck.isEmpty()){
            JOptionPane.showMessageDialog(null, "Deck empty, Game over");
            playing = false;
        }
        else{
            previousCard = currentCard;
            currentCard = cardDeck.dealCard();
            if(equalCard()){
                gameTextArea.append("Same card skip round"+"\n");
                gameTextArea.update(gameTextArea.getGraphics());
                nextRound();
            }
            else{
                gameTextArea.append("Is the next card higher or lower than "+ previousCard+"\n");
                gameTextArea.update(gameTextArea.getGraphics());
            }
        }
    }

    public void setScore(){
        roundScore+=1;
        setScoreLabel(Integer.toString(roundScore));

        if(roundScore>currentPlayer.getHighScore()){
            savingData=true;
            setHighScoreLabel(Integer.toString(roundScore));
        }
    }

    public void savePlayerData(){
        for (Player p:playerData){
            if (p.getUserName().equals(currentPlayer.getUserName())){
                p.setHighScore(roundScore);
                System.out.println(p);
                FileIO.saveDataToFile("playerData",playerData);

            }
        }
    }

}
