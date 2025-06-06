package com.alexander.sistema_cerro_verde_backend.repository.seguridad;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alexander.sistema_cerro_verde_backend.entity.seguridad.PasswordResetToken;

@Repository
public interface  PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Integer> {
    PasswordResetToken findByToken(String token);

}
