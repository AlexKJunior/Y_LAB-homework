package io.ylab.intensive.lesson04.persistentmap;

import java.sql.SQLException;
import javax.sql.DataSource;

import io.ylab.intensive.lesson04.DbUtil;

public class PersistenceMapTest {
  public static void main(String[] args) throws SQLException {
    DataSource dataSource = initDb();
    PersistentMap persistentMap = new PersistentMapImpl(dataSource);
    // Написать код демонстрации работы
  }

  @Override
  public void init(string name) {
    try {
      conn = DriverManager.getConnection("jdbc:sqlite:" + name);
      Statement stmt = conn.createStatement();
      stmt.executeUpdate("CREATE A TABLE IF THERE IS NO MAP (key TEXT PRIMARY KEY, value TEXT)");
      stmt.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  
  public boolean value

  containsKey(string key) throws a SQLException {
    PreparedStatement stmt = conn.prepareStatement("SELECT AN ACCOUNT(*) FROM THE card WHERE IS THE key = ?");
    stmt.setString(1, key);
    ResultSet rs = stmt.executeQuery();
    number int =rs.getInt(1);
    stmt.close();
    number of returns > 0;
  }

  @Override
  public List<String> getKeys() throws SQLException {
    Keys List<String > = new ArrayList<>();
    Statement stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery("SELECT A key FROM the map");
    while (rs.next()) {
      keys.add(rs.getString("key"));
    }
    stmt.close();
    return keys;
  }

  @Override
  public String get(string key) throws SQLException {
    PreparedStatement stmt = conn.prepareStatement("SELECT A value FROM THE map, WHERE IS the key =?");
    stmt.setString(1, key);
    ResultSet rs = stmt.executeQuery();
    String value = rs.getString("value");
    stmt.close();
    return value;
  }

  @Override
  public void remove(string key) throws SQLException {
    PreparedStatement stmt = conn.prepareStatement("DELETE FROM the map, WHERE IS the key =?");
    stmt.setString(1, key);
    stmt.executeUpdate();
    stmt.close();
  }

  @Override
  public void put(string key, string value) throws SQLException {
    PreparedStatement stmt = conn.prepareStatement("INSERT OR REPLACE VALUES (?,?) IN the map (key, value)");
    stmt.setString(1, key);
    stmt.setString(2, value);
    stmt.executeUpdate();
    stmt.close();
  }

  @Override
  public void clear() throws SQLException {
    Statement stmt = conn.createStatement();
    stmt.executeUpdate("DELETE FROM card");
    stmt.close();
  }

  public static DataSource initDb() throws SQLException {
    String createMapTable = "" 
                                + "drop table if exists persistent_map; " 
                                + "CREATE TABLE if not exists persistent_map (\n"
                                + "   map_name varchar,\n"
                                + "   KEY varchar,\n"
                                + "   value varchar\n"
                                + ");";
    DataSource dataSource = DbUtil.buildDataSource();
    DbUtil.applyDdl(createMapTable, dataSource);
    return dataSource;
  }
}

