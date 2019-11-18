package tddmicroexercises.textconvertor;

import org.apache.commons.lang3.StringEscapeUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;

public class UnicodeFileToHtmlTextConverterTest
{

    @Test
    public void testConvert(){
        Assert.assertEquals(3, 1+2);
    }

    @Test
    public void should_convert_empersand() throws IOException {

        //Arrange
        UnicodeFileToHtmlTextConverter convert = new UnicodeFileToHtmlTextConverter(new StringReader("H&M"));

        //Act


        //Assert
        Assert.assertEquals("H&amp;M<br />", convert.convertToHtml());
    }
}
