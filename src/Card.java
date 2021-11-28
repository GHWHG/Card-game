public class Card {
    private String suite;
    private int rank;

    public Card(String suite, int rank) {
        this.suite = suite;
        this.rank = rank;
    }

    public String getSuite() {
        return suite;
    }

    public int getRank() {
        return rank;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        if (getRank()==1){
            return "Ace" + " of " + getSuite();
        }
        else if (getRank()==11){
            return "Jack" + " of " + getSuite();
        }
        else if (getRank()==12){
            return "Queen" + " of " + getSuite();
        }
        else if (getRank()==13){
            return "King" + " of " + getSuite();
        }
        else{
            return getRank() + " of " + getSuite();
        }
    }
}
