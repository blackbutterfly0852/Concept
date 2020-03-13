 class Animal {
    String name;

    public void setName(String name) {
        this.name = name;
    }
 }

 interface Predator {
    public String getFood();
 }

 interface Barkable{
    public String getBark();
 }

 interface PredatorBarkable extends Predator, Barkable{


 }


 // Tiger class는 Animal class Type Or Predator interface Type으로 변환가능 -> 하나 이상의 타입으로 변환 가능하다? -> 다형성
 class Tiger extends Animal implements PredatorBarkable {

    public String getFood(){
        return "apple";
    }
    public String getBark(){

        return "어흥";
    }
 
 }

 
 // Lion class는 Animal class Type Or Predator interface Type으로 변환가능 -> 하나 이상의 타입으로 변환 가능하다? -> 다형성
 class Lion extends Animal implements PredatorBarkable{

    public String getFood(){
        return "banana";
    }

    public String getBark(){

        return "으르렁";
    }

 }

// 클래스의 구현체와 상관없이 인터페이스를 기준으로 중요 클래스를 작성해야만 한다.
public class ZooKeeper {
    // 단 한개의 feed 메소드로 구현이 가능해졌다.
    // ZooKeeper class는 동물 종류에 따른 의존적인 클래스 (feed() 계속 생성)에서 동물들의 종류와 상관없는 독립적인 클래스
    public void feed(Predator predator) {
        System.out.println("feed " + predator.getFood());
    }

    public void bark(Barkable barkable) {
        System.out.println("bark " + barkable.getBark());
    }
  
    public void feedBark(PredatorBarkable predatorBarkable) {
        System.out.println("bark " + predatorBarkable.getFood());
        System.out.println("bark " + predatorBarkable.getBark());
    }
  
    public static void main(String[] args) {
        ZooKeeper zooKeeper = new ZooKeeper();
        Tiger tiger = new Tiger();
        Lion lion = new Lion();
        zooKeeper.feed(tiger);
        zooKeeper.feed(lion);

        zooKeeper.bark(tiger);
        zooKeeper.bark(lion);

        zooKeeper.feedBark(tiger);
        zooKeeper.feedBark(lion);
        
    }
}