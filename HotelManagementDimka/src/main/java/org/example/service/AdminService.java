package org.example.service;

import org.example.entity.Admin;
import org.example.repository.AdminRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    private final AdminRepo adminRepository;

    public AdminService(AdminRepo adminRepository) {
        this.adminRepository = adminRepository;
    }

    public Admin createAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    public Admin getAdminByUsername(String username) {
        return adminRepository.findByUsername(username);
    }

    public void deleteAdmin(Long id) {
        adminRepository.deleteById(id);
    }
}
