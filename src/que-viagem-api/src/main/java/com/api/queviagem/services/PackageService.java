package com.api.queviagem.services;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.api.queviagem.models.PackageModel;
import com.api.queviagem.repositories.PackageRepository;

@Service
public class PackageService {
    final PackageRepository packageRepository;

    public PackageService(PackageRepository packageRepository) {
        this.packageRepository = packageRepository;
    }
    
    public List<PackageModel> getFinishedPackages(LocalDate initialDate, LocalDate finalDate) {
        return packageRepository.getFinishedPackages(initialDate, finalDate);
    }

    public Optional<PackageModel> findById(int id) {
        return packageRepository.getPackageById(id);
    }
}
