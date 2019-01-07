package restorans.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="Menues")
@EntityListeners(AuditingEntityListener.class)
public class Menu {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@NotBlank
	private String namaMakanan;

	@NotBlank
	private String imageURL;
	
	@NotBlank
	private String harga;

	@NotBlank
	private String jenis;
	
	@NotBlank
	private String keterangan;
	
	private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Long getId() {
	return id;
	}

	public void setId(Long id) {
	this.id = id;
	}

	public String getNamaMakanan() {
	return namaMakanan;
	}

	public void setNamaMakanan(String namaMakanan) {
	this.namaMakanan = namaMakanan;
	}

	public String getHarga() {
	return harga;
	}

	public void setHarga(String harga) {
	this.harga = harga;
	}

	public String getJenis() {
	return jenis;
	}

	public void setJenis(String jenis) {
	this.jenis = jenis;
	}

	public String getKeterangan() {
	return keterangan;
	}

	public void setKeterangan(String keterangan) {
	this.keterangan = keterangan;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	
}
