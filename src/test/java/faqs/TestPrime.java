package faqs;

import org.junit.Test;

public class TestPrime {


    @Test
    public void isPrime()
    {

        int n=12;

        for(int i=2; i< Math.sqrt(n);i++)
        {
            if(n%i==0) {
                System.out.println(false);
                break;
            }

        }


    }
}
