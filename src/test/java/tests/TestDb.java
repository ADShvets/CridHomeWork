package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLException;

public class TestDb extends BaseTest{
    @Test
    public void testTwoDb() throws SQLException {
        getSqlTableClass();
        getSqlTableClass().getRemoveTableTableCountries();
        getSqlTableClass().getCreateTableCountries();
        getSqlTableClass().getAddingDataToTable();
        getSqlTableClass().getPrintTableTableCountries();
        getSqlTableClass().getMinPopulationDensity();
        Assert.assertTrue(getSqlTableClass().checkPopulationDensityUsa());
        Assert.assertTrue(getSqlTableClass().checkPopulation());

    }
}
