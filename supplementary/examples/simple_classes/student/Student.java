class Student
{
	//Value constructor
	public Student(String name, String bNumber, String major)
	{
		m_name = name;
		m_bNumber = bNumber;
		m_major = major;
		m_gpa = 4.0;
	}
	
	//Getter methods.
	public String getName()
	{
		return m_name;
	}
	
	public String getBNumber()
	{
		return m_bNumber;
	}
	
	public String getMajor()
	{
		return m_major;
	}
	
	public double getGPA()
	{
		return m_gpa;
	}
	
	//Setter methods.
	public void setName(String newName)
	{
		m_name = newName;
	}
	
	public void setMajor(String newMajor)
	{
		m_major = newMajor;
	}
	
	public void setGPA(double newGPA)
	{
		m_gpa = newGPA;
	}
	
	//Other Methods
	public boolean isHonorStudent()
	{
		return m_gpa >= HONOR_THRESHOLD;
	}
	
	public String toString()
	{
		String ret = 	"Name:   " + m_name + "\n" +
				"Bnum:   " + m_bNumber + "\n" +
				"Major:  " + m_major + "\n" +
				"GPA: 	 " + m_gpa + "\n" +
				"Honors: " + isHonorStudent() + "\n\n";
				
		return ret;
	}
	
	static final double HONOR_THRESHOLD = 3.2;
	
	//Student Data.
	private String m_name;
	private final String m_bNumber;
	private String m_major;
	private double m_gpa;
}
