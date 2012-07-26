public class Car implements Comparable <Car> {

    String make;
    String model;
    int    age;
    int    miles;
    double price;

    Car (String make, String model, int age, int miles){

	this.make = make;
	this.model = model;
	this.age = age;
	this.miles = miles;

	if (age < 10 && miles < 100000){
	    price = 0.02 * (10-age) * (100000 - miles);
	} else {
	    price = 0.0;
	}
    }

    String getMake (){ return make; }
    String getModel () { return model; }
    int  getAge () { return age; }
    int  getMiles () { return miles;}
    double  getPrice () { return price;}

    public int compareTo(Car c){
	Double dobj = new Double(price);
	return (dobj.compareTo(c.getPrice()));
    }
}