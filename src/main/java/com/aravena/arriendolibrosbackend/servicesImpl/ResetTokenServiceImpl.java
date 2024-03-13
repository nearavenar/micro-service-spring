package com.aravena.arriendolibrosbackend.servicesImpl;

import com.aravena.arriendolibrosbackend.model.ResetToken;
import com.aravena.arriendolibrosbackend.repository.ResetTokenRepository;
import com.aravena.arriendolibrosbackend.service.ResetTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResetTokenServiceImpl implements ResetTokenService {

    @Autowired
    private ResetTokenRepository repo;

    @Override
    public ResetToken findByToken(String token) {
        return repo.findByToken(token);
    }

    @Override
    public void guardar(ResetToken token) {
        repo.save(token);

    }

    @Override
    public void eliminar(ResetToken token) {
        repo.delete(token);
    }
}
