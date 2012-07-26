import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.io.*;

public class PhoneUtil {

    
    public static  List <PhoneNum> readPhoneList(String fileName){
	String line;
	List <PhoneNum> phoneList = new ArrayList<PhoneNum>();
	
	try {
	    Scanner lineScan = new Scanner(new File(fileName));

	    while (lineScan.hasNextLine()){
		line = lineScan.nextLine();
		Scanner tokScan = new Scanner (line);

		int lex = 1;
		int areacode=0, exchange=0, suffix=0;
		String token="", stripparen="";
		
		while (tokScan.hasNext()){
		    token = tokScan.next();
		    //		    System.out.println ("token:\t" +  token);
		    switch (lex){
		    case 1:
			if (token.startsWith("(")){
			    stripparen = token.substring(1,4);
			    //System.out.println ("Stripped" + stripparen);
			    areacode = Integer.parseInt(stripparen);
			}else {
			    areacode = Integer.parseInt(token);
			}
			
			break;
		    case 2:
			exchange = Integer.parseInt(token);
			break;
		    case 3:
			suffix =  Integer.parseInt(token);
			break;
		    }
		    lex++;
		}
		
		phoneList.add(new PhoneNum(areacode, exchange, suffix));
		tokScan.close();
	    }
	    lineScan.close();
	    return(phoneList);
	}catch (IOException e){
	    System.out.println("error: " + e.getMessage());
	    return (null);
	}
    }
}