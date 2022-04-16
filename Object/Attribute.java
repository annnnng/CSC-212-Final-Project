import java.util.*;
/**
 * Atrribute represents the way user can interact with game object
 *
 *  @author  Nicholas R. Howe
 *  @version CSC 212, October 2021
 */
public enum Attribute {
  HASLIGHT (false, new String[]{"on", "off"});

  /** Can the user pick up this item */
  public final boolean isStatic;

  /** How to display the square */
  public final String[] command;

  /** Constructor */
  private Attribute(boolean isStatic, String[] command) {
		this.isStatic = isStatic;
		this.command = command;
  }
}