package pondit;

public class MysqlDatabaseConnection implements  DatabaseConnectionInterface{
    /**
     *
     */
    @Override
    public void connect() {
        System.out.println("Connection MySQL Database...");
    }

    /**
     *
     */
    @Override
    public void query() {
        System.out.println("Querying To MySQL Database...");
    }

    /**
     *
     */
    @Override
    public void disconnect() {
        System.out.println("Disconnection From MySQL Database...");
    }
}
