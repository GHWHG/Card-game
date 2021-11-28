import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class existingPlayerForm extends JFrame{
    private JPanel mainPanel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton OKButton;
    private JButton cancelButton;


    public existingPlayerForm(ArrayList<Player> playerData) {

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();


        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Boolean usernameMatch = false;
                Boolean passwordMatch = false;

                for (Player currentPlayer:playerData){
                    if (currentPlayer.getUserName().equals(usernameField.getText())){
                        usernameMatch = true;
                        if(currentPlayer.getPassword().equals(new String(passwordField.getPassword()))){
                            passwordMatch = true;
                            closeForm();
                            gameScreenForm form3 = new gameScreenForm(playerData,currentPlayer);
                            form3.setLocationRelativeTo(null);
                            form3.setVisible(true);
                        }
                    }
                }
                if (!usernameMatch){
                    JOptionPane.showMessageDialog(null, "Username does not exist");
                }
                else if (usernameMatch && !passwordMatch){
                    JOptionPane.showMessageDialog(null, "Incorrect password");
                }
            }
        });


        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeForm();
            }
        });
    }

    private void closeForm(){
        this.setVisible(false);
    }
}
