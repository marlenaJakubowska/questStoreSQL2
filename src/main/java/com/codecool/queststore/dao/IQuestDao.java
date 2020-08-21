package com.codecool.queststore.dao;

import java.util.List;

public interface IQuestDao<Quest> extends IDao<Quest> {

    List<Quest> getAllQuests();
    Quest getById(int id);

}
