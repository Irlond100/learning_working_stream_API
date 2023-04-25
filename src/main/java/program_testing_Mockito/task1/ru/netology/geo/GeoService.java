package program_testing_Mockito.task1.ru.netology.geo;

import program_testing_Mockito.task1.ru.netology.entity.Location;

public interface GeoService {

    Location byIp(String ip);

    Location byCoordinates(double latitude, double longitude);
}
