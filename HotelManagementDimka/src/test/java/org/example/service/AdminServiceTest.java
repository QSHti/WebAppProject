package org.example.service;

import org.example.entity.Admin;
import org.example.repository.AdminRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class AdminServiceTest {

    @Mock
    private AdminRepo adminRepository;

    @InjectMocks
    private AdminService adminService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createAdmin() {
        Admin admin = new Admin("adminUser", "adminPass");
        when(adminRepository.save(any(Admin.class))).thenReturn(admin);

        Admin savedAdmin = adminService.createAdmin(admin);

        assertNotNull(savedAdmin);
        assertEquals("adminUser", savedAdmin.getUsername());
        verify(adminRepository).save(admin);
    }

    @Test
    void getAdminByUsername() {
        String username = "adminUser";
        Admin admin = new Admin(username, "adminPass");
        when(adminRepository.findByUsername(username)).thenReturn(admin);

        Admin foundAdmin = adminService.getAdminByUsername(username);

        assertNotNull(foundAdmin);
        assertEquals(username, foundAdmin.getUsername());
    }

    @Test
    void deleteAdmin() {
        Long adminId = 1L;
        doNothing().when(adminRepository).deleteById(adminId);

        adminService.deleteAdmin(adminId);

        verify(adminRepository).deleteById(adminId);
    }
}
