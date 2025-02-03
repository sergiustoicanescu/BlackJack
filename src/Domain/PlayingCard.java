package Domain;

public class PlayingCard
{
    final private PlayingCardValue playingCardValue;
    final private PlayingCardTypes playingCardTypes;
    public PlayingCard(PlayingCardTypes _playingCardTypes, PlayingCardValue _playingCardValue)
    {
        playingCardTypes = _playingCardTypes;
        playingCardValue = _playingCardValue;
    }

    @Override
    public String toString()
    {
        return playingCardValue.toString() + " of " + playingCardTypes.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlayingCard that = (PlayingCard) o;

        if (playingCardValue != that.playingCardValue) return false;
        return playingCardTypes == that.playingCardTypes;
    }

    @Override
    public int hashCode() {
        int result = playingCardValue != null ? playingCardValue.hashCode() : 0;
        result = 31 * result + (playingCardTypes != null ? playingCardTypes.hashCode() : 0);
        return result;
    }
    public int getValue()
    {
        return playingCardValue.getValue();
    }
    public PlayingCardValue getFaceValue()
    {
        return playingCardValue;
    }
}
