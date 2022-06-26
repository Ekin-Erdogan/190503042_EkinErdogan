/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.anwalt_sys;

/**
 *
 * @author Dell
 */
public class Cases {

    public Cases(int caseId, String description, String category, String nameDefendant, String namePlaintiff, String datum, String historicalData, String nameLawyer, int userId, int clientId) {
        this.caseId = caseId;
        this.description = description;
        this.category = category;
        this.nameDefendant = nameDefendant;
        this.namePlaintiff = namePlaintiff;
        this.datum = datum;
        this.historicalData = historicalData;
        this.nameLawyer = nameLawyer;
        this.userId = userId;
        this.clientId = clientId;
    }

    private int caseId;
    private String description;
    private String category;
    private String nameDefendant;
    private String namePlaintiff;
    private String datum;
    private String historicalData;
    private String nameLawyer;
    private int userId;
    private int clientId;

    Cases() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getCaseId() {
        return caseId;
    }

    public void setCaseId(int caseId) {
        this.caseId = caseId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getNameDefendant() {
        return nameDefendant;
    }

    public void setNameDefendant(String nameDefendant) {
        this.nameDefendant = nameDefendant;
    }

    public String getNamePlaintiff() {
        return namePlaintiff;
    }

    public void setNamePlaintiff(String namePlaintiff) {
        this.namePlaintiff = namePlaintiff;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getHistoricalData() {
        return historicalData;
    }

    public void setHistoricalData(String historicalData) {
        this.historicalData = historicalData;
    }

    public String getNameLawyer() {
        return nameLawyer;
    }

    public void setNameLawyer(String nameLawyer) {
        this.nameLawyer = nameLawyer;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }
}
