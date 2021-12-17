package com.movie.theater.service.impl;

import com.movie.theater.exception.AppException;
import com.movie.theater.model.common.ErrorCode;
import com.movie.theater.model.common.SeatStatus;
import com.movie.theater.model.entity.Seat;
import com.movie.theater.model.request.SeatRequest;
import com.movie.theater.model.response.SeatResponse;
import com.movie.theater.repository.ISeatRepository;
import com.movie.theater.service.ISeatService;
import com.movie.theater.service.mapper.SeatMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SeatServiceImpl implements ISeatService {
    @Autowired
    private ISeatRepository iSeatRepository;
    @Autowired
    private SeatMapper mapper;

    @Override
    public void creat(SeatRequest seatRequest) {
        if (iSeatRepository.findById(seatRequest.getSeatId()).isPresent()) {
            throw new AppException(ErrorCode.SEAT_ALREADY_EXISTS);
        } else {
            Seat seat = mapper.map(seatRequest);
            iSeatRepository.save(seat);
        }
    }

    @Override
    public SeatResponse read(SeatRequest seatRequest) {
        Optional<Seat> seat = iSeatRepository.findById(seatRequest.getSeatId());
        if ( seat.isPresent()) {
            SeatResponse seatResponse = mapper.map(seat.get());
            return seatResponse;
        } else {
            return null;
        }
    }

    @Override
    public void updateStatus(SeatRequest seatRequest) {
        Optional<Seat> seat = iSeatRepository.findById(seatRequest.getSeatId());
        if (seat.isPresent()) {
            Seat seat1 = seat.get();
            if (seatRequest.getSeatStatus() == 1) {
                seat1.setSeatStatus(1);
            } else {
                seat1.setSeatStatus(0);
            }
            iSeatRepository.save(seat1);
        } else if (seatRequest.getSeatColumn() != null && seatRequest.getSeatRow() != 0 && seatRequest.getCinemaRoomId() != 0) {
            List<Seat> list = iSeatRepository.findAll();
            for (Seat s : list) {
                if (seatRequest.getSeatColumn().equals(s.getSeatColumn()) && seatRequest.getSeatRow() == s.getSeatRow() && seatRequest.getCinemaRoomId() == s.getCinemaRoomId()) {
                    if (seatRequest.getSeatStatus() == 1) {
                        s.setSeatStatus(1);
                    } else {
                        s.setSeatStatus(0);
                    }
                    iSeatRepository.save(s);
                }
            }
        } else {
            System.out.println("Seat is not existence!");
        }
    }

    @Override
    public List<String> getAvailableSeat(int cinemaRoomId) {
        List<String> seatAvaiList = new ArrayList<>();
        List<Seat> seatlist = iSeatRepository.findAll();
        for (Seat seat : seatlist) {
            if (SeatStatus.AVAILABLE.compareValue(seat.getSeatStatus()) && seat.getCinemaRoomId() == cinemaRoomId) {
                seatAvaiList.add(seat.getSeatColumn() + Integer.toString(seat.getSeatRow()));
            }
        }
        return seatAvaiList;
    }

    @Override
    public List<SeatResponse> getAllSeatBooked(SeatRequest SeatRequest) {
        List<Seat> listSeat = iSeatRepository.findAll();
        return listSeat.stream().map(mapper::map).collect(Collectors.toList());
    }
}
