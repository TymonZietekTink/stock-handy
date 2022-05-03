package tymonzietek.stockhandyweb.config;


public class FakeDataConfig {
  private String username;
  private String jdbcUrl;

  public FakeDataConfig(String username, String jdbcUrl) {
    this.username = username;
    this.jdbcUrl = jdbcUrl;
  }
}
