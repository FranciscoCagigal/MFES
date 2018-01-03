
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class App {
  public VDMSet users = SetUtil.set();
  public VDMSet shows = SetUtil.set();

  public void cg_init_App_1() {

    return;
  }

  public App() {

    cg_init_App_1();
  }

  public VDMSet getUsers() {

    return Utils.copy(users);
  }

  public VDMSet getShows() {

    return Utils.copy(shows);
  }

  public void addUserToApp(final Regular_User User) {

    users = SetUtil.union(Utils.copy(users), SetUtil.set(User));
    return;
  }

  public void rmvUserToApp(final Regular_User User) {

    users = SetUtil.diff(Utils.copy(users), SetUtil.set(User));
    return;
  }

  public void addShowToApp(final Fashion_Show Fashion_Show) {

    shows = SetUtil.union(Utils.copy(shows), SetUtil.set(Fashion_Show));
    return;
  }

  public void rmvShowToApp(final Fashion_Show Fashion_Show) {

    shows = SetUtil.diff(Utils.copy(shows), SetUtil.set(Fashion_Show));
    return;
  }

  public VDMSet getShowsByTheme(final String theme) {

    VDMSet return_value = SetUtil.set();
    for (Iterator iterator_1 = shows.iterator(); iterator_1.hasNext(); ) {
      Fashion_Show show = (Fashion_Show) iterator_1.next();
      if (Utils.equals(show.getTheme(), theme)) {
        return_value = SetUtil.union(Utils.copy(return_value), SetUtil.set(show));
      }
    }
    return Utils.copy(return_value);
  }

  public VDMSeq getShowsByDate() {

    VDMSeq return_value = SeqUtil.seq();
    Fashion_Show aux_show = null;
    for (Iterator iterator_2 = shows.iterator(); iterator_2.hasNext(); ) {
      Fashion_Show show = (Fashion_Show) iterator_2.next();
      for (Iterator iterator_3 = shows.iterator(); iterator_3.hasNext(); ) {
        Fashion_Show show2 = (Fashion_Show) iterator_3.next();
        Boolean andResult_1 = false;

        Boolean orResult_1 = false;

        if (Utils.equals(aux_show, null)) {
          orResult_1 = true;
        } else {
          orResult_1 = compareDates(show2.getDate(), aux_show.getDate());
        }

        if (orResult_1) {
          if (!(SetUtil.inSet(show2, SeqUtil.elems(Utils.copy(return_value))))) {
            andResult_1 = true;
          }
        }

        if (andResult_1) {
          aux_show = show2;
        }
      }
      return_value = SeqUtil.conc(Utils.copy(return_value), SeqUtil.seq(aux_show));
      aux_show = null;
    }
    return Utils.copy(return_value);
  }

  public static Boolean compareDates(final Fashion_Show.Date date1, final Fashion_Show.Date date2) {

    if (date1.year.longValue() < date2.year.longValue()) {
      return true;

    } else {
      if (date1.year.longValue() > date2.year.longValue()) {
        return false;

      } else {
        if (date1.month.longValue() < date2.month.longValue()) {
          return true;

        } else {
          if (date1.month.longValue() > date2.month.longValue()) {
            return false;

          } else {
            if (date1.day.longValue() < date2.day.longValue()) {
              return true;

            } else {
              if (date1.day.longValue() > date2.day.longValue()) {
                return false;

              } else {
                if (date1.hour.longValue() < date2.hour.longValue()) {
                  return true;

                } else {
                  if (date1.hour.longValue() > date2.hour.longValue()) {
                    return false;

                  } else {
                    if (date1.minute.longValue() < date2.minute.longValue()) {
                      return true;

                    } else {
                      if (date1.minute.longValue() > date2.minute.longValue()) {
                        return false;

                      } else {
                        return true;
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }

  public String toString() {

    return "App{"
        + "users := "
        + Utils.toString(users)
        + ", shows := "
        + Utils.toString(shows)
        + "}";
  }
}
