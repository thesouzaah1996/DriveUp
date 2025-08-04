package com.driveup.driveup.controller;

import com.driveup.driveup.dto.CarPostDTO;
import com.driveup.driveup.message.KafkaProducerMessage;
import com.driveup.driveup.service.CarPostStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/car")
public class CarPostController {

    @Autowired
    private CarPostStoreService carPostStoreService;

    @GetMapping("/posts")
    public ResponseEntity<List<CarPostDTO>> getCarSales() {
        return ResponseEntity.status(HttpStatus.FOUND).body(carPostStoreService.getCarsForSale());
    }

    @Autowired
    private KafkaProducerMessage kafkaProducerMessage;

    @PostMapping("/post")
    public ResponseEntity postCarForSale(@RequestBody CarPostDTO carPostDTO) {
        kafkaProducerMessage.sendMessage(carPostDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateCarSale(@RequestBody CarPostDTO carPostDTO, @PathVariable("id") String id) {
        carPostStoreService.updateCarForSale(carPostDTO, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCarForSale(@PathVariable("id") String id) {
        carPostStoreService.deleteCarForSale(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}























































































