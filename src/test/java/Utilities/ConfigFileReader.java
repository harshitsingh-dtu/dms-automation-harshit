package Utilities;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

@Slf4j
@Data
public class ConfigFileReader extends PageObject {

    File configFile = new File("serenity.conf");
    Properties prop = new Properties();
    public String readConfigFile(String data) throws IOException {
        java.io.FileReader reader = new java.io.FileReader(configFile);
        prop.load(reader);
        return prop.getProperty(data);
    }
    public String getDataFromConfigFile(String data){
        EnvironmentVariables objEnvVar1 = SystemEnvironmentVariables.createEnvironmentVariables();
        String value= EnvironmentSpecificConfiguration.from(objEnvVar1).getProperty(data);
        return value;
    }
        public ResultSet connectDatabase(String database, String statement,String condition) {
        try {
            ConfigFileReader configFileReader=new ConfigFileReader();
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(configFileReader.getDataFromConfigFile("db.url").concat(database),configFileReader.getDataFromConfigFile("db.user") ,configFileReader.getDataFromConfigFile("db.password"));
            log.info("--------------connected------------------------------------------"+connection);
//            System.out.println("connection with postgresql: " + connection);
            PreparedStatement stmt = connection.prepareStatement(statement);
            stmt.setString(1,condition);
            ResultSet rs=stmt.executeQuery();
            return rs;
//            ResultSet rs = stmt.executeQuery();
//
//            while (rs.next()) {
//
//                String strOrgDesc = rs.getString("email_id");
//                System.out.println(strOrgDesc);
//
//            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
