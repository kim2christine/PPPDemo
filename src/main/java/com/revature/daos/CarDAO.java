package com.revature.daos;

import com.revature.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;

//What is <Car, Integer> It means his DAO Interface deals with Car objects and the PK is an integer
public interface CarDAO extends JpaRepository<Car, Integer> {
}
