package mamtalwtrial.hineshkumar.com.pregnantwoman.dtos;

import java.util.List;

public class FormCrf1DTO {

    List<UltrasoundExaminationDTO> ultrasoundExaminationDTOS;
    private PregnantWomanDTO pregnantWomanDTO;
    private UserContract teamDTO;
    private Long id;
    private String q02;
    private String q03;
    private String q17;
    private String q18;
    private String q19;
    private String q38;

    private String name; //lw_crf_1_09
    private String husbandName; //lw_crf_1_10
    private String site; //lw_crf_1_11
    private String para; //lw_crf_1_12
    private String block; //lw_crf_1_13
    private String structure; //lw_crf_1_14
    private String householdOrFamily; //lw_crf_1_15
    private Integer womanNumber;//lw_crf_1_16
    private String assessmentId;



    private String crf1;

    public PregnantWomanDTO getPregnantWomanDTO() {
        return pregnantWomanDTO;
    }

    public void setPregnantWomanDTO(PregnantWomanDTO pregnantWomanDTO) {
        this.pregnantWomanDTO = pregnantWomanDTO;
    }

    public UserContract getTeamDTO() {
        return teamDTO;
    }

    public void setTeamDTO(UserContract teamDTO) {
        this.teamDTO = teamDTO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQ02() {
        return q02;
    }

    public void setQ02(String q02) {
        this.q02 = q02;
    }

    public String getQ03() {
        return q03;
    }

    public void setQ03(String q03) {
        this.q03 = q03;
    }

    public String getQ17() {
        return q17;
    }

    public void setQ17(String q17) {
        this.q17 = q17;
    }

    public String getQ18() {
        return q18;
    }

    public void setQ18(String q18) {
        this.q18 = q18;
    }

    public String getQ19() {
        return q19;
    }

    public void setQ19(String q19) {
        this.q19 = q19;
    }

    public String getQ38() {
        return q38;
    }

    public void setQ38(String q38) {
        this.q38 = q38;
    }

    public List<UltrasoundExaminationDTO> getUltrasoundExaminationDTOS() {
        return ultrasoundExaminationDTOS;
    }

    public void setUltrasoundExaminationDTOS(List<UltrasoundExaminationDTO> ultrasoundExaminationDTOS) {
        this.ultrasoundExaminationDTOS = ultrasoundExaminationDTOS;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHusbandName() {
        return husbandName;
    }

    public void setHusbandName(String husbandName) {
        this.husbandName = husbandName;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getPara() {
        return para;
    }

    public void setPara(String para) {
        this.para = para;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public String getStructure() {
        return structure;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    public String getHouseholdOrFamily() {
        return householdOrFamily;
    }

    public void setHouseholdOrFamily(String householdOrFamily) {
        this.householdOrFamily = householdOrFamily;
    }

    public Integer getWomanNumber() {
        return womanNumber;
    }

    public void setWomanNumber(Integer womanNumber) {
        this.womanNumber = womanNumber;
    }

    public String getAssessmentId() {
        return assessmentId;
    }

    public void setAssessmentId(String assessmentId) {
        this.assessmentId = assessmentId;
    }

    public String getCrf1() {
        return crf1;
    }

    public void setCrf1(String crf1) {
        this.crf1 = crf1;
    }

    /*public List<UltrasoundExaminationDTO> getUltrasoundExaminationDTOS() {
        return ultrasoundExaminationDTOS;
    }

    public void setUltrasoundExaminationDTOS(List<UltrasoundExaminationDTO> ultrasoundExaminationDTOS) {
        this.ultrasoundExaminationDTOS = ultrasoundExaminationDTOS;
    }*/
}
