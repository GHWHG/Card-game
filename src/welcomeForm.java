import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class welcomeForm extends JFrame{
    private JButton existingPlayerButton;
    private JButton guestButton;
    private JButton newPlayerButton;
    private JPanel mainPanel;

    public welcomeForm(ArrayList<Player> playerData){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        newPlayerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame form1 = new newPlayerForm(playerData);
                form1.setLocationRelativeTo(null);
                form1.setVisible(true);

            }
        });
        existingPlayerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame form2 = new existingPlayerForm(playerData);
                form2.setLocationRelativeTo(null);
                form2.setVisible(true);
            }
        });

        guestButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame form3 = new gameScreenForm(playerData,new Player("Guest",0,null));
                form3.setLocationRelativeTo(null);
                form3.setVisible(true);
            }
        });
    }

}
