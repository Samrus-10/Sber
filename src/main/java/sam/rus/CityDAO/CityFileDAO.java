package sam.rus.CityDAO;

import sam.rus.model.City;
import sam.rus.model.NotCorrectData;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CityFileDAO {
    private Path path;

    public CityFileDAO() {
        path = Paths.get("/Users/u19305165/Desktop/Задание/city.txt");
    }

    public CityFileDAO(String path) {
        this.path = Paths.get(path);
    }

    public List<City> getListCity() throws NotCorrectData {
        List<City> result = new ArrayList<>();
        try (
                Scanner scan = new Scanner(path);
        ) {
            while (scan.hasNext()) {
                String line = scan.nextLine();
                String[] split = line.split(";");
                validateElement(split);
                result.add(
                        new City(
                                split[1],
                                split[2],
                                split[3],
                                Long.parseLong(split[4]),
                                split[5]));
            }
            validateEmptyFile(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private void validateElement(String[] element) throws NotCorrectData {
        for (int i = 0; i < element.length; i++) {
            if (element[i].equals("")) {
                throw new NotCorrectData("File is not correct  created ");
            }
        }
    }

    private void validateEmptyFile(List<City> list) throws NotCorrectData {
        if(list.size() == 0)
            throw new NotCorrectData("File is empty");
    }

}
