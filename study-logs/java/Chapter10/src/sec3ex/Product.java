package sec3ex;

public class Product {
    // フィールド
    protected String name;
    protected int price;
    private boolean advisability; // 商品の販売可否
    // コンストラクタ
    public Product(String name) { 
    	this(name, 1);  
    }
    
    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }
    // メソッド
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public boolean isAdvisability() {
        return advisability;
    }
    public void setAdvisability(boolean advisability) {
        this.advisability = advisability;
    }
    public void use () { // アクセス修飾子publicを指定
        System.out.println("商品を使用します");
    }
    public void discount() {
    	this.price *= 0.9;
    }
    public void discount(int value) {
    	this.price -= value;
    }
}