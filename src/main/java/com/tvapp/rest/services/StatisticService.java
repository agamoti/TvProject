package com.tvapp.rest.services;

import com.tvapp.enums.UserStatistics;
import dto.UserDto;
import java.util.Set;


/**
 * Created by agamoti on 22/05/2017.
 */
public interface StatisticService {

    void handleStatisticsAction(UserDto userDto, UserStatistics userStatistics);
    Set<String> getStatistic(String rKey);
}
