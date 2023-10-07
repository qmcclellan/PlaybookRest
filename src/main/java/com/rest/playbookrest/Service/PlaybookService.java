package com.rest.playbookrest.Service;

import com.rest.playbookrest.Dao.PlaybookDao;
import com.rest.playbookrest.Entity.Playbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaybookService implements Services<Playbook>{

    private PlaybookDao playbookDao;

    @Autowired
    public PlaybookService(PlaybookDao playbookDao) {
        this.playbookDao = playbookDao;
    }

    @Override
    public List<Playbook> findAll() {
        return null;
    }

    @Override
    public Playbook retrieve(Integer id) {
        return null;
    }

    @Override
    public Playbook saveAndFlush(Playbook playbook) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }
}
