package mapper.test;

public class City {
    private int id;
    private String name;
    private int provinceId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public City(int id, String name, int provinceId) {
		super();
		this.id = id;
		this.name = name;
		this.provinceId = provinceId;
	}
	public int getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(int provinceId) {
		this.provinceId = provinceId;
	}
}
