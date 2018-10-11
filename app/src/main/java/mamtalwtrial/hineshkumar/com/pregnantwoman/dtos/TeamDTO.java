package mamtalwtrial.hineshkumar.com.pregnantwoman.dtos;


import java.util.List;

public class TeamDTO {

    private Integer id;
    private String sraName;
    private String userName;
    private String password;
    private TeamTitleDTO teamTitle;
    private SiteDTO site;
    private List<FormCrf1DTO> formCrf1;
    private Integer status;
    private String date;
    private String time;

    public TeamDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public TeamTitleDTO getTeamTitle() {
        return teamTitle;
    }

    public void setTeamTitle(TeamTitleDTO teamTitle) {
        this.teamTitle = teamTitle;
    }

    public SiteDTO getSite() {
        return site;
    }

    public void setSite(SiteDTO site) {
        this.site = site;
    }

    public List<FormCrf1DTO> getFormCrf1() {
        return formCrf1;
    }

    public void setFormCrf1(List<FormCrf1DTO> formCrf1) {
        this.formCrf1 = formCrf1;
    }

    public String getSraName() {
        return sraName;
    }

    public void setSraName(String sraName) {
        this.sraName = sraName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
