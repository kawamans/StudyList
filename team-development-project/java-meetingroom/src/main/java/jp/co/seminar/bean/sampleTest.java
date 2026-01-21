package jp.co.seminar.bean;

public class sampleTest {
public static void main(String[] args) {
	System.out.println("=============================================================");
	
	
	ExtraMR mr = new ExtraMR();
	
	RoomBean rb =  mr.createRoom("name", "floor", "roomNumber");
	System.out.println(rb);
	
	
	try {
		
		mr.insertRoom(rb);
		
		
	} catch (AppException.AlreadyRegisteredRoomException e) {
			System.out.println(e.getMessage());
			
	}catch(AppException.InsertRoomFailedException e) {
		System.out.println(e.getMessage());
		
		}
	
	
	

	  }
}
