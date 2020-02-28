package ex3student;

import org.junit.Assert;
import org.junit.Test;

public class EvaluatorTest {

	@Test
	public void testIsValidNum() {
		NumberEvaluator num = new NumberEvaluator();

		Assert.assertTrue(num.isValid("123"));
		Assert.assertTrue(num.isValid("+123"));
		Assert.assertTrue(num.isValid("-123"));
		Assert.assertFalse(num.isValid("123+"));
		Assert.assertFalse(num.isValid("123-"));
		Assert.assertTrue(num.isValid(".123"));
		Assert.assertTrue(num.isValid("123."));
		Assert.assertFalse(num.isValid("12.3.4"));
		Assert.assertTrue(num.isValid("1.123E33"));
		Assert.assertTrue(num.isValid(".1E-3"));
		Assert.assertTrue(num.isValid("0"));
		Assert.assertTrue(num.isValid("-0.0"));
		Assert.assertFalse(num.isValid(""));
		Assert.assertFalse(num.isValid(" "));
		Assert.assertFalse(num.isValid("-"));
		Assert.assertFalse(num.isValid("0,0123"));
	}

	@Test
	public void testIsValidMail() {
		EmailEvaluator mail = new EmailEvaluator();

		Assert.assertTrue(mail.isValid("user@host"));
		Assert.assertTrue(mail.isValid("first.last@host.domain"));
		Assert.assertFalse(mail.isValid("first..last@host..domain"));
		Assert.assertFalse(mail.isValid("user@@host"));
		Assert.assertFalse(mail.isValid(""));
		Assert.assertFalse(mail.isValid(" "));
		Assert.assertFalse(mail.isValid("user"));
		Assert.assertFalse(mail.isValid("user@"));
		Assert.assertFalse(mail.isValid("@host"));
		Assert.assertFalse(mail.isValid("user@."));
		Assert.assertFalse(mail.isValid("user@host."));
		Assert.assertFalse(mail.isValid("user@.host"));
		Assert.assertFalse(mail.isValid(".@host"));
		Assert.assertFalse(mail.isValid(".user@host"));
		Assert.assertFalse(mail.isValid("user.@host"));
	}
}
