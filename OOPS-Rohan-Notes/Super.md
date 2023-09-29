Super is used to access parent class methods and attributes from the child class's scope.

⚠ Note the super constructor should be called before any initialization of the child class members.
```
public Car(int price,int milage,String fuelType,String manufacturer,int tax){  
    super(4,5,price,milage);  
    this.fuelType = fuelType;  
    this.manufacturer = manufacturer;  
    this.tax = tax;  
}
```