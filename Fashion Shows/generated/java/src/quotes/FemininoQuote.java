package quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class FemininoQuote {
  private static int hc = 0;
  private static FemininoQuote instance = null;

  public FemininoQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static FemininoQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new FemininoQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof FemininoQuote;
  }

  public String toString() {

    return "<Feminino>";
  }
}
