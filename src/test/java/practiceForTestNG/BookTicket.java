package practiceForTestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BookTicket {
@Test(dataProvider = "dataProvider_bookTicketTest")

public void bookTicketTest(String src,String dst) {
	System.out.println("Book ticket from "+src+"to"+dst);
	
}
@DataProvider
public Object[][] dataProvider_bookTicketTest(){
	Object[][] objArr=new Object[5][2];
	
	objArr[0][0]="Bangaluru";
	objArr[0][1]="Goa";
	
	objArr[1][0]="Bangaluru";
	objArr[1][1]="Mysore";
	
	objArr[2][0]="Bangaluru";
	objArr[2][1]="Mangalore";
	
	objArr[3][0]="Banguluru";
	objArr[3][1]="Hydrabad";
	
	objArr[4][0]="Banguluru";
	objArr[4][1]="Mp";
	return objArr;
	
}
}
