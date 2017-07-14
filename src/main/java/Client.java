import java.util.ArrayList;
import java.util.List;

public class Client {
  private String mClientName;
  private static List<Client> instancesOfClients = new ArrayList<Client>();
  private int mClientId;
//method to instantiate client object
  public Client(String clientName) {
    mClientName = clientName;
    instancesOfClients.add(this);
    mClientId = instancesOfClients.size();
  }
//method to get name of client object
  public String getClientName() {
    return mClientName;
  }
//method to get all names of all client objects added to the client array
  public static List<Client> all() {
    return instancesOfClients;
  }
//method to clear client array
  public static void clear() {
    instancesOfClients.clear();
  }
//method to get a client's unique ID
  public int getClientId() {
    return mClientId;
  }
//method to find a client based on ID
  public static Client find(int clientId) {
    return instancesOfClients.get(clientId - 1);
  }

}
