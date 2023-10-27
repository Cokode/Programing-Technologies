package secondWeek.interfaces;

import secondWeek.RealEstate;

public interface PropertyInterface {
      void discount(int percentage);
      long totalPrice ();
      int average ();
      int compareTo(RealEstate o);
}
