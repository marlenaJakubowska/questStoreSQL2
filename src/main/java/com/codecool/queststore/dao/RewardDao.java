package com.codecool.queststore.dao;

import com.codecool.queststore.model.Reward;

import java.util.List;

public class RewardDao extends Dao<Reward> implements IRewardDao<Reward> {
    @Override
    public void add(Reward reward) {
        String query = String.format(
                "INSERT INTO rewards (name, description, price, category_id, mentor_id, times_ordered) values ('%s', '%s', %d, %d, %d, %d);",
                reward.getName(),
                reward.getDescription(),
                reward.getPrice(),
                reward.getCategory().getCategoryId(),
                reward.getMentorId(),
                0
        );
        executeInsertQuery(query);
    }

    @Override
    public void remove(Reward reward) {

    }

    @Override
    public List<Reward> getAll() {
        return null;
    }
}
