package de.uni.potsdam.bean;

import static de.uni.potsdam.util.DefaultValue.COMPULSORY_ALL;
import static de.uni.potsdam.util.DefaultValue.COURSE_CONTEXT;
import static de.uni.potsdam.util.DefaultValue.NO_CACHE;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import de.uni.potsdam.dto.CompetenceLink;
import de.uni.potsdam.service.CourseService;

@ManagedBean(name="userManagedBean")
@SessionScoped
public class UserCourseManagedBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private List<String> userCompetencen;
	private String selectedCompetence;
	private List<CompetenceLink> competenceLinks;
	
	private String userName;
	
	@PostConstruct
	public void init() {
		try {
			final String loginName = CourseService.getInstance().getUserLoggedIn().getLogin();
			userName = CourseService.getInstance().getUserLoggedIn().getFullName(); 
			userCompetencen = CourseService.getInstance().getCompetencenFromUser(COURSE_CONTEXT, COMPULSORY_ALL, NO_CACHE, loginName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<String> getUserCompetencen() {
		return userCompetencen;
	}

	public void setUserCompetencen(List<String> userCompetencen) {
		this.userCompetencen = userCompetencen;
	}

	public String getSelectedCompetence() {
		return selectedCompetence;
	}

	public void setSelectedCompetence(String selectedCompetence) {
		this.selectedCompetence = selectedCompetence;
	}
	
	public List<CompetenceLink> getCompetenceLinks() {
		return competenceLinks;
	}

	public void setCompetenceLinks(List<CompetenceLink> competenceLinks) {
		this.competenceLinks = competenceLinks;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public void getCompetencenLink() {
		try {
			final String loginName = CourseService.getInstance().getUserLoggedIn().getLogin();
			competenceLinks = CourseService.getInstance().getCompetencenLink(loginName, selectedCompetence);
			userCompetencen = CourseService.getInstance().getCompetencenFromUser(COURSE_CONTEXT, COMPULSORY_ALL, NO_CACHE, loginName);
		} catch (Exception e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Fehler from server : "+e,""));
		}
	}
}
