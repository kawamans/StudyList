package check;
public class Pet {

    private String name;
    private String masterName;
    
    //課題④
    //2つの引数を受け取って、フィールド変数nameとmasterNameにそれぞれ値を代入するコンストラクタを記述して下さい


    protected String getName() {
        return name;
    }

    protected String getMasterName() {
        return masterName;
    }

    public void introduce() {
        System.out.println("■僕の名前は" + name + "です");
        System.out.println("■ご主人様は" + masterName + "です");
    }
}

class RobotPet extends Pet {
    public RobotPet(String name, String masterName) {
    	//課題⑤
    	//下記記述は何を行っているか、コメントにて簡潔に説明して下さい
    	//【ここにコメントを記述】
        super(name, masterName);
    }

    public void introduce() {
        System.out.println("◇私はロボット。名前は" + getName() + "です");
        System.out.println("◇ご主人様は" + getMasterName() + "です");
    }
}