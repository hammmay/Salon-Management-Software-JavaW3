import java.util.ArrayList;
import java.util.List;
import org.sql2o.*;

public class Client {
  private String name;
  private int id;
  private int stylistId;

//method to instantiate client object
  public Client(String name, int stylistId) {
    this.name = name;
    this.stylistId = stylistId;
  }
//method to get name of client object
  public String getName() {
    return name;
  }
//method to get all names of all client objects added to the client table
  public static List<Client> all() {
    String sql = "SELECT id, name, stylistId FROM clients";
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
      return this.getName().equals(newClient.getName()) &&
        this.getId() == newClient.getId() &&
        this.getStylistId() == newClient.getStylistId();
    }
  }

  public void save() {
      try(Connection con = DB.sql2o.open()) {
        String sql = "INSERT INTO clients(name, stylistId) VALUES (:name, :stylistId);";
        this.id = (int) con.createQuery(sql, true)
          .addParameter("name", this.name)
          .addParameter("stylistId", this.stylistId)
          .executeUpdate()
          .getKey();
      }
    }

  //method to get a client's unique ID
  public int getId() {
    return id;
  }
  //method to find a client based on ID
  public static Client find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM clients where id=:id";
      Client client = con.createQuery(sql)
        .addParameter("id", id)
        .executeAndFetchFirst(Client.class);
      return client;
    }
  }

  public int getStylistId() {
    return stylistId;
  }

}
