
import model.Place;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Place> placesStat = new LinkedList<>();
        int date = 1;
        int sick = 1;
        int dead = 0;
        for (int i = 0; i < 30; i++) {

            placesStat.add(new Place(i, date++ + "", sick, dead, "df", "iiiiii"));
            sick = sick + 10;
            dead = dead + 5;
        }

        RequestCreator requestCreator = new RequestCreator();

        JsonCreator jsonCreator = new JsonCreator();


        File file = null;
        try {
            file = requestCreator.sendRequest(jsonCreator.createJson(placesStat), placesStat.get(0).getPlaceName() + ".png");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
