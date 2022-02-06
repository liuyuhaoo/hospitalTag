package com.example.hosptialtag.pojo;

public class Tag {

    private int tag_id;
    private String tag_name;
    private int tag_group;
    private String tag_start_time;
    private String tag_end_time;
    private boolean tag_delete;

    public Tag(int tag_id, String tag_name, int tag_group, String tag_start_time, String tag_end_time, boolean tag_delete) {
        this.tag_id = tag_id;
        this.tag_name = tag_name;
        this.tag_group = tag_group;
        this.tag_start_time = tag_start_time;
        this.tag_end_time = tag_end_time;
        this.tag_delete = tag_delete;
    }

    public int getTag_id() {
        return tag_id;
    }

    public void setTag_id(int tag_id) {
        this.tag_id = tag_id;
    }

    public String getTag_name() {
        return tag_name;
    }

    public void setTag_name(String tag_name) {
        this.tag_name = tag_name;
    }

    public int getTag_group() {
        return tag_group;
    }

    public void setTag_group(int tag_group) {
        this.tag_group = tag_group;
    }

    public String getTag_start_time() {
        return tag_start_time;
    }

    public void setTag_start_time(String tag_start_time) {
        this.tag_start_time = tag_start_time;
    }

    public String getTag_end_time() {
        return tag_end_time;
    }

    public void setTag_end_time(String tag_end_time) {
        this.tag_end_time = tag_end_time;
    }

    public boolean isTag_delete() {
        return tag_delete;
    }

    public void setTag_delete(boolean tag_delete) {
        this.tag_delete = tag_delete;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "tag_id=" + tag_id +
                ", tag_name='" + tag_name + '\'' +
                ", tag_group=" + tag_group +
                ", tag_start_time='" + tag_start_time + '\'' +
                ", tag_end_time='" + tag_end_time + '\'' +
                ", tag_delete=" + tag_delete +
                '}';
    }
}

