package restorans.model.entity;

import java.util.List;

import restorans.model.Menu;

public class ResponseMenu {
	private List<Menu> dataMenu;
	private String message;
	
	public List<Menu> getDataMenu() {
		return dataMenu;
	}
	public void setDataMenu(List<Menu> dataMenu) {
		this.dataMenu = dataMenu;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
