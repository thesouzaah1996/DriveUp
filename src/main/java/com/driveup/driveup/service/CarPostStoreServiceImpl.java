package com.driveup.driveup.service;

import com.driveup.driveup.client.CarPostStoreClient;
import com.driveup.driveup.dto.CarPostDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarPostStoreServiceImpl implements CarPostStoreService {

    @Autowired
    private CarPostStoreClient carPostStoreClient;

    @Override
    public List<CarPostDTO> getCarsForSale() {
        return carPostStoreClient.carForSaleClient();
    }

    @Override
    public void updateCarForSale(CarPostDTO carPost, String id) {
        carPostStoreClient.changeCarForSaleClient(carPost, id);
    }

    @Override
    public void deleteCarForSale(String id) {
        carPostStoreClient.deleteCarForSaleClient(id);
    }
}
