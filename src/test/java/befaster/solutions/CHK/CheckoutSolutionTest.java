package befaster.solutions.CHK;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import befaster.solutions.CHK.CheckoutSolution;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CheckoutSolutionTest {
    private CheckoutSolution checkoutSolution;

    @BeforeEach
    public void setUp() {
        checkoutSolution = new CheckoutSolution();
    }

    @Test
    public void checkout_test() {
        assertThat(checkoutSolution.checkout("F"), equalTo(10));
        assertThat(checkoutSolution.checkout("ABCDEF"), equalTo(165));
        assertThat(checkoutSolution.checkout("FF"), equalTo(20));
        assertThat(checkoutSolution.checkout("FFFF"), equalTo(30));
        assertThat(checkoutSolution.checkout("FFFFFF"), equalTo(40));
        assertThat(checkoutSolution.checkout("FFF"), equalTo(20));
        assertThat(checkoutSolution.checkout("AAAAAEEBAAABBFFF"), equalTo(475));
        assertThat(checkoutSolution.checkout("B"), equalTo(30));
        assertThat(checkoutSolution.checkout("M"), equalTo(15));
        assertThat(checkoutSolution.checkout("Q"), equalTo(30));
        assertThat(checkoutSolution.checkout("PPP"), equalTo(150));
        assertThat(checkoutSolution.checkout("PPPP"), equalTo(200));
        assertThat(checkoutSolution.checkout("PPPPPPPP"), equalTo(350));
        assertThat(checkoutSolution.checkout("UUUUUUUU"), equalTo(240));
        assertThat(checkoutSolution.checkout("UUUUU"), equalTo(160));
        assertThat(checkoutSolution.checkout("NNN"), equalTo(120));
        assertThat(checkoutSolution.checkout("NNNM"), equalTo(120));
        assertThat(checkoutSolution.checkout("STX"), equalTo(45));
        assertThat(checkoutSolution.checkout("STXSTX"), equalTo(90));
        assertThat(checkoutSolution.checkout("SSS"), equalTo(45));
        assertThat(checkoutSolution.checkout("STXS"), equalTo(62));
        assertThat(checkoutSolution.checkout("SSSZ"), equalTo(65));
        assertThat(checkoutSolution.checkout("STXYZSTXYZ"), equalTo(152));
        assertThat(checkoutSolution.checkout("ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZ"), equalTo(1602));
        assertThat(checkoutSolution.checkout("LGCKAQXFOSKZGIWHNRNDITVBUUEOZXPYAVFDEPTBMQLYJRSMJCWH"), equalTo(1602));
    }
}
