import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class newPlayerForm extends JFrame{
    private JPanel mainPanel;
    private JTextField userNameField;
    private JButton OKButton;
    private JButton cancelButton;
    private JPasswordField passwordField;
    private JTextPane passwordMustBeAtTextPane;


    public newPlayerForm(ArrayList<Player> playerData){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeForm();
            }
        });

        OKButton.addActionListener(new ActionListener() {
            Boolean uniqueUser = true;
            Boolean numberIncluded = false;
            Boolean upperCaseIncluded = false;
            Boolean specialCharIncluded = false;
            String specialCharString = "%?@*";

            @Override
            public void actionPerformed(ActionEvent e) {
                for (Player currentPlayer : playerData){
                    if(currentPlayer.getUserName().equals(userNameField.getText())){
                        uniqueUser=false;
                    }
                }
                if (uniqueUser){
                    if (passwordField.getPassword().length>=8){
                        for (char s:passwordField.getPassword()){
                            if(Character.isDigit(s)){
                                numberIncluded = true;
                            }
                            if(Character.isUpperCase(s)){
                                upperCaseIncluded = true;
                            }
                            if(specialCharString.contains(Character.toString(s))){
                                specialCharIncluded = true;
                            }
                        }
                        if (numberIncluded||upperCaseIncluded||specialCharIncluded){
                            playerData.add(new Player(
                                    userNameField.getText(), 0,new String(passwordField.getPassword())));
                            gameScreenForm form3 = new gameScreenForm(playerData,new Player(userNameField.getText(),
                                    0,new String(passwordField.getPassword())));
                            form3.setLocationRelativeTo(null);
                            JOptionPane.showMessageDialog(null, "Player added");
                            closeForm();
                            form3.setVisible(true);
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Invalid password");
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Invalid password");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Username already exists");
                }

                uniqueUser=true;
                numberIncluded = false;
                upperCaseIncluded = false;
                specialCharIncluded = false;

            }
        });
    }

    private void closeForm(){
        this.setVisible(false);
    }


}
