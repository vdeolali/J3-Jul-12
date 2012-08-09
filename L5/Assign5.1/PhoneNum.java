//Start of PhoneNum 
public class PhoneNum implements Comparable <PhoneNum> { 

    int areacode; 
    int exchange; 
    int suffix; 
    String phonenum; 
    // int extension; 

    PhoneNum (int areacode, int exchange, int suffix){ 

    this.areacode = areacode; 
    this.exchange = exchange; 
    this.suffix = suffix; 
    //    this.extension = extension; 
    this.phonenum= " ("+ Integer.toString(areacode)+") "+ Integer.toString(exchange)+Integer.toString(suffix); 
    } 

    int getAreacode (){ return areacode; } 
    int getExchange () { return exchange; } 
    int getSuffix () { return suffix; } 
    String getPhoneNum () { return phonenum;} 

    public int compareTo(PhoneNum pn){ 
    Integer iobj = new Integer(areacode); 
    return (iobj.compareTo(pn.getAreacode())); 
    } 
} 