package com.codecool.queststore.dao;

import java.util.List;

public interface IQuestDao<Quest>  {

    List<Quest> getAllQuests();
    Quest getById(int id);
    void insert(Quest t);
    void update(Quest t);
    void delete(Quest t);

}
