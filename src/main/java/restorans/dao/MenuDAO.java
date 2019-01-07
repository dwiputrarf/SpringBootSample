package restorans.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import restorans.model.Menu;
import restorans.repository.MenuesRepository;

@Service
public class MenuDAO {
	@Autowired
	MenuesRepository menuRepository;
	
	public Menu save(Menu item) {
		return menuRepository.save(item);
	}
	
	public List<Menu> getAll() {
		return menuRepository.findAll();
	}
	
	public Menu findOne(Long itemId) {
		return menuRepository.findOne(itemId);
	}
	
	public void delete(Menu item) {
		menuRepository.delete(item);
	}
}
