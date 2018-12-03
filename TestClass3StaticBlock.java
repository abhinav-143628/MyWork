package com.abhi.java.core;

public class TestClass3StaticBlock {

	int a = 2;
	// static can be used in constructor
	static int b = 3;
	final int c;
	static final int d;
	static final int e = 51;

	static {
		System.out.println("I am static");
		d = 5;
		System.out.println("Static d :" + d);
		System.out.println("Static b :" + b);
		b = 10;
		System.out.println("Static b:" + b);
	}

	public TestClass3StaticBlock() {
		this(71, 72, 73, 74, 75);
		System.out.println("I am construtor");
		System.out.println("Constructor a :" + a);
		// while we are using this() as first line in no-args constructor the we
		// cannot initialize final variables in this no-args constructor due to
		// constructor chaining.
		// Final variables are initialized on that constructor which is called
		// first
		// this.c = 4;
		System.out.println("Constructor c :" + c);
		b = 7;
		System.out.println("Constructor b :" + b);
		// uninitialized static final variable cannot be declared in constructor
		// only in static block
		// d =8;
		System.out.println("Constructor e :" + e);

	}

	public TestClass3StaticBlock(int a1, int b1, int c1, int d1, int e1) {
		this(81,82);
		System.out.println("I am construtor parameterized");
		//final can be initialized here as well
		//this.c = c1;
		this.a = a1;
		this.b = b1;
		// static final variables cannot be initialized
		// this.d = d1;
		// this.e = e1;

		System.out.println("Constructor parameterized a :" + a);
		System.out.println("Constructor parameterized b :" + b);
		System.out.println("Constructor parameterized c :" + c);
		System.out.println("Constructor parameterized d :" + d);
		System.out.println("Constructor parameterized e :" + e);
	}
	
	public TestClass3StaticBlock(int a1, int b1){
		System.out.println("I am construtor parameterized2");
		this.a = a1;
		this.b = b1;
		this.c = b;
		
		System.out.println("Constructor parameterized2 a :" + a);
		System.out.println("Constructor parameterized2 b :" + b);
		System.out.println("Constructor parameterized2 c :" + c);
	}
	
	InnerClass in = new InnerClass();
	
	public void callInnerMethod(){
		in.innerMethod();
	}

	public static void main(String[] args) {
		TestClass3StaticBlock t = new TestClass3StaticBlock();
		t.callInnerMethod();
		InnerClass inC  = t.new InnerClass();
		inC.innerMethod();
		TestClass3StaticBlock t2 = new TestClass3StaticBlock();
		TestClass3StaticBlock t3 = new TestClass3StaticBlock(61, 62, 63, 64, 65);
		TestClass3StaticBlock t1 = new TestClass3StaticBlock(91,92);

	}
	
	 private class InnerClass{
		private void innerMethod(){
			System.out.println("inner method");
		}
	}

}

class OuterClass{
	public void OuterMethod(){
		System.out.println("outer method");
	}
}
