- If you make any variable as final, you cannot change the value of final variable(It will be constant). 
- The final keyword can be applied with the variables, a final variable that have no value it is called **blank final variable** or uninitialized final variable. It can be initialized in the constructor only. 
- **If its primitive, you cannot change the value**
- **If its non primitive, you can change the value of any of its members.**
```
final Student vrinda = new Student("Vrinda",1,2);  
Student rohan = new Student("Rohan",10,30);  
vrinda = rohan; //this is not allowed
```
- Non final objects can point to final objects