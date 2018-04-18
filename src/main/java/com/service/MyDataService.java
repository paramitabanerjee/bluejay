package com.service;

import com.dao.MyDataDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by m840378 on 4/13/18.
 */
@Service
public class MyDataService {

    @Autowired
    private MyDataDao myDataDao;

    public void saveData(List<String> messages) {
        myDataDao.saveData(messages);

    }
}
