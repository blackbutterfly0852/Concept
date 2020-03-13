@FunctionalInterface // 함수가 하나만 존재하는 Interface
interface Say{
    int someting(int a,int b);
}
class Person{
    public void hi(Say line) {
    // main method에서 구현체가 생성된 후, 생성된 구현체의 someting(3,4) 메소드 실행
	int number = line.someting(3,4);
	System.out.println("Number is "+number);
    }

    public static void main(String[] args){
        Person person = new Person();
        // method hi()는 Say 인터페이스 타입의 구현체가 필요.
        person.hi(new Say(){
            public int someting(int a, int b){
                return a+b;
            }
        });
        // 람다식 문법 : 메소드 ( (매개변수 목록)->{실행문} ) // Interface에 함수가 하나만 있다고 가정.
       person.hi((a,b) ->{
           return a+b;
       });

    }
}