
class Test{
    public int vartest(int a) {
        a++;
        return a;
    }

    public static void main(String[] args) {
        int a = 1;
        Test myTest = new Test();
        a = myTest.vartest(a);
        System.out.println("Test : " + a);
    }
}



class TestObject{
    int a ;
    // 4. myTest 객체 내 vartest() 메소드에 myTest객체 자기자신을 입력값으로 넣음.
    // 이렇게 메소드가 객체를 전달 받으면 메소드 내의 객체는 전달받은 객체 그 자체로 수행된다. 
    // 메소드로 객체를 전달할 경우 메소드에서 객체의 객체변수(속성) 값을 변경할 수 있게 된다.
    public int vartest(TestObject testObject) {
        // 5. myTest 객체내 객체변수 a++증가.
        this.a++;
        return a;
    }

    
    public static void main(String[] args) {
        // 1.객체 생성 시, 아래 부분이 생성.
        /* int a ;
           public int vartest(TestObject testObject) {
              testObject.a++;
              return testObject.a;
           } */

        TestObject myTest = new TestObject();
        // 2. 생성된 객체 내에 객체 변수 a에 1 대입
        myTest.a = 1;
        // 3. 메소드 호출시, 위에서 작업이 완료된 객체가 그 객체의 메소드 입력값으로 본인 자신을 넣음.
        int b = myTest.vartest(myTest);
        System.out.println("TestOjbect : " + b);
    }
}


class Updater {
    public void update(int count) {
        count++;
    }
}

class Counter {
    int count = 0;  // 객체변수
    public static void main(String[] args) {
        // 1. 객체변수 count = 0 만 존재하는 myCounter 객체 생성               
        Counter myCounter = new Counter(); 
        System.out.println("before update:"+myCounter.count); // 0
        // 2. 메소드 update() 만 존재하는 myUpdater 객체 생성
        Updater myUpdater = new Updater(); 
        // 3. myUpdater의 update() 메소드 실행, 입력값은 단지 0
        myUpdater.update(myCounter.count); 
        // 4. myUpdater 객체의 update()메소드는 return 값도 없고, update 메소드의 로컬변수 count는 myCounter 객체의 count 객체 변수와 상관 X 
        System.out.println("after update:"+myCounter.count);  // 0 예상
    }
}/*  */


class UpdaterObject {
    // 4. myUpdater 내에서 이미 생성된 myCounter 객체를 입력받아 myCounter 객체의 객체변수 count를 +1 증가시킴.
    public void update(CounterObject counterObject) {
        counterObject.count++;
    }
}

class CounterObject {
    int count = 0;  // 객체변수
    public static void main(String[] args) {
        // 1. 객체변수 count = 0 만 존재하는 myCounter 객체 생성               
        CounterObject myCounter = new CounterObject(); 
        // 0 예상
        System.out.println("before update :"+myCounter.count); // 0
        // 2. 메소드 update() 만 존재하는 myUpdater 객체 생성
        UpdaterObject myUpdater = new UpdaterObject(); 
        // 3. myUpdater의 update() 메소드 실행, 입력값은 myCounter 객체
        myUpdater.update(myCounter); 
        // 1 예상
        System.out.println("after update :"+myCounter.count); 
    }
}