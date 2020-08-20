package com.codecool.queststore.model;

import java.util.HashMap;
import java.util.Map;

public enum QuestStatus {
    NOTSTARTED(1),
    INPROGRES(2),
    SUBMITTED(3),
    APPROVED(4),
    NOTAPPROVED(5);

    private final int questStatusId;
    private static final Map<Integer, QuestStatus> map = new HashMap<>();


    QuestStatus(int questStatusId) {
        this.questStatusId = questStatusId;
    }

    public int getQuestStatusId() {
        return questStatusId;
    }

    public static QuestStatus valueOf(int questStatusId) {
        for (QuestStatus questStatus : QuestStatus.values()) {
            map.put(questStatus.questStatusId, questStatus);
        }
        return map.get(questStatusId);
    }
}
