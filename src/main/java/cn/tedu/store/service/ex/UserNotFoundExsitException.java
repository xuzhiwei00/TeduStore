package cn.tedu.store.service.ex;

public class UserNotFoundExsitException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserNotFoundExsitException() {
		
		// TODO Auto-generated constructor stub
	}
	public UserNotFoundExsitException(String message){
		super(message);
	}


}
