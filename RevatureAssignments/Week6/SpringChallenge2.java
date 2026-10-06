// Challenge 2
// Created By Patrick Guinn
// 10/2/26
// Goal is to use DTOs such that enrollment records can be inserted. "A student should be able to sign up to a course"

// DTO Layer - The client only needs to provide student and course ids
public class EnrollmentWriteDto {
	
	@NotNull
	@Positive
	private Integer studentId;

	@NotNull
	@Positive
	private Integer courseId;

	public Integer getStudentId() {
		return studentId;
	}
	
	public void setStudentId(studentId) {
		this.studentId = studentId;
	}

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(courseId) {
		this.courseId = courseId;
	}
}

// Service layer - An EnrollmentService class handles creating and adding an enrollment
// to the student's record
@Service
public class EnrollmentService {

	private final StudentRepository studentRepository;
	private final CourseRepository courseRepository;

	public EnrollmentService(StudentRepository studentRepository, CourseRepository courseRepository) {
		this.studentRepository = studentRepository;
		this.courseRepository = courseRepository;
	}

	@Transactional
	public void signUpForCourse(EnrollmentWriteDto dto) {
		// Find the instances of the entities using the DTO
        	Student student = studentRepository.findById(dto.getStudentId())
            		.orElseThrow(() -> new EntityNotFoundException("Student not found"));
	        Course course = courseRepository.findById(dto.getCourseId())
        	    .orElseThrow(() -> new EntityNotFoundException("Course not found"));

        	// Build the new Enrollment record
	        Enrollment enrollment = new Enrollment();
	        enrollment.setStudent(student);
	        enrollment.setCourse(course);
	        enrollment.setEnrollmentDate(LocalDate.now());
        	enrollment.setGrade(null);

	        student.getEnrollments().add(enrollment);
        	studentRepository.save(student);
	}
}

// Controller Layer - Exposes a POST mapping that allows a student to enroll from
@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController {

	private final EnrollmentService enrollmentService;

	public EnrollmentController(EnrollmentService enrollmentService) {
		this.enrollmentService = enrollmentService;
	}

	@PostMapping
	public ResponseEntity<String> enroll(@Valid @RequestBody EnrollmentWriteDto dto) {
		enrollmentService.signUpForCourse(dto);
		return new ResponseEntity<>("Student has successfully signed up for the course.", HttpStatus.CREATED);
	}
}