package pages;

import java.sql.*;

public class SqlTableClass {
    private Statement statement;

    {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:Countries.db");
            statement = connection.createStatement();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void getPrintTableTableCountries() throws SQLException {
        ResultSet rs = statement.executeQuery("SELECT * FROM Countries");
        while (rs.next()) {
            String country = rs.getString("country");
            int population = rs.getInt("population");
            int area = rs.getInt("area");
            System.out.printf("%s %d %d%n", country, population, area);
        }
    }

    public void getRemoveTableTableCountries() throws SQLException {
        statement.executeUpdate("DROP TABLE IF EXISTS Countries");
    }
//
    public void getCreateTableCountries() throws SQLException {
        statement.executeUpdate("CREATE TABLE Countries (country STRING, population INT(20), area INT(20))");
    }

    public void getAddingDataToTable() throws SQLException {
//        CountriesClass ukraine = new CountriesClass("Ukraine",41588354,603628);
//        save(ukraine,statement);
        statement.executeUpdate("INSERT INTO Countries (country, population, area) VALUES ('Ukraine', 41588354, 603628)");
        statement.executeUpdate("INSERT INTO Countries (country, population, area) VALUES ('France', 67399000, 640679)");
        statement.executeUpdate("INSERT INTO Countries (country, population, area) VALUES ('USA', 328239523, 9833520)");
        statement.executeUpdate("INSERT INTO Countries (country, population, area) VALUES ('China', 1400050000, 9596961)");
    }

//    public static void save(CountriesClass countries, Statement statement) throws SQLException {
//        String sql = "INSERT INTO Countries (country, population, area) VALUES ('%s', %d, %d)";
//        sql = String.format(sql, countries.getCountry(), countries.getPopulation(), countries.getArea());
//        statement.executeUpdate(sql);
//    }


    public void getMinPopulationDensity() throws SQLException {

        System.out.println(" ");
        ResultSet rs = statement.executeQuery("SELECT * FROM Countries");
        while (rs.next()) {
            String country = rs.getString("country");
            int population = rs.getInt("population");
            int area = rs.getInt("area");
            int density = population / area;
            if (density < 50) {
                System.out.println("Minimum population density: " + country + " " + density);
            }
        }
    }

    public int getPopulationDensityUsa() throws SQLException {
        int result = 0;

        ResultSet rs = statement.executeQuery("SELECT Country, (population/area) AS 'Result' from Countries WHERE Country like 'USA'");
        while (rs.next()) {
            result = rs.getInt("result");
//            System.out.println("Population density in the USA: " + result);
        }
        return result;
    }

    public boolean checkPopulationDensityUsa() throws SQLException {
        if (getPopulationDensityUsa()<50){
            return true;
        }
            return false;
    }

    public boolean checkPopulation() throws SQLException {
        if (populationGreaterThanOrLessThanTwoBillion() < 2000000000) {
            return true;
        }
        return false;
    }

    public int populationGreaterThanOrLessThanTwoBillion() throws SQLException {
        int population = 0;
        System.out.println(" ");
        ResultSet rs = statement.executeQuery("SELECT * FROM Countries");
        while (rs.next()) {
            population = rs.getInt("population");
//            count += population;
        }
//        if (count > 2000000000) {
//            System.out.println("Population of countries over 2000000000");
//        } else {
//            System.out.println("Population of countries less than 2000000000");
//        }
        return population;
    }
}