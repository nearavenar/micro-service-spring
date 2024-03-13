package com.aravena.arriendolibrosbackend.service;

import com.aravena.arriendolibrosbackend.model.ResetToken;

public interface ResetTokenService {

	ResetToken findByToken(String token);
    void guardar(ResetToken token);
    void eliminar(ResetToken token);
}
