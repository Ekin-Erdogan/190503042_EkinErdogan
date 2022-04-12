public class Cases {
    public Cases(){

    }

    private int caseId;
    private String description;
    private String category;
    private String nameDefendant;
    private String namePlaintiff;
    private char[] datum;
    private String historicalData;
    private String nameLawyer;

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

    public char[] getDatum() {
        return datum;
    }

    public void setDatum(char[] datum) {
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

}
