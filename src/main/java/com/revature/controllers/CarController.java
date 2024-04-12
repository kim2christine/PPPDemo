package com.revature.controllers;


import com.revature.daos.CarDAO;
import com.revature.models.Car;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController //This makes a Class a bean, and also converts request data into JSON automatically
@RequestMapping("/cars")//Any HTTP requests sent to the app ending in /cars will go to this controller
@ResponseBody //This turns any response data into JSON automatically


public class CarController {
    //also, we're skipping the service layer for now...see P1 demo

    //We can't instantiate CarDAO... it's an Interface (can't be instantiated)
    //So we need to use Spring's dependency injection to get an instance of CarDAO


    private CarDAO carDAO;
    //we need to inject the CarDAO bean into this Controller
    //We need to build a constructor
    public CarController(CarDAO carDAO){
        this.carDAO = carDAO;
    }

    @PostMapping()//this method is set to handle POST requests ending in /car

    //this method will insert a car into the database
    public ResponseEntity<Car> addCar(@RequestBody Car car){
        return ResponseEntity.ok(carDAO.save(car));
    }
}
