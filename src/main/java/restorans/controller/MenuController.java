package restorans.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import restorans.dao.MenuDAO;
import restorans.dao.UserDAO;
import restorans.model.Menu;
import restorans.model.User;
import restorans.model.entity.LoginRequest;
import restorans.model.entity.ResponseMenu;

@RestController
@RequestMapping("/restorans")
public class MenuController {
	
	@Autowired
	MenuDAO menuDAO;
	
	@Autowired
	UserDAO userDAO;
	
	/*Logging*/
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody LoginRequest logs){
		List<User> listUser = userDAO.getAll();
		for (int a=0; a<listUser.size();a++) {
			if(logs.getUsername().equals(listUser.get(a).getUsername())) {
				return ResponseEntity.ok().body(null);
			} 
		}
		return ResponseEntity.notFound().build();		
	}
	
	/* save an Menu */
	@PostMapping("/menus")
	public ResponseEntity<Menu> createMenu(@Valid @RequestBody Menu item) {
		String code ="";
		menuDAO.save(item);
		List<Menu> listMenu = menuDAO.getAll();
		Menu lastMenu = listMenu.get(listMenu.size()-1);
		Long titem = lastMenu.getId();
		if(titem==null) {
			code = "CPXXXX";
		} else if (titem%100==0){
			code = "CP0"+titem;
		} else if (titem%10==0) {
			code = "CP00"+titem;
		} else {
			code = "CP000"+titem;
		}
		lastMenu.setCode(code);
		menuDAO.save(lastMenu);
		return ResponseEntity.ok().build();
	}
	
	/* get all Menu */
	@GetMapping("/menus")
	public ResponseEntity<ResponseMenu> getAllMenus(){
		List<Menu> listMenu = menuDAO.getAll();
		ResponseMenu response = new ResponseMenu();
		response.setDataMenu(listMenu);
		response.setMessage("All Data Found in Database");
		return ResponseEntity.ok().body(response);
	}
	
	/* get Menu by id */
	@GetMapping("/menus/{id}")
	public ResponseEntity<ResponseMenu> getMenuById(@PathVariable(value="id") Long itemId){
		Menu item = menuDAO.findOne(itemId);
		List<Menu> listMenu = new ArrayList<Menu>();
		listMenu.add(item);
		ResponseMenu response = new ResponseMenu();
		response.setDataMenu(listMenu);
		response.setMessage("Data Found in Database");
		if(item==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(response);
	}
	
	/* update Menu by id*/
	@PutMapping("/menus/{id}")
	public ResponseEntity<ResponseMenu> updateMenu(@PathVariable(value="id") Long itemId,@Valid @RequestBody Menu itemDetails){
		Menu item = menuDAO.findOne(itemId);
		if(item==null) {
			return ResponseEntity.notFound().build();
		}
		item.setNamaMakanan(itemDetails.getNamaMakanan());
		item.setJenis(itemDetails.getJenis());
		item.setHarga(itemDetails.getHarga());
		item.setKeterangan(itemDetails.getKeterangan());
		
		Menu updateMenu=menuDAO.save(item);
		List<Menu> listMenu = new ArrayList<Menu>();
		listMenu.add(updateMenu);
		ResponseMenu response = new ResponseMenu();
		response.setDataMenu(listMenu);
		response.setMessage("Data has been Updated");
		return ResponseEntity.ok().body(response);
	}
	
	/* Delete Menu By Id */
	@DeleteMapping("/menus/{id}")
	public ResponseEntity<Menu> deleteMenu(@PathVariable(value="id") Long itemId){
		Menu item=menuDAO.findOne(itemId);
		if(item==null) {
			return ResponseEntity.notFound().build();
		}
		menuDAO.delete(item);
		return ResponseEntity.ok().build();
	}
}
