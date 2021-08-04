package com.service.implementation;

import com.dao.interfaces.WorkerDao;
import com.model.Worker;
import com.service.interfaces.WorkerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class WorkerServiceImpl implements WorkerService {
    private WorkerDao workerDao;

    public WorkerServiceImpl(WorkerDao workerDao) {
        this.workerDao = workerDao;
    }

    @Override
    public List<Worker> getAll() {
        return workerDao.getAll();
    }
}
