package test.selfTest;

public class Test6 {
	 private int number;
	 private String username;
	 private String password;
	 private int x = 100;
	 public Test6(int n) {
	  number = n;  // 这个还可以写为: this.number=n;
	 }
	 public Test6(int i, String username, String password) {
	  // 成员变量和参数同名,成员变量被屏蔽,用"this.成员变量"的方式访问成员变量.
	  this.username = username;
	  this.password = password;
	 }
	 // 默认不带参数的构造方法
	 public Test6() {
	  this(0, "未知", "空"); // 通过this调用另一个构造方法
	 }
	 public Test6(String name) {
	  this(1, name, "空"); // 通过this调用另一个构造方法
	 }
	 public static void main(String args[]) {
	  Test6 t1 = new Test6();
	  Test6 t2 = new Test6("游客");
	  t1.outinfo(t1);
	  t2.outinfo(t2);
	 }
	 private void outinfo(Test6 t) {
	  System.out.println("-----------");
	  System.out.println(t.number);
	  System.out.println(t.username);
	  System.out.println(t.password);
	  f(); // 这个可以写为: this.f();
	 }
	 private void f() {
	  // 局部变量与成员变量同名,成员变量被屏蔽,用"this.成员变量"的方式访问成员变量.
	  int x;
	  x = this.x++;
	  System.out.println(x);
	  System.out.println(this.x);
	 }
	 
	 //返回当前实例的引用
	 private Test6 getSelf() {
	  return this; 
	 }
	}
