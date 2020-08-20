package com.codecool.queststore.model;

public class StudentQuests {
    int id;
    int quest_id;
    QuestStatus questStatus;
    String questSubmission;

    public StudentQuests(int id, int quest_id, QuestStatus questStatus, String questSubmission) {
        this.id = id;
        this.quest_id = quest_id;
        this.questStatus = questStatus;
        this.questSubmission = questSubmission;
    }

    public StudentQuests(){};

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuest_id() {
        return quest_id;
    }

    public void setQuest_id(int quest_id) {
        this.quest_id = quest_id;
    }

    public QuestStatus getQuestStatus() {
        return questStatus;
    }

    public void setQuestStatus(QuestStatus questStatus) {
        this.questStatus = questStatus;
    }

    public String getQuestSubmission() {
        return questSubmission;
    }

    public void setQuestSubmission(String questSubmission) {
        this.questSubmission = questSubmission;
    }

    @Override
    public String toString() {
        return "StudentQuests{" +
                "id=" + id +
                ", quest_id=" + quest_id +
                ", questStatus=" + questStatus +
                ", questSubmission='" + questSubmission + '\'' +
                '}';
    }
}
