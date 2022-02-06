package com.example.hosptialtag.pojo;

public class Bind {
    private int bind_int;
    private int bind_patient_id;
    private int bind_tag_id;
    private String bind_start_time;
    private String bind_end_time;
    private boolean bind_delete;

    public Bind(int bind_int, int bind_patient_id, int bind_tag_id, String bind_start_time, String bind_end_time, boolean bind_delete) {
        this.bind_int = bind_int;
        this.bind_patient_id = bind_patient_id;
        this.bind_tag_id = bind_tag_id;
        this.bind_start_time = bind_start_time;
        this.bind_end_time = bind_end_time;
        this.bind_delete = bind_delete;
    }

    public int getBind_int() {
        return bind_int;
    }

    public void setBind_int(int bind_int) {
        this.bind_int = bind_int;
    }

    public int getBind_patient_id() {
        return bind_patient_id;
    }

    public void setBind_patient_id(int bind_patient_id) {
        this.bind_patient_id = bind_patient_id;
    }

    public int getBind_tag_id() {
        return bind_tag_id;
    }

    public void setBind_tag_id(int bind_tag_id) {
        this.bind_tag_id = bind_tag_id;
    }

    public String getBind_start_time() {
        return bind_start_time;
    }

    public void setBind_start_time(String bind_start_time) {
        this.bind_start_time = bind_start_time;
    }

    public String getBind_end_time() {
        return bind_end_time;
    }

    public void setBind_end_time(String bind_end_time) {
        this.bind_end_time = bind_end_time;
    }

    public boolean isBind_delete() {
        return bind_delete;
    }

    public void setBind_delete(boolean bind_delete) {
        this.bind_delete = bind_delete;
    }

    @Override
    public String toString() {
        return "Bind{" +
                "bind_int=" + bind_int +
                ", bind_patient_id=" + bind_patient_id +
                ", bind_tag_id=" + bind_tag_id +
                ", bind_start_time='" + bind_start_time + '\'' +
                ", bind_end_time='" + bind_end_time + '\'' +
                ", bind_delete=" + bind_delete +
                '}';
    }
}
