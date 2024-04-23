import java.util.Objects;

public class Card {
  private String shape;
  private String colour;
  private String pattern;

  public Card(String newShape, String newColour, String newPattern){
    this.shape = newShape;
    this.colour = newColour;
    this.pattern = newPattern;
  }

  public boolean equals(Object obj){
    if (this==obj){
      return true;
    }
    if (obj== null || getClass() != obj.getClass()) {
      return false;
    }
    Card otherCard = (Card) obj;

    return Objects.equals(shape, otherCard.shape) &&
            Objects.equals(colour, otherCard.colour) && 
              Objects.equals(pattern, otherCard.pattern);
  }
}