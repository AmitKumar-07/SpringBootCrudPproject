package com.first.example;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class ExampleApplicationTests {

	private Calculataor cal=new Calculataor();

	@Test
	void testSum(){
		int expected=20;
		 int actual=cal.doSum(3,12,5);
		 assertThat(actual).isEqualTo(expected);
	}
	 class Calculataor{

		public int doSum(int a,int b,int c){
			return a+b+c;
		}
	 }
}
