package com.movie.theater.service.mapper;

import com.movie.theater.DTO.request.MovieRequest;
import com.movie.theater.DTO.response.MovieResponse;
import com.movie.theater.model.entity.Movie;
import com.movie.theater.model.entity.Schedule;
import com.movie.theater.model.entity.ShowDates;
import com.movie.theater.model.entity.Type;
import com.movie.theater.repository.CinemaRoomRepository;
import com.movie.theater.service.ScheduleService;
import com.movie.theater.service.ShowDatesService;
import com.movie.theater.service.TypeService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class MovieMapper {
    private final CinemaRoomRepository cinemaRoomRepository;
    private final ScheduleService scheduleService;
    private final TypeService typeService;
    private final ShowDatesService showDatesService;


    public MovieMapper(CinemaRoomRepository cinemaRoomRepository, ScheduleService scheduleService, TypeService typeService, ShowDatesService showDatesService) {
        this.cinemaRoomRepository = cinemaRoomRepository;
        this.scheduleService = scheduleService;
        this.typeService = typeService;
        this.showDatesService = showDatesService;
    }


    public MovieResponse mapEntityToDto(Movie movieEntity) {
        MovieResponse result = new MovieResponse();
        result.setActor(movieEntity.getActor());
        result.setCinemaRoom(movieEntity.getCinemaRoom().getCinemaRoomName());
        result.setContent(movieEntity.getContent());
        result.setDirector(movieEntity.getDirector());
        result.setDuration(movieEntity.getDuration());
        result.setFromDate(movieEntity.getFromDate());
        result.setLargeImage(movieEntity.getLargeImage());
        result.setMovieNameEnglish(movieEntity.getMovieNameEnglish());
        result.setMovieNameVn(movieEntity.getMovieNameVn());
        result.setMovieProductionCompany(movieEntity.getMovieProductionCompany());
        result.setSmallImage(movieEntity.getSmallImage());
        result.setToDate(movieEntity.getToDate());
        result.setVersion(movieEntity.getVersion());

        List<ShowDates> showDates = new ArrayList<>();
        for (ShowDates item: movieEntity.getShowDates()
             ) {
            ShowDates showDates1 = new ShowDates();
            showDates1.setShowDate(item.getShowDate());
            showDates1.setDateName(item.getDateName());
            showDates.add(showDates1);
        }
        result.setShowDates(showDates);

        List<String> scheduleTimes = new ArrayList<>();
        for (Schedule item: movieEntity.getSchedules()
             ) {
            scheduleTimes.add(item.getScheduleTime());
        }
        result.setScheduleTimes(scheduleTimes);

        List<String> types = new ArrayList<>();
        for (Type item: movieEntity.getTypes()
             ) {
            types.add(item.getTypeName());
        }
        result.setTypes(types);
        return result;
    }

    public Movie mapDtoToEntity(MovieRequest movieRequest) {
        Movie result = new Movie();
        result.setActor(movieRequest.getActor());
        result.setCinemaRoom(cinemaRoomRepository.findByCinemaRoomId(movieRequest.getCinemaRoomId()));
        result.setContent(movieRequest.getContent());
        result.setDirector(movieRequest.getDirector());
        result.setDuration(movieRequest.getDuration());
        result.setFromDate(movieRequest.getFromDate());
        result.setLargeImage(movieRequest.getLargeImage());
        result.setMovieNameEnglish(movieRequest.getMovieNameEnglish());
        result.setMovieNameVn(movieRequest.getMovieNameVn());
        result.setMovieProductionCompany(movieRequest.getMovieProductionCompany());
        result.setSmallImage(movieRequest.getSmallImage());
        result.setToDate(movieRequest.getToDate());
        result.setVersion(movieRequest.getVersion());

        Set<ShowDates> showDatesList = new HashSet<>();
        showDatesService.saveFromMovieRequest(movieRequest).stream().forEach(
                showDateId -> {
                    showDatesList.add(showDatesService.findByShowDateId(showDateId));
                }
        );
        result.setShowDates(showDatesList);

        Set<Schedule> scheduleList = new HashSet<>();
        movieRequest.getScheduleIds().stream().forEach(
                scheduleId -> {
                    scheduleList.add(scheduleService.findOne(scheduleId));
                }
        );
        result.setSchedules(scheduleList);
        Set<Type> typeList = new HashSet<>();
        movieRequest.getTypeIds().stream().forEach(
                typeId -> {
                    typeList.add(typeService.findByTypeId(typeId));
                }
        );
        result.setTypes(typeList);
        return result;
    }

    public Movie mapDtoToEntity(Movie result,MovieRequest movieRequest) {
        result.setActor(movieRequest.getActor());
        result.setContent(movieRequest.getContent());
        result.setDirector(movieRequest.getDirector());
        result.setDuration(movieRequest.getDuration());
        result.setFromDate(movieRequest.getFromDate());
        result.setLargeImage(movieRequest.getLargeImage());
        result.setMovieNameEnglish(movieRequest.getMovieNameEnglish());
        result.setMovieNameVn(movieRequest.getMovieNameVn());
        result.setMovieProductionCompany(movieRequest.getMovieProductionCompany());
        result.setSmallImage(movieRequest.getSmallImage());
        result.setToDate(movieRequest.getToDate());
        result.setVersion(movieRequest.getVersion());

        Set<ShowDates> showDatesList = new HashSet<>();
        movieRequest.getShowDateIds().stream().forEach(
                showDateId -> {
                    showDatesList.add(showDatesService.findByShowDateId(showDateId));
                }
        );
        result.setShowDates(showDatesList);

        Set<Schedule> scheduleList = new HashSet<>();
        movieRequest.getScheduleIds().stream().forEach(
                scheduleId -> {
                    scheduleList.add(scheduleService.findOne(scheduleId));
                }
        );
        result.setSchedules(scheduleList);
        Set<Type> typeList = new HashSet<>();
        movieRequest.getTypeIds().stream().forEach(
                typeId -> {
                    typeList.add(typeService.findByTypeId(typeId));
                }
        );
        result.setTypes(typeList);
        return result;
    }
}
