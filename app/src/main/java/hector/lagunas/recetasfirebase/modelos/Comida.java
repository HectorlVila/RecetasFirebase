package hector.lagunas.recetasfirebase.modelos;

public class Comida{
	private String strMealThumb;
	private String idMeal;
	private String strMeal;
	private String strCategory;
	private String strArea;
	private String strInstructions;

	public String getStrCategory() {
		return strCategory;
	}

	public void setStrCategory(String strCategory) {
		this.strCategory = strCategory;
	}

	public String getStrArea() {
		return strArea;
	}

	public void setStrArea(String strArea) {
		this.strArea = strArea;
	}

	public String getStrInstructions() {
		return strInstructions;
	}

	public void setStrInstructions(String strInstructions) {
		this.strInstructions = strInstructions;
	}

	public void setStrMealThumb(String strMealThumb){
		this.strMealThumb = strMealThumb;
	}

	public String getStrMealThumb(){
		return strMealThumb;
	}

	public void setIdMeal(String idMeal){
		this.idMeal = idMeal;
	}

	public String getIdMeal(){
		return idMeal;
	}

	public void setStrMeal(String strMeal){
		this.strMeal = strMeal;
	}

	public String getStrMeal(){
		return strMeal;
	}

	@Override
	public String toString() {
		return "Comida{" +
				"strMealThumb='" + strMealThumb + '\'' +
				", idMeal='" + idMeal + '\'' +
				", strMeal='" + strMeal + '\'' +
				", strCategory='" + strCategory + '\'' +
				", strArea='" + strArea + '\'' +
				", strInstructions='" + strInstructions + '\'' +
				'}';
	}
}
