package sam.rus.service;

import sam.rus.CityDAO.CityFileDAO;
import sam.rus.model.City;
import sam.rus.model.NotCorrectData;

import java.util.*;

public class CityInformation {
    private CityFileDAO cityFileDAO;

    public CityInformation(CityFileDAO cityFileDAO) {
        this.cityFileDAO = cityFileDAO;
    }

    public void showAllCity() throws NotCorrectData {
        List<City> listCity = cityFileDAO.getListCity();
        listCity.forEach(System.out::println);
    }

    public void showAllCitySortByAlphavity() throws NotCorrectData {
        List<City> listCity = cityFileDAO.getListCity();
        Collections.sort(listCity,(obj1, obj2)->{
             return obj1.getName().compareToIgnoreCase(obj2.getName());
        });
        listCity.forEach(System.out::println);
    }

    public void  showAllCitySortByParamenter() throws NotCorrectData {
        List<City> listCity = cityFileDAO.getListCity();
        Collections.sort(listCity, (obj1, obj2) ->{
            int result = String.CASE_INSENSITIVE_ORDER.compare(obj1.getDistrict(), obj2.getDistrict());
            if (result == 0) {
                result = String.CASE_INSENSITIVE_ORDER.compare(obj1.getName(), obj2.getName());
            }
            return result;
        });
        listCity.forEach(System.out::println);
    }

    public void findCityMorePopulation() throws NotCorrectData {
        List<City> listCity = cityFileDAO.getListCity();
        City[] arrayCity = listCity.stream().toArray(City[]::new);
        int index = 0;
        long maxPopulation = arrayCity[index].getPopulation();
        for (int i = 0; i < arrayCity.length; i++) {
            if (arrayCity[i].getPopulation() > maxPopulation) {
                index = i;
                maxPopulation = arrayCity[i].getPopulation();
            }
        }
        System.out.printf("[ %d ] = %d\n", index, maxPopulation);
    }

    public void findCityByRegion() throws NotCorrectData {
        List<City> listCity = cityFileDAO.getListCity();
        Set<String> setRegion = new HashSet<>();

        listCity.forEach((item) -> {
            setRegion.add(item.getRegion());
        });

        Map<String, Integer> mapCountRegion = new TreeMap<>();

        setRegion.forEach((item) -> {
            mapCountRegion.put(item, 0);
        });

        listCity.forEach((item) -> {
            mapCountRegion.forEach((key, value) -> {
                if (item.getRegion().equals(key)) {
                    mapCountRegion.replace(key, value + 1);
                }
            });
        });

        mapCountRegion.forEach((key, value) -> {
            System.out.printf("%s - %d\n", key, value);
        });
    }
}
