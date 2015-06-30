package maintest;

import de.uni.potsdam.service.CourseService;





public class Main {

	public static void main(String[] args) throws Exception {

		System.out.println(CourseService.getInstance().learnedCompetence("university", "max", "teacher", "dit", "CS students explore informatics systems systematically", "Kompetenztool,link"));
		
		System.out.println(CourseService.getInstance().getCompetencenFromUser("university", "all", "nocache", "dit"));
	}

}
