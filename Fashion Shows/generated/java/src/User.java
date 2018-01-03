
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class User {
  protected String name = "Default_Name";
  protected Object gender = quotes.MasculinoQuote.getInstance();
  protected String email = "";
  protected String password = "";

  public String getName() {

    return name;
  }

  public Object getGender() {

    return gender;
  }

  public String getEmail() {

    return email;
  }

  public String getPassword() {

    return password;
  }

  public User() {}

  public String toString() {

    return "User{"
        + "name := "
        + Utils.toString(name)
        + ", gender := "
        + Utils.toString(gender)
        + ", email := "
        + Utils.toString(email)
        + ", password := "
        + Utils.toString(password)
        + "}";
  }
}
