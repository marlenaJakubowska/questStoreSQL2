package com.codecool.queststore.dao;

import com.codecool.queststore.model.Quest;
import com.codecool.queststore.model.users.User;

import java.util.List;

public class QuestDao extends Dao<Quest> implements IQuestDao<Quest>{


    @Override
    public List<Quest> getAllQuests() {
        String query = "SELECT * FROM applicants;";
        return createQuestList(query);

    }

    private List<Quest> createQuestList(String query) {
        return null;
    }

    @Override
    public Quest getById(int id) {
        return null;
    }

    @Override
    public void insert(Quest t) {

    }

    @Override
    public void update(Quest t) {

    }

    @Override
    public void delete(int id) {

    }

//--------------------redundant methods------------------------------


    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public void add(User user) {

    }

    @Override
    public void edit(User user) {

    }

    @Override
    public void remove(User user) {

    }


}
