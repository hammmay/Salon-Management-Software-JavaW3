import java.util.ArrayList;
import java.util.List;
import org.sql2o.*;

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
    String sql = "SELECT Id, name FROM clients";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Client.class);
    }
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
        String sql = "INSERT INTO clients(name) VALUES (:clientName)";
        this.clientId = (int) con.createQuery(sql, true)
          .addParameter("clientName", this.clientName)
          .executeUpdate()
          .getKey();
      }
    }

  //method to get a client's unique ID
  public int getClientId() {
    return clientId;
  }
  //method to find a client based on ID
  public static Client find(int clientId) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM clients where id=:clientId";
      Client client = con.createQuery(sql)
        .addParameter("clientId", clientId)
        .executeAndFetchFirst(Client.class);
      return client;
    }
  }

}
