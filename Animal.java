public class Animal{
    String name;

    public void setName(String name){
        this.name = name;
    }

}

class Dog extends Animal {

    public void sleep(){
        System.out.println("dog.sleep");
    }


    public static void main(String[] args) {
    
        Dog dog = new Dog();
        dog.setName("dog");
        System.out.println("dog.name : " + dog.name);
        
    }
}
class HouseDog extends Dog{
    // Constructor
    // HouseDog 객체를 생성시 입력값을 받아, 객체 변수에 할당
    public HouseDog(String name){
        // this.name = name -> 작동 X -> Animal class에 존재하지, HouseDog class에 존재 안함. 객체변수의 변경은 존재하는 메소드로만 가능.
        this.setName(name);
    }

    // Method Overriding
    public void sleep(){
        System.out.println("dog.sleep in house");
    }

    // Method Overloding
    public void sleep(int hour){
        System.out.println("dog.sleep in house for " + hour);
    }

    public static void main(String[] args) {
    
     HouseDog houseDog = new HouseDog("Constructor Dog");
     // Animal Class
     //houseDog.setName("houseDog");
     System.out.println("houseDog.name : " + houseDog.name);
     // Method Overriding
     houseDog.sleep();
     // Method Overloding
     houseDog.sleep(3);
           
    }


}    





