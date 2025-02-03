package Domain;

public interface OutputDevice {
    void setPlayerCard(PlayingCard card);
    void setDealerCard(PlayingCard card);
    void reshuffleMessage();
}
