package mysql;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;
import java.sql.*;
import java.sql.SQLExcepion;



public class DataBase{
    Connection conn = null;
    Statement stmt = null;
    ResultSet resultSet = null;
    WebDriver driver;
    
    // xxx.xxx.xxx.xxx is IP of mySQL.
    String dataBaseUrl = "jdbc:mysql://xxx.xxx.xxx.xxx";  
    String dataBaseUserName = "username";
    String dataBasePassword = " password";
    public PreparedStatement preparedStatement;

    @BeforeTest
    public void SetUpConnection() throws SQLException, ClassNotFoundException {



        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        
        // DATABASE CONNECTION
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(dataBaseUrl, dataBaseUserName, dataBasePassword);

    }

    @Test
    public void DeleteBasket() {

            // Execute a query
            try {
                String query = "DELETE FROM you.`sadness`";
                preparedStatement = conn.prepareStatement(query);
                preparedStatement.executeUpdate();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }
    @Test
    public void DeleteCampaign() {

            // Execute a query
            try {
                String query = "DELETE FROM you.`sadness`";
                preparedStatement = conn.prepareStatement(query);
                preparedStatement.executeUpdate();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }


    @AfterTest
    public void CloseTheConnection(){

        // Code to close each and all Object related to Database connection
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (Exception e) {
            }
        }

        if (stmt != null) {
            try {
                stmt.close();
            } catch (Exception e) {
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (Exception e) {
            }
        }

        driver.quit();
    }

}
