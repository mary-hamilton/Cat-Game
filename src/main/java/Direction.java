public enum Direction {
  NORTH("north"),
  EAST("east"),
  SOUTH("south"),

  WEST("west");


  private String properName;

  Direction(String properName) {
    this.properName = properName;
  }

  public String toString() {
    return properName;
  }
}