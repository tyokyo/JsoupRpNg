package control;

public class Bean {
	private String tag;
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public String getExpectValue() {
		return expectValue;
	}
	public void setExpectValue(String expectValue) {
		this.expectValue = expectValue;
	}
	private String count;
	private String expectValue;
}
