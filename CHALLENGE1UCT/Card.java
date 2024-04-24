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
    if (this == obj) {
        return true;  // Check if it's the same object
    }
    if (!(obj instanceof Card)) {
        return false;  // Check if obj is null or belongs to a different class
    }
    Card otherCard = (Card) obj;  // Cast obj to Card

    // Compare attributes using Objects.equals() method
    return Objects.equals(shape, otherCard.shape) &&
            Objects.equals(colour, otherCard.colour) && 
            Objects.equals(pattern, otherCard.pattern);
  }

}