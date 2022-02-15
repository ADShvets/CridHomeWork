package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestApi extends BaseTest{
    private static final String IMAGE_URL = "http://apimeme.com/meme?meme=Alarm-Clock&top=Top+text&bottom=Bottom+text";
    private static final String IMAGE_EXAMPLE = "src/main/java/resources/example.jpeg";


    @Test
    public void testOneApi() throws IOException {
        getCheckImageClass();
        Assert.assertEquals(getCheckImageClass().getFromExampleImage(IMAGE_EXAMPLE)
                , getCheckImageClass().getFromUrlImage(IMAGE_URL));
    }
}
