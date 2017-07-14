import java.util.ArrayList;
import java.util.List;

public class Client {
  private String clientName;
  private int clientId;

//method to instantiate client object
  public Client(String clientName) {
    this.clientName = clientName;
  }
//method to get name of client object
  public String getClientName() {
    return clientName;
  }
//method to get all names of all client objects added to the client table
  public static List<Client> all() {
    String sql = "SELECT id, client_name FROM client";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Client.class);
    }
  }
//method to get a client's unique ID
  public int getClientId() {
    return clientId;
  }
//method to find a client based on ID
  public static Client find(int clientId) {

  }

  @Override
  public boolean equals(Object otherClient) {
    if (!(otherClient instanceof Client)) {
      return false;
    } else {
      Client newClient = (Client) otherClient;
      return this.getClientName().equals(newClient.getClientName()) &&
        this.getClientId() == newClient.getClientId();
    }
  }

  public void save() {
      try(Connection con = DB.sql2o.open()) {
        String sql = "INSERT INTO clients(clientName) VALUES (:clientName)";
        this.clientID = (int) con.createQuery(sql, true)
          .addParameter("clientName", this.clientName)
          .executeUpdate();
          .getKey();
      }
    }

}
