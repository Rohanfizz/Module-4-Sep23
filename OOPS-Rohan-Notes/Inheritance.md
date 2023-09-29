- A child can extend a parent
`public class Vehicle {..}` - parent
`public class Car extends Vehicle{..}` - child

- The car class **extends** vehicle class. this means car class adds to whatever vehicle class is already having.
- Child class acquire properties of parent class.
- [[Super]] keyword is used to access the parent class's members/methods from the child class.
- Every class implicitly extends Object class which provides it with some essential functionalities such as `toString(), hashCode()`
- Types Of Inheritance
	1. Singe Level Inheritance
![[Pasted image 20230928225127.png]]
	2.  Multiple Inheritance - One class extending 2 class ⚠ Not supported in java.
![[Pasted image 20230928225152.png]]
	3. Multi Level Inheritance
	Object <- Vehicle <- Car <- SUV
	4. Hierarchical Inheritance
	![[Pasted image 20230928225522.png]]
	6. Hybrid Inheritance - Mix of multiple and hierarchical.