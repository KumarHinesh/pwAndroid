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
}
