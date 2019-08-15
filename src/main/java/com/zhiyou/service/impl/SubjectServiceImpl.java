package com.zhiyou.service.impl;

import com.zhiyou.mapper.SubjectDao;
import com.zhiyou.model.Subject;
import com.zhiyou.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author
 * @date 2019/6/18
 */
@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    SubjectDao dao;

    @Override
    public List<Subject> selectAll() {
        return dao.selectAll();
    }

	@Override
	public Subject selectOne(int id) {
		
		return dao.selectOne(id);
	}
}
