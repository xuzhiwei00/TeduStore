package cn.tedu.store.bean;

public class ResponseResult<T> {
	private String state;
	private String message;
	private T date;
	
	public ResponseResult() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResponseResult(String state, String message, T date) {
		super();
		this.state = state;
		this.message = message;
		this.date = date;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getDate() {
		return date;
	}

	public void setDate(T date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "ResponseResult [state=" + state + ", message=" + message + ", date=" + date + "]";
	}
	
}
