package de.uni.potsdam.bean;


import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import de.uni.potsdam.dto.CompetenceDto;
import de.uni.potsdam.service.CourseService;
import static de.uni.potsdam.util.DefaultValue.*;

@ManagedBean(name="courseManagedBean")
@SessionScoped
public class CourseManagedBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<CompetenceDto> competenceDto;
	
	public CourseManagedBean() {
	}
	
	@PostConstruct
	public void init() {
		try {
			final String loginName = CourseService.getInstance().getUserLoggedIn().getLogin();
			this.competenceDto = CourseService.getInstance().
									getAllCompetencen(COURSE_CONTEXT, COMPULSORY_ALL, NO_CACHE, loginName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<CompetenceDto> getCompetenceDto() {
		return competenceDto;
	}

	public void setCompetenceDto(List<CompetenceDto> competenceDto) {
		this.competenceDto = competenceDto;
	}
	
	public void updateCompetencen(CompetenceDto competence){
        try {
        	final String loginName = CourseService.getInstance().getUserLoggedIn().getLogin();
        	if(CourseService.getInstance().learnedCompetence(COURSE_CONTEXT, CREATOR, ROLR_TEACHER, loginName, competence.getName(), EVIDENCES)){
        		competence.setLearned(true);
        		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "Lernproject wird erfolgreich gelernt!" ,""));
        	} else {
        		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                        "Unforunately!, Lernproject wird nicht erfolgreich gelernt! ",""));
        	}
        } catch (Exception e) {
        	e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Unforunately!, Lernproject wird nicht erfolgreich gelernt : "+e,""));
        }
    }

}
