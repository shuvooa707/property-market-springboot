package pondit;

public class OracleDatabaseConnection implements DatabaseConnection {
    /**
     *
     */
    @Override
    public void connect() {
        System.out.println("Connection Oracle Database...");
    }

    /**
     *
     */
    @Override
    public void query() {
        System.out.println("Querying To Oracle Database...");
    }

    /**
     *
     */
    @Override
    public void disconnect() {
        System.out.println("Disconnection From Oracle Database...");
    }
}
