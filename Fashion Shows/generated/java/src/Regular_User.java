
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Regular_User extends User {
  private VDMSet favorite_looks = SetUtil.set();
  private Boolean premium_user = false;
  private Boolean admin = false;

  public void cg_init_Regular_User_1(
      final String name1,
      final Object gender1,
      final String email1,
      final String password1,
      final Boolean premium_user1,
      final Boolean admin1) {

    name = name1;
    gender = gender1;
    email = email1;
    password = password1;
    premium_user = premium_user1;
    admin = admin1;
    return;
  }

  public Regular_User(
      final String name1,
      final Object gender1,
      final String email1,
      final String password1,
      final Boolean premium_user1,
      final Boolean admin1) {

    cg_init_Regular_User_1(name1, gender1, email1, password1, premium_user1, admin1);
  }

  public Boolean isAdmin() {

    return admin;
  }

  public Boolean getPremium() {

    return premium_user;
  }

  public VDMSet getFavoriteLooks() {

    return Utils.copy(favorite_looks);
  }

  public void addLookToFavoriteLooks(final Model_Look look) {

    favorite_looks = SetUtil.union(Utils.copy(favorite_looks), SetUtil.set(look));
  }

  public void removeLookFromFavoriteLooks(final Model_Look look) {

    favorite_looks = SetUtil.diff(Utils.copy(favorite_looks), SetUtil.set(look));
  }

  public Regular_User() {}

  public String toString() {

    return "Regular_User{"
        + "favorite_looks := "
        + Utils.toString(favorite_looks)
        + ", premium_user := "
        + Utils.toString(premium_user)
        + ", admin := "
        + Utils.toString(admin)
        + "}";
  }
}
