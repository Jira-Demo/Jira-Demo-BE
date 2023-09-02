package com.jj.jirademo.task.service;

import com.jj.jirademo.task.repository.PriorityRepository;
import org.springframework.stereotype.Service;

@Service
public class PriorityService {

    private final PriorityRepository priorityRepository;

    public PriorityService(PriorityRepository priorityRepository) {
        this.priorityRepository = priorityRepository;
    }
}
