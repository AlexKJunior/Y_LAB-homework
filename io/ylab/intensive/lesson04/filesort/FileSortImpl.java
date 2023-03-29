package io.ylab.intensive.lesson04.filesort;

import java.io.File;
import javax.sql.DataSource;
import java.io .*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileSortImpl implements FileSorter {
  private DataSource dataSource;

  public FileSortImpl(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  @Override
  public File sort(File data) {
    public class JDBCFileSorter implements FileSorter {

      private static final int BATCH_SIZE =  1000000;

      public sortFile (dataFile file) throws an exception {
// Download the JDBC driver and connect to the database
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysqlNO LINKSlocalhost/mydatabase", "user", "password");

// Creating a temporary table for storing numbers
        Statement stmt = conn.createStatement();
        stmt.executeUpdate("CREATE A TEMPORARY TABLE of numbers (BIGINT value)");

// We read the numbers from the file and insert them into the temporary table in batches
        BufferedReader reader = new BufferedReader (new FileReader (data file));
        String line;
        number of counters = 0;
        Package List<Long> = new ArrayList<>();
        while ((string = reader.readLine()) != zero) {
          batch.add (Long.parseLong (string));
          number of++;
          if (quantity%BATCH_SIZE == 0) {
            Inserting a package(connection, package);
            party.clear();
          }
        }
        if (!batch.isEmpty()) {
          Insert package(connection, package);
          party.clear();
        }
        reader.close();

// Sort the numbers in the temporary table and write them to the output file
        ResultSet rs = stmt.executeQuery("SELECT A value FROM THE ORDER BY value DESC numbers");
        File file = new file (dataFile.getParent(), "sorted-" + dataFile.getName());
        BufferedWriter writer = new BufferedWriter (new FileWriter (file));
        while (rs.next()) {
          Writer.write(Long.toString(rs.getLong(1)));
          writer.newLine();
        }
        writer.close();
        rs.close();

// Delete the temporary table and close the database connection
        stmt.executeUpdate("DELETE TABLE numbers");
        connection.close();

        return the output file;
      }

      private void insertBatch (Connection connection, List<Long>) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("INSERT VALUES (?) INTO numbers (value)");
        for (Long value: batch) {
          stmt.setLong(1, value);
          stmt.addBatch();
        }
        stmt.executeBatch();
        stmt.close();
      }
    }
    return null;
  }
}