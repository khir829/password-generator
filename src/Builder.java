public class Builder {
	private int length;
	private boolean upper = false;
	private boolean number = false;
	private boolean special = false;
	private int numberOfTrue = 0;

	public Builder(int length) {
		this.length = length;
	}

	public Builder addUpper() {
		this.upper = true;
		numberOfTrue++;
		return this;
	}

	public Builder addNumber() {
		this.number = true;
		numberOfTrue++;
		return this;
	}

	public Builder addSpecial() {
		this.special = true;
		numberOfTrue++;
		return this;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public boolean isUpper() {
		return upper;
	}

	public void setUpper() {
		numberOfTrue++;
		this.upper = true;
	}

	public boolean isNumber() {
		return number;
	}

	public void setNumber() {
		numberOfTrue++;
		this.number = true;
	}

	public boolean isSpecial() {
		return special;
	}

	public void setSpecial() {
		numberOfTrue++;
		this.special = true;
	}

	public int getNumberOfTrue() {
		return numberOfTrue;
	}

	public void setNumberOfTrue(int numberOfTrue) {
		this.numberOfTrue = numberOfTrue;
	}

	public Password build() {
		return new Password(this);
	}
}