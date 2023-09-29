Poly - many
morph - change shape

- Compile Time/ Static poly.
	- Method overloading.
		- 2 methods act differently, when the data types of parameters are diff
	- Operator overloading - **Java Doesn't support**
		- a = 10, b = 10;
		- a + b => 
- Runtime Poly/Dynamic poly
	- Method Overriding
		- [[@Override Annotation]]
		- The child class during runtime decides to ignore the implementation of same method from the parent class, giving priority of its own method
		- [[Upcasting or Dynamic method dispatch and Downcasting]]
		- You cannot override **final** methods
			- I don't want any tampering
			- Enhance compiler performance  for early binding, compiler during the compile time will decide that a final method will look same for every child.
```
public final void sayHello(){  
    System.out.println("Hello from the parent class");  
}
```
- Static methods can be inherited but cannot be overridden 