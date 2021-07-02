package sam.rus.service;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import sam.rus.CityDAO.CityFileDAO;
import sam.rus.model.NotCorrectData;

public class CityInformationTest {
    private static CityInformation cityInformation;
    @BeforeClass
    public static void init() {
        cityInformation = new CityInformation(new CityFileDAO("/Users/u19305165/Desktop/Задание/moreCity.txt"));
        //cityInformation = new CityInformation(new CityFileDAO("/Users/u19305165/Desktop/Задание/empty.txt"));
        //cityInformation = new CityInformation(new CityFileDAO("/Users/u19305165/Desktop/Задание/notCorrectFile.txt"));
        //cityInformation = new CityInformation(new CityFileDAO());
    }

    @Before
    public void before(){
        System.out.println("===========================================================================");
    }

    @After
    public void after() {
        System.out.println("===========================================================================");
    }

    @Test
    public void showAll() throws NotCorrectData {
        cityInformation.showAllCity();
    }

    @Test
    public void showllAllSortByAlpha() throws NotCorrectData {
        cityInformation.showAllCitySortByAlphavity();
    }

    @Test
    public void showAllSortByParameter() throws NotCorrectData {
        cityInformation.showAllCitySortByParamenter();
    }

    @Test
    public void findCityMorePopulation() throws NotCorrectData {
        cityInformation.findCityMorePopulation();
    }

    @Test
    public void countPopulation() throws NotCorrectData {
        cityInformation.findCityByRegion();
    }

    @Test(expected = NotCorrectData.class)
    public void emptyFile() throws NotCorrectData {
        cityInformation.showAllCity();
    }

    @Test(expected = NotCorrectData.class)
    public void notCorrectPutFile() throws NotCorrectData {
        cityInformation.showAllCity();
    }
}
