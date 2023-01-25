class StudentDriver
{
	public static void main(String[] args)
	{
		//We can use the Student class to instantiate multiple instances.
		//Each instance will have similar data internally, but will be distinictly 
		//separate from one student to the next.


		//Calling new Student(name, bnum, major) utilizes the 
		//value constructor in the Student class
		//and allocates a Student object on the heap for us.
		Student student1 = new Student("Logan Richards", "B00402050", "Computer Science");		
		Student student2 = new Student("Mike Hall", "B00201739", "History");
		
		//We can now do stuff with these two Students.
		
		//In java, if we print an object, it will call that object's toString() method.
		//Which we took the time to define within our Student class.
		System.out.println(student1);
		System.out.println(student2);
		
		//Although we can't access the Student data directly (we made all the data private),
		//we can utilize the getter methods to get the data (here we use the getter for their names / GPAs):
		System.out.println(student1.getName() + "'s GPA: " + student1.getGPA());
		System.out.println(student2.getName() + "'s GPA: " + student2.getGPA());
		
		//We can utilize the setter methods to change the data. (here we use the setter for Mike's GPA)
		student2.setGPA(3.0);
		
		//Because Mike's GPA has dropped a letter grade, he doesn't meet the criteria of being an honor's student
		//(recall the HONOR_THRESHOLD was set to be 3.2 in the Student class)
		System.out.println(student1.getName() + " honors: " + student1.isHonorStudent()); 
		System.out.println(student2.getName() + " honors: " + student2.isHonorStudent());
	}
}
