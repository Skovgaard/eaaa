package Architecture1stSem.application.model;

public class Pre {
	public static void require(boolean precondition) {
		if (!precondition)
			throw new RuntimeException("Pre condition violated");
	}
}
