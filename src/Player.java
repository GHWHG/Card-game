public class Player {
    private String userName;
    private int highScore;
    private String password;

    public Player(String userName, int highScore, String password) {
        this.userName = userName;
        this.highScore = highScore;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getHighScore() {
        return highScore;
    }

    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return getUserName()+","+getHighScore()+","+getPassword();
    }
}
