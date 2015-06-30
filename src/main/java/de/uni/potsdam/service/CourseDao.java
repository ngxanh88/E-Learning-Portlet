package de.uni.potsdam.service;

import de.uni.potsdam.dto.CourseCompetenceDto;
import de.uni.potsdam.dto.LearnPathDto;
import de.uni.potsdam.dto.UserCompetenceDto;
import de.uni.potsdam.util.QueryBuilder;

public class CourseDao {
    
	/**
	 * Lade alle Kompetenzen für einen Kurs
	 * @param context 
	 * @param compulsory
	 * @param noCache
	 * @return alle kompetenzen
	 */
	public CourseCompetenceDto getAllCourseCompetence(String context,
			String compulsory, String noCache) throws Exception {
		final QueryBuilder builder = new QueryBuilder();
		
		builder.withPathParam("competences/xml/competencetree")
				.withPathParam(context)
				.withPathParam(compulsory)
				.withPathParam(noCache);
		return builder.build().executeFromXML(CourseCompetenceDto.class);
	}

	/**
	 * Lade alle Kompetenzen für einen Kurs mit Filter
	 * @param context
	 * @param compulsory
	 * @param noCache
	 * @param selectedCatchwords
	 * @param selectedOperators
	 * @param textFilter
	 * @return
	 */
	public CourseCompetenceDto getAllCourseCompetence(String context,
			String compulsory, String noCache, String selectedCatchwords,
			String selectedOperators, String textFilter) throws Exception{
		final QueryBuilder builder = new QueryBuilder();
		
		builder.withPathParam("competences/xml/competencetree")
				.withPathParam(context)
				.withPathParam(compulsory)
				.withPathParam(noCache);
		
		if(selectedCatchwords != null) {
			builder.withQueryParam("selectedCatchwords", selectedCatchwords);
		}
		if(selectedOperators != null) {
			builder.withQueryParam("selectedOperators", selectedOperators);
		}
		if(selectedOperators != null) {
			builder.withQueryParam("textFilter", textFilter);
		}
		return builder.build().executeFromXML(CourseCompetenceDto.class);
	}

	/**
	 * Lade alle Lernpfade für einen Kurs bestehend aus einer Menge von Relationen
	 * @param course
	 * @return
	 */
	public LearnPathDto getLearnPathForCourse(String course) throws Exception{
		final QueryBuilder builder = new QueryBuilder();
		builder.withPathParam("competences/json/prerequisite/graph");
		builder.withPathParam(course);
		return builder.build().executeFromJson(LearnPathDto.class);
	}

	/**
	 * Lade alle Lernpfade für einen Kurs mit FIlter
	 * @param course
	 * @param selectedCompetences
	 * @return
	 */
	public LearnPathDto getLearnPathForCourse(String course,
			String selectedCompetences) throws Exception{
		final QueryBuilder builder = new QueryBuilder();
		builder.withPathParam("competences/json/prerequisite/graph");
		builder.withPathParam(course);
		builder.withQueryParam("selectedCompetences", selectedCompetences);
		return null;
	}

	/**
	 * Lade Fortschritt eines Nutzers bezüglich einer Menge von Kompetenzen
	 * @param user
	 * @return
	 */
	public UserCompetenceDto getUserCompetence(String user) throws Exception{
		final QueryBuilder builder = new QueryBuilder();
		builder.withPathParam("competences/json/link/overview")
				.withPathParam(user);
		return builder.build().executeFromJson(UserCompetenceDto.class);
	}

	/**
	 * Ein Nutzer hat eine Kompetenz gelernt
	 * @param course
	 * @param creator
	 * @param role
	 * @param linkedUser
	 * @param competences
	 * @throws Exception 
	 */
	public boolean updateLearnedCompetenceForUser(String course, String creator,
			String role, String linkedUser, String competences, String evidences) throws Exception {
		final QueryBuilder builder = new QueryBuilder();
		
		String competenceString = competences.trim().replace(" ", "+");
		builder.withPathParam("competences/json/link/create")
				.withPathParam(course)
				.withPathParam(creator)
				.withPathParam(role)
				.withPathParam(linkedUser)
				
				.withQueryParam("competences", competenceString)
				.withQueryParam("evidences", evidences);
		return builder.build().executeWithPostMethode();
	}

	/**
	 * Kommentar zu dem Lernen einer Kompetenz 
	 * @param linkId
	 * @param user
	 * @param courseContext
	 * @param role
	 * @param text
	 */
	public void updateCommentarForCompetence(String linkId, String user,
			String courseContext, String role, String text) {
		// TODO Auto-generated method stub
		
	}

}
