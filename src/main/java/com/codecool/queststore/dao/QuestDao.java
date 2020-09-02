package com.codecool.queststore.dao;

import com.codecool.queststore.model.Quest;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuestDao extends Dao<Quest> implements IQuestDao<Quest>{


    @Override
    public List<Quest> getAllQuests() {
        String query = "SELECT * FROM quests;";
        return createQuestsList(query);
    }

    private List<Quest> createQuestsList(String query) {
        List<Quest> quests = new ArrayList<>();
        try {
            connect();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int coins = rs.getInt("coins_to_earn");
                int moduleId = rs.getInt("module_id");
                String description = rs.getString("description");
                Quest quest = new Quest(id, name,  description, coins, moduleId);
                quests.add(quest);
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return quests;
    }

    @Override
    public Quest getById(int id) {
        return null;
    }

    @Override
    public void add(Quest quest) {
        String query = String.format(
                "INSERT INTO quests (name, description, coins_to_earn, module_id) values ('%s', '%s', %d, %d);",
                quest.getName(),
                quest.getDescription(),
                quest.getCoinsToEarn(),
                quest.getModuleId()
        );
        executeInsertQuery(query);
    }

    @Override
    public void remove(Quest quest) {

    }

    @Override
    public List<Quest> getAll() {
        return null;
    }
}
