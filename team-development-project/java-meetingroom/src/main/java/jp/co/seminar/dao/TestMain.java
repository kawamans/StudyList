package jp.co.seminar.dao;

public class TestMain {

	public static void main(String[] args) {
		
//		String id = "9900001";
//		String password = "a00001";
//		UserBean ub = UserDao.certificate(id, password);
//		
//		System.out.println(ub.getId() + ub.getName());
		
//		for (RoomBean u : RoomDao.findAll()) {
//			System.out.println(u.getId() + " / " + u.getName());
//		}
		
//		for (ReservationBean r : ReservationDao.findByDate("2026-01-20")) {
//			System.out.println(
//					r.getId() + " / " + r.getRoomId() + " / " + r.getDate()
//					+ " /\n" + r.getStart() + " / " + r.getEnd() + " / " + r.getUserId());
//		}
		
//		ReservationBean rvBean = new ReservationBean("0201", "2026-01-23", "09:00:00", "10:00:00", "9900001");
//		if(ReservationDao.insert(rvBean)) {
//			System.out.println(
//					rvBean.getId() + " / " + rvBean.getRoomId() + " / " + rvBean.getDate()
//					+ " /\n" + rvBean.getStart() + " / " + rvBean.getEnd() + " / " + rvBean.getUserId());
//		}
		
//		for(ReservationBean rvBean : ReservationDao.findByDate("2026-01-23")) {
//			ReservationDao.delete(rvBean);
//		}
		
//		TestMR mr = new TestMR();
//		UserBean userBean = mr.inputUser("aiueok","hoge","1999","愛知県","1");
//		System.out.println(userBean);
		
//		ExtraMR mr = new ExtraMR();
//		UserBean userBean = new UserBean("000000","hoge","1999","愛知県","1");
//		try {
//			mr.logicalDeleteUser(userBean);
//			System.out.println(userBean);
//		} catch (AlreadyRegisteredUserException e) {
//			System.out.println(e);
//		} 
		
//		ExtraMR ex = new ExtraMR();
//		UserBean userBean = new UserBean("iiiiii","fuge","1999","愛知県","0");
//		if (ex.searchUser("9900000")) {
//			System.out.println(ex.getUser());
//		} else {
//			System.out.println("いません");
//		}
		
//		ExtraMR ex = new ExtraMR();
//		UserBean userBean = new UserBean("9900005", "000001", "fuge", "愛知県", "0", "select");
//		try {
//			ex.updateUser(userBean);
//			System.out.println(userBean);
//		} catch (AlreadyRegisteredUserException e) {
//			System.out.println(e);
//		} catch (UpdateUserFailedException e) {
//			System.out.println(e);
//		}
		
//		ExtraMR ex = new ExtraMR();
//		UserBean userBean = new UserBean("9900001", "000001", "fuge", "愛知県", "1", "select");
//		try {
//			ex.logicalDeleteUser(userBean);
//			System.out.println(userBean);
//		} catch (LogicalDeleteAdminException e) {
//			System.out.println(e);
//		} catch (LogicalDeleteUserFailedException e) {
//			System.out.println(e);
//		}
		
//		ExtraMR ex = new ExtraMR();
//		RoomBean roomBean = new RoomBean("会議室", "3", "310");
//		try {
//			ex.insertRoom(roomBean);
//			System.out.println(roomBean);
//		} catch (AlreadyRegisteredRoomException e) {
//			System.out.println(e);
//		} catch (InsertRoomFailedException e) {
//			System.out.println(e);
//		}
		
//		ExtraMR ex = new ExtraMR();
//		RoomBean roomBean = new RoomBean("0110", "会議室");
//		try {
//			ex.deleteRoom(roomBean);
//			System.out.println(roomBean);
//		} catch (NonExistentRoomException e) {
//			System.out.println(e);
//		} catch (DeleteRoomFailedException e) {
//			System.out.println(e);
//		}
		
		
		
	}

}
