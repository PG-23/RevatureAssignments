// Challenge 1
// Created by Patrick Guinn
// 10/2/26
// Goal is to create an endpoint that utilizes @Query
// My implementation has an endpoint that returns the top 10 students from Harvard
// sorted by last name

// Repository Layer implementation using @Query
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	// ... rest of class

	@Query("SELECT s FROM Student s WHERE s.school = 'Harvard' ORDER BY s.lastName ASC")
	// Pageable is used since JPQL does not support LIMIT keyword
	List<Student> findTopHarvardStudents(Pageable pageable);

}

// Service Layer implementation that passes a PageRequest object
@Service
public class StudentService {
	
	//... rest of class
	
	public List<Student> getTop10HarvardStudents() {
		return studentRepository.findTopHarvardStudents(PageRequest.of(0,10));
	}
}

// Controller Layer that accepts HTTP request and returns the top 10 student list
@RestController
@RequestMapping("/api/students")
public class StudentController {
	
	// ... rest of class

	@GetMapping("/harvard")
	public List<Student> getHarvardStudents() {
		return studentService.getTop10HarvardStudents();
	}
}