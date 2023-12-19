package org.example.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.example.entity.Admin;
import org.example.repository.AdminRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {AdminService.class})
@ExtendWith(SpringExtension.class)
class AdminServiceDiffblueTest {
    @MockBean
    private AdminRepo adminRepo;

    @Autowired
    private AdminService adminService;

    /**
     * Method under test: {@link AdminService#createAdmin(Admin)}
     */
    @Test
    void testCreateAdmin() {
        Admin admin = new Admin("janedoe", "iloveyou");

        when(adminRepo.save(Mockito.<Admin>any())).thenReturn(admin);
        Admin actualCreateAdminResult = adminService.createAdmin(new Admin("janedoe", "iloveyou"));
        verify(adminRepo).save(Mockito.<Admin>any());
        assertSame(admin, actualCreateAdminResult);
    }

    /**
     * Method under test: {@link AdminService#getAdminByUsername(String)}
     */
    @Test
    void testGetAdminByUsername() {
        Admin admin = new Admin("janedoe", "iloveyou");

        when(adminRepo.findByUsername(Mockito.<String>any())).thenReturn(admin);
        Admin actualAdminByUsername = adminService.getAdminByUsername("janedoe");
        verify(adminRepo).findByUsername(Mockito.<String>any());
        assertSame(admin, actualAdminByUsername);
    }

    /**
     * Method under test: {@link AdminService#deleteAdmin(Long)}
     */
    @Test
    void testDeleteAdmin() {
        doNothing().when(adminRepo).deleteById(Mockito.<Long>any());
        adminService.deleteAdmin(1L);
        verify(adminRepo).deleteById(Mockito.<Long>any());
    }
}
