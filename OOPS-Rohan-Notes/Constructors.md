- Default constructor has no parameters
- If you provide constructor explicitly, default constructor will no longer be used.
```
public Student(){  
  
}  
public Student(String name, int roll, int marks) {  
    this.name = name;  
    this.roll = roll;  
    this.marks = marks;  
}
```
- Return type of the constructor is implicit.
- Constructor Shows [[Polymorphism|Compile time polymorphism]]
- Copy constructor - Creates copy of an object ([[Shallow VS Deep copy|Deep Copy]])
```
public Student(Student other){  
    this.name = other.name;  
    this.roll = other.roll;  
    this.marks = other.marks;  
}
```
- If you do not initialize the primitive variables
	- int= 0
	- boolean = false
- But non primitive, always get initialized as `null`