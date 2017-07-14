import java.util.ArrayList;
import java.util.List;

public class Stylist {
  private String mNameOfStylist;
  private static List<Stylist> instancesOfStylist = new ArrayList<Stylist>();
  private int mStylistId;
  private List<Client> mClients;

  public Stylist(String nameOfStylist) {
    mNameOfStylist = nameOfStylist;
    instancesOfStylist.add(this);
    mStylistId = instancesOfStylist.size();
    mClients = new ArrayList<Client>();
  }

  public String getStylistName() {
    return mNameOfStylist;
  }

  public static List<Stylist> all() {
    return instancesOfStylist;
  }
//method to clear stylist array
  public static void clear() {
    instancesOfStylist.clear();
  }
//method to get a stylist's unique ID
  public int getStylistId() {
    return mStylistId;
  }
//method to find a stylist based on ID
  public static Stylist find(int stylistId) {
    return instancesOfStylist.get(stylistId - 1);
  }
//method to check a stylist instantiates and returns a clients list
  public List<Client> getClients() {
    return mClients;
  }
//method to place clients into stylists
  public void addClient(Client client) {
    mClients.add(client);
  }



}
