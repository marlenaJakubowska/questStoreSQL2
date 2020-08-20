package com.codecool.queststore.model.users;

import com.codecool.queststore.model.Quest;
import com.codecool.queststore.model.Reward;

import java.util.List;

public class Student extends User{

    int studentId;
    int moduleId;
    int studentQuestId;
    int wallet;
    int sharedWalletId;
    List<Quest> questList;
    List<Reward> rewardList;

    public Student(int id, String firstName, String lastName, Role role, boolean isActive, String login, String password) {
        super(id, firstName, lastName, role, isActive, login, password);
    }

    public Student() {};

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getModuleId() {
        return moduleId;
    }

    public void setModuleId(int moduleId) {
        this.moduleId = moduleId;
    }

    public int getStudentQuestId() {
        return studentQuestId;
    }

    public void setStudentQuestId(int studentQuestId) {
        this.studentQuestId = studentQuestId;
    }

    public int getWallet() {
        return wallet;
    }

    public void setWallet(int wallet) {
        this.wallet = wallet;
    }

    public int getSharedWalletId() {
        return sharedWalletId;
    }

    public void setSharedWalletId(int sharedWalletId) {
        this.sharedWalletId = sharedWalletId;
    }

    public List<Quest> getQuestList() {
        return questList;
    }

    public void setQuestList(List<Quest> questList) {
        this.questList = questList;
    }

    public List<Reward> getRewardList() {
        return rewardList;
    }

    public void setRewardList(List<Reward> rewardList) {
        this.rewardList = rewardList;
    }
}
