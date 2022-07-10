package com.example.ems.services;

import com.example.ems.model.Login;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface LoginService extends CrudRepository<Login, Integer> {
}
