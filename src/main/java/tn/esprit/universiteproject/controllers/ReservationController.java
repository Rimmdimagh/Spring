package tn.esprit.universiteproject.controllers;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.universiteproject.entities.Reservation;
import tn.esprit.universiteproject.service.IChambreService;
import tn.esprit.universiteproject.service.IReservationService;
import tn.esprit.universiteproject.service.ReservationService;

import java.util.Date;
import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("Reservation")
public class ReservationController {
    IReservationService reservationService;



    @PostMapping("/addReservation")
    public Reservation addReservation(@RequestBody Reservation reservation){
return reservationService.addReservation(reservation);
    }


    @GetMapping("/getReservationParAnneeUniversitaire/{date}")
    public List<Reservation>getReservationParAnneeUniversitaire(@PathVariable  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date){
return reservationService.getReservationParAnneeUniversitaire(date);
    }
}
