
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class WorkShop {
  private String theme;
  private Fashion_Show.Date begin_date;
  private Fashion_Show.Date end_date;
  private Number lotation;
  private String orator;
  private VDMSet registered_users = SetUtil.set();
  private String room;

  public void cg_init_WorkShop_1(
      final String theme1,
      final Fashion_Show.Date begin_date1,
      final Fashion_Show.Date end_date1,
      final Number lotation1,
      final String orator1,
      final String room1) {

    theme = theme1;
    begin_date = Utils.copy(begin_date1);
    end_date = Utils.copy(end_date1);
    lotation = lotation1;
    orator = orator1;
    room = room1;
    return;
  }

  public WorkShop(
      final String theme1,
      final Fashion_Show.Date begin_date1,
      final Fashion_Show.Date end_date1,
      final Number lotation1,
      final String orator1,
      final String room1) {

    cg_init_WorkShop_1(
        theme1, Utils.copy(begin_date1), Utils.copy(end_date1), lotation1, orator1, room1);
  }

  public String getTheme() {

    return theme;
  }

  public Fashion_Show.Date getBeginDate() {

    return Utils.copy(begin_date);
  }

  public Fashion_Show.Date getEndDate() {

    return Utils.copy(end_date);
  }

  public Number getLotation() {

    return lotation;
  }

  public String getOrator() {

    return orator;
  }

  public String getRoom() {

    return room;
  }

  public VDMSet getUsers() {

    return Utils.copy(registered_users);
  }

  public void addUserToWorkshop(final Regular_User Regular_User) {

    registered_users = SetUtil.union(Utils.copy(registered_users), SetUtil.set(Regular_User));
    return;
  }

  public void rmvUserToWorkshop(final Regular_User Regular_User) {

    registered_users = SetUtil.diff(Utils.copy(registered_users), SetUtil.set(Regular_User));
    return;
  }

  public WorkShop() {}

  public String toString() {

    return "WorkShop{"
        + "theme := "
        + Utils.toString(theme)
        + ", begin_date := "
        + Utils.toString(begin_date)
        + ", end_date := "
        + Utils.toString(end_date)
        + ", lotation := "
        + Utils.toString(lotation)
        + ", orator := "
        + Utils.toString(orator)
        + ", registered_users := "
        + Utils.toString(registered_users)
        + ", room := "
        + Utils.toString(room)
        + "}";
  }
}
