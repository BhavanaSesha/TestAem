package com.mindtree.Project_O2Store.core.excels;

public class PlantPojo {
	
	private String pageName;
	private String  pagePath;
	private String  templatePath;
	private String  pageTitle;
	private String  category;
	private String  title;
	private String  description;
	private String  abt1;
	private String  abt2;
	private String  abt3;
	private int  price;
	private String  image;
	private String  offer1;
	private String  offer2;
	private int originalPrice;
	private int plantdId;
	
	
	public PlantPojo() {
		super();
	}

	

	public PlantPojo(String pageName, String pagePath, String templatePath, String pageTitle, String category,
			String title, String description, String abt1, String abt2, String abt3, int price, String image,
			String offer1, String offer2, int originalPrice, int plantdId) {
		super();
		this.pageName = pageName;
		this.pagePath = pagePath;
		this.templatePath = templatePath;
		this.pageTitle = pageTitle;
		this.category = category;
		this.title = title;
		this.description = description;
		this.abt1 = abt1;
		this.abt2 = abt2;
		this.abt3 = abt3;
		this.price = price;
		this.image = image;
		this.offer1 = offer1;
		this.offer2 = offer2;
		this.originalPrice = originalPrice;
		this.plantdId = plantdId;
	}



	public String getPageName() {
		return pageName;
	}



	public void setPageName(String pageName) {
		this.pageName = pageName;
	}



	public String getPagePath() {
		return pagePath;
	}



	public void setPagePath(String pagePath) {
		this.pagePath = pagePath;
	}



	public String getTemplatePath() {
		return templatePath;
	}



	public void setTemplatePath(String templatePath) {
		this.templatePath = templatePath;
	}



	public String getPageTitle() {
		return pageTitle;
	}



	public void setPageTitle(String pageTitle) {
		this.pageTitle = pageTitle;
	}



	public String getCategory() {
		return category;
	}



	public void setCategory(String category) {
		this.category = category;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getAbt1() {
		return abt1;
	}



	public void setAbt1(String abt1) {
		this.abt1 = abt1;
	}



	public String getAbt2() {
		return abt2;
	}



	public void setAbt2(String abt2) {
		this.abt2 = abt2;
	}



	public String getAbt3() {
		return abt3;
	}



	public void setAbt3(String abt3) {
		this.abt3 = abt3;
	}



	public int getPrice() {
		return price;
	}



	public void setPrice(int price) {
		this.price = price;
	}



	public String getImage() {
		return image;
	}



	public void setImage(String image) {
		this.image = image;
	}



	public String getOffer1() {
		return offer1;
	}



	public void setOffer1(String offer1) {
		this.offer1 = offer1;
	}



	public String getOffer2() {
		return offer2;
	}



	public void setOffer2(String offer2) {
		this.offer2 = offer2;
	}



	public int getOriginalPrice() {
		return originalPrice;
	}



	public void setOriginalPrice(int originalPrice) {
		this.originalPrice = originalPrice;
	}



	public int getPlantdId() {
		return plantdId;
	}



	public void setPlantdId(int plantdId) {
		this.plantdId = plantdId;
	}




}
