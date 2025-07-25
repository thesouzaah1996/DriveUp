package com.driveup.driveup.service;

import com.driveup.driveup.dto.CarPostDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarPostStoreService {

    List<CarPostDTO> getCarsForSale();

    void updateCarForSale(CarPostDTO carPost, String id);

    void deleteCarForSale(String id);
}
