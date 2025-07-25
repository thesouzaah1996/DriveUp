package com.driveup.driveup.service;

import com.driveup.driveup.dto.OwnerPostDTO;
import org.springframework.stereotype.Service;

@Service
public interface OwnerPostService {
    void createOwnerCar(OwnerPostDTO ownerPostDTO);
}
