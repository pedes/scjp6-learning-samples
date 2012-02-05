package net.mgorski.scjp.tests.classes;

public class TestScope {

	public static void main(String[] args) throws CloneNotSupportedException {

		MyScope ms = new MyScope();

		int j = ms.getScope();
		Integer jj = ms.getScopeI();
		SubScope ss = ms.getSubScope();
		SubScope clone = (SubScope) ms.getSubScope().clone();

		j++;
		jj++;
		ss.setValue(ss.getValue() + 1);
		clone.setValue(20);
		
		System.out.println("VALUES : " + j +", " + jj +", " + ss.getValue() +", " + clone.getValue());

		System.out.println(ms.toString());
	}
}

class MyScope {

	private int scope = 10;
	private Integer scopeI = 10;
	private SubScope subScope = new SubScope();

	public SubScope getSubScope() {
		return subScope;
	}

	public void setSubScope(SubScope subScope) {
		this.subScope = subScope;
	}

	public int getScope() {
		return scope;
	}

	public void setScope(int scope) {
		this.scope = scope;
	}

	public Integer getScopeI() {
		return scopeI;
	}

	public void setScopeI(Integer scopeI) {
		this.scopeI = scopeI;
	}

	@Override
	public String toString() {
		String str = "Values of scope : " + scope + " scopeI " + scopeI + " subscope : " + subScope.getValue();
		return str;
	}

}

class SubScope implements Cloneable  {
	
	public SubScope() {
		this(10);
	}
	
	SubScope(Integer valuee) {
		this.value = valuee;
	}

	private Integer value = null;

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}
	
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
