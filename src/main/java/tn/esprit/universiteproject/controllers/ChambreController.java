package tn.esprit.universiteproject.controllers;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.universiteproject.entities.Bloc;
import tn.esprit.universiteproject.entities.Chambre;
import tn.esprit.universiteproject.service.ChambreService;
import tn.esprit.universiteproject.service.IChambreService;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("Chambre")
public class ChambreController {





}
