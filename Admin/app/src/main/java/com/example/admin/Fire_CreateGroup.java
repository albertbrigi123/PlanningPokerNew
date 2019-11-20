package com.example.admin;

public class Fire_CreateGroup {
    private String name;
    private String groupName;

    public Fire_CreateGroup()
    {

    }

    public Fire_CreateGroup(String name, String groupName) {
        this.name = name;
        this.groupName = groupName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

}
