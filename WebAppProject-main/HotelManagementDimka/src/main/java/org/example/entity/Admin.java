package org.example.entity;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Objects;

@Table ("admins")
@Getter
public class Admin {
        @Id
        private Long id;
        private String username;
        private String password;

        public Admin(String username, String password) {
            this.username = username;
            this.password = password;
        }

    public void setId(Long id) {
            this.id = id;
        }

    public void setUsername(String username) {
            this.username = username;
        }

    public void setPassword(String password) {
            this.password = password;
        }

}
