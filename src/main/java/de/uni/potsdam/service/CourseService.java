package de.uni.potsdam.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.PrincipalThreadLocal;
import com.liferay.portal.service.UserLocalServiceUtil;

import de.uni.potsdam.dto.CompetenceDto;
import de.uni.potsdam.dto.CompetenceLink;
import de.uni.potsdam.dto.UserCompetenceDto;

public class CourseService {

	private static CourseService courseService = null;
	private final CourseDao courseDao;
	
	private CourseService() {
		courseDao = new CourseDao();
	}
	
	public static CourseService getInstance() {
		if(courseService == null) {
			courseService = new CourseService();
		}
		return courseService;
	}
	
	public List<CompetenceDto> getAllCompetencen(String context,
			String compulsory, String noCache, String user) throws Exception {
		final List<String> userCometencen = getCompetencenFromUser(context, compulsory, noCache, user);
		final List<CompetenceDto> competencen = courseDao.getAllCourseCompetence(context, compulsory, noCache).getCompetence().getChildren();

		for(CompetenceDto c: competencen) {
			if(userCometencen.contains(c.getName())) {
				c.setLearned(true);
			}
		}
		return competencen;
	}
	
	public List<String> getCompetencenFromUser(String context,
			String compulsory, String noCache,String user) throws Exception {
		final List<String> competenceString = new ArrayList<String>();
		final UserCompetenceDto userCompetenceDto = courseDao.getUserCompetence(user);
		
		for(Entry<String, List<CompetenceLink>> e : userCompetenceDto.getMapUserCompetenceLinks().entrySet()) {
			competenceString.add(e.getKey());
		}
		return competenceString;
	}
	
	public CompetenceDto getCompetenceWithName(String context,
			String compulsory, String noCache,String text) throws Exception {
		final List<CompetenceDto> competenceDtos = courseDao.getAllCourseCompetence(context, compulsory, noCache, null, null, text).getCompetence().getChildren();
		return competenceDtos.size() == 0 ? null : competenceDtos.get(0);
	}
	
	public List<CompetenceLink> getCompetencenLink(String user, String competence) throws Exception {
		return courseDao.getUserCompetence(user).getMapUserCompetenceLinks().get(competence);
	}
	
	public boolean learnedCompetence(String course, String creator,
			String role, String linkedUser, String competences, String evidences) throws Exception {
		return courseDao.updateLearnedCompetenceForUser(course, creator, role, linkedUser, competences, evidences);
	}
	
	public User getUserLoggedIn() throws PortalException, SystemException {
		final User user = UserLocalServiceUtil.getUser(PrincipalThreadLocal.getUserId());	
		return user;
	}
}
