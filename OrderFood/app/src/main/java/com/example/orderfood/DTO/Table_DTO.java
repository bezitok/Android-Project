package com.example.orderfood.DTO;

public class Table_DTO {

    int id_table;
    String tableName;
    boolean table_selected;

    public Table_DTO() {
    }

    public Table_DTO(int id_table, String tableName) {
        this.id_table = id_table;
        this.tableName = tableName;
    }

    public int getId_table() {
        return id_table;
    }

    public void setId_table(int id_table) {
        this.id_table = id_table;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public boolean isTable_selected() {
        return table_selected;
    }

    public void setTable_selected(boolean table_selected) {
        this.table_selected = table_selected;
    }
}
