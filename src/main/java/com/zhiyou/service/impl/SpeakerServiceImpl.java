package com.zhiyou.service.impl;

import com.zhiyou.mapper.SpeakerDao;
import com.zhiyou.model.Speaker;
import com.zhiyou.service.SpeakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author
 * @date 2019/6/18
 */
@Service
public class SpeakerServiceImpl implements SpeakerService {

    @Autowired
    SpeakerDao dao;

    @Override
    public void add(Speaker speaker) {
        if (speaker != null) {
            dao.add(speaker);
        }
    }

    @Override
    public void delete(int id) {
        dao.delete(id);
    }

    @Override
    public void update(Speaker speaker) {
        if (speaker != null) {
            dao.update(speaker);
        }
    }

    @Override
    public int selectNums() {
        return dao.selectNums();
    }

    @Override
    public List<Speaker> selectByPage(int num) {
        return dao.selectByPage(num);
    }

    @Override
    public Speaker selectById(int id) {
        List<Speaker> list = dao.selectById(id);
        if (list!= null) {
            return list.get(0);
        }else {
            return null;
        }
    }

    @Override
    public List<Speaker> selectAll() {
        return dao.selectAll();
    }
}
